package aqikotlin.cmd.utils

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.default

class CommandLineInterface(parser: ArgParser) {

    val operation: Operations by parser.mapping(
            "--aqi" to Operations.AQI,
            "--cc" to Operations.CONCENTRATION,
            help = "The operation to use, default operation is '--aqi'." +
                    " '--aqi' convert a pollutant to its AQI." +
                    " '--cc' convert an AQI to its pollutant concentration.")
            .default(Operations.AQI)

    val algorithm: Algorithms by parser.mapping(
            "--epa" to Algorithms.EPA,
            "--mep" to Algorithms.MEP,
            help = "The algorithm to use, default algorithm is '--epa'." +
                    " '--epa' select United States Environmental Protection Agency (EPA) algorithm." +
                    " '--mep' select China Ministry of Environmental Protection (MEP) algorithm.")
            .default(Algorithms.EPA)

    val list by parser.flagging("-l",
            "--list",
            help = "List supported library.algorithms, pollutants and units.")

    val values by parser.positionalList("Format: 'pm25:136'. Use '-l' argument to list available pollutants.",
            1..Int.MAX_VALUE).default(null)
}