from pydantic import BaseModel
from typing import List
from datetime import datetime
class Note(BaseModel):
  title: str
  body: str

class ShowNote (BaseModel):
  note_id:int
  title: str
  body: str
  created_at: datetime
  updated_at: datetime

  class Config:
    from_attributes=True

class PaginatedNotes(BaseModel):
  total: int
  items: List[ShowNote]

  class Config:
    from_attributes=True

class User(BaseModel):
  name: str
  email:str
  password: str

class ShowUser(BaseModel):
  # user_id:int
  name: str
  email:str
  # password:str

  class Config:
    from_attributes=True

class Token(BaseModel):
  access_token:str
  token_type:str

class TokenData(BaseModel):
  username : str | None = None
  user_id : int | None = None

