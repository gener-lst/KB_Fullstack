const _ = require('lodash');

// 기존 배열 복사의 문제점
// : 참조형이기 때문에 생긴다.

let arr1 = [1, 2, 3];
let arr2 = arr1;

arr2[1] = 4;

console.log(`arr1 : ${arr1}`);
console.log(`arr1 : ${arr2}`);

// 얕은 복사
// 전개 연산자 사용 : ... (내부 데이터들을 펼쳐준다)
let shallow1 = ['a', 'b', 'c'];
let shallow2 = [...shallow1];
// 값만 복사해서 배열 안에 다시 나열하는 방식

shallow2[1] = 4;

console.log(shallow1);
console.log(shallow2);
// 하지만, 참조형 데이터 안에 또 다른 참조형 데이터가 있다면?
let shallow3 = ['a', 'b', ['가', '나', '다']];
let shallow4 = [...shallow3];

shallow3[2][0] = '변경';

console.log(shallow3);
console.log(shallow4);

// lodash를 사용(npm 외부 모듈)
// lodash의 clonedeep 함수 사용
// 내부를 순환하면서 모든 데이터들을 값으로 복사해준다.
let deep1 = ['a', 'b', ['가', '나', '다']];
let deep2 = _.cloneDeep(deep1);

deep1[2][0] = '변경';

console.log(deep1);
console.log(deep2);
