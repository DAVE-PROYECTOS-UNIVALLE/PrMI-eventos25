package com.example.eventos25

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SegundaActividad : AppCompatActivity() {
    private lateinit var tv2 : TextView
    private lateinit var btn2 : Button
    private lateinit var img2 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda_actividad)
        tv2= findViewById(R.id.tv2)
        btn2 = findViewById(R.id.btn2)
        img2 = findViewById(R.id.img2)

        btn2.setOnLongClickListener {
            Toast.makeText(this,
                "Ahora si longclick",
                Toast.LENGTH_LONG).show()
            true
        }
        btn2.setOnClickListener {
            Toast.makeText(this,
            "solo click, necesitas presionar mas",
            Toast.LENGTH_LONG).show() }

    }
}