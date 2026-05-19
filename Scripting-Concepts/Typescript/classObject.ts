// Base Class
class Person{
    constructor(
        public name: string,
        protected age: number
    ){}

    greet(): void{
        console.log(`Hello, my name is ${this.name}`);
    }
}

// Child Class(Inheritance)
class Student extends Person{
    private rollNo : number;
    constructor(name: string, age: number, rollNo: number){
        super(name, age);
        this.rollNo = rollNo;
    }

    displayInfo(): void {
        console.log("Name: ", this.name);
        console.log("Age: ", this.age);
        console.log("Roll No: ", this.rollNo);
    }
}

// Creating Object
let student1 = new Student("Shubham", 27, 101);
student1.greet();
student1.displayInfo();