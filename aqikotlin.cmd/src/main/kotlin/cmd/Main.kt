package cmd

import algorithms.Epa
import algorithms.Mep
import cmd.calculator.Calculator
import cmd.utils.CommandLineInterface
import com.xenomachina.argparser.*

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
            true -> println("EPA: " + Epa().units + "\nMEP: " + Mep().units)
        }

    } catch (ex: UnrecognizedOptionException) {
        println("Invalid option: ${ex.optName}")
    } catch (ex: NumberFormatException) {
        println("Invalid parameter: ${ex.message}")
    }
}