package elements

import kotlin.math.round

class ConcentrationRounded(private val pollutantCode: String, private val pollutantConcentration: Double){

    fun getRoundedConcentrationOnPollutantCode(): Number {
        return when (pollutantCode) {
            POLLUTANT_PM10, POLLUTANT_NO2, POLLUTANT_SO2 -> round(pollutantConcentration).toInt()
            POLLUTANT_PM25, POLLUTANT_CO -> round(pollutantConcentration * 10) / 10
            POLLUTANT_O3 -> round(pollutantConcentration * 1000) / 1000
            else -> {
                0
            }
        }
    }
}

