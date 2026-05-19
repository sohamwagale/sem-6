class Employee{
  String name;
  int salary;

  Employee(this.name,this.salary);

  void salaryType(){
    if(this.salary > 50000){
      print(this.name + " has : High Salary");
    }else{
      print(this.name + " has : Normal Salary");
    }
  }
}

void main(){
  Employee em1 = Employee("Soham Wagale", 350000);
  em1.salaryType();
}
