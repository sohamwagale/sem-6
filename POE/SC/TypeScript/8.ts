class Calculator {
  
  add(a:number,b:number):number{
    return a + b;
  }

  substract(a:number,b:number):number{
    return a - b;
  }

  multiply(a:number,b:number):number{
    return a * b;
  }

  divide(a:number,b:number):number{
    if(b==0){
      console.log("Division by zero not possible")
      return 0;
    }
    return a / b;
  }
}

const calc = new Calculator();

const num1 = 20;
const num2 = 5;

console.log("Addition: ",calc.add(num1,num2));
console.log("Substraction: ",calc.substract(num1,num2));
console.log("Multiplication: ",calc.multiply(num1,num2));
console.log("Division: ",calc.divide(num1,num2));