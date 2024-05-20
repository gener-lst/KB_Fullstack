let x = 100;
let y = 200;
// 전역변수 : 스코프 바깥 범위의 변수

function swap(x, y) {
  let temp = x;
  x = y;
  y = temp;
  console.log(`swap 함수 안 -> x: ${x}, y: ${y}`);
}
// 지역 변수가 있을 경우, 우선 순위는 지역 변수가 됨
// 함수 내에서 쓰이는 지역변수는 함수가 끝나는 즉시 반환된다.
// 없을 경우, 전역 변수 중 일치하는 변수를 가져옴

console.log(`swap 호출 전 -> a: ${x}, b: ${y}`);
swap(x, y);
console.log(`swap 호출 전 -> a: ${x}, b: ${y}`);
