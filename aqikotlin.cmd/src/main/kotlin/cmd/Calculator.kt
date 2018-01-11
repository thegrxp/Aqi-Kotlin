package cmd

import calculator.Calculator

class Calculator {

    fun calculate(operations: Operations, pollutantCode: String, value: String): Number {
        if (operations == Operations.AQI) {
            val result = Calculator().getAqi(pollutantCode, value)
            when (result == 0) {
                true -> println("$pollutantCode data is not valid ")
                false -> println("$pollutantCode:$result ")
            }
            return result
        } else if (operations == Operations.CONCENTRATION) {
            val result = Calculator().getConcentration(pollutantCode, value)
            when (result == 0) {
                true -> println("$pollutantCode data is not valid ")
                false -> println("$pollutantCode:$result ")
            }
            return result
        }
        return 0
    }
}