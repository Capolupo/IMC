package com.example.logonrm.imc.extensions

/**
 * Created by logonrm on 27/02/2018.
 */

fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f",this)