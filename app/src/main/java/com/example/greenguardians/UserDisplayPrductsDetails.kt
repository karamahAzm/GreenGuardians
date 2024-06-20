package com.example.greenguardians
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.greenguardians.databinding.ActivityUserDisplayPrductsDetailsBinding

class UserDisplayPrductsDetails: AppCompatActivity() {

    private lateinit var binding: ActivityUserDisplayPrductsDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDisplayPrductsDetailsBinding.inflate(layoutInflater)
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

        binding.orderBtn.setOnClickListener{
            val intent = Intent(this, EnterOrderDetails::class.java)
            startActivity(intent)
            finish()
        }
    }

}


