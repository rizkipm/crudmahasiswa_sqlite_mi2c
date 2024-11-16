package com.rizki.crud_mahasiswa_sqlite_mi2c.screen_page

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rizki.crud_mahasiswa_sqlite_mi2c.R
import com.rizki.crud_mahasiswa_sqlite_mi2c.databinding.ActivityTambahDataMahasiswaBinding
import com.rizki.crud_mahasiswa_sqlite_mi2c.helper.DbHelper
import com.rizki.crud_mahasiswa_sqlite_mi2c.model.ModelMahasiswa

class TambahDataMahasiswaActivity : AppCompatActivity() {

    //binding : cara ringkas untuk kita deklarasi variable dan widget
    private lateinit var binding: ActivityTambahDataMahasiswaBinding
    private lateinit var db : DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahDataMahasiswaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = DbHelper(this,null)
        binding.btnTambahData.setOnClickListener{
            val nama = binding.txtInputNama.text.toString()
            val nim = binding.txtInputNIM.text.toString()

            //karena nim --> int jadi kita perlu convert dari string ke int
            //toInt()
            val dataMahasiswa = ModelMahasiswa(0, nama, nim.toInt(), "Teknik Komputer" )
            db.insertDataMahasiswa(dataMahasiswa)
            finish();
            Toast.makeText(this, "Berhasil Tambah Data",
                Toast.LENGTH_LONG).show()
        }

    }
}