package pt.lunata.hitamado.ui.detail.siapantar.headdriver

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.siapantar.SiapAntarEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_detail_siap_antar_head_driver.*

@AndroidEntryPoint
class DetailSiapAntarHeadDriverActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
        const val JENIS_DELEGASI = "jenis_delegasi"
    }

    private val viewModel: DetailSiapAntarHeadViewModel by viewModels()
    private lateinit var adapter:DetailItemPoHouseSiapAntarAdapter
    private lateinit var items:SiapAntarEntity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_siap_antar_head_driver)
        adapter= DetailItemPoHouseSiapAntarAdapter()
        var listItems = ArrayList<String>()
        var listUid = ArrayList<String>()
        var uidDriver: String? = null
        items = intent.getParcelableExtra(EXTRA_DATA) as SiapAntarEntity
        viewModel.getListDriver(this).observe(this, Observer { drivers ->
            listItems.add("Pilih Supir")
            listUid.add("0")
            for (data in drivers) {
                listItems.add(data.nama.toString())
                listUid.add(data.uid.toString())
            }
            var spinnerAdapter =
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listItems)
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_listDriver.adapter = spinnerAdapter
        })
        spinner_listDriver.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = listUid[position]
                uidDriver = listUid[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        btn_proses_siap_antar.setOnClickListener {
            viewModel.postSiapAntar(this, items.uid, uidDriver, tv_description.text.toString())
                .observe(this,
                    Observer { result ->
                        if (result.error!=null && !result.error){
                            Toast.makeText(this,"Berhasil di proses",Toast.LENGTH_SHORT).show()
                        }
                    })
            finish()

        }
        btn_back.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        populatePickup(items)
    }
    private fun populatePickup(item: SiapAntarEntity) {
        if (item.siap_antar!!) {
            tv_status_siap_antar.text = "Siap Dikirm"
            container_item_siap_antar.visibility = View.VISIBLE
            tv_notice_siap_antar.visibility = View.GONE
        } else {
            container_item_siap_antar.visibility = View.GONE
            btn_proses_siap_antar.visibility = View.GONE
            tv_status_siap_antar.text = "Belum bisa dikirim, dikarenakan ada item yang belum tiba"
        }
        tv_number_po_master.text=item.po_master_number
        adapter.setListItems(item.itemsAllHouse,item.itemsPo)
        with(rv_detail_siap_antar){
            layoutManager=LinearLayoutManager(this@DetailSiapAntarHeadDriverActivity,LinearLayoutManager.VERTICAL,false)
            setHasFixedSize(true)
            adapter=this@DetailSiapAntarHeadDriverActivity.adapter
        }
    }
}