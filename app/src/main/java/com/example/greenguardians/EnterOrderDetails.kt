package com.example.greenguardians
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.greenguardians.databinding.ActivityEnterOrderDetailsBinding
import com.google.firebase.database.FirebaseDatabase

class EnterOrderDetails : AppCompatActivity() {

    private lateinit var binding: ActivityEnterOrderDetailsBinding
    private lateinit var dbR: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityEnterOrderDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.confirmOrderBtn.setOnClickListener {
            val todaydate =binding.todayDate.text.toString()
            val customername= binding.loadCustomerName.text.toString()
            val address= binding.loadCustomerAddress.text.toString()
            val phone=binding.loadCustomerPhone.text.toString()
            val itemname =binding.loadItemName.text.toString()
            val nofItems=binding.loadnumberofItems.text.toString()
            val orderdtclass= OrderDetailsDataClass(todaydate,customername,nofItems,address,phone,itemname)
            val  dbR =FirebaseDatabase.getInstance().getReference("Order Details").child(todaydate)
                .setValue(orderdtclass).addOnSuccessListener {
                binding.todayDate.text.clear()
                binding.loadCustomerName.text.clear()
                binding.loadCustomerAddress.text.clear()
                binding.loadCustomerPhone.text.clear()
                binding.loadItemName.text.clear()
                binding.loadnumberofItems.text.clear()

                Toast.makeText(this,"Data are Saved",Toast.LENGTH_SHORT).show()
                    finish()
            }.addOnFailureListener{
                Toast.makeText(this,"Data are not Saved",Toast.LENGTH_SHORT).show()
            }
         }
        }
    }
