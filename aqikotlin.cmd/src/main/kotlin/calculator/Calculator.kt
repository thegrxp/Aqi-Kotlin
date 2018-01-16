package cmd.calculator

import calculator.Calculator
import cmd.utils.Algorithms
import cmd.utils.Operations
import utils.EPA
import utils.MEP

class Calculator {

    fun calculate(operations: Operations, algorithm: Algorithms, pollutantCode: String, value: Number): Number {
        val algorithmSelected: String

        when (algorithm) {
            Algorithms.EPA -> algorithmSelected = EPA
            Algorithms.MEP -> algorithmSelected = MEP
        }

        if (operations == Operations.AQI) {
            val result = Calculator().getAqi(pollutantCode, value, algorithmSelected)
            when (result == 0) {
                true -> println("$pollutantCode data is not valid ")
                false -> println("$pollutantCode:$result ")
            }
            return result
        } else if (operations == Operations.CONCENTRATION) {
            val result = Calculator().getConcentration(pollutantCode, value, algorithmSelected)
            when (result == 0) {
                true -> println("$pollutantCode data is not valid ")
                false -> println("$pollutantCode:$result ")
            }
            return result
        }
        return 0
    }
}