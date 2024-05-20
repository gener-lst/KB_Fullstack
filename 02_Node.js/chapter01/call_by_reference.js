function swap(numbers) {
  let temp = numbers[0];
  numbers[0] = numbers[1];
  numbers[1] = temp;
  console.log(`swap 함수 안 -> numbers: ${numbers}`);
}

let arr = [100, 200];

console.log(`swap 함수 밖 -> arr : ${arr}`);
swap(arr);
console.log(`swap 함수 밖 -> arr : ${arr}`);
