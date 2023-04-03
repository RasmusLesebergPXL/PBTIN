function maakRij(min, max, tussenstap = 1) {
    let nummerArray = [];
    if (min < max && tussenstap > 0) {
        for (let i = min; i <= max; + tussenstap) {
            nummerArray.push(i);
            i += tussenstap;
        }
    } else if (max < min && tussenstap > 0) {
        let exchange = min;
        min = max;
        max = exchange;
        for (let i = min; i <= max; + tussenstap) {
            nummerArray.push(i);
            i += tussenstap;
        }
    } else {
        for (let i = min; i >= max; + tussenstap) {
            nummerArray.push(i);
            i += tussenstap;
        }
    }
    return nummerArray;
}

console.log(maakRij(9, 2, -2));