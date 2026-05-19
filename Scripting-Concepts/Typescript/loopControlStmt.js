// Function
function checkNo(num) {
    if (num > 0) {
        return "Positive";
    }
    else if (num < 0) {
        return "Negative";
    }
    else {
        return "Zero";
    }
}
console.log(checkNo(5));
console.log(checkNo(0));
console.log(checkNo(-8));
// Switch Stmt
var day = 3;
switch (day) {
    case 1:
        console.log("Monday");
        break;
    case 2:
        console.log("Tuesday");
        break;
    case 3:
        console.log("Wednesday");
        break;
    case 4:
        console.log("Invalid Day");
        break;
}
// For loop
for (var i = 1; i <= 5; i++) {
    console.log("For Loop: ", i);
}
// While Loop
var count = 1;
while (count <= 3) {
    console.log("While Loop: ", count);
    count++;
}
// Do While loop
var num = 1;
do {
    console.log("Do-While Loop: ", num);
    num++;
} while (num <= 2);
// Arrow Function
var add = function (a, b) {
    return a + b;
};
console.log("Addition: ", add(10, 20));
