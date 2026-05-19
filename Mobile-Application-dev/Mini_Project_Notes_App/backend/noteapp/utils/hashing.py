from passlib.context import CryptContext
from pwdlib import PasswordHash 
from pwdlib.hashers.bcrypt import BcryptHasher

# password_context = CryptContext(schemes=["bcrypt"],deprecated = "auto")
password_hash = PasswordHash(hashers=[BcryptHasher()])

def get_hash(password:str):
  return password_hash.hash(password)

def verify(hash_pass,plain_pass):
  return password_hash.verify(plain_pass,hash_pass)