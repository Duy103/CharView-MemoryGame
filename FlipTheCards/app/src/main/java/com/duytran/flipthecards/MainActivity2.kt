package com.duytran.flipthecards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.duytran.flipthecards.model.DataCards

class MainActivity2 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recyclerView = findViewById(R.id.recyclerView1)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val cardsList: MutableList<DataCards> = ArrayList()
        cardsList.add(DataCards(id = 1, image = R.drawable.person1, false, 1))
        cardsList.add(DataCards(id = 2, image = R.drawable.person2, false, 2))
        cardsList.add(DataCards(id = 3, image = R.drawable.person3, false, 3))
        cardsList.add(DataCards(id = 4, image = R.drawable.person4, false, 4))
        cardsList.add(DataCards(id = 5, image = R.drawable.person5, false, 5))
        cardsList.add(DataCards(id = 6, image = R.drawable.person6, false, 6))



        cardsList.shuffle() // Shuffle list
        adapter = CardAdapter(cardsList, recyclerView)
        recyclerView.adapter = adapter

    }



}


