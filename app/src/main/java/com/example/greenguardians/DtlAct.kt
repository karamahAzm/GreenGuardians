package com.example.greenguardians

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.greenguardians.databinding.ActivityDtlBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class DtlAct: AppCompatActivity() {

    private lateinit var list: FloatingActionButton
    private lateinit var delete19f19478: FloatingActionButton
    private lateinit var binding: ActivityDtlBinding
    private var ifMenuopen = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDtlBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)


        val title19f19478 = intent.getStringExtra("title")
        val image19f19478 = intent.getStringExtra("Image")
        val description19f19478 = intent.getStringExtra("description")

        val titleView = findViewById<TextView>(R.id.detailTitle)
        val imageview = findViewById<ImageView>(R.id.detailImage)
        val descriptionView = findViewById<TextView>(R.id.description)

        titleView.text = title19f19478
        Glide.with(this).load(image19f19478).into(imageview)
        descriptionView.text = description19f19478

        val list: FloatingActionButton = findViewById(R.id.list)
        val delete19f19478: FloatingActionButton = findViewById(R.id.delete19f19478)


        binding.list.setOnClickListener {
            actioButtonMenu()
        }
        binding.delete19f19478.setOnClickListener {
            val intent = Intent(this, DeleteByAdmin::class.java)
            startActivity(intent)
        }

    }

    private fun actioButtonMenu() {
        if (ifMenuopen) {

            binding.delete19f19478.hide()
        } else{
            binding.delete19f19478.show()
        }
        ifMenuopen = !ifMenuopen
    }
}
