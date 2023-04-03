function berekenAfstand(punt1, punt2) {
    return Math.sqrt(Math.pow((punt1.x - punt2.x), 2) + (Math.pow((punt1.y - punt2.y), 2)));
}
let punt1 = {x:1, y:1};
let punt2 = {x:2, y:3};
console.log(berekenAfstand(punt1, punt2));