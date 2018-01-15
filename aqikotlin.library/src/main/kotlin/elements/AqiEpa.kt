package elements

class AqiEpa {

    private val aqi: List<Number> = listOf(
            0, 50,
            51, 100,
            101, 150,
            151, 200,
            201, 300,
            301, 400,
            401, 500)

    private val pm25: List<Number> = listOf(
            0.0, 12.0,
            12.1, 35.4,
            35.5, 55.4,
            55.5, 150.4,
            150.5, 250.4,
            250.5, 350.4,
            350.5, 500.4)

    private val pm10: List<Number> = listOf(
            0, 54,
            55, 154,
            155, 254,
            255, 354,
            355, 424,
            425, 504,
            505, 604)

    private val co: List<Number> = listOf(
            0.0, 4.4,
            4.5, 9.4,
            9.5, 12.4,
            12.5, 15.4,
            15.5, 30.4,
            30.5, 40.4,
            40.5, 50.4)

    private val no2: List<Number> = listOf(
            0, 53,
            54, 100,
            101, 360,
            361, 649,
            650, 1249,
            1250, 1649,
            1650, 2049)

    private val so2: List<Number> = listOf(
            0, 35,
            36, 75,
            76, 185,
            186, 304,
            305, 604,
            605, 804,
            805, 1004)

    private val o3: List<Number> = listOf(
            0.000, 0.054,
            0.055, 0.070,
            0.071, 0.085,
            0.086, 0.105,
            0.106, 0.200)

    val lists: List<List<Number>> = listOf(aqi, pm25, pm10, co, no2, so2, o3)
}