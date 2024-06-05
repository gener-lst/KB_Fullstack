const http = require('http');

const server = http.createServer((req, res) => {
  console.log('req.method');

  req.setHeader('Content-Type', 'test/pain'); // 응답 헤더
  req.write('Hello Node'); // 응답 본문
  req.end(); // 응답 종료
});

server.listen(3000, () => {
  console.log('http://localhost3000번 포트에서 서버 실행 중');
});
