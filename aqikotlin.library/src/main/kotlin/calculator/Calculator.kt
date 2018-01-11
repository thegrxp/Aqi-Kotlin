package calculator

import elements.*

class Calculator {

    private val bpAqi = AqiEpa().aqi
    private val bpPM25 = AqiEpa().pm25
    private val bpPM10 = AqiEpa().pm10
    private val bpCO = AqiEpa().co
    private val bpNO2 = AqiEpa().no2
    private val bpSO2 = AqiEpa().so2
    private val bpO3 = AqiEpa().o3
    private var list: List<Number> = listOf()

    fun getAqi(pollutantCode: String, pollutantConcentration: String): Int {
        val concentrationRounded = ConcentrationRounded(pollutantCode, pollutantConcentration.toDouble())
                .getRoundedConcentrationOnPollutantCode().toDouble()

        when (pollutantCode) {
            POLLUTANT_PM25 -> list = bpPM25
            POLLUTANT_PM10 -> list = bpPM10
            POLLUTANT_CO -> list = bpCO
            POLLUTANT_NO2 -> list = bpNO2
            POLLUTANT_SO2 -> list = bpSO2
            POLLUTANT_O3 -> list = bpO3
            else -> {
            }
        }

        // Define breakpoints for this pollutant at this concentration
        for ((i) in list.withIndex()) {
            try {
                if (concentrationRounded >= list[i].toDouble() && concentrationRounded <= list[i + 1].toDouble()) {
                    val bpLo = list[i]
                    val bpHi = list[i + 1]
                    // Get corresponding AQI boundaries
                    val inLo = bpAqi[list.indexOf(bpLo)]
                    val inHi = bpAqi[list.indexOf(bpHi)]
                    return Equations().concentrationToAqi(concentrationRounded, bpLo.toDouble(), bpHi.toDouble(),
                            inLo, inHi)
                }
            } catch (e: IndexOutOfBoundsException) {
                // Value is out of bounds, error message send in 'fun calculate()'
            }
        }
        return 0
    }

    fun getConcentration(pollutantCode: String, aqiValue: String): Number {
        val aqiIndex = aqiValue.toInt()

        when (pollutantCode) {
            POLLUTANT_PM25 -> list = bpPM25
            POLLUTANT_PM10 -> list = bpPM10
            POLLUTANT_CO -> list = bpCO
            POLLUTANT_NO2 -> list = bpNO2
            POLLUTANT_SO2 -> list = bpSO2
            POLLUTANT_O3 -> list = bpO3
            else -> {
            }
        }

        // Define breakpoints for this AQI
        for ((i) in bpAqi.withIndex()) {
            try {
                if (aqiIndex >= bpAqi[i].toDouble() && aqiIndex <= bpAqi[i + 1].toDouble()) {
                    val inLo = bpAqi[i]
                    val inHi = bpAqi[i + 1]
                    // Get corresponding pollutant boundaries
                    val bpLo = list[bpAqi.indexOf(inLo)]
                    val bpHi = list[bpAqi.indexOf(inHi)]

                    val concentration = Equations().aqiToConcentration(aqiIndex, bpLo.toDouble(), bpHi.toDouble(),
                            inLo.toDouble(), inHi.toDouble())

                    return when (pollutantCode) {
                        POLLUTANT_PM10, POLLUTANT_NO2, POLLUTANT_SO2 ->
                            ConcentrationRounded(pollutantCode, concentration)
                                    .getRoundedConcentrationOnPollutantCode().toInt()
                        else -> {
                            ConcentrationRounded(pollutantCode, concentration)
                                    .getRoundedConcentrationOnPollutantCode().toDouble()
                        }
                    }
                }
            } catch (e: IndexOutOfBoundsException) {
                // Value is out of bounds, error message send in 'fun calculate()'
            }
        }
        return 0
    }
}
