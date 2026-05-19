class Table{
  
  check(){
    for(let i :number = 1;i<=20;i++){
      if(i%2==0){
        console.log(`${i} is even`);
      }else{
        console.log(`${i} is odd`);
      }
    }
  }
}

const t1 = new Table();

t1.check();