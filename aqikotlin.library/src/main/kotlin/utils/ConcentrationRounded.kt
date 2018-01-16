package utils

import kotlin.math.round

class ConcentrationRounded(private val pollutantCode: String, private val pollutantConcentration: Double,
                           private val algorithm: String){

    fun getRoundedConcentrationOnPollutantCode(): Number {
        if (algorithm == EPA) {
            return when (pollutantCode) {
                POLLUTANT_PM10, POLLUTANT_NO2_1H, POLLUTANT_SO2_1H -> round(pollutantConcentration).toInt()
                POLLUTANT_PM25, POLLUTANT_CO_8H -> round(pollutantConcentration * 10) / 10
                POLLUTANT_O3_1H, POLLUTANT_O3_8H -> round(pollutantConcentration * 1000) / 1000
                else -> {
                    0
                }
            }
        } else if (algorithm == MEP) {
            return round(pollutantConcentration).toInt()
        }
        return 0
    }
}

