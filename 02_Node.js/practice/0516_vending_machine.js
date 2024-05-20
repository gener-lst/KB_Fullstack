const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

class menuList {
  constructor() {
    this.list = [];
  }

  addList(menu) {
    this.list.push(menu);
  }
}

class menu {
  constructor(name, cost, stock) {
    this.name = name;
    this.cost = cost;
    this.stock = stock;
  }
}

class vending_machine {
  constructor(menuList) {
    this.menuItems = menuList.list;
    this.change = change;
  }

  addItem(item) {
    this.menuItems.push(item);
  }

  addstock(item, ea) {
    let supplyItem = this.menuItems.name.indexOf(item);
    this.menuItems[supplyItem].stock += ea;
  }

  sellItem(item, bill) {
    let selectItem = this.menuItems.name.indexOf(item);
    if ((this.menuItems[selectItem].stock = 0)) {
      console.log('재고가 부족합니다.');
      return null;
    } else if (this.menuItems[selectItem].cost > bill) {
      console.log('돈을 더 투입해주세요.');
      return null;
    } else {
      this.menuItems[selectItem].stock -= 1;
      this.change += bill;
      let exchange = bill - this.menuItems[selectItem].cost;
      return exchange;
    }
  }
}

function prepare() {
  let tempList = new menuList();
  let loop = true;

  while (loop) {
    temp = new menu();

    temp.console.log('메뉴 이름 ');
    rl.on('line', (line) => {
      temp.name = line;
      console.log('메뉴 이름: ');
      rl.close();
    });

    rl.on('line', (line) => {
      temp.name = line;
      rl.close();
    });

    // rl.on('close', () => {
    //   console.log(temp.name);
    // });

    // rl.on('line', (line) => {
    //   console.log('메뉴 가격: ');
    //   temp.cost = line;
    //   rl.close();
    // });

    // rl.on('close', () => {
    //   console.log(temp.cost);
    // });

    // rl.on('line', (line) => {
    //   console.log('메뉴 재고: ');
    //   temp.stock = line;
    //   rl.close();
    // });

    // rl.on('close', () => {
    //   console.log(temp.stock);
    //   console.log(temp);
    // });
    // rl.on('line', function (line) {
    //   input = line;
    // }).on('close', function () {
    //   temp.name = input;
    // });
    // console.log('메뉴 가격: ');
    // rl.on('line', function () {
    //   temp.cost = Number(input);
    // }).on('close', function () {});
    // console.log('메뉴 개수: ');
    // rl.on('line', function (input) {
    //   temp.stock = Number(input);
    // });

    tempList.addList(temp);

    loop = false;
  }
}

prepare();
// class Main {
//     public static void main(String[]) {

//     }
// }
