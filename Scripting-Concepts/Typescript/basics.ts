// Primitive Types
let username: string = "Shubham";
let age: number = 21;
let isStudent: boolean = true;

// Array
let marks: number[] = [85, 90, 78];

// Tuple
let userInfo: [string, number] = ["Shubham", 21];

// Enum
enum Role {
  Admin,
  User,
  Guest
}

let userRole: Role = Role.Admin;

// Union Type
let userId: number | string;
userId = 101;
userId = "A101";

// Type Alias
type User = {
  name: string;
  age: number;
  isActive: boolean;
};

let user1: User = {
  name: "Shubham",
  age: 21,
  isActive: true
};

// Output
console.log("Username:", username);
console.log("Age:", age);
console.log("Student:", isStudent);
console.log("Marks:", marks);
console.log("User Info:", userInfo);
console.log("Role:", Role[userRole]);
console.log("User ID:", userId);
console.log("User Object:", user1);