let human = {
  name: '김상형',
  age: 29,
};

human.salary = 520;
delete human.age;

console.log(`${human.name}의 월급 : ${human.salary}`);
console.log(`${human.name}의 나이 : ${human.age}`);
