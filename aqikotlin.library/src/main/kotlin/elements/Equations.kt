package elements

import kotlin.math.round

class Equations {

    fun concentrationToAqi(cp: Double, bpLo: Double, bpHi: Double, inLo: Int, inHi: Int): Int {
        return round((inHi - inLo) / (bpHi - bpLo) * (cp - bpLo) + inLo).toInt()
    }

    fun aqiToConcentration(inAqi: Int, bpLo: Double, bpHi: Double, inLo: Double, inHi: Double): Double {
        return ((inAqi - inLo) * (bpHi - bpLo) / (inHi - inLo) + bpLo)
    }
}

