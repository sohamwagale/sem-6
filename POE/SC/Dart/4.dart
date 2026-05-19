class Table{
  int num;

  Table(this.num);

  void display(){
    for(int i =1;i<=10;i++){
      print(this.num * i);
    }
  }
}

void main(){
  Table t1 = Table(2);
  t1.display();
}