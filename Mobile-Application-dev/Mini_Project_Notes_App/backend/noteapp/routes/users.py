from fastapi import APIRouter ,Depends,HTTPException,status
from sqlalchemy.orm import Session
from .. import schemas
from .. database import get_db
from .. import models
from typing import List
from ..utils.hashing import get_hash


router = APIRouter(
  tags=["User"],
  prefix='/user'
)

@router.post('/',response_model=schemas.ShowUser)
def create_user(req:schemas.User,db:Session=Depends(get_db)):
  new_user = models.User(
    name = req.name,
    email = req.email,
    password = get_hash(req.password)
  )
  old_user_with_same_email = db.query(models.User).filter(models.User.email == new_user.email).first()
  if old_user_with_same_email:
    raise HTTPException(
      status_code=status.HTTP_400_BAD_REQUEST,
      detail={"user with same email id exists"}
    )
  db.add(new_user)
  db.commit()
  db.refresh(new_user)
  return new_user

@router.get('/',response_model=List[schemas.ShowUser])
def get_all_users(db:Session=Depends(get_db)):
  users = (
    db.query(models.User).all()
  )
  return users

@router.get('/{user_id}',response_model=schemas.ShowUser)
def get_user_by_id(user_id,db:Session = Depends(get_db)):
  user = (
    db.query(models.User)
    .filter(models.User.user_id == user_id)
    .first()
  )
  if not user:
    raise HTTPException(
      status_code=status.HTTP_404_NOT_FOUND,
      detail= f"user with id {user_id} not found" 
    )
  return user