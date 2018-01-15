package calculator

import elements.*

class Calculator {

    private val listEpa = AqiEpa().lists
    private var pollutantList: List<Number> = listOf()
    private var aqiList: List<Number> = listOf()

    fun getAqi(pollutantCode: String, pollutantConcentration: String, algorithm: String = US_EPA): Int {
        val concentrationRounded = ConcentrationRounded(pollutantCode, pollutantConcentration.toDouble())
                .getRoundedConcentrationOnPollutantCode().toDouble()

        // Define selected algorithm
        val algorithmSelected = getAlgorithm(algorithm)

        // Associate pollutantCode to the corresponding pollutant list
        setPollutant(pollutantCode, algorithmSelected)

        // Define breakpoints for this pollutant at this concentration
        for ((i) in pollutantList.withIndex()) {
            try {
                if (concentrationRounded >= pollutantList[i].toDouble() && concentrationRounded <= pollutantList[i + 1].toDouble()) {
                    val bpLo = pollutantList[i]
                    val bpHi = pollutantList[i + 1]
                    // Get corresponding AQI boundaries
                    val inLo = aqiList[pollutantList.indexOf(bpLo)]
                    val inHi = aqiList[pollutantList.indexOf(bpHi)]
                    return Equations().concentrationToAqi(concentrationRounded, bpLo.toDouble(), bpHi.toDouble(),
                            inLo, inHi)
                }
            } catch (e: IndexOutOfBoundsException) {
                // Value is out of bounds, error message send in 'fun calculate()'
            }
        }
        return 0
    }

    fun getConcentration(pollutantCode: String, aqiValue: String, algorithm: String = US_EPA): Number {
        val aqiIndex = aqiValue.toInt()

        // Define selected algorithm
        val algorithmSelected = getAlgorithm(algorithm)

        // Associate pollutantCode to the corresponding pollutant list
        setPollutant(pollutantCode, algorithmSelected)

        // Define breakpoints for this AQI
        for ((i) in aqiList.withIndex()) {
            try {
                if (aqiIndex >= aqiList[i].toDouble() && aqiIndex <= aqiList[i + 1].toDouble()) {
                    val inLo = aqiList[i]
                    val inHi = aqiList[i + 1]
                    // Get corresponding pollutant boundaries
                    val bpLo = pollutantList[aqiList.indexOf(inLo)]
                    val bpHi = pollutantList[aqiList.indexOf(inHi)]

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

    private fun setPollutant(pollutantCode: String, algorithm: List<List<Number>>) {
        when (pollutantCode) {
            AQI -> aqiList = algorithm[0]
            POLLUTANT_PM25 -> pollutantList = algorithm[1]
            POLLUTANT_PM10 -> pollutantList = algorithm[2]
            POLLUTANT_CO -> pollutantList = algorithm[3]
            POLLUTANT_NO2 -> pollutantList = algorithm[4]
            POLLUTANT_SO2 -> pollutantList = algorithm[5]
            POLLUTANT_O3 -> pollutantList = algorithm[6]
            else -> {
            }
        }
    }

    private fun getAlgorithm(algorithm: String): List<List<Number>> {
        return when (algorithm) {
            US_EPA -> listEpa
            // TODO: create MEP list
            else -> {
                return listEpa
            }
        }
    }
}
