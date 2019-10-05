package com.example.basickotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Main2Activity : AppCompatActivity() {

    var etName: EditText? = null
    var spGander: Spinner? = null
    var etEmail: EditText? = null
    var etTelpon: EditText? = null
    var etAlamat: EditText? = null
    var btnAdd: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        etName = findViewById(R.id.et_nama)
        spGander = findViewById(R.id.sp_gender)
        etEmail = findViewById(R.id.et_email)
        etTelpon = findViewById(R.id.et_telpon)
        etAlamat = findViewById(R.id.et_alamat)
        btnAdd = findViewById(R.id.btn_add)

        btnAdd?.setOnClickListener {
            validasinput()
        }
        setDataGender()
    }
    private fun validasinput(){
        val inputName = etName?.text.toString()
        val inputEmail = etEmail?.text.toString()
        val inputTelpon = etTelpon?.text.toString()
        val inputAlamat = etAlamat?.text.toString()
        val inputGender = spGander?.selectedItem.toString()

        when {
            inputName.isEmpty() -> etName?.error = "Nama tidak boleh kosong"
            inputGender.equals("Pilih Jenis Kelamin") -> tampilkanToast("jenis kelamin tidak boleh kosong")
            inputEmail.isEmpty() -> etEmail?.error = "Email tidak boleh kosong"
            inputTelpon.isEmpty() -> etTelpon?.error = "No telpon tidak boleh kosong"
            inputAlamat.isEmpty() -> etAlamat?.error = "Alamat tidak boleh kosong"

            else -> {
                tampilkanToast("Navigasi ke halaman Profile")

                val intent = Intent(this, ProfileActivity::class.java)

                intent.putExtra("name", inputName)
                intent.putExtra("gender", inputGender)
                intent.putExtra("email", inputEmail)
                intent.putExtra("telpon", inputTelpon)
                intent.putExtra("alamat", inputAlamat)

                startActivity(intent)
            }
        }
    }

    private fun tampilkanToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun setDataGender(){
        val adapter = ArrayAdapter.createFromResource(this, R.array.gender_list, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spGander?.adapter = adapter
    }
}
