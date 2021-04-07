package com.example.recyical

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.example.view.*

class exampleadapter(
        private val examplelist: List<example>,
        private val listener: OnItemClickListener
) : RecyclerView.Adapter<exampleadapter.exampleviweholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): exampleviweholder {
        val itemView =LayoutInflater.from(parent.context).inflate(R.layout.example, parent, false)

        return exampleviweholder(itemView)

    }
    override fun onBindViewHolder(holder: exampleviweholder, position: Int) {
       val currenitem = examplelist[position]



holder.ImageView.setImageResource(currenitem.imageResource)
        holder.textview.text = currenitem.text1
        holder.textview2.text = currenitem.text2

    }

    override fun getItemCount() = examplelist.size



   inner class exampleviweholder(itemView: View) : RecyclerView.ViewHolder(itemView),
           View.OnClickListener {
        val ImageView: ImageView =itemView.imageview
        val textview : TextView=itemView.textview1
        val textview2 : TextView=itemView.textview2
            init {
                itemView.setOnClickListener(this)

            }

        override fun onClick(v: View?) {
            val postion = adapterPosition
            if (postion != RecyclerView.NO_POSITION) {
                listener.onItemClick(postion)
            }
        }
        }
       interface OnItemClickListener {
           fun onItemClick(position: Int)

    }
}