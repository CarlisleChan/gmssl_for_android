package com.example.gmssl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dialog: InputDialog by lazy { InputDialog(this) }

    private val key = "0123456789abcdef"

    private var plain = ""
    private var result = byteArrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupCrypto()
        setupView()
    }

    private fun setupCrypto() {
        Crypto.genSM2KeyPairs(getKeyPath() ?: return)
    }

    private fun setupView() {
        btn_aes_enc.setOnClickListener {
            dialog.show()
            plain = dialog.getInput()
            val cipher = Crypto.aesEnc(plain.toByteArray(), plain.toByteArray().size, key.toByteArray())
            result = cipher
            tv_result.text = "明文：$plain\n\nkey：$key\n\n密文：${cipher.toHexString()}"
        }
        btn_aes_dec.setOnClickListener {
            val cipher = result
            val plain = Crypto.aesDec(cipher, cipher.size, key.toByteArray())
            tv_result.text = "密文：${cipher.toHexString()}\n\nkey：$key\n\n明文：${String(plain)}"
        }
        btn_sha1.setOnClickListener {
            dialog.show()
            plain = dialog.getInput()
            val cipher = Crypto.sha1(plain.toByteArray(), plain.toByteArray().size)
            result = cipher
            tv_result.text = "明文：$plain\n\n摘要：${cipher.toHexString()}"
        }
        btn_sm3.setOnClickListener {
            dialog.show()
            plain = dialog.getInput()
            val cipher = Crypto.sm3(plain.toByteArray(), plain.toByteArray().size)
            result = cipher
            tv_result.text = "明文：$plain\n\n摘要：${cipher.toHexString()}"
        }
        btn_sm4_enc.setOnClickListener {
            dialog.show()
            plain = dialog.getInput()
            val cipher = Crypto.sm4Enc(plain.toByteArray(), plain.toByteArray().size, key.toByteArray())
            result = cipher
            tv_result.text = "明文：$plain\n\nkey：$key\n\n密文：${cipher.toHexString()}"
        }
        btn_sm4_dec.setOnClickListener { 
            val cipher = result
            val plain = Crypto.sm4Dec(cipher, cipher.size, key.toByteArray())
            tv_result.text = "密文：${cipher.toHexString()}\n\nkey：$key\n\n明文：${String(plain)}"
        }
        btn_sm2_enc.setOnClickListener {
            dialog.show()
            plain = dialog.getInput()
            val cipher = Crypto.sm2Enc(plain.toByteArray(), plain.toByteArray().size)
            result = cipher
            tv_result.text = "明文：$plain\n\nkey path：${getKeyPath()}\n\n密文：${cipher.toHexString()}"
        }
        btn_sm2_dec.setOnClickListener { 
            val cipher = result
            val plain = Crypto.sm2Dec(cipher, cipher.size)
            tv_result.text = "密文：${cipher.toHexString()}\n\nkey path：${getKeyPath()}\n\n明文：${String(plain)}"
        }
        btn_sm2_sign.setOnClickListener {
            dialog.show()
            plain = dialog.getInput()
            val cipher = Crypto.sm2Sign(plain.toByteArray(), plain.toByteArray().size)
            result = cipher
            tv_result.text = "明文：$plain\n\nkey path：${getKeyPath()}\n\n签名：${cipher.toHexString()}"
        }
        btn_sm2_verify_sign.setOnClickListener {
            val cipher = result
            val result = Crypto.sm2Verify(plain.toByteArray(), plain.toByteArray().size, cipher, cipher.size) == 1
            tv_result.text = "明文：$plain\n\nkey path：${getKeyPath()}\n\n签名：${cipher.toHexString()}\n\n验签：$result"
        }


    }

    private fun getKeyPath() = externalCacheDir?.absolutePath

}