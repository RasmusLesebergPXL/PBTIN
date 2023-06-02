const pg = require('pg');
const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const cors = require('cors');
require('dotenv').config();

const port = 3000;

const pool = new pg.Pool({
    user: process.env.DB_USER,
    host: process.env.DB_HOST,
    database: process.env.DB_NAME,
    password: process.env.DB_PASSWORD,
    port: process.env.DB_PORT,
    connectionTimeoutMillis: 5000
});


// const pool = new pg.Pool({
//     user: 'secadv',
//     host: 'db',
//     database: 'pxldb',
//     password: 'ilovesecurity',
//     port: 5432,
//     connectionTimeoutMillis: 5000
// })

console.log("Connecting...:")

//CORS
const allowedOrigins = ['http://localhost:8080'];

const corsOptions = {
  origin: function (origin, callback) {
    if (allowedOrigins.indexOf(origin) !== -1 || !origin) {
      callback(null, true);
    } else {
      callback(new Error('Not allowed by CORS'));
    }
  }
};

//CORS
app.use(cors(corsOptions));
app.use(bodyParser.json());
app.use(
    bodyParser.urlencoded({
        extended: true,
    })
)

app.get('/authenticate/:username/:password', async (request, response) => {
  const username = request.params.username;
  const password = request.params.password;

  const query = 'SELECT * FROM users WHERE user_name=$1 and password=$2';
  console.log(query);
  pool.query(query, [username, password], (error, results) => {
    if (error) {
      throw error
    }
    response.status(200).json(results.rows)});
});

// app.get('/authenticate/:username/:password', async (request, response) => {
//     const username = request.params.username;
//     const password = request.params.password;

//     const query = `SELECT * FROM users WHERE user_name='${username}' and password='${password}'`;
//     console.log(query);
//     pool.query(query, (error, results) => {
//       if (error) {
//         throw error
//       }
//       response.status(200).json(results.rows)});
      
// });

app.listen(port, () => {
  console.log(`App running on port ${port}.`)
})

