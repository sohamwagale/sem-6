from fastapi import APIRouter ,Depends , HTTPException ,status , Query
from sqlalchemy.orm import Session
from .. import schemas
from .. database import get_db
from .. import models
from sqlalchemy import or_
from ..utils.auth import get_current_user

router = APIRouter(
  prefix="/note",
  tags=['Note']
)


@router.post('/', response_model=schemas.ShowNote)
def create_note(req:schemas.Note,db:Session=Depends(get_db),current_user: schemas.TokenData = Depends(get_current_user)):
  note = models.Note(
    title = req.title,
    body = req.body,
    user_id = current_user.user_id
  )
  db.add(note)
  db.commit()
  db.refresh(note)
  return note


@router.get('/',response_model=schemas.PaginatedNotes)
def get_all_notes(skip: int = Query(0,ge=0), limit: int = Query(10, ge=1, le=50),search:str|None=Query(None),db:Session=Depends(get_db),current_user: schemas.TokenData = Depends(get_current_user)):
  query = (
    db.query(models.Note)
    .filter(
      models.Note.user_id == current_user.user_id,
      models.Note.is_deleted.is_(False)
    )
  )

  if search:
    query = query.filter(
      or_(
        models.Note.title.ilike(f"%{search}%"),
        models.Note.body.ilike(f"%{search}%")
      )
    )

  count = query.count()
  
  notes = (
    query
    .offset(skip)
    .limit(limit)
    .all()
  )
  return {
    "total":count,
    "items":notes
  }


@router.get('/{note_id}',response_model=schemas.ShowNote)
def get_note(note_id:int,db:Session=Depends(get_db),current_user:schemas.TokenData = Depends(get_current_user)):
  note = (
    db.query(models.Note)
    .filter(
      models.Note.user_id == current_user.user_id,
      models.Note.note_id == note_id,
      models.Note.is_deleted.is_(False)
    )
    .first()
  )
  if not note:
    raise HTTPException(
      status_code=status.HTTP_404_NOT_FOUND,
      detail= f"note with id {note_id} not found" 
    )
  return note

  
@router.put('/{note_id}', response_model=schemas.ShowNote)
def edit_note(note_id:int,request:schemas.Note,db:Session=Depends(get_db),current_user: schemas.TokenData = Depends(get_current_user)):
  note_query = (
    db.query(models.Note)
    .filter(
      models.Note.note_id == note_id,
      models.Note.user_id == current_user.user_id,
      models.Note.is_deleted.is_(False)
    )
  )

  note = note_query.first()
  if not note:
    raise HTTPException(
      status_code=status.HTTP_404_NOT_FOUND,
      detail= f"note with id {note_id} not found" 
    )
  
  note_query.update({
    models.Note.title: request.title,
    models.Note.body: request.body,
  },synchronize_session=False)
  
  db.commit()
  db.refresh(note)
  return note

@router.delete('/{note_id}')
def delete_note(note_id:int,db:Session=Depends(get_db),current_user:schemas.TokenData = Depends(get_current_user)):
  note = (
    db.query(models.Note)
    .filter(
      models.Note.note_id == note_id,
      models.Note.user_id == current_user.user_id,
      models.Note.is_deleted.is_(False)
    )
  )
  if not note.first():
    raise HTTPException(
      status_code=status.HTTP_404_NOT_FOUND,
      detail= f"note with id {note_id} not found" 
    )
  # note.delete(synchronize_session=False)
  note.update({"is_deleted": True},synchronize_session=False)
  db.commit()
  return {"message": "Deleted successfully"}
