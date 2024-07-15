import org.junit.jupiter.api.*;

public class JUnitCycleTest {
    @BeforeAll // 전체 테스트 시작전 1회 실행, static 선언 -> 테스트 클래스의 인스턴스가 생성되기 전에 실행되기 때문
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach // 테스트 케이스를 시작하기 전마다 실행
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }

    @AfterEach // 테스트 케이스를 종료하기 전마다 실행
    public void afterEach() {
        System.out.println("@AfterEach");
    }

    @AfterAll // 전체 테스트를 마치고 종료하기 전 1회. static 선언 -> 테스트 클래스의 인스턴스가 소멸된 이후에 실행되기 때문
    static void afterAll() {
        System.out.println("@AfterAll");
    }
}
