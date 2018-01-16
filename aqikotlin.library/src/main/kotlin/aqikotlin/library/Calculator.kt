package aqikotlin.library

import aqikotlin.library.algorithms.Epa
import aqikotlin.library.algorithms.Mep
import aqikotlin.library.constants.*
import aqikotlin.library.utils.ConcentrationRounded
import aqikotlin.library.utils.Equations

class Calculator {

    private val listEpa = Epa().lists
    private val listMep = Mep().lists
    private var pollutantList: List<Number> = listOf()
    private var aqiList: List<Number> = listOf()

    fun getAqi(pollutantCode: String, pollutantConcentration: Number, algorithm: String = EPA): Int {
        val concentrationRounded = ConcentrationRounded(pollutantCode, pollutantConcentration.toDouble(), algorithm)
                .getRoundedConcentrationOnPollutantCode().toDouble()

        // Define selected algorithm
        val algorithmSelected = getAlgorithm(algorithm)

        // Define AQI breakpoints
        setAqiBreakpoints(algorithmSelected)

        // Associate pollutantCode to the corresponding pollutant list
        setPollutantBreakpoints(pollutantCode, algorithmSelected)

        // Define breakpoints for this pollutant at this concentration
        for ((i) in pollutantList.withIndex()) {
            try {
                if (concentrationRounded >= pollutantList[i].toDouble() &&
                        concentrationRounded <= pollutantList[i + 1].toDouble()) {
                    val bpLo = pollutantList[i]
                    val bpHi = pollutantList[i + 1]
                    // Get corresponding AQI boundaries
                    val inLo = aqiList[pollutantList.indexOf(bpLo)]
                    val inHi = aqiList[pollutantList.indexOf(bpHi)]
                    return Equations().concentrationToAqi(concentrationRounded, bpLo.toDouble(), bpHi.toDouble(),
                            inLo, inHi)
                }
            } catch (e: IndexOutOfBoundsException) {
                println("Pollutant Concentration not valid.")
            }
        }
        return 0
    }

    fun getConcentration(pollutantCode: String, aqiValue: Number, algorithm: String = EPA): Number {
        val aqiIndex = aqiValue.toInt()

        // Define selected algorithm
        val algorithmSelected = getAlgorithm(algorithm)

        // Define AQI breakpoints
        setAqiBreakpoints(algorithmSelected)

        // Associate pollutantCode to the corresponding pollutant list
        setPollutantBreakpoints(pollutantCode, algorithmSelected)

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

                    return ConcentrationRounded(pollutantCode, concentration, algorithm)
                            .getRoundedConcentrationOnPollutantCode()
                }
            } catch (e: IndexOutOfBoundsException) {
                println("Pollutant Concentration not valid.")
            }
        }
        return 0
    }

    private fun setPollutantBreakpoints(pollutantCode: String, algorithm: Map<String, List<Number>>) {
        try {
            when (pollutantCode) {
                POLLUTANT_PM25 -> pollutantList = algorithm[POLLUTANT_PM25]!!
                POLLUTANT_PM10 -> pollutantList = algorithm[POLLUTANT_PM10]!!
                POLLUTANT_CO_1H -> pollutantList = algorithm[POLLUTANT_CO_1H]!!
                POLLUTANT_CO_8H -> pollutantList = algorithm[POLLUTANT_CO_8H]!!
                POLLUTANT_CO_24H -> pollutantList = algorithm[POLLUTANT_CO_24H]!!
                POLLUTANT_NO2_1H -> pollutantList = algorithm[POLLUTANT_NO2_1H]!!
                POLLUTANT_NO2_24H -> pollutantList = algorithm[POLLUTANT_NO2_24H]!!
                POLLUTANT_SO2_1H -> pollutantList = algorithm[POLLUTANT_SO2_1H]!!
                POLLUTANT_SO2_24H -> pollutantList = algorithm[POLLUTANT_SO2_24H]!!
                POLLUTANT_O3_1H -> pollutantList = algorithm[POLLUTANT_O3_1H]!!
                POLLUTANT_O3_8H -> pollutantList = algorithm[POLLUTANT_O3_8H]!!
                else -> {
                }
            }
        } catch (e: NullPointerException) {
            println("Pollutant code not valid.")
        }

    }

    private fun setAqiBreakpoints(algorithm: Map<String, List<Number>>) {
        when (algorithm) {
            listEpa, listMep -> aqiList = algorithm[AQI]!!
        }
    }

    private fun getAlgorithm(algorithm: String): Map<String, List<Number>> {
        return when (algorithm) {
            EPA -> listEpa
            MEP -> listMep
            else -> {
                return listEpa
            }
        }
    }
}
