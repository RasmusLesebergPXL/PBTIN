const request = require('supertest')
const app = require('../app');

describe("Test if frontend server works", () => {
    test("It should respond with statuscode 200", async () => {
      const response = await request(app).get("/");
      expect(response.statusCode).toBe(200);
    });
});

//Tests for addition
describe("Test the add path", () => {
    test("It should response the GET method", async () => {
      const response = await request(app).get("/calc/add/1/2");
      expect(response.statusCode).toBe(200);
    });
});

describe("Test the add logic", () => {
    test("It should respond with '7'", async () => {
      const response = await request(app).get("/calc/add/5/2");
      expect(response.body).toBe('7');
    });
});
describe("Test the subtract logic", () => {
    test("It should respond with '11'", async () => {
      const response = await request(app).get("/calc/subtract/22/11");
      expect(response.body).toBe('11');


describe("Test the divide path", () => {
    test("It should response the GET method", async () => {
        const response = await request(app).get("/calc/divide/1/2");
        expect(response.statusCode).toBe(200);
    });
});

describe("Test the divide logic", () => {
    test("It should respond with '5'", async () => {
        const response = await request(app).get("/calc/divide/15/3");
        expect(response.body).toBe('5');
    });
});

describe("Test the divide by 0 logic", () => {
    test("It should respond with 'Infinity'", async () => {
        const response = await request(app).get("/calc/divide/15/0");
        expect(response.body).toBe('Infinity');
    });
});

//Tests for exponentiation
describe("Test the exponentiation path", () => {
  test("It should response the GET method", async () => {
    const response = await request(app).get("/calc/exponentiation/1/2");
    expect(response.statusCode).toBe(200);
  });
});

describe("Test the exponential logic", () => {
  test("It should respond with '8'", async () => {
    const response = await request(app).get("/calc/exponentiation/2/3");
    expect(response.body).toBe('8');
  })
});

//Tests for multiplication
describe("Test the multiplication path", () => {
  test("It should response the GET method", async () => {
    const response = await request(app).get("/calc/multiplication/1/2");
    expect(response.statusCode).toBe(200);
  });
});
//Test for positive * positive
describe("Test the multiplication logic for two positive numbers", () => {
  test("It should respond with '10'", async () => {
    const response = await request(app).get("/calc/multiplication/2/5");
    expect(response.body).toBe('10');
  })
});

//Test for positive * negative
describe("Test the multiplication logic for a positive and a negative number", () => {
  test("It should respond with '-6'", async () => {
    const response = await request(app).get("/calc/multiplication/2/-3");
    expect(response.body).toBe('-6');
  })
});

//Test for negative * negative
describe("Test the multiplication logic for two negative numbers", () => {
  test("It should respond with '8'", async () => {
    const response = await request(app).get("/calc/multiplication/-2/-4");
    expect(response.body).toBe('8');
  })
});

//Test for positive * fraction
describe("Test the multiplication logic for a positive number and a fraction", () => {
  test("It should respond with '4.5'", async () => {
    const response = await request(app).get("/calc/multiplication/3/1.5");
    expect(response.body).toBe('4.5');
  })
});

//Test for negative * fraction
describe("Test the multiplication logic for a negative number and a positive fraction", () => {
  test("It should respond with '-10'", async () => {
    const response = await request(app).get("/calc/multiplication/-4/2.5");
    expect(response.body).toBe('-10');
  })
});
