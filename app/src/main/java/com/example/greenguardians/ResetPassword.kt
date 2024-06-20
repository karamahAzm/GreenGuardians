package com.example.greenguardians

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.greenguardians.databinding.ActivityFirstLoginPageBinding
import com.example.greenguardians.databinding.ActivityResetPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ResetPassword : AppCompatActivity() {
    private lateinit var binding: ActivityResetPasswordBinding
    private lateinit var fauth: FirebaseAuth
    private lateinit var txtemail: EditText
    private lateinit var sendEmlButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fauth = FirebaseAuth.getInstance()
        sendEmlButton = findViewById<Button>(R.id.sendEml)
        txtemail = findViewById<EditText>(R.id.currentEmail)
        binding.sendEml.setOnClickListener {
            val email = txtemail.text.toString().trim()
            if (email.isNotEmpty()) {
                pswrdRstSnt(email)
            } else {
                Toast.makeText(this, "Enter email please", Toast.LENGTH_SHORT).show()
            }
        }

    }
    private fun pswrdRstSnt(email:String){
        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
            .addOnCompleteListener { task->
                if(task.isSuccessful){
                    Toast.makeText(this, "An email to reset password is sent to $email", Toast.LENGTH_SHORT).show()
              val int= Intent(this, FirstLoginPage::class.java)
               startActivity(int)
                }else{
                    Toast.makeText(this, "Failure,try gain to reset email: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}