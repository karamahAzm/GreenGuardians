package com.example.greenguardians
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.greenguardians.databinding.ActivityAdminLoginBinding
import com.google.firebase.auth.FirebaseAuth

class AdminLogin : AppCompatActivity() {

    private lateinit var binding: ActivityAdminLoginBinding
    private lateinit var fauth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fauth = FirebaseAuth.getInstance()

        binding.loginButtonAdmin.setOnClickListener {
            val emlAdmin = binding.adminloginEmail.text.toString()
            val pswrdAdmin = binding.loginPasswordAdmin.text.toString()

            if (emlAdmin.isNotEmpty() && pswrdAdmin.isNotEmpty()) {
                fauth.signInWithEmailAndPassword(emlAdmin, pswrdAdmin)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Your login is successful", Toast.LENGTH_SHORT).show()
                            val intent19f19478 = Intent(this, ActivityAdminControl::class.java)
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
