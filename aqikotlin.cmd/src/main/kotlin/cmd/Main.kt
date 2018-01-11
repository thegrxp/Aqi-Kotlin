package cmd

import com.xenomachina.argparser.*

fun main(args: Array<String>) = mainBody {
    try {
        val cli = CommandLineInterface(ArgParser(
                args = args,
                mode = ArgParser.Mode.GNU,
                helpFormatter = DefaultHelpFormatter()))

        val operation = cli.operation
        val values = cli.values
        val list = cli.list

        values?.forEach {
            val pollutantCode = it.substringBefore(":")
            val value = it.substringAfter(":")
            Calculator().calculate(operation, pollutantCode, value)
        }

        when (list) {
            true -> println("Pollutants: pm10 (µg/m³), o3 (ppm), co (ppm), no2 (ppb), so2 (ppb), pm25 (µg/m³)\n" +
                    "Formats: pm10 (pm10:174), o3 (o3:0.081), co (co:12.9), no2 (no2:431), so2 (so2:89), pm25 (pm25:37.8)")
        }

    } catch (ex: UnrecognizedOptionException) {
        println("Invalid option: ${ex.optName}")
    } catch (ex: NumberFormatException) {
        println("Invalid parameter: ${ex.message}")
    }
}