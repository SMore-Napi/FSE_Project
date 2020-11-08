package com.example.innorussian.account

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.innorussian.R
import kotlinx.android.synthetic.main.activity_my_account.*

class MyAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_account)

        btn_logout.setOnClickListener {
            Intent(this, LogInActivity::class.java).also{
                startActivity(it)

            }
        }
    }



}