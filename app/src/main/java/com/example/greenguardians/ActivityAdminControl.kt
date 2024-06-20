package com.example.greenguardians
import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import com.example.greenguardians.databinding.ActivityAdminControlBinding
class ActivityAdminControl : AppCompatActivity() {
    private lateinit var binding: ActivityAdminControlBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminControlBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.ManageChallenges.setOnClickListener{
            val intent = Intent(this, AdminManagePage::class.java)
            startActivity(intent)
        }

        binding.ManageMagazine.setOnClickListener{
            val intent = Intent(this, EMagazine::class.java)
            startActivity(intent)
        }
    }
}