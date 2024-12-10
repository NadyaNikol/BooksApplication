package com.example.booksapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.data.entities.Genre
import com.example.booksapplication.data.entities.Language
import com.example.booksapplication.databinding.ActivityMainBinding
import com.example.booksapplication.view.utils.GeneralUtil
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        initRecyclerView()
        initListeners()
        initObserves()
    }

    private fun initRecyclerView() {

    }

    private fun initObserves() {

    }

    private fun initListeners() {

    }


}