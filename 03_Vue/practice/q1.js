function solution(array, height) {
  let count = 0;
  array.forEach((num) => {
    if (num > height) count += 1;
  });
  return count;
}

//   for (let num of array) {
//     if (num > height) count += 1;
//   }
//   return count;
// }
