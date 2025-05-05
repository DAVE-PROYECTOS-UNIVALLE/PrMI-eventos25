package com.example.eventos25

import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.*

class TerceraActividad : AppCompatActivity() {
    private lateinit var img3 : ImageView
    private lateinit var detectorGestos : ScaleGestureDetector
    private var escala = 1.0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tercera_actividad)
        img3= findViewById(R.id.img3)
        detectorGestos = ScaleGestureDetector(this,
            object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
                override fun onScale(detector: ScaleGestureDetector): Boolean {
                    escala *= detector.scaleFactor
                    // redducion de tamanio y ampliacion
                    escala = max(0.5f, min(escala,5.0f))
                    img3.scaleX = escala
                    img3.scaleY = escala
                    return true

                }
                
            })
        img3.setOnTouchListener { view, event ->
            detectorGestos.onTouchEvent(event)
            if(event.action== MotionEvent.ACTION_UP){
                view.performClick()
            }
            true
        }
    }
}