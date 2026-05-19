// Primitive Types
var username = "Shubham";
var age = 21;
var isStudent = true;
// Array
var marks = [85, 90, 78];
// Tuple
var userInfo = ["Comp!lo", 21];
// Enum
var Role;
(function (Role) {
    Role[Role["Admin"] = 0] = "Admin";
    Role[Role["User"] = 1] = "User";
    Role[Role["Guest"] = 2] = "Guest";
})(Role || (Role = {}));
var userRole = Role.Admin;
// Union Type
var userId;
userId = 101;
userId = "A101";
var user1 = {
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
