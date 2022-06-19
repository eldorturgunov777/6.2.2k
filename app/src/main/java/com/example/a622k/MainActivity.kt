package com.example.a622k

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.a622k.manager.PrefsManager


class MainActivity : AppCompatActivity() {
    private var edit_name: EditText? = null
    private var edit_email: EditText? = null
    private var edit_password: EditText? = null
    private var edit_passwordConfirm: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit_name = findViewById(R.id.edit_name);
        edit_email = findViewById(R.id.edit_email);
        edit_password = findViewById(R.id.edit_password);
        edit_passwordConfirm = findViewById(R.id.edit_passwordConfirm);
    }

    fun button_register(view: View) {
        val name = edit_name!!.text.toString()
        val email = edit_email!!.text.toString()
        val psw = edit_password!!.text.toString()
        val psw_conf = edit_passwordConfirm!!.text.toString()

        PrefsManager.getInstance(this)!!.saveData("name", name)
        PrefsManager.getInstance(this)!!.saveData("email", email)
        PrefsManager.getInstance(this)!!.saveData("psw", psw)
        PrefsManager.getInstance(this)!!.saveData("psw_conf", psw_conf)
    }
}