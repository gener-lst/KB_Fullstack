let base = 100;

// named 키워드(export) -> 이름을 무조건 지정해줘야 한다
export const add = (x) => base + x;
export const multiply = (x) => base * x;
// default 키워드는 이름을 지정해주지 않아도 된다

export default () => base;

// export { add, multiply };
// export default getBase;
