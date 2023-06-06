package com.example.kohi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.uklkasir.R
import com.example.kohi.database.CafeDatabase

class EditMejaActivity : AppCompatActivity() {
    lateinit var inputNama: EditText
    lateinit var simpanButton: Button

    lateinit var db: CafeDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_meja)
        supportActionBar?.hide()

        inputNama = findViewById(R.id.inputNamaMeja)
        simpanButton = findViewById(R.id.buttonSimpan)

        db = CafeDatabase.getInstance(applicationContext)

        var id = intent.getIntExtra("ID", 0)

        simpanButton.setOnClickListener{
            if(inputNama.text.toString().isNotEmpty()){
                db.cafeDao().updateMeja(inputNama.text.toString(), id)
                finish()
            }
        }
    }
}