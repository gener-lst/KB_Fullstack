function solution(num_list) {
  let count_odd = 0;
  let count_even = 0;
  num_list.forEach((num) => {
    if (num % 2 == 0) {
      count_even++;
    } else {
      count_odd++;
    }
  });
  let answer = [count_even, count_odd];
  return answer;
}
