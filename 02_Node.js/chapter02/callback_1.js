const order = (text, callback) => {
  console.log(`${text} 주문 접수`);
  setTimeout(() => {
    display(text);
  }, 3000);
};

const display = (result) => {
  console.log(`${result} 완료!`);
};
// 한 줄인 함수의 경우 매개변수의 괄호와 중괄호 모두 생략 가능
// const display = (result) => console.log(`${result} 완료!`);

order('아메리카노', display);
