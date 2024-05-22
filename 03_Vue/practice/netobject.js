let human = {
  name: '김상형',
  age: 29,
  address: {
    city: '하남시',
    dong: '덕풍동',
    bunji: 638,
  },
};

console.log(
  // human과 address가 둘다 객체기 때문에 .으로 두번 접근한다.
  `이룸 = ${human.name}, 나이 = ${human.age}, 주소 = ${human.address.city} ${human.address.dong} ${human.address.bunji}`
);
