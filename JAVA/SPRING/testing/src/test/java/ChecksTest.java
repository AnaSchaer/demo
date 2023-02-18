import org.example.Checks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Month;
import java.util.EnumSet;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChecksTest {
//    teste parametrizate
    @ParameterizedTest
    @ValueSource(ints = {1,3,5,7, Integer.MAX_VALUE})
    public void isOddTest(int number){
        System.out.println("Number from argument source: " + number);
        assertTrue(Checks.isOdd(number));
//given
        boolean expectedResult = Checks.isOdd(number);
//        assertTrue(actualResult);
    }
@ParameterizedTest
@ValueSource(strings = {"java", "php"})
    public void isBlankTest(String input) {
    System.out.println("String from argument source: " + input);
//    given
    boolean expectedResult = false;
//    when
    boolean actualResult = Checks.isBlank(input);
//    then
    Assertions.assertEquals(expectedResult, actualResult);
    Assertions.assertFalse(actualResult);

}

//    @ParameterizedTest
//    @ValueSource(strings = {"", "  "})
//    public void isBlankWithEmptyStringTest(String input) {
//        System.out.println("String from argument source: " + input);
////    given
//        boolean expectedResult = false;
////    when
//        boolean actualResult = Checks.isBlank(input);
////    then
////        Assertions.assertEquals(expectedResult, actualResult);
////        Assertions.assertFalse(actualResult);

//    }

@ParameterizedTest
@NullSource
    public void isBlankWithNullValue(String input){
    System.out.println("String from argument source: " + input + "<-----");
    assertTrue(Checks.isBlank(input));

}
    @ParameterizedTest
    @EmptySource
public void isBlankWithEmptySource(String input){
        System.out.println("String from argument source: " + input + "<-----");
        assertTrue(Checks.isBlank(input));

}
    @ParameterizedTest
//    @EmptySource
//    @NullSource
    @NullAndEmptySource
    public void isBlankWithEmptyAndNullSource(String input){
        System.out.println("String from argument source: " + input + "<-----");
        assertTrue(Checks.isBlank(input));

    }

//    Testing ENUMS
@ParameterizedTest
@EnumSource(value = Month.class)
    public void getMonthNumberTest(Month month){
    System.out.println("Month name: " + month.name());
int monthNumber = month.getValue();
    assertThat(monthNumber).isBetween(1,12);
    }
@ParameterizedTest
@EnumSource(value = Month.class,
            names = {"FEBRUARY", "APRIL", "SEPTEMBER", "JUNE", "NOVEMBER"},
            mode = EnumSource.Mode.EXCLUDE)
    public void getMonthWit31DaysTest(Month month){
        assertEquals(31, month.length(false));

    }

    @ParameterizedTest
    @EnumSource(value = Month.class,
    names = ".+BER",
    mode = EnumSource.Mode.MATCH_ALL)
    public void getMonthEndingInBerTest(Month month){
        EnumSet<Month> monthsEndingInBer = EnumSet.of(Month.DECEMBER,
                Month.SEPTEMBER, Month.NOVEMBER, Month.OCTOBER);
        assertTrue(monthsEndingInBer.contains(month));
        }

        // reading data from a file

    @ParameterizedTest
    @CsvSource(value = {"java,JAVA", "php, PHP", "python, PYTHON"})
    public void getValueFromCSVFile(String input, String expected){
        String actualResult = input.toUpperCase();
        assertEquals(expected, actualResult);

    }

    @ParameterizedTest
    @CsvSource(value = {"java:JAVA", "php:PHP", "python:PYTHON"}, delimiter = ':')
    public void getValueWithSpecialDelimiterFromCSVFile(String input, String expected){
        String actualResult = input.toUpperCase();
        assertEquals(expected, actualResult);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test.csv")
    public void getValuesFromFileTest(String input, String expected){
        String actualResult = input.toUpperCase();
        assertEquals(expected, actualResult);
    }
    @ParameterizedTest
    @MethodSource("getStringsForChecksTest")
    public void getValuesFromMethodSource(String input, boolean expected){
        boolean actualResult = Checks.isBlank(input);
assertEquals(expected, actualResult);
    }
    private static Stream<Arguments> getStringsForChecksTest(){
        return Stream.of(Arguments.of(null, true),
                Arguments.of(" ", true),
                Arguments.of("", true),
                Arguments.of("java", false),
                Arguments.of("php", false));
    }
}
