class Student{
  constructor(
    public name:string,
    private marks:number
  ){}

  calcGrade(){
    if(this.marks > 90){
      console.log("Grade A");
    }else if(this.marks > 80){
      console.log("Grade B");
    }
    else {
      console.log("Grade C");
    }
  }
}

const soham =  new Student("Soham",87);
soham.calcGrade();