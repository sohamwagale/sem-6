function sortThreeDesc(a, b, c) {
    let max, mid, min;


    max = (a + b + Math.abs(a - b)) / 2;
    max = (max + c + Math.abs(max - c)) / 2;

    min = (a + b - Math.abs(a - b)) / 2;
    min = (min + c - Math.abs(min - c)) / 2;

    mid = a + b + c - max - min;

    console.log(max, mid, min);
}

sortThreeDesc(10, 5, 20); 
