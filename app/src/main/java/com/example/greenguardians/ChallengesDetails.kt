package com.example.greenguardians
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.greenguardians.databinding.ActivityChallengesDetailsBinding
class ChallengesDetails: AppCompatActivity() {
    private lateinit var binding: ActivityChallengesDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChallengesDetailsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val title19f19478 = intent.getStringExtra("title")
        val image19f19478 = intent.getStringExtra("Image")
        val description19f19478 = intent.getStringExtra("description")

        //retrieve
        val titleView = findViewById<TextView>(R.id.detailTitle)
        val imageview = findViewById<ImageView>(R.id.detailImage)
        val descriptionView = findViewById<TextView>(R.id.description)

        //display
        titleView.text = title19f19478
        Glide.with(this).load(image19f19478).into(imageview)
        descriptionView.text = description19f19478
        val confirmbutton=findViewById<Button>(R.id.Confirmbtn)
        confirmbutton.setOnClickListener {
            DisplayAlertDailog()
        }
    }
    private fun DisplayAlertDailog(){
        val bldr=AlertDialog.Builder(this)
        bldr.setTitle("Congratulations!!")
            .setMessage("Do you want to move to the next challenge?")
            .setPositiveButton("yes") { dialog, which ->
                Toast.makeText(this, "You Can Start Another Challenge", Toast.LENGTH_SHORT).show()
            }.setNegativeButton("No"){dialog, which->
                dialog.dismiss()
            }
        val alrtdialog:AlertDialog= bldr.create()
        alrtdialog.show()

    }
}
