package com.example.lab2_interactionactivities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etMessage: EditText = findViewById<EditText>(R.id.etMessage)
        val btnSend: Button = findViewById<Button>(R.id.btnSend)
        btnSend.setOnClickListener{
            this.sendMessage(etMessage.text.toString());
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun sendMessage(message: String){
        val intent = Intent(this,activity_result::class.java)
        intent.putExtra("param",message)
        startActivity(intent)
    }
}