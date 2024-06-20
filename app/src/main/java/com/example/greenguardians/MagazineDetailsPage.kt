package com.example.greenguardians
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.greenguardians.databinding.ActivityMagazineDetailsPageBinding

class MagazineDetailsPage : AppCompatActivity() {
        private lateinit var binding: ActivityMagazineDetailsPageBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMagazineDetailsPageBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val title19f19478 = intent.getStringExtra("Magazinetitle")
            val image19f19478 = intent.getStringExtra("MagazineImage")
            val description19f19478 = intent.getStringExtra("MagazineDescription")
            val titleViewMagazine = findViewById<TextView>(R.id.MagdetailTitle)
            val imageviewMagazine = findViewById<ImageView>(R.id.MagdetailImage)
            val descriptionViewMagazine = findViewById<TextView>(R.id.MagDetaildescription)

            titleViewMagazine.text = title19f19478
            Glide.with(this).load(image19f19478).into(imageviewMagazine)
            descriptionViewMagazine.text = description19f19478

        }
    }



