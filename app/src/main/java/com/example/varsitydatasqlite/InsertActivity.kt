package com.example.varsitydatasqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.varsitydatasqlite.databinding.ActivityInsertBinding
import com.google.android.material.snackbar.Snackbar

class InsertActivity : AppCompatActivity() {
    lateinit var binding: ActivityInsertBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = DBHelper(this)

        binding.saveid.setOnClickListener {
            val name = binding.nameid.text.toString()
            val email = binding.emailid.text.toString()
            val blood = binding.bloodid.text.toString()
            val department = binding.departmentID.text.toString()
            if(name.isNotEmpty() && email.isNotEmpty() && blood.isNotEmpty() && department.isNotEmpty()){
                val value = db.insert(name,email,blood,department)
                if (value==(-1).toLong()){
                    Snackbar.make(binding.insertLayoutID,"Insertion Failed",Snackbar.LENGTH_LONG).show()
                }
                else{
                    Snackbar.make(binding.insertLayoutID,"Insertion Successful",Snackbar.LENGTH_LONG).show()
                }
            }
            else{
                Snackbar.make(binding.insertLayoutID,"enter data first",Snackbar.LENGTH_LONG).show()
            }

        }
        binding.showid.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}