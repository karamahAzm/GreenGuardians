package com.example.greenguardians
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.greenguardians.databinding.ActivityFirstLoginPageBinding
import com.google.firebase.auth.FirebaseAuth

class FirstLoginPage : AppCompatActivity() {
        private lateinit var binding: ActivityFirstLoginPageBinding
        private lateinit var fauth: FirebaseAuth
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityFirstLoginPageBinding.inflate(layoutInflater)
            setContentView(binding.root)
            fauth = FirebaseAuth.getInstance()
            binding.loginButton.setOnClickListener {
                val email = binding.loginEmail.text.toString()
                val password = binding.loginPassword.text.toString()
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    fauth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(
                                    this,
                                    "Your login attempt is successful",
                                    Toast.LENGTH_SHORT
                                ).show()
                                val intent = Intent(this, HomePg::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(this, "Failed to login", Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    Toast.makeText(
                        this,
                        "You need to enter email and password ",
                        Toast.LENGTH_SHORT).show()
                }
            }
            binding.resetpassword.setOnClickListener{
                startActivity(Intent(this,ResetPassword::class.java))
                finish()

            }
            binding.signupText.setOnClickListener {
                startActivity(Intent(this,RegistrationPage::class.java))
                finish()
            }
            binding.adminsignupText.setOnClickListener {
                startActivity(Intent(this,AdminLogin::class.java))
                finish()
            }
            binding.suppsignupText.setOnClickListener {
                startActivity(Intent(this,SupplierLogin::class.java))
                finish()
            }
        }
    }
