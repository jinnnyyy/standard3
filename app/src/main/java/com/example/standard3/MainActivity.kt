package com.example.standard3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standard3.databinding.ActivityDetatilBinding
import com.example.standard3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val datalist = mutableListOf<item>()
        datalist.add(item( "Anderson","2423 3581 9581 2412","21/24", "3,100.30"))
        datalist.add(item( "Anderson","2423 3581 9581 2412","12/25", "3,100.30"))
        datalist.add(item( "Anderson","2423 3581 9581 2412","21/24", "3,100.30"))

        val adapter = adapter(datalist)
        binding.recyclerview.adapter = adapter
//        binding.main.id.recyclerview.adapter = adapter

        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
}