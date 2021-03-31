package pt.lunata.hitamado.ui.detail.newpo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.newpo.NewpoEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_detail_newpo.*

@AndroidEntryPoint
class DetailNewPoActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
        const val JENIS_DELEGASI = "jenis_delegasi"
    }

    private val viewModel: DetailNewPoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_newpo)
        var listItems = ArrayList<String>()
        var listUid = ArrayList<String>()
        var uidDriver: String? = null
        val item = intent.getParcelableExtra(EXTRA_DATA) as NewpoEntity
        Log.d("tesgan", item.toString())
        val jenis = intent.getStringExtra(JENIS_DELEGASI) as String
        populateDataPO(item)
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
                uidDriver = listUid[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        btn_proses_newpo.setOnClickListener {
            if (jenis == "Delegasi Pickup") {
                viewModel.postNewpo(this, item.uid, uidDriver, tv_description.text.toString())
                    .observe(this,
                        Observer { result ->
                            Log.d("tesPost", result.success.toString())
                        })
                finish()
            } else if (jenis == "Delegasi Kantor") {
                viewModel.postDelegasiOffice(
                    this,
                    item.uid,
                    uidDriver,
                    tv_description.text.toString()
                ).observe(this,
                    Observer { result ->
                        Log.d("tesPost", result.success.toString())
                    })
                finish()
            } else if (jenis == "Delegasi Siap Antar") {
                viewModel.postDelegasiSiapantar(
                    this,
                    item.uid,
                    uidDriver,
                    tv_description.text.toString()
                ).observe(this, Observer { result ->
                    Log.d("tesPost", result.success.toString())
                })
                Toast.makeText(this@DetailNewPoActivity, uidDriver, Toast.LENGTH_SHORT).show()
                finish()
            } else if (jenis == "Delegasi Ke Maskapai") {
                viewModel.postDelegasiDeliverAirline(
                    this,
                    item.uid,
                    uidDriver,
                    tv_description.text.toString()
                ).observe(this, Observer { result ->
                    Log.d("tesPost", result.success.toString())
                })
                finish()
            } else {
                viewModel.postNewpo(this, item.uid, uidDriver, tv_description.text.toString())
                    .observe(this,
                        Observer { result ->
                            Log.d("tesPost", result.success.toString())
                        })
                finish()
            }
        }
        btn_back.setOnClickListener {
            finish()
        }
    }

    private fun populateDataPO(item: NewpoEntity) {
        tv_number_po_house.text = item.po_house_number
        tv_username_customer.text = item.customer_name
        tv_alamat_customer.text = item.customer_alamt
        tv_telepon.text = item.no_telepon
        tv_marketing.text = item.marketing_name
        tv_komoditi.text = item.comodity_name
        tv_berat_benda.text = item.quantity_est
        tv_collie.text = item.collie_est
    }
}