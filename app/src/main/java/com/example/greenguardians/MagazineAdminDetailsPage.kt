package com.example.greenguardians
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.greenguardians.databinding.ActivityMagazineAdminDetailsPageBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MagazineAdminDetailsPage : AppCompatActivity() {

        private lateinit var listMag: FloatingActionButton
        private lateinit var deleteMag: FloatingActionButton
        //   private lateinit var edit19f19478: FloatingActionButton
        private lateinit var binding: ActivityMagazineAdminDetailsPageBinding
        private var ifMenuopen = false


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityMagazineAdminDetailsPageBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val title = intent.getStringExtra("Magazinetitle")
            val image = intent.getStringExtra("MagazineImage")
            val description= intent.getStringExtra("MagazineDescription")

            //retrieve
            val titleViewMag= findViewById<TextView>(R.id.MMagdetailTitle)
            val imageviewMag = findViewById<ImageView>(R.id.MMagdetailImage)
            val descriptionViewMag = findViewById<TextView>(R.id.MMagDetaildescription)

            //display
            titleViewMag.text = title
            Glide.with(this).load(image).into(imageviewMag)
            descriptionViewMag.text = description

            val listMag: FloatingActionButton = findViewById(R.id.listMag)
            // val edit19f19478: FloatingActionButton = findViewById(R.id.edit19f19478)
            val deleteMag: FloatingActionButton = findViewById(R.id.deleteMag)


            binding.listMag.setOnClickListener {
                actioButtonMenu()
            }
            binding.deleteMag.setOnClickListener {
                val intent = Intent(this, DeleteByAdminMagazine::class.java)
                startActivity(intent)
            }

            //  binding.edit19f19478.setOnClickListener {
            //    val intent = Intent(this, UpdateByAdmin::class.java)
            //  startActivity(intent)
            // }
        }

        private fun actioButtonMenu() {
            if (ifMenuopen) {

                binding.deleteMag.hide()
                //  binding.edit19f19478.hide()
            } else{
                binding.deleteMag.show()
                //  binding.edit19f19478.show()
            }
            ifMenuopen = !ifMenuopen
        }
    }
