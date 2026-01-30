function findMaxMidMin(a, b, c) {
    let max, mid, min;

    if (a >= b && a >= c) {
        max = a;
        if (b >= c) {
            mid = b;
            min = c;
        } else {
            mid = c;
            min = b;
        }
    } 
    else if (b >= a && b >= c) {
        max = b;
        if (a >= c) {
            mid = a;
            min = c;
        } else {
            mid = c;
            min = a;
        }
    } 
    else {
        max = c;
        if (a >= b) {
            mid = a;
            min = b;
        } else {
            mid = b;
            min = a;
        }
    }

    console.log("Max:", max);
    console.log("Mid:", mid);
    console.log("Min:", min);
}

findMaxMidMin(10, 5, 20);
