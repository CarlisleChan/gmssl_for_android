package com.example.gmssl

object Crypto {
    external fun sha1(`in`: ByteArray, length: Int): ByteArray

    external fun sm3(`in`: ByteArray, length: Int): ByteArray

    external fun aesEnc(`in`: ByteArray, length: Int, key: ByteArray): ByteArray

    external fun aesDec(`in`: ByteArray, length: Int, key: ByteArray): ByteArray

    external fun sm4Enc(`in`: ByteArray, length: Int, key: ByteArray): ByteArray

    external fun sm4Dec(`in`: ByteArray, length: Int, key: ByteArray): ByteArray

    external fun sm2Enc(`in`: ByteArray, length: Int): ByteArray

    external fun sm2Dec(`in`: ByteArray, length: Int): ByteArray

    external fun sm2Sign(`in`: ByteArray, length: Int): ByteArray

    external fun sm2Verify(`in`: ByteArray, length: Int, sign: ByteArray, signLen: Int): Int

    external fun genSM2KeyPairs(path: String): Int
}