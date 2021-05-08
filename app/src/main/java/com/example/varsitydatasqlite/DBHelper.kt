package com.example.varsitydatasqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.lang.Exception

class DBHelper(private val context: Context):SQLiteOpenHelper(context, DB_NAME,null, VERSION) {

    companion object{
        const val DB_NAME = "varsityDatabase"
        const val TABLE_NAME = "userTable"
        const val NAME = "name"
        const val EMAIL = "email"
        const val BLOOD = "blood"
        const val DEPARTMENT = "department"
        const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createtable = "CREATE TABLE "+ TABLE_NAME +" " +
                "("+ NAME +" VARCHAR(100),"+ EMAIL+ " VARCHAR(100),"+ BLOOD +" VARCHAR(100),"+ DEPARTMENT +" VARCHAR(100)); "
        try {
            db?.execSQL(createtable)
            Toast.makeText(context,"Table Create Successfully",Toast.LENGTH_LONG).show()
        }catch (e:Exception){
            Toast.makeText(context,""+e,Toast.LENGTH_LONG).show()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        val upgrade = "DROP TABLE IF EXISTS $TABLE_NAME"
        try {
            db?.execSQL(upgrade)
            Toast.makeText(context,"Table upgrade Successfully",Toast.LENGTH_LONG).show()
        }catch (e:Exception){
            Toast.makeText(context,""+e,Toast.LENGTH_LONG).show()
        }
    }

    fun insert(name: String, email: String, blood: String, department: String): Long {

        val db= writableDatabase
        val contentValues = ContentValues()
        contentValues.put("NAME",name)
        contentValues.put("EMAIL",email)
        contentValues.put("BLOOD",blood)
        contentValues.put("DEPARTMENT",department)
        return db.insert(TABLE_NAME,null,contentValues)
    }

    fun show():Cursor{
        val db  = readableDatabase
        val getdata = "SELECT * FROM $TABLE_NAME"
        return db.rawQuery(getdata,null)
    }

}