let nums = [5,2,5,6,7,3,2];

let asc = [...nums].sort((a,b)=>a-b);
console.log("Ascending",asc);

let desc = [...nums].sort((a,b)=>b-a);
console.log("Descending",desc);