import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {
//    테스트 메소드 별로 @DisplayName(테스트이름)을 부여 -> 필수는 아님
    @DisplayName("1+2는 3이다")
//    @Test: 해당 메소드가 테스트 메소드라는 것을 알림
    @Test
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = 3;

        Assertions.assertEquals(a + b, sum);
        // assertEquals(기대값, 실재값): 기대값과 실재값을 비교해서 테스트 진행
    }
}
