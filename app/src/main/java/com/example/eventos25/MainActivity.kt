package com.example.eventos25

import android.app.ComponentCaller
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private lateinit var btn1 : Button
    private lateinit var tv1 : TextView
    private lateinit var img1 : ImageView
    private lateinit var btnPopUp : Button
    private lateinit var btn5 : Button
    private lateinit var btn6 : Button
    private val CODIGO_GALERIA = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btn1 = findViewById(R.id.btn1)
        tv1 = findViewById(R.id.tv1)
        img1 = findViewById(R.id.img3)
        btnPopUp = findViewById(R.id.btnPopUp)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn1.setOnClickListener {
            Snackbar.make(findViewById(R.id.main),
                "Primer snack bar", Snackbar.LENGTH_LONG)
                .setAction("aceptar"){

                }.show()

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
        btnPopUp.setOnClickListener { view ->
            mostrarPopUp(view)
        }
        registerForContextMenu(tv1)

        btn5.setOnClickListener {
            enviarWhatsapp()
        }
        btn6.setOnClickListener {
            recibirImagenes()
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context, menu)
        menu?.setHeaderTitle("Opciones")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.ctit1 -> {
                Toast.makeText(this,
                    "elemento 1",
                    Toast.LENGTH_SHORT).show()
                true

            }
            R.id.ctit2 ->{
                Toast.makeText(this,
                    "elemento 2",
                    Toast.LENGTH_SHORT).show()
                true
            }
            else -> false

        }
    }

    private fun mostrarPopUp(view : View){
        val popUp = PopupMenu(this, view)
        popUp.menuInflater.inflate(R.menu.popup, popUp.menu)
        popUp.setOnMenuItemClickListener { menuItem : MenuItem ->
            when (menuItem.itemId){
                R.id.item1 -> {
                    Toast.makeText(this, "seleccionaste item1",
                        Toast.LENGTH_LONG).show()
                    true
                }
                R.id.item2 -> {
                    Toast.makeText(this, "seleccionaste item2",
                        Toast.LENGTH_LONG).show()
                    true
                }
                else -> false
            }
        }
        popUp.show()
    }
    private fun enviarWhatsapp(){
        val mensaje = "hola que tal este es un mensaje desde kotlin"
        // definir intent
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, mensaje)

        if (intent.resolveActivity(packageManager)!= null){
            startActivity(intent)
        }
        else{
            Toast.makeText(this,
                "No se encontraron aplicaciones",
                Toast.LENGTH_SHORT).show()
        }


    }
    private fun recibirImagenes(){
        val intent = Intent(Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent,
            CODIGO_GALERIA)

    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == CODIGO_GALERIA && resultCode == RESULT_OK && data != null)
        {
            val mensaje ="hola"
            val imagenURI = data.data
            Toast.makeText(this , "recibido", Toast.LENGTH_SHORT).show()
            img1.setImageDrawable(null)
            img1.setImageURI(imagenURI)
        }
    }
}