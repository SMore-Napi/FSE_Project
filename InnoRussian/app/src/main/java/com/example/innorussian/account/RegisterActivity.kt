package com.example.innorussian.account

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.innorussian.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_create_account.setOnClickListener {
            Intent(this, MyAccountActivity::class.java).also {
                startActivity(it)
            }
        }
    }

}