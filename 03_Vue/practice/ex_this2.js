let obj = { result: 0 };
obj.add = function (x, y) {
  this.result = x + y;
  return this.result;
};

/* 
let obj = {
  result: 0; 
  add: function (x, y) {
    this.result = x + y;
    return this.result;
}
*/

// add2와 obj.add가 가르키고 있는 대상은 같음
let add1 = obj.add;
console.log(add2 === obj.add); // true

// add2를 일반 함수로서 호출하고 있으므로 this는 전역객체를 가리킨다
// 따라서 console.log (obj)를 찍어도
console.log(add2(3, 4));
console.log(obj);
console.log(result);

let add2 = function (x, y) {
  this.result = x + y;
  return this.result;
};
