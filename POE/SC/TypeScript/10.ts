class Employee{
  constructor(
    public name: string,
    private salary :number
  ){}

  check(){
    if(this.salary > 50000){
      console.log("High salary");
    }else{
      console.log("Low salary");
    }
  }
}

const emp1 = new Employee("Soham",42000);
const emp2 = new Employee("Wagale",62000);

emp1.check();
emp2.check();