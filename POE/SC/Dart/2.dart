class Loop{
  int num;

  Loop(this.num);

  void display(){
    for(int i = 0;i<this.num;i++){
      print(i+1);
    }
  }
}


void main(){
  Loop loop1 = Loop(5);
  loop1.display();
}
