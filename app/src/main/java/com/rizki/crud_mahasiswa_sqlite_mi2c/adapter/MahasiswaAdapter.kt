package com.rizki.crud_mahasiswa_sqlite_mi2c.adapter

import android.content.Context
import android.view.Display.Mode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.rizki.crud_mahasiswa_sqlite_mi2c.R
import com.rizki.crud_mahasiswa_sqlite_mi2c.helper.DbHelper
import com.rizki.crud_mahasiswa_sqlite_mi2c.model.ModelMahasiswa

class MahasiswaAdapter(
    private var listMahasiswa: List<ModelMahasiswa>,
    val context: Context
) : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

    private val db : DbHelper = DbHelper(context)

    class MahasiswaViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        val txtNama : TextView = itemView.findViewById(R.id.txtItemNamaMahasiswa)
        val txtJurusan : TextView = itemView.findViewById(R.id.txtItemJurusan)
        val txtNim : TextView = itemView.findViewById(R.id.txtItemNIM)

        val btnEdit : ImageView = itemView.findViewById(R.id.btnEditItem)
        val btnDelete : ImageView = itemView.findViewById(R.id.btnDeleteItem)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data_mahasiswa,
           parent, false
           )
        return MahasiswaViewHolder(view)
    }

    override fun getItemCount(): Int {
       return listMahasiswa.size
    }
    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val nMahasiswa = listMahasiswa[position]
        holder.txtNim.text = nMahasiswa.nim.toString()
        holder.txtNama.text = nMahasiswa.nama
        holder.txtJurusan.text = nMahasiswa.jurusan

        //untuk proses delete
        holder.btnDelete.setOnClickListener(){
            db.deleteMahasiswa(nMahasiswa.id)
            refreshData(db.getAllDataMahasiswa())
            Toast.makeText(holder.itemView.context,
                "Berhasil delete data ${nMahasiswa.nama}", Toast.LENGTH_LONG
                ).show()
        }
        //bagi yang sudah bisa delete nanti d whatsapp ya


        //edit data
        holder.btnEdit.setOnClickListener(){
            //perlu bikin 1 lagi activity edit
        }
    }
    //ini untuk refresh data
    fun refreshData(newMahasiswa : List<ModelMahasiswa>){
        listMahasiswa = newMahasiswa
        notifyDataSetChanged()
    }
}