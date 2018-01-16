package aqikotlin.library.utils

import kotlin.math.round

internal class Equations {

    fun concentrationToAqi(cp: Double, bpLo: Double, bpHi: Double, inLo: Number, inHi: Number): Int {
        return round((inHi.toInt() - inLo.toInt()) / (bpHi - bpLo) * (cp - bpLo) + inLo.toInt()).toInt()
    }

    fun aqiToConcentration(inAqi: Int, bpLo: Double, bpHi: Double, inLo: Double, inHi: Double): Double {
        return ((inAqi - inLo) * (bpHi - bpLo) / (inHi - inLo) + bpLo)
    }
}

