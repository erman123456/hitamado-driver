package pt.lunata.hitamado.ui.detail.office.driver

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.office.OfficeEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_detail_driver_office.*
import java.util.*

@AndroidEntryPoint
class DetailDriverOfficeActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val viewModel: DetailDriverOfficeViewModel by viewModels()
    private var items: OfficeEntity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_driver_office)
        items = intent.getParcelableExtra(EXTRA_DATA) as OfficeEntity
        populateOffice(items!!)
        btn_arrive_at_office.setOnClickListener(this)
        btn_delegasi_office.setOnClickListener(this)

    }

    private fun populateOffice(item: OfficeEntity) {
        tv_number_po_house.text = item.po_house_number
        tv_customer_name_office.text = item.customer_name
        tv_alamat_customer_office.text = item.customer_alamt
        tv_telepon_office.text = item.no_telepon
        if (item.tiba_office != "false") {
            btn_arrive_at_office.text = "Continue"
            tv_arrived_time_office.visibility = View.VISIBLE
            tv_arrived_time_office.text = "*Anda sudah tiba pada pukul ${items?.tiba_office}"
        }
        tv_marketing_office.text = item.marketing_name
        tv_komoditi_office.text = item.comodity_name
        tv_berat_benda_office.text =item.quantity_est
        tv_collie_office.text = item.collie_est
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_arrive_at_office -> {
                if (items != null && items?.tiba_office == "false") {
                    viewModel.postArrivedOffice(this, items?.uid).observe(this, Observer { result ->
                        if (result.success != null && result.success) {
                            finish()
                            /*Toast.makeText(applicationContext,"Tiba di Kantor", Toast.LENGTH_SHORT).show()
                            val builder= AlertDialog.Builder(this@DetailDriverOfficeActivity)
                            builder.setMessage("Apakah anda ingin melanjutkan proses Siap Antar?")
                            builder.setPositiveButton("YES"){dialog, which ->
                                Toast.makeText(applicationContext,"OK Lanjut", Toast.LENGTH_SHORT).show()
                                viewModel.postContinueOffice(this,items?.uid).observe(this, Observer { result->
                                    if (result.success!!){
                                        finish()
                                    }
                                })

                            }
                            builder.setNegativeButton("NO"){dialog, which ->
                                Toast.makeText(applicationContext,"Klik Delegasi", Toast.LENGTH_SHORT).show()
                            }
                            val dialog=builder.create()
                            dialog.show()*/
                        }
                    })
                } else {
                    val builder = AlertDialog.Builder(this@DetailDriverOfficeActivity)
                    builder.setMessage("Apakah anda ingin melanjutkan proses Siap Antar?")
                    builder.setPositiveButton("YES") { dialog, which ->
                        viewModel.postContinueOffice(this, items?.uid)
                            .observe(this, Observer { result ->
                                if (result.success!!) {
                                    finish()
                                }
                            })
                    }
                    builder.setNegativeButton("NO") { dialog, which ->
                        Toast.makeText(applicationContext, "Klik Delegasi", Toast.LENGTH_SHORT)
                            .show()
                    }
                    val dialog = builder.create()
                    dialog.show()
                }
            }
            R.id.btn_delegasi_office -> {
                val preference = getSharedPreferences("APP", Context.MODE_PRIVATE)
                var uid = preference.getString("UserId", null)
                val editText = EditText(this)
                val builder = AlertDialog.Builder(this@DetailDriverOfficeActivity)
                builder.setMessage("Lanjutkan ke proses Delegasi?")
                builder.setView(editText)
                builder.setPositiveButton("YES") { dialog, which ->
                    viewModel.postDelegasiOffice(this, items?.uid, uid, editText.text.toString())
                        .observe(this,
                            Observer { result ->
                                if (result.success!!) {
                                    Toast.makeText(this, "Berhasil Delegasi", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            })
                }
                builder.setNegativeButton("NO") { dialog, which ->
                    Toast.makeText(applicationContext, "Klik Delegasi", Toast.LENGTH_SHORT).show()
                }
                val dialog = builder.create()
                dialog.show()
            }
        }
    }
}