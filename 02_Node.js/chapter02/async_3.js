function displayA() {
  console.log('A');
}

function displayB(callback) {
  setTimeout(() => {
    console.log('B');
    callback();
  }, 2000);
}

function displayC(callback) {
  setTimeout(() => {
    console.log('C');
    callback();
  }, 2000);
}

function displayD() {
  console.log('D');
}

displayA();
displayB(displayC(displayD()));
// callback 함수가 중첩되어서 코드가 난해해질 경우를 callback hell이라고 부름
// 이를 해결하기 위해, 프라미스와 async/await가 나타남 -> 코드는 동기 방식으로, 작동은 비동기 방식으로
