package com.example.greenguardians
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.greenguardians.databinding.ActivitySupplierLoginBinding
import com.google.firebase.auth.FirebaseAuth
class SupplierLogin : AppCompatActivity() {
        private lateinit var binding: ActivitySupplierLoginBinding
        private lateinit var fauth: FirebaseAuth
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivitySupplierLoginBinding.inflate(layoutInflater)
            setContentView(binding.root)
            fauth = FirebaseAuth.getInstance()
            binding.loginButtonSupp.setOnClickListener {
                val emlAdmin = binding.supploginEmail.text.toString()
                val pswrdAdmin = binding.loginPasswordSupp.text.toString()
                if (emlAdmin.isNotEmpty() && pswrdAdmin.isNotEmpty()) {
                    fauth.signInWithEmailAndPassword(emlAdmin, pswrdAdmin)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(this, "Your login is successful", Toast.LENGTH_SHORT).show()
                                val intent19f19478 = Intent(this, SupplierManagePage::class.java)
                                startActivity(intent19f19478)
                                finish()
                            } else {
                                Toast.makeText(this, "Failed to login", Toast.LENGTH_SHORT).show()
                            }
                        } } else {
                    Toast.makeText(this, "You need to enter email and password ", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
