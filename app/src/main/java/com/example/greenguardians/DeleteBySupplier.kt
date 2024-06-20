package com.example.greenguardians
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.greenguardians.databinding.ActivityDeleteBySupplierBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DeleteBySupplier : AppCompatActivity() {
    private lateinit var binding: ActivityDeleteBySupplierBinding
    private lateinit var dbR: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDeleteBySupplierBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.supplierDeleteThis.setOnClickListener {
            val dataTitle19f19478 = binding.supplierDeleteText.text.toString()
            if (dataTitle19f19478.isNotEmpty()) {
                DeleteFun(dataTitle19f19478)
            } else {
                Toast.makeText(this, "please enter the title", Toast.LENGTH_SHORT).show()
            }
        }

    }
    private fun DeleteFun(dataTitle19f19478: String) {
        dbR = FirebaseDatabase.getInstance().getReference("SupplierData")
        dbR.child(dataTitle19f19478).removeValue().addOnSuccessListener {
            binding.supplierDeleteText.text.clear()
            Toast.makeText(this, "Successful deletion", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this, "Failed to delete", Toast.LENGTH_SHORT).show()
        }
    }
}