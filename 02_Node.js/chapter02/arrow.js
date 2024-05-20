// let getTriangle = (base, height) => {
//   return (base * height) / 2;
// };

let getTriangle = (base, height) => (base * height) / 2;

let getObject = () => ({
  name: 'kim',
});
// 객체 return 시에는 구현부와 차이를 두기 위해 소괄호로 한번더 감싸준다.

console.log(`삼각형의 면적 : ${getTriangle(5, 2)}`);
