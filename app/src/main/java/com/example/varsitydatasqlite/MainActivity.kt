package com.example.varsitydatasqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SnapHelper
import com.example.varsitydatasqlite.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    val userList= ArrayList<User>()
    lateinit var dbHelper: DBHelper
    lateinit var myAdapter: MyAdapter

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerID.layoutManager = LinearLayoutManager(this)
        binding.recyclerID.setHasFixedSize(true)
        loadData()

        binding.insertbuttonID.setOnClickListener{
            startActivity(Intent(this,InsertActivity::class.java))
        }

    }

    private fun loadData() {
        val dbHelper = DBHelper(this)
        val cursor = dbHelper.show()
        if(cursor.equals(0)){
            Snackbar.make(binding.MainLAyoutID,"No data Found",Snackbar.LENGTH_LONG).show()
        }
        else{
            while(cursor.moveToNext()){
                val name  = cursor.getString(0).toString()
                val email = cursor.getString(1).toString()
                val blood = cursor.getString(2).toString()
                val department = cursor.getString(3).toString()
                val user = User(name, email, blood, department)
                userList.add(user)
            }
            myAdapter = MyAdapter(userList)
            binding.recyclerID.adapter = myAdapter
        }
    }


}