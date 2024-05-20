fs = require('fs');

// fs.readFile : 비동기로 파일을 불러온다.
const data = fs.readFileSync('./chapter03/example.txt', 'utf-8'); // dlszheld wlwjd
// fs.writerFileSync : 동기로 파일 쓰기
fs.writerFileSync('./chapter03/example.text1.txt');
