void main(){
  print("Hello Shubham!!!");

  // Variables and Data Types
  String name = "Shubham";
  int age = 21;
  double num = 33.55;
  bool isStudent = true;

  print("Name: $name");
  print("Age: $age");
  print("marks: $num");
  print("Is Student: $isStudent");

  // Var and Dynamic
  var city = "Kolhapur";
  dynamic anything = 100;
  anything = "How are you???";

  print("City: $city");
  print("Dynamic: $anything");

  // IF-ELSE
  int marks = 75;
  if(marks >= 40){
    print("Result: Pass");
  } else {
    print("Result: Fail");
  }

  // For Loop
  print("For Loop: ");
  for(int i =1; i<=5; i++){
    print(i);
  }

  // While Loop
  print("While Loop: ");
  int count = 1;
  while(count <=3){
    print(count);
    count++;
  }

  // Functions
  // Function Without Return
  void greet(String name){
    print("Hello $name");
  }
  greet("Shubham");

  int sum = add(12,14);
  print("Sum: $sum");

  // List
  List<int> numbers = [1,2,3,4];
  print("List: $numbers");
  numbers.add(5);
  print("Updated List: $numbers");

  // Map
  Map<String, int> student = {
    "Math" : 90,
    "Science" : 54
  };

  // Class and Object
  Student s1 = Student("Shubham", 27);
  s1.display();
}

// Class must be written outside main function...
class Student {
    String name;
    int age;
    Student(this.name, this.age);

    void display(){
      print("Student Name: $name, Age: $age");
    }
  }

// You can write function inside or outside the main function
  // Function with return
  int add(int a, int b){
    return a+b;
  }