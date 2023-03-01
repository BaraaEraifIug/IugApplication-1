package com.example.myapplication1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore
    private lateinit var submitData : Button
    private lateinit var id : EditText
    private lateinit var name : EditText
    private lateinit var age : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        id = findViewById(R.id.id_ed)
        age = findViewById(R.id.age_ed)
        name = findViewById(R.id.name_ed)
        submitData = findViewById(R.id.submitData)
        submitData.setOnClickListener{
            val id = id.text.toString()
            val name = name.text.toString()
            val age = age.text.toString()


            val person = hashMapOf(
                "name" to name,
                "id" to id,
                "age" to age
            )

            db.collection("Persons")
                .add(person)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(applicationContext, documentReference.id,Toast.LENGTH_SHORT).show()

                }
                .addOnFailureListener { e ->
                    Toast.makeText(applicationContext,"$e",Toast.LENGTH_SHORT).show()

                }
        }
    }
}