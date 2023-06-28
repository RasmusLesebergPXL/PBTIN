let bovengrens = 100;
let ondergrens = 1;
let som = 0;
for (let i = ondergrens; i < bovengrens; i++) {
    if (i % 3 === 0) {
        som += i;
    }
}
console.log(som)