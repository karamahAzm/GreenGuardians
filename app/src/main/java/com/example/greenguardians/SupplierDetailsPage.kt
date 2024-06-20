package com.example.greenguardians

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.greenguardians.databinding.ActivitySupplierDetailsPageBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class SupplierDetailsPage: AppCompatActivity() {

    private lateinit var listSuppllier: FloatingActionButton
    private lateinit var deleteSupplier: FloatingActionButton
    private lateinit var binding: ActivitySupplierDetailsPageBinding
    private var ifMenuopen = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySupplierDetailsPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val title19f19478 = intent.getStringExtra("titleSupplier")
        val image19f19478 = intent.getStringExtra("imageSupplier")
        val description19f19478 = intent.getStringExtra("descriptionSupplier")


        val titleViewSupplier = findViewById<TextView>(R.id.SuppllierdetailTitle)
        val imageviewSupplier = findViewById<ImageView>(R.id.SuppllierdetailImage)
        val descriptionViewSupplier = findViewById<TextView>(R.id.SuppllierDetaildescription)


        titleViewSupplier.text = title19f19478
        Glide.with(this).load(image19f19478).into(imageviewSupplier)
        descriptionViewSupplier.text = description19f19478

        val listSupplier: FloatingActionButton = findViewById(R.id.listSupplier)
        val deleteSupplier: FloatingActionButton = findViewById(R.id.deleteSupllier)


        binding.listSupplier.setOnClickListener {
            actioButtonMenu()
        }
       binding.deleteSupllier.setOnClickListener {
            val intent = Intent(this, DeleteBySupplier::class.java)
           startActivity(intent)
       }

    }

    private fun actioButtonMenu() {
        if (ifMenuopen) {
            binding.deleteSupllier.hide()
        } else{
            binding.deleteSupllier.show()
        }
        ifMenuopen = !ifMenuopen
    }
}
