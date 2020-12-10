package com.example.fundamental

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        btnTakePhoto.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also{
                it.type = "image/+"
                startActivityForResult(it,0)
            }
        }
        btnGoBackThird.setOnClickListener {
            finish();
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode==Activity.RESULT_OK && requestCode == 0){
            val uri = data?.data
            ivPhoto.setImageURI(uri)
        }
    }
}
