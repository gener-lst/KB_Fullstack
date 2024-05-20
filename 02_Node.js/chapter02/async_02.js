let likePizza = true;

const pizza = new Promise((resolve, reject) => {
  // if(likePizza === true) 와 동일한 조건문
  if (likePizza) resolve('피자를 주문합니다.');
  else reject('피자를 주문하지 않습니다.');
});

pizza.then((result) => console.log(result)).catch((err) => console.log(err));

// .then : 작업이 성공했을 때 실행되는 코드(resolve 값을 받아옴)
// .catch : 작업이 실패했을 때 실행되는 코드(reject 값을 받아옴)
//.finally 실패하든 성공하든 무조건 실행되는 애

// 메서드 체인 : .then으로 계속 이어지는 복잡한 코드
