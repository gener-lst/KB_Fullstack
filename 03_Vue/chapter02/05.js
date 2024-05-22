function addContact(
  name,
  mobile,
  home = '없음',
  address = '없음',
  email = '없음'
  // home address email은 기본 파라미터 지정
) {
  let str = `name=${name}, mobile=${mobile}, home=${home}, address=${address}, email=${email}`;
  console.log(str);
}
// 기본 파라미터를 넣어주면 전다하지 않은 인자가 기본값으로 들어간다.
addContact('홍길동', '010-222-3331');
// 기본 파라미터가 있는 값에 인자를 넣어주면 기봅값을 덮어씌운다.
addContact('이몽룡', '010-222-3331', '02-3422-9900', '서울시');
