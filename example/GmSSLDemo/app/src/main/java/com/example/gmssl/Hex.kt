package com.example.gmssl

fun ByteArray.toHexString() = joinToString("") { "%02x".format(it) }
