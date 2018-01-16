import calculator.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import utils.EPA
import utils.MEP
import utils.POLLUTANT_PM10
import utils.POLLUTANT_PM25

class CalculatorTest {

    @Test
    fun printResultForAqi() {
        // given
        val pollutantCode = POLLUTANT_PM10
        val value = 123
        val algorithm = EPA
        // when
        val result = Calculator().getAqi(pollutantCode, value, algorithm)
        // then
        assertEquals(85, result)
    }

    @Test
    fun printErrorForAqi() {
        // given
        val pollutantCode = "pm98"
        val value = 123
        val algorithm = EPA
        // when
        val result = Calculator().getAqi(pollutantCode, value, algorithm)
        // then
        assertEquals(0, result)
    }

    @Test
    fun printErrorOutOfRange() {
        // given
        val pollutantCode = POLLUTANT_PM25
        val value = 3012
        val algorithm = EPA
        // when
        val result = Calculator().getAqi(pollutantCode, value, algorithm)
        // then
        assertEquals(0, result)
    }

    @Test
    fun printIntResultForConcentration() {
        // given
        val pollutantCode = POLLUTANT_PM10
        val value = 123
        val algorithm = EPA
        // when
        val result = Calculator().getConcentration(pollutantCode, value, algorithm)
        // then
        assertEquals(199, result)
    }

    @Test
    fun printDoubleResultForConcentration() {
        // given
        val pollutantCode = POLLUTANT_PM25
        val value = 123
        val algorithm = EPA
        // when
        val result = Calculator().getConcentration(pollutantCode, value, algorithm)
        // then
        assertEquals(44.4, result)
    }

    @Test
    fun printErrorForConcentration() {
        // given
        val pollutantCode = "pm98"
        val value = 123
        val algorithm = EPA
        // when
        val result = Calculator().getConcentration(pollutantCode, value, algorithm)
        // then
        assertEquals(0, result)
    }

    @Test
    fun printAlgorithmSelected() {
        // given
        val pollutantCode = POLLUTANT_PM10
        val value = 123
        val algorithm = MEP
        // when
        val result = Calculator().getAqi(pollutantCode, value, algorithm)
        // then
        assertEquals(87, result)
    }
}