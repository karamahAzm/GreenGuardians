package com.example.greenguardians

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.greenguardians.databinding.ActivityDeleteByAdminBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DeleteByAdmin : AppCompatActivity() {
    private lateinit var binding: ActivityDeleteByAdminBinding
    private lateinit var dbR: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDeleteByAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.deleteThis.setOnClickListener {
            val dataTitle19f19478 = binding.deleteText.text.toString()
            if (dataTitle19f19478.isNotEmpty()) {
                DeleteFun(dataTitle19f19478)
            } else {
                Toast.makeText(this, "please enter the title", Toast.LENGTH_SHORT).show()
            }
        }

    }
    private fun DeleteFun(dataTitle19f19478: String) {
        dbR = FirebaseDatabase.getInstance().getReference("OmanGreenGuardians")
        dbR.child(dataTitle19f19478).removeValue().addOnSuccessListener {
            binding.deleteText.text.clear()
            Toast.makeText(this, "Successful deletion", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this, "Failed to delete", Toast.LENGTH_SHORT).show()
        }
    }
}