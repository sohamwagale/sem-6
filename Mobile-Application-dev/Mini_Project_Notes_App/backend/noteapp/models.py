from sqlalchemy import Column , Integer , String ,ForeignKey , Boolean
from .database import Base
from sqlalchemy.orm import relationship
from sqlalchemy import DateTime
from datetime import datetime , timezone

# Used for database

class Note(Base):
  __tablename__ = "notes"

  note_id = Column(Integer,primary_key=True,index=True)
  title = Column(String)
  body = Column(String)
  created_at = Column(DateTime(timezone=True), default=lambda: datetime.now(timezone.utc))
  updated_at = Column(DateTime(timezone=True),default=lambda:datetime.now(timezone.utc),onupdate=lambda:datetime.now(timezone.utc))
  user_id = Column(Integer, ForeignKey('users.user_id'))
  is_deleted = Column(Boolean, default=False)

  creator = relationship("User",back_populates="notes")

class User(Base):
  __tablename__ = 'users'

  user_id = Column(Integer,primary_key=True,index=True)
  name = Column(String)
  email = Column(String,unique=True,index=True)
  password = Column(String)

  notes = relationship("Note",back_populates='creator')