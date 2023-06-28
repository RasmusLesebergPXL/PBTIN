function reverseArray(array) {
    let output = [];
    while (array.length) {
        output.push(array.pop());
    }
    return output;
}
let waarden = [1, 2, 3, 4, 5];
console.log(reverseArray(waarden));