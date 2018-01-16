package aqikotlin.cmd

import aqikotlin.cmd.calculator.Calculator
import aqikotlin.cmd.utils.CommandLineInterface
import com.xenomachina.argparser.*
import aqikotlin.cmd.constants.*

fun main(args: Array<String>) = mainBody {
    try {
        val cli = CommandLineInterface(ArgParser(
                args = args,
                mode = ArgParser.Mode.GNU,
                helpFormatter = DefaultHelpFormatter()))

        val operation = cli.operation
        val algorithm = cli.algorithm
        val values = cli.values
        val list = cli.list

        values?.forEach {
            val pollutantCode = it.substringBefore(":")
            val value = it.substringAfter(":")
            Calculator().calculate(operation, algorithm, pollutantCode, value.toDouble())
        }

        when (list) {
            true -> println("EPA: ${EPA_UNITS} \nMEP: ${MEP_UNITS}")
        }

    } catch (ex: UnrecognizedOptionException) {
        println("Invalid option: ${ex.optName}")
    } catch (ex: NumberFormatException) {
        println("Invalid parameter: ${ex.message}")
    }
}