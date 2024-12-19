package br.edu.ifal.aulaprmo.extensions

import java.text.NumberFormat
import java.util.Locale


fun Double.toBrazilianCurrency(): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
    formatter.maximumFractionDigits = 0
    return formatter.format(this)
}

