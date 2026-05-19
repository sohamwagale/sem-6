import jwt
from jwt.exceptions import InvalidTokenError
from datetime import datetime, timedelta, timezone
from .. schemas import TokenData

SECRET_KEY = "98b01c12d1be1954fe11695807aeeb18492b0c181cb8586830a88364b475a257"
ALGORITHM = "HS256"
ACCESS_TOKEN_EXPIRE_MINUTES = 30


def create_access_token(data: dict):
    to_encode = data.copy()
    expire = datetime.now(timezone.utc) + timedelta(minutes=ACCESS_TOKEN_EXPIRE_MINUTES)
    to_encode.update({"exp": expire})
    encoded_jwt = jwt.encode(to_encode, SECRET_KEY, algorithm=ALGORITHM)
    return encoded_jwt


def verify_token_and_return_data(token: str, credentials_exception):
  try:
    payload = jwt.decode(token, SECRET_KEY, algorithms=[ALGORITHM])
    email = payload.get("email")
    user_id = payload.get("user_id")
    if email is None:
        raise credentials_exception
    token_data = TokenData(username=email,user_id=user_id)
    return token_data   
  except InvalidTokenError:
    raise credentials_exception
  
  
