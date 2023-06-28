function fibonacci(nummer) {
    if (nummer == 0) {
        return 1;
    } else if (nummer == 1) {
        return 1;
    }
    return (fibonacci(nummer - 2) + fibonacci(nummer - 1));
}
console.log(fibonacci(8));

