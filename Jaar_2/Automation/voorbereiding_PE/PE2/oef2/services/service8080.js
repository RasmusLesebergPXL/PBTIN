const http = require('http');

const server = http.createServer((req, res) => {
  res.writeHead(200);
  res.end('Service2 running on port 8080!');
});

server.listen(8080, () => {
  console.log('Service2 listening on port 8080');
});