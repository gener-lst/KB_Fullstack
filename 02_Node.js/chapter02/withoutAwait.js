fetch('https://jsonplaceholder.typicode.com/users')
  // fetch() --> promise를 return함
  .then((response) => response.json)
  // 요청이 성공했을 때 받아온 데이터를 JSON으로 변경
  .then((data) => console.log(data))
  .catch((err) => console.log(err));
