class Student {
  double attendance;

  Student(this.attendance); // Constructor

  void checkEligibility(){
    if(this.attendance > 75){
      print("Eligible");
    }else{
      print("Not Eligible");
    }
  }
}

void main(){
  Student student1 = Student(45);

  student1.checkEligibility();
}