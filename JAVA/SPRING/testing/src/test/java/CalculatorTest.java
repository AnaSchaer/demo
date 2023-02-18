import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {
    Calculator calculator;


    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        System.out.println("This prints before each test");
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("This prints after each test");
    }

    @BeforeAll
    public static void logBeforeAllTests() {
        System.out.println("Started tests at: " + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @Test
    public void addTest() {
        //given

        Double expectedResult = 10d;
        Double unexpectedResult = 99d;
        double givenFirstNum = 7;
        double givenSecondNum = 3;
        //when
        Double actualResult = calculator.add(givenFirstNum, givenSecondNum);
        //then
        assertEquals(expectedResult, actualResult);
        assertNotEquals(unexpectedResult, actualResult);
        assertNotNull(actualResult);
    }

    @Test
//    @Disabled pune testul pe hold
    @DisplayName("This is a unit test to divide")
    public void divideTest() {
        //given

        Double expectedResult = 10d;
        Double unexpectedResult = 99d;
        double givenFirstNum = 20;
        double givenSecondNum = 2;
        //when
        Double actualResult = calculator.divide(givenFirstNum, givenSecondNum);
        //then
        assertEquals(expectedResult, actualResult);
        assertNotEquals(unexpectedResult, actualResult);
        assertNotNull(actualResult);
    }

    @Test
    public void divideWithAssertJTest() {
        System.out.println("divide with assert J test");
        //given
        Double expectedResult = 10d;
        Double unexpectedResult = 99d;
        double givenFirstNum = 20;
        double givenSecondNum = 2;
        //when
        Double actualResult = calculator.divide(givenFirstNum, givenSecondNum);
        //then
        assertThat(actualResult)
                .isNotInfinite()
                .isEqualTo(expectedResult)
                .isNotEqualTo(unexpectedResult)
                .isIn(9d,10d,11d)
                .isBetween(1d,99d)
                .isNotNegative()
                .isNotZero();
    }

//    @Test
//    public void divideWithZeroTest() {
//        //given
//        double givenFirstNum = 20;
//        double givenSecondNum = 0;
//        //when + then
//        assertThrows(IllegalArgumentException.class, () -> calculator.divide(givenFirstNum, givenSecondNum));
//    }

    @Test
    public void divideWithZeroTest() {
        //given
        String expectedExceptionMessage = "Division by 0 not possible";
        double givenFirstNum = 20;
        double givenSecondNum = 0;
        //when + then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(givenFirstNum, givenSecondNum));
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    public void divideWithZeroAssertJTest() {
        //given
        String expectedExceptionMessage = "Division by 0 not possible";
        double givenFirstNum = 20;
        double givenSecondNum = 0;
        //when + then
        assertThatThrownBy(() -> calculator.divide(givenFirstNum, givenSecondNum))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedExceptionMessage);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.divide(givenFirstNum, givenSecondNum))
                .withMessage(expectedExceptionMessage);
    }
//teste parametrizate
    public void addWithMultipleInputTest() {
//        given
        assertAll(() -> assertEquals(10, calculator.add(5, 5)),
                () -> assertEquals(8, calculator.add(5, 3)),
                () -> assertEquals(10, calculator.add(5, 5))
        );

    }
}
