const p1 = { name: 'john', age: 20 };
p1.age = 22;
// 참조 값의 경우 const로 선언되도 내부의 속성값은 바꿀 수 있음
console.log(p1);
// p1 = { name: 'lee', age: 25 };
// 하지만, p1 자체의 주소를 바꾸는 대입문은 실행 불가
