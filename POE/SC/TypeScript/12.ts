class Student{
  constructor(
    public name:string,
    private p:number,
    private c:number,
    private m:number,
  ){}

  check(){
    if ((this.p + this.c + this.m)/3 > 35){
      console.log("Pass");
    }else{
      console.log("Failed");
    }
  }

  display(){
    console.log(`
      Name : ${this.name}
      Physics : ${this.p}  
      Chemistry : ${this.c}  
      Maths : ${this.m}  
    `)
  }
}

const s1 = new Student(
  "Soham Wagale",
  87,
  45,
  54
);

s1.check();
s1.display();