package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class myadapter(val context: Context, val listener: rv) : RecyclerView.Adapter<holder>() {
    val data = ArrayList<Note>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        val viewHolder = holder(LayoutInflater.from(context).inflate(R.layout.item,parent,false))
        viewHolder.delete.setOnClickListener {
            listener.onitemclick(data[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
     val current = data[position]
        holder.txt.text= current.text
    }

    override fun getItemCount(): Int {
      return  data.size
    }

fun update(newlist: List<Note>){
    data.clear()
    data.addAll(newlist)
    data.reverse()
    notifyDataSetChanged()
}

}
class holder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val txt:TextView = itemView.findViewById(R.id.textView)
    val delete:ImageView = itemView.findViewById(R.id.img)

}
interface rv{
    fun onitemclick(note: Note)
}
