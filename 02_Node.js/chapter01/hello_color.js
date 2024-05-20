const c = require('ansi-colors');
// require('모듈명' ~> 경로: node_module/모듈명);

function hello(name) {
  console.log(c.green(name) + '님, 안녕하세요?');
}

hello('김민철');
