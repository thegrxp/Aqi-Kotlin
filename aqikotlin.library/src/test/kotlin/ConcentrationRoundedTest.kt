import elements.ConcentrationRounded
import elements.POLLUTANT_CO
import elements.POLLUTANT_O3
import elements.POLLUTANT_PM10
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConcentrationRoundedTest {
    @Test
    fun roundToInteger() {
        // given
        val pollutantCode = POLLUTANT_PM10
        val pollutantConcentration = 123.234
        // when
        val result = ConcentrationRounded(pollutantCode, pollutantConcentration).
                getRoundedConcentrationOnPollutantCode()
        // then
        assertEquals(123, result)
    }

    @Test
    fun roundToOneDecimalPlace() {
        // given
        val pollutantCode = POLLUTANT_CO
        val pollutantConcentration = 10.76455
        // when
        val result = ConcentrationRounded(pollutantCode, pollutantConcentration).
                getRoundedConcentrationOnPollutantCode()
        // then
        assertEquals(10.8, result)
    }

    @Test
    fun roundToThreeDecimalPlace() {
        // given
        val pollutantCode = POLLUTANT_O3
        val pollutantConcentration = 0.07621231
        // when
        val result = ConcentrationRounded(pollutantCode, pollutantConcentration).
                getRoundedConcentrationOnPollutantCode()
        // then
        assertEquals(0.076, result)
    }
}