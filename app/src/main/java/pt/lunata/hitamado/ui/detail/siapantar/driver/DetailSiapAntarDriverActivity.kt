package pt.lunata.hitamado.ui.detail.siapantar.driver

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
import pt.lunata.hitamado.model.siapantar.SiapAntarEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_detail_siap_antar_driver.*

@AndroidEntryPoint
class DetailSiapAntarDriverActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val viewModel: DetailSiapAntarDriverViewModel by viewModels()
    private var items: SiapAntarEntity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_siap_antar_driver)
        items = intent.getParcelableExtra(EXTRA_DATA) as SiapAntarEntity
        /*populateSiapantar(items!!)*/
        tv_po_master_number.text=items?.po_master_number
        btn_arrive_siap_antar.setOnClickListener(this)
        btn_delegasi_siap_antar.setOnClickListener(this)
    }
    /*private fun populateSiapantar(item: SiapAntarEntity){
        tv_customer_name_siap_antar.text=item.customer_name
        tv_alamat_customer_siap_antar.text=item.customer_alamt
        tv_telepon_siap_antar.text=item.no_telepon
        Toast.makeText(this,item.siap_antar,Toast.LENGTH_SHORT).show()
        if (item.siap_antar!="false"){
            btn_arrive_siap_antar.text="Continue"
        }
        tv_marketing_siap_antar.text=item.marketing_name
        tv_komoditi_siap_antar.text=item.comodity_name
        tv_berat_benda_siap_antar.text=item.quantity_est
        tv_collie_siap_antar.text=item.collie_est
    }*/

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_arrive_siap_antar -> {
                if (items != null && items?.siap_antar!!) {
                    btn_arrive_siap_antar.text = "Continue"
                    viewModel.postArrivedSiapAntar(this, items?.uid)
                        .observe(this, Observer { result ->
                            if (result.success != null && result.success) {
                                Toast.makeText(applicationContext, "Siap Antar", Toast.LENGTH_SHORT)
                                    .show()
                                val builder =
                                    AlertDialog.Builder(this@DetailSiapAntarDriverActivity)
                                builder.setMessage("Apakah anda ingin melanjutkan proses Antar Ke Maskapai?")
                                builder.setPositiveButton("YES") { dialog, which ->
                                    Toast.makeText(
                                        applicationContext,
                                        "OK Lanjut",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    viewModel.postContinueSiapAntar(this, items?.uid).observe(this,
                                        Observer { result ->
                                            if (result.success!!) {
                                                finish()
                                            }
                                        })
                                }
                                builder.setNegativeButton("NO") { dialog, which ->
                                    Toast.makeText(
                                        applicationContext,
                                        "Klik Delegasi",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                                val dialog = builder.create()
                                dialog.show()
                            }
                        })
                } else {
                    val builder = AlertDialog.Builder(this@DetailSiapAntarDriverActivity)
                    builder.setMessage("Apakah anda ingin melanjutkan proses Antar Ke Maskapai?")
                    builder.setPositiveButton("YES") { dialog, which ->
                        viewModel.postContinueSiapAntar(this, items?.uid).observe(this,
                            Observer { result ->
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
            R.id.btn_delegasi_siap_antar -> {
                val preference = getSharedPreferences("APP", Context.MODE_PRIVATE)
                var uid = preference.getString("UserId", null)
                val editText = EditText(this)
                val builder = AlertDialog.Builder(this@DetailSiapAntarDriverActivity)
                builder.setMessage("Lanjutkan ke proses Delegasi?")
                builder.setView(editText)
                builder.setPositiveButton("YES") { dialog, which ->
                    viewModel.postDelegasiSiapAntar(this, items?.uid, uid, editText.text.toString())
                        .observe(this,
                            Observer { result ->
                                finish()
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