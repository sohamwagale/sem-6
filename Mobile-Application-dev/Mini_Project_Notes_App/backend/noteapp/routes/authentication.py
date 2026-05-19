from fastapi import APIRouter , Depends , HTTPException , status
from sqlalchemy.orm import Session
from .. database import get_db
from .. schemas import Token
from .. models import User
from ..utils.hashing import verify
from fastapi.security import OAuth2PasswordRequestForm
from .. utils.jwtoken import create_access_token


router = APIRouter(
  tags=["Authentication"]
)

@router.post('/login',response_model=Token)
def login(req:OAuth2PasswordRequestForm = Depends(),db:Session=Depends(get_db)):
  user = (
    db.query(User)
    .filter(User.email == req.username)
    .first()
  )
  if not user:
    raise HTTPException(
      status_code=status.HTTP_401_UNAUTHORIZED,
      detail="No user found"
    )
  
  if not verify(user.password,req.password):
    raise HTTPException(
      status_code=status.HTTP_401_UNAUTHORIZED,
      detail="Incorrect Password or Email"
    )
  
  access_token = create_access_token(data = {"email":user.email,"user_id":user.user_id})
  return {"access_token":access_token,"token_type":"bearer"}