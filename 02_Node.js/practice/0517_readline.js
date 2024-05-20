const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

class menu {
  constructor(name, cost, stock) {
    this.name = name;
    this.cost = cost;
    this.stock = stock;
  }
}

class menuList {
  constructor() {
    this.list = [];
  }
  addList(menu) {
    this.list.push(menu);
  }
}

let temp = new menu();
console.log(Object.keys(temp));

let questions = ['메뉴 이름을 ', '메뉴 가격을 ', '재고량을 '];
let input = [];

console.log(questions[input.length] + '입력해주세요');
rl.on('line', (line) => {
  input.push(line);
  console.log(input);
  console.log(input[input.length - 1]);
  if (input.length > questions.length - 1) {
    adding(input);
    rl.close();
  } else {
    console.log(questions[input.length] + '입력해주세요');
  }
});

function adding(list) {
  let i = 0;
  let tempList = new menuList();

  while (i <= list.length) {
    console.log(list[i]);
    temp.name = Number.toString(list[i]);
    i++;
    console.log(list[i]);
    temp.cost = Number.parseFloat(list[i]);
    i++;
    console.log(list[i]);
    temp.stock = Number.parseFloat(list[i]);
    i++;
    tempList.addList(temp);
  }

  console.log(tempList);
}

// console.log('출력합니다.');

// rl.on('close', () => {
//   console.log(input);
//   process.exit();
// });
