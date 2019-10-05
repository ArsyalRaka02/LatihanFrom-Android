package com.example.basickotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {

    var tvName: TextView? = null
    var tvGender: TextView? = null
    var tvEmail: TextView? = null
    var tvTelpon: TextView? = null
    var tvAlamat: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvName =  findViewById(R.id.tv_nama)
        tvGender =  findViewById(R.id.tv_gender)
        tvEmail =  findViewById(R.id.tv_email)
        tvTelpon =  findViewById(R.id.tv_telpon)
        tvAlamat =  findViewById(R.id.tv_alamat)

        ambilData()
    }

    private fun ambilData(){
        tvName?.text = intent.getStringExtra("name")
        tvGender?.text = intent.getStringExtra("gender")
        tvEmail?.text = intent.getStringExtra("email")
        tvTelpon?.text = intent.getStringExtra("telpon")
        tvAlamat?.text = intent.getStringExtra("alamat")
    }
}
