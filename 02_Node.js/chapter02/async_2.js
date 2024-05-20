function displayA() {
  console.log('A');
}

function displayB(callback) {
  setTimeout(() => {
    console.log('B');
    callback();
  }, 2000);
  // C작업이 B작업이 끝난 후 실행되어야 하고, B작업이 비동기 작업일 경우
  // 작업이 끝난 후에 콜백 함수를 통해 지정된 작업을 이어하게 됨
  // 콜백함수를 이용하면 원하는대로 순서를 보장할 수 있다.
}

function displayC() {
  console.log('C');
}

displayA();
displayB(displayC);
