package com.duytran.flipthecards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.duytran.flipthecards.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button3x2.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("mode", "3x2")
            startActivity(intent)
        }

        binding.button4x4.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("mode", "4x4")
            startActivity(intent)
        }


        binding.button6x6.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("mode", "6x6")
            startActivity(intent)
        }
    }
}