function add1({ name, phone, email = 'x', age = 0 }) {
  console.log(name, phone, email, age);
}
add1({ name: '이몽룡', phone: '010-3434-8989' });

const test1 = (a, b) => {
  return a + b;
};
console.log(test1(3, 4));
