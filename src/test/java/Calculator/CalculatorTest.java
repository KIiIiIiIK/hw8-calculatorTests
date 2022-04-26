package Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init() {
        System.out.println("Before each called");
        calculator = new Calculator();
    }

    @Test //1
    @DisplayName("test for '+'")
    void testPlus() {
        //GIVEN
        double first = 6;
        double second = 20;
        String operation = "+";
        String expectedResult = "26,00";
        //WHEN
        String actualResult = calculator.calculate(first, second, operation);
        //THEN
        assertEquals(expectedResult, actualResult);
    }

    @Test //2
    @DisplayName("test for '-'")
    void testMinus() {
        //GIVEN
        double first = 6;
        double second = 20;
        String operation = "-";
        String expectedResult = "-14,00";
        //WHEN
        String actualResult = calculator.calculate(first, second, operation);
        //THEN
        assertEquals(expectedResult, actualResult);
    }

    @Test //3
    @DisplayName("test for '*'")
    void testMultiply() {
        //GIVEN
        double first = 6;
        double second = 20;
        String operation = "*";
        String expectedResult = "120,00";
        //WHEN
        String actualResult = calculator.calculate(first, second, operation);
        //THEN
        assertEquals(expectedResult, actualResult);
    }

    @Test //4
    @DisplayName("test for '/'")
    void testDivide() {
        //GIVEN
        double first = 6;
        double second = 20;
        String operation = "/";
        String expectedResult = "0,30";
        //WHEN
        String actualResult = calculator.calculate(first, second, operation);
        //THEN
        assertEquals(expectedResult, actualResult);
    }

    @Test //5
    @DisplayName("test for '%'")
    void testPercentage() {
        //GIVEN
        double first = 6;
        double second = 20;
        String operation = "%";
        String expectedResult = "1,20";
        //WHEN
        String actualResult = calculator.calculate(first, second, operation);
        //THEN
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @DisplayName("test for all ops")
    @CsvSource(value = {"+: 26,00", "-: -14,00", "*: 120,00", "/: 0,30", "%: 1,20"}, delimiter = ':')
    void test_CsvValue(String operation, String expectedResult) {
        //GIVEN
        double first = 6;
        double second = 20;
        //WHEN
        String actualResult = calculator.calculate(first, second, operation);
        //THEN
        assertEquals(expectedResult, actualResult);
    }

    @TestFactory //favourite
    @DisplayName("Test Factory")
    Iterable<DynamicTest> Tests() {
        return Arrays.asList(
                DynamicTest.dynamicTest("'+' test",
                        () -> assertEquals("26,00", calculator.calculate(6, 20, "+"))),

                DynamicTest.dynamicTest("'-' test",
                        () -> assertEquals("-14,00", calculator.calculate(6, 20, "-"))),

                DynamicTest.dynamicTest("'*' test",
                        () -> assertEquals("120,00", calculator.calculate(6, 20, "*"))),

                DynamicTest.dynamicTest("'/' test",
                        () -> assertEquals("0,30", calculator.calculate(6, 20, "/"))),

                DynamicTest.dynamicTest("'%' test",
                        () -> assertEquals("1,20", calculator.calculate(6, 20, "%"))));
    }

}
