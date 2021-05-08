package com.example.varsitydatasqlite

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.varsitydatasqlite.databinding.SingleItemBinding


class MyAdapter(private val user: List<User>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view = SingleItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return user.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text=user[position].name
        holder.email.text = user[position].email
        holder.blood.text = user[position].blood
        holder.department.text = user[position].department
    }

    class MyViewHolder(private val binding: SingleItemBinding):RecyclerView.ViewHolder(binding.root){

        val name:TextView= binding.singleNameID
        val email:TextView =binding.singleEamilID
        val blood:TextView =binding.singleBlooDID
        val department:TextView =binding.singleDepID
    }
}



