const http = require('http');

const server = http.createServer((req, res) => {
  console.log('요청 발생');
});

server.listen(3000, () => {
  console.log('3000번 포트에서 서버 실행 중');
});
