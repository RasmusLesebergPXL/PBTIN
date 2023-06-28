let aantalLijnen = 7;

for (let i = 0; i < aantalLijnen; i++) {
    console.log(" ".repeat(aantalLijnen - i - 1) +
        "#".repeat(i + 1));
}