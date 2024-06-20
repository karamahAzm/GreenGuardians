package com.example.greenguardians

import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.example.greenguardians.databinding.ActivityRegistrationPageBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import java.lang.Exception

class RegistrationPage : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationPageBinding
    private lateinit var fAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fAuth = FirebaseAuth.getInstance()
        binding.regitrationBtn.setOnClickListener {
            val email = binding.signupEmail.text.toString().trim()
            val password = binding.registrationPswrd.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                signUpUsr(email,password)
                        } else {
                            Toast.makeText(this, "Enter email and password", Toast.LENGTH_SHORT)
                                .show()
                        }
                  }
        binding.regitertxt.setOnClickListener {
            startActivity(Intent(this, FirstLoginPage::class.java))
            finish()
          }    }
        private fun signUpUsr(email:String,password:String) {
            fAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        EmailVerificationSend()

                    } else {
                        task.exception?.let { exception: Exception ->
                            println("failed to registered")
                        }
                    }
                }
           }

    private fun EmailVerificationSend() {
        val currentClient = fAuth.currentUser
        currentClient?.let {
            it.sendEmailVerification()
                .addOnCompleteListener() { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Email Verification is sent to ${it.email}", Toast.LENGTH_SHORT).show()

                    } else {
                              Toast.makeText(this, "Failed to login", Toast.LENGTH_SHORT).show()
                        task.exception?.let { exception: Exception ->
                            Toast.makeText(this, "\"Email verification failed: ${exception.message}\"", Toast.LENGTH_SHORT).show()

                        }
                    }
                }
        } ?: run {
            println("There was no authenticated user that is found")
                   Toast.makeText(this, "You need to enter email and password", Toast.LENGTH_SHORT).show()
        }

    }

}




