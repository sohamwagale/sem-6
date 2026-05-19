class Student{
  String name;
  int MathMarks;
  int ScienceMarks;
  int PhysicsMarks;

  Student(this.name,this.MathMarks,this.PhysicsMarks,this.ScienceMarks);

  int total(){
    return this.MathMarks + this.PhysicsMarks + this.ScienceMarks;
  }

  double average(){
    return this.total()/3;
  }

  String grade(){
    if(this.average() > 90) return "A";
    else if(this.average() > 50) return "B";
    else return "C";
  }
}

void main() {
  Student s1 = Student("Soham", 90, 85, 95);

  print("Name ${s1.name}");
  print("Marks Total : ${s1.total()}");
  print("Average : ${s1.average()}");
  print("Grade : ${s1.grade()}");
}