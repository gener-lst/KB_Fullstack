function solution(numbers) {
  let sum = 0;
  numbers.forEach((num) => {
    sum += num;
  });
  return sum / numbers.length;
}
