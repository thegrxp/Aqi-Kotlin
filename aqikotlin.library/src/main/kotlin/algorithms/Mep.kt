package algorithms

import utils.*

class Mep {

    private val aqi: List<Number> = listOf(
            0, 50,
            51, 100,
            101, 150,
            151, 200,
            201, 300,
            301, 400,
            401, 500)

    private val pm25: List<Number> = listOf(
            0.0, 35,
            36, 75,
            76, 115,
            116, 150,
            151, 250,
            251, 350,
            351, 500)

    private val pm10: List<Number> = listOf(
            0.0, 50,
            51, 150,
            151, 250,
            251, 350,
            351, 420,
            421, 500,
            501, 600)

    private val co_1h: List<Number> = listOf(
            0.0, 5,
            6, 10,
            11, 35,
            36, 60,
            61, 90,
            91, 120,
            121, 150)

    private val co_24h: List<Number> = listOf(
            0.0, 2,
            3, 4,
            5, 14,
            15, 24,
            25, 36,
            37, 48,
            49, 60)

    private val no2_1h: List<Number> = listOf(
            0.0, 100,
            101, 200,
            201, 700,
            701, 1200,
            1201, 2340,
            2341, 3090,
            3091, 3840)

    private val no2_24h: List<Number> = listOf(
            0.0, 40,
            41, 80,
            81, 180,
            181, 280,
            281, 565,
            566, 750,
            751, 940)

    private val so2_1h: List<Number> = listOf(
            0.0, 150,
            151, 500,
            501, 650,
            651, 800)

    private val so2_24h: List<Number> = listOf(
            0.0, 50,
            51, 150,
            151, 475,
            476, 800,
            801, 1600,
            1601, 2100,
            2101, 2620)

    private val o3_1h: List<Number> = listOf(
            0.0, 160,
            161, 200,
            201, 300,
            301, 400,
            401, 800,
            801, 1000,
            1001, 1200)

    private val o3_8h: List<Number> = listOf(
            0.0, 100,
            101, 160,
            161, 215,
            216, 265,
            266, 800)

    val lists: Map<String, List<Number>> = mapOf(
            AQI to aqi,
            POLLUTANT_PM25 to pm25,
            POLLUTANT_PM10 to pm10,
            POLLUTANT_CO_1H to co_1h,
            POLLUTANT_CO_24H to co_24h,
            POLLUTANT_NO2_1H to no2_1h,
            POLLUTANT_NO2_24H to no2_24h,
            POLLUTANT_SO2_1H to so2_1h,
            POLLUTANT_SO2_24H to so2_24h,
            POLLUTANT_O3_1H to o3_1h,
            POLLUTANT_O3_8H to o3_8h)

    val units = listOf(
            "$POLLUTANT_PM10 (µg/m³)",
            "$POLLUTANT_O3_1H (µg/m³)",
            "$POLLUTANT_O3_8H (µg/m³)",
            "$POLLUTANT_CO_1H (mg/m³)",
            "$POLLUTANT_CO_24H (mg/m³)",
            "$POLLUTANT_NO2_1H (µg/m³)",
            "$POLLUTANT_NO2_24H (µg/m³)",
            "$POLLUTANT_SO2_1H (µg/m³)",
            "$POLLUTANT_SO2_24H (µg/m³)",
            "$POLLUTANT_PM25 (µg/m³)")
}