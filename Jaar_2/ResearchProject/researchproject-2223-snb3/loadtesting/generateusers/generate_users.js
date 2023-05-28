function insert_customer_bulk(objects) {
    db.customers.insertMany(objects);
}

function insert_address_bulk(objects) {
    db.addresses.insertMany(objects);
}

function insert_card_bulk(objects) {
    db.cards.insertMany(objects);
}

function generateRandomID() {
    const letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    let randomLetters = "";
    let randomDigits = "";
    // Generate 6 random letters
    for (let i = 0; i < 6; i++) {
      randomLetters += letters.charAt(Math.floor(Math.random() * letters.length));
    }
    // Generate 6 random digits
    for (let i = 0; i < 6; i++) {
      randomDigits += Math.floor(Math.random() * 10);
    }
    return randomLetters + randomDigits;
  }
  

const numUsers = Math.floor(Math.random() * 31) + 20;
const randomID = Math.floor(Math.random() * (500000 - 1000 + 1) + 1000);
const customers = [];
const addresses = [];
const cards = [];

for (let i = 1; i <= numUsers; i++) {
    const randomID = generateRandomID();
    const newCard = {
            "longNum" : "5953580604169678",
            "expires" : "01/01",
            "ccv" : "666"
    };
    cards.push(newCard);

    const newAddress = {
            "number" : "123",
            "street" : "DDoS Road",
            "city" : "Disco",
            "postcode" : "123 AB",
            "country" : "Planet Mars"
    };
    addresses.push(newAddress);

    const newCustomer = {
            "firstName": "botUser",
            "lastName": "last_bot",
            "username": randomID,
            "password": "6a226556916d6bd4bdcc0f452714418d690eda81",
            "salt": "72eaa93ec8473c268e05354568d0fdf2c934c677",
    };
    customers.push(newCustomer);
}

insert_card_bulk(cards);
insert_address_bulk(addresses);
insert_customer_bulk(customers);
