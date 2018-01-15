import calculator.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun printResultForAqi() {
        // given
        val pollutantCode = "pm10"
        val value = "123"
        val algorithm = "epa"
        // when
        val result = Calculator().getAqi(pollutantCode, value, algorithm)
        // then
        assertEquals(85, result)
    }

    @Test
    fun printErrorForAqi() {
        // given
        val pollutantCode = "pm98"
        val value = "123"
        val algorithm = "epa"
        // when
        val result = Calculator().getAqi(pollutantCode, value, algorithm)
        // then
        assertEquals(0, result)
    }

    @Test
    fun printErrorOutOfRange() {
        // given
        val pollutantCode = "pm25"
        val value = "3012"
        val algorithm = "epa"
        // when
        val result = Calculator().getAqi(pollutantCode, value, algorithm)
        // then
        assertEquals(0, result)
    }

    @Test
    fun printIntResultForConcentration() {
        // given
        val pollutantCode = "pm10"
        val value = "123"
        val algorithm = "epa"
        // when
        val result = Calculator().getConcentration(pollutantCode, value, algorithm)
        // then
        assertEquals(199, result)
    }

    @Test
    fun printDoubleResultForConcentration() {
        // given
        val pollutantCode = "pm25"
        val value = "123"
        val algorithm = "epa"
        // when
        val result = Calculator().getConcentration(pollutantCode, value, algorithm)
        // then
        assertEquals(44.4, result)
    }

    @Test
    fun printErrorForConcentration() {
        // given
        val pollutantCode = "pm98"
        val value = "123"
        val algorithm = "epa"
        // when
        val result = Calculator().getConcentration(pollutantCode, value, algorithm)
        // then
        assertEquals(0, result)
    }
}