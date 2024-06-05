const http = require('http');
const fs = require('fs');

const server = http.createServer((req, res) => {
  req.setHeader('Content-Type', 'test/html'); // 응답 헤더
  const readStream = fs.createReadStream(__dirname + '/index.html', 'utf8');

  readStream.pipe(res);
});

server.listen(3000, () => {
  console.log('http://localhost3000 서버 실행 중');
});
