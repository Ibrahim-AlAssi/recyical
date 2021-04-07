package com.example.recyical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), exampleadapter.OnItemClickListener {
    private val examplelist =generateDummyList(500) //3m yb3at size 500 lal function
    private val adapter =exampleadapter(examplelist, this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyleview.adapter =adapter
        recyleview.layoutManager =LinearLayoutManager(this)
        recyleview.setHasFixedSize(true)
    }
    fun insert(View: View){
        val index = Random.nextInt(8)
        val newitem = example(
                R.drawable.pic1,
                text1 = "new item at postion $index",
                text2 = "line 2 "
        )
        examplelist.add(index,newitem)
        adapter.notifyItemInserted(index)




    }
    fun remove(View: View){
        val index = Random.nextInt(8)
        examplelist.removeAt(index)
        adapter.notifyItemRemoved(index)

    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = examplelist[position]
        clickedItem.text1 = "Clicked"
        adapter.notifyItemChanged(position)

    }

    private fun generateDummyList(size: Int): ArrayList<example> {
        val list = ArrayList<example>()
        for (i in 0 until size) { //for loop 3ade for(int i, i=0, i<=500)
            val drawable = when (i % 3) {
                0 -> R.drawable.pic1
                1 -> R.drawable.pic2
                else -> R.drawable.pic3
            }
            val item = example(drawable, "Item $i", "Line 2")
            list += item
        }
        return list
    }

}