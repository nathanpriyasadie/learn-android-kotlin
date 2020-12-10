package com.example.fundamental

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val person = intent.getSerializableExtra("EXTRA_PERSON") as Person

        tvMain.text = person.name

        val goBackDialog = AlertDialog.Builder(this).setTitle("Go Back")
            .setMessage("u sure You Want to go back?")
            .setIcon(R.drawable.ic_notification)
            .setPositiveButton("Sure"){_, _ ->
                finish();
            }
            .setNegativeButton("No"){_,_->
                Toast.makeText(this,"Ok",Toast.LENGTH_SHORT).show()
            }.create()

        val options = arrayOf("First Item","Second item","Third Item")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one")
            .setSingleChoiceItems(options,0){_, i ->
                Toast.makeText(this,"You Clicked On ${options[i]}",Toast.LENGTH_SHORT).show()
            }.setPositiveButton("Accept"){_, _ ->
                finish();
            }
            .setNegativeButton("Decline"){_,_->
                Toast.makeText(this,"You Decline SingleChoice",Toast.LENGTH_SHORT).show()
            }.create()

        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one")
            .setMultiChoiceItems(options, booleanArrayOf(false,false,false)){ _, i, isChecked ->
                if(isChecked){
                    Toast.makeText(this,"You Checked ${options[i]}",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"You UnCHecked ${options[i]}",Toast.LENGTH_SHORT).show()
                }

            }.setPositiveButton("Accept"){_, _ ->
                finish();
            }
            .setNegativeButton("Decline"){_,_->
                Toast.makeText(this,"You Decline MultiChoice",Toast.LENGTH_SHORT).show()
            }.create()

        btnBack.setOnClickListener {
//            goBackDialog.show()
//            singleChoiceDialog.show()
            multiChoiceDialog.show()
        }




        btnNextActivity.setOnClickListener {
            Intent(this,ThirdActivity::class.java).also{
                startActivity(it)
            }
        }
    }
}