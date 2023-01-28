package com.brisson.finde

import android.text.format.DateUtils
import android.text.format.DateUtils.SECOND_IN_MILLIS
import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

fun formatLongToDate(long: Long): CharSequence {
    return DateUtils.getRelativeTimeSpanString(long, System.currentTimeMillis(), SECOND_IN_MILLIS)
}

fun compactDecimalFormat(numValue: Long): String {
    val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')

    val value = floor(log10(numValue.toDouble())).toInt()
    val base = value / 3

    return if (value >= 3 && base < suffix.size) {
        DecimalFormat("#0.0").format(
            numValue / 10.0.pow((base * 3).toDouble())
        ) + suffix[base]
    } else {
        DecimalFormat("#,##0").format(numValue)
    }
}