const hello = (name) => {
  console.log(`${name}님, 안녕하세요?`);
};

module.exports = hello; // hello 함수 내보내기
// 원래의 경우 module.exports = {}; 의 형태
// 이 때, 빈 객체의 위치에 hello을 넣어 내보냄
