from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from noteapp.routes import notes ,users,authentication
import noteapp.models
from noteapp.database import engine


app = FastAPI()

app.add_middleware(
  CORSMiddleware,
  allow_origins=["*"],
  allow_credentials=True,
  allow_methods=["*"],
  allow_headers=["*"],
)

noteapp.models.Base.metadata.create_all(engine)

app.include_router(notes.router)
app.include_router(users.router)
app.include_router(authentication.router)