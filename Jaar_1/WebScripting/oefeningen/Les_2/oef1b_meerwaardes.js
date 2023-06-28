const min = function( ...numbers) {
    let minvalue = numbers[0]
    for (let i = 0; i < numbers.length; i++) {
        if (numbers[i] < minvalue) {
            minvalue = numbers[i];
        }
    }
    return minvalue
}

console.log(min());
console.log(min(1));
console.log(min(1, 2));
console.log(min(2, 1));
console.log(min(5, 6));
console.log(min(1, 5, 6, 2, 34 , 54, 23, 5));