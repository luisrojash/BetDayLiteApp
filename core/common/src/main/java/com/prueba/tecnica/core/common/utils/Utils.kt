package com.prueba.tecnica.core.common.utils

import java.text.SimpleDateFormat
import java.util.Locale

object Utils {
    fun formatDate(dateString: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd MMM HH:mm", Locale.getDefault())

        val date = inputFormat.parse(dateString)
        return if (date != null) {
            outputFormat.format(date)
        } else {
            "-"
        }
    }
}