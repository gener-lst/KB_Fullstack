// as를 사용하면 가져온 함수를 원하는 이름으로 사용 가능
import { hello as hi, goodbye as bye } from './greeting.mjs';

hi('홍길동');
bye('홍길동');
