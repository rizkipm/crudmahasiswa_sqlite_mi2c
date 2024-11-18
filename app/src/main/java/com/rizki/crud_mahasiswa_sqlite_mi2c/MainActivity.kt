package com.rizki.crud_mahasiswa_sqlite_mi2c

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.rizki.crud_mahasiswa_sqlite_mi2c.adapter.MahasiswaAdapter
import com.rizki.crud_mahasiswa_sqlite_mi2c.databinding.ActivityMainBinding
import com.rizki.crud_mahasiswa_sqlite_mi2c.helper.DbHelper
import com.rizki.crud_mahasiswa_sqlite_mi2c.screen_page.TambahDataMahasiswaActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db : DbHelper
    private lateinit var mahasiswaAdapater : MahasiswaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db  = DbHelper(this)
        mahasiswaAdapater = MahasiswaAdapter(db.getAllDataMahasiswa(), this)

        binding.rvDataMahasiswa.layoutManager = LinearLayoutManager(this)
        binding.rvDataMahasiswa.adapter = mahasiswaAdapater

        //Silahkan buat detail page
        //ketika di klik item nya akan pindah ke page lain


        binding.btnPageTambah.setOnClickListener{
            val intent = Intent(this, TambahDataMahasiswaActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val newMahasiswa = db.getAllDataMahasiswa()
        mahasiswaAdapater.refreshData(newMahasiswa)
    }
}