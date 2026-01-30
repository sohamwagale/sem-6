let marks=parseInt(prompt("Enter your marks:"));

console.log("Marks: "+marks+"<br>");
document.write("Marks: "+marks+"<br>");

if(marks<50){
    console.log("Grade: Fail");
    document.write("Grade: Fail");

}
else if(marks>=50 && marks<60){
    console.log("Grade: c");
    document.write("Grade: c");

}
else if(marks>=90){
    console.log("Grade: A+");
    document.write("Grade: A+");

}
