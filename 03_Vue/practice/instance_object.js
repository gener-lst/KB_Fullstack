console.log(this);

let ex1 = 7;

console.log(this);

this.ex2 = ex1;

console.log(this);

let human5 = {
  name: 'Lee',
  say: function () {
    let talk = function () {
      console.log(this.name);
    };
  },
};
human5.say();

function talk() {
  console.log(this);
}
talk();

let human1 = {
  name: 'Kim',
  say: () => console.log(this.name),
};
human1.say();

let human2 = {
  name: 'Ahn',
  say() {
    let talk = () => console.log(this.name);
    talk();
  },
};
human2.say();

function Human3(name) {
  this.name = name;
}

let human3 = new Human3('Jung');
let human4 = Human3('Choi');
console.log(human3.name);
console.log(human4.name);
