let arr1 = [1, 2, 3];
let arr2 = arr1;

arr1[0] = 10;

console.log(arr1[0], arr2[0]);

arr2[1] = 20;

console.log(arr1[1], arr2[1]);
// 같은 주소를 가리키고 있기 때문에 저장된 값이 바뀌면 둘 다 출력값이 바뀌게 됨
