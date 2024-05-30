let obj = { result: 0 };
obj.add = function (x, y) {
  this.result = x + y;
};

// obj.add 시, add 라는 함수를 호출한건 obj
// 따라서 this는 함수를 호출한 obj객체를 가르킨다.
// obj (주어)가 add(동사)를 호출
obj.add(3, 4);
console.log(obj);
