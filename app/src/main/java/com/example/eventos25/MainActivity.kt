package com.example.eventos25

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btn1 : Button
    private lateinit var tv1 : TextView
    private lateinit var img1 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btn1 = findViewById(R.id.btn1)
        tv1 = findViewById(R.id.tv1)
        img1 = findViewById(R.id.img3)

        btn1.setOnClickListener {
            Toast.makeText(this,
                "Haz hecho click en el boton",
                Toast.LENGTH_LONG).show()
            val intent = Intent(this,
                SegundaActividad::class.java)
            startActivity(intent)
        }
        tv1.setOnClickListener {
            Toast.makeText(this,
                "Haz hecho click en el textview",
                Toast.LENGTH_LONG).show()
        }
        img1.setOnClickListener {
            Toast.makeText(this,
                "Haz hecho click en la imagen",
                Toast.LENGTH_LONG).show()
        }
    }
}