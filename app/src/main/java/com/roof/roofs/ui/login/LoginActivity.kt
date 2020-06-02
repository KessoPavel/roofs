package com.roof.roofs.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.roof.roofs.MainActivity
import com.roof.roofs.R
import com.roof.roofs.data.Repository
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton.setOnClickListener {
            val userLogin = login.text.toString()
            val pass = Repository.getPassword(userLogin)
            if (pass == password.text.toString()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Wrong login or password", Toast.LENGTH_LONG).show()
            }
        }
    }
}