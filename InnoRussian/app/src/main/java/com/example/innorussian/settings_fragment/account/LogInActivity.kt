package com.example.innorussian.settings_fragment.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.innorussian.R
import kotlinx.android.synthetic.main.activity_login.*

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btn_register.setOnClickListener{
            Intent(this, RegisterActivity::class.java).also {
                startActivity(it)
            }
        }

        btn_login.setOnClickListener {
            Intent(this, MyAccountActivity::class.java ).also{
                startActivity(it)
            }
        }



    }



}