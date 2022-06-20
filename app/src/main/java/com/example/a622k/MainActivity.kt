package com.example.a622k

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var edit_name: EditText? = null
    private var edit_email: EditText? = null
    private var edit_password: EditText? = null
    private var edit_passwordConfirm: EditText? = null
    private var load_name: TextView? = null
    private var load_email: TextView? = null
    private var load_psw: TextView? = null
    private var load_pswC: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit_name = findViewById(R.id.edit_name);
        edit_email = findViewById(R.id.edit_email);
        edit_password = findViewById(R.id.edit_password);
        edit_passwordConfirm = findViewById(R.id.edit_passwordConfirm);
        load_name = findViewById(R.id.load_name)
        load_email = findViewById(R.id.load_email)
        load_psw = findViewById(R.id.load_psw)
        load_pswC = findViewById(R.id.load_pswC)
        save();
        load();
    }

    @SuppressLint("SetTextI18n")
    private fun load() {
        val button_load = findViewById<Button>(R.id.button_load)
        button_load.setOnClickListener { view: View? ->
            val prefs = applicationContext.getSharedPreferences(
                "MyPref",
                MODE_PRIVATE
            )
            val name = prefs.getString("name", null)
            val email = prefs.getString("email", null)
            val psw = prefs.getString("psw", null)
            val psw_c = prefs.getString("psw_c", null)
            if (name != null || email != null || psw != null || psw_c != null) {
                load_name!!.text = "Full name: $name"
                load_email!!.text = "Email : $email"
                load_psw!!.text = "Password : $psw"
                load_pswC!!.text = "Password Confirm : $psw_c"
            }
        }
    }

    private fun save() {
        val button_register = findViewById<Button>(R.id.button_register)
        button_register.setOnClickListener { view: View? ->
            val prefs = applicationContext.getSharedPreferences(
                "MyPref",
                MODE_PRIVATE
            )
            val editor = prefs.edit()
            editor.putString("name", edit_name!!.text.toString())
            editor.putString("email", edit_email!!.text.toString())
            editor.putString("psw", edit_password!!.text.toString())
            editor.putString("psw_c", edit_passwordConfirm!!.text.toString())
            editor.apply()
        }

    }
}