const http = require('http');

const server = http.createServer((req, res) => {
  // 요청 메서드와 URL 가져오기
  const { method, url } = req;
  req.setHeader('Content-Type', 'test/plain'); // 응답 헤더

  // URL과 메서드에 따라 응답을 다르게 처리
  if (method === 'GET' && url === '/home') {
    res.statusCode = 200;
    res.end('HOME');
  } else if (method === 'GET' && url === '/about') {
    res.statusCode = 200;
    res.end('ABOUT');
  } else {
    res.statusCode = 404;
    res.end('NOT FOUND');
  }
});

server.listen(3000, () => {
  console.log('http://localhost3000 서버 실행 중');
});
