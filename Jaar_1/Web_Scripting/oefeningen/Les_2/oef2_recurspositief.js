function isEven(nummer) {
    if (nummer == 0) {
        return true;
    } else if (nummer == 1) {
        return false;
    }
    return isEven(nummer - 2);
}
console.log(isEven(24))

