let bill=0;
let units=parseInt(prompt("Enter units :"));

if(units<=100){
    bill=units*2;
}
else if(units<=200){
    bill=100*2+(units-100)*3;

}
else{
       bill=100*2+100*3+(units-200)*5;

}
console.log("Total Bill : "+bill);
document.write("Total Bill : "+bill);
