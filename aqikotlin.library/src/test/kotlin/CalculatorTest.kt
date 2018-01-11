import calculator.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun printResultForAqi() {
        // given
        val pollutantCode = "pm10"
        val value = "123"
        // when
        val result = Calculator().getAqi(pollutantCode, value)
        // then
        assertEquals(85, result)
    }

    @Test
    fun printErrorForAqi() {
        // given
        val pollutantCode = "pm98"
        val value = "123"
        // when
        val result = Calculator().getAqi(pollutantCode, value)
        // then
        assertEquals(0, result)
    }

    @Test
    fun printErrorOutOfRange() {
        // given
        val pollutantCode = "pm25"
        val value = "3012"
        // when
        val result = Calculator().getAqi(pollutantCode, value)
        // then
        assertEquals(0, result)
    }

    @Test
    fun printIntResultForConcentration() {
        // given
        val pollutantCode = "pm10"
        val value = "123"
        // when
        val result = Calculator().getConcentration(pollutantCode, value)
        // then
        assertEquals(199, result)
    }

    @Test
    fun printDoubleResultForConcentration() {
        // given
        val pollutantCode = "pm25"
        val value = "123"
        // when
        val result = Calculator().getConcentration(pollutantCode, value)
        // then
        assertEquals(44.4, result)
    }

    @Test
    fun printErrorForConcentration() {
        // given
        val pollutantCode = "pm98"
        val value = "123"
        // when
        val result = Calculator().getConcentration(pollutantCode, value)
        // then
        assertEquals(0, result)
    }
}