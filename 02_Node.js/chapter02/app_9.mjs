// * 키워드로 전체 파일을 가져와서 사용 가능
// 하지만, 안쪽의 변수나 함수를 접근할 때는 .을 써서 접근해야 함
import * as say from './greeting.mjs'; // greeting.mjs 에서 내보낸 함수들을 한꺼번에 say 로 받기
say.hello('홍길동');
say.goodbye('홍길동');
