package pt.lunata.hitamado.ui.detail.pickup.driver

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
import pt.lunata.hitamado.model.pickup.PickupEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_detail_status_pickup_driver.*
import java.util.*

@AndroidEntryPoint
class DetailStatusPickupDriverActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val viewModel: DetailStatusPickupDriverViewModel by viewModels()
    private var items: PickupEntity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_status_pickup_driver)
        items = intent.getParcelableExtra(EXTRA_DATA) as PickupEntity
        items?.let { populatePickup(it) }
        btn_confirm_detail_pickup.setOnClickListener(this)
        btn_arrive_at_the_customer.setOnClickListener(this)
        btn_delegasi_pickup.setOnClickListener(this)
    }

    private fun populatePickup(item: PickupEntity) {
        tv_number_po_house.text = item.po_house_number
        tv_customer_name_pickup.text = item.customer_name
        tv_alamat_customer_pickup.text = item.customer_alamt
        tv_telepon_pickup.text = item.no_telepon
        if (item.status != null && item.status) {
            tv_status_pickup.text = "Dikonfirmasi Driver"
            btn_confirm_detail_pickup.setBackgroundResource(R.drawable.shape_button_green)
            btn_confirm_detail_pickup.text = "Dikonfirmasi"
            btn_arrive_at_the_customer.visibility = View.VISIBLE
        } else {
            tv_status_pickup.text = "Belum Dikonfirmasi Driver"
        }
        if (item.tiba_customer != "false") {
            btn_arrive_at_the_customer.text = "Continue"
            tv_arrived_time.visibility = View.VISIBLE
            tv_arrived_time.text = "*Anda sudah tiba pada pukul ${items?.tiba_customer}"
        }
        tv_marketing_pickup.text = item.marketing_name
        tv_komoditi_pickup.text = item.comodity_name
        tv_berat_benda_pickup.text =item.quantity_est
        tv_collie_pickup.text = item.collie_est
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_confirm_detail_pickup -> {
                progressbar.visibility=View.VISIBLE
                if (items?.status != null && items?.status == false) {
                    viewModel.postConfirmPickup(this, items?.uid).observe(this, Observer { result ->
                        if (result.confirmed != null && result.confirmed) {
                            progressbar.visibility=View.GONE
                            Toast.makeText(this, "Berhasil Dikonfirmasi!", Toast.LENGTH_SHORT)
                                .show()
                            try {
                                btn_arrive_at_the_customer.visibility = View.VISIBLE
                                btn_confirm_detail_pickup.setBackgroundResource(R.drawable.shape_button_green)
                            }catch (e:Exception){
                                progressbar.visibility=View.GONE
                                Toast.makeText(this,"Gagal terhubung ke Server...",Toast.LENGTH_SHORT).show()
                            }

                        }else{
                            progressbar.visibility=View.GONE
                        }
                    })
                }
            }
            R.id.btn_arrive_at_the_customer -> {
                if (items != null && items?.tiba_customer == "false") {
                    viewModel.postArrivedToCustomer(this, items?.uid)
                        .observe(this, Observer { result ->
                            if (result.confirmed != null && result.confirmed) {
                                Toast.makeText(
                                    applicationContext,
                                    "Tiba di customer",
                                    Toast.LENGTH_SHORT
                                ).show()
                                if (items != null && items?.antar_kantor!!) {
                                    val builder =
                                        AlertDialog.Builder(this@DetailStatusPickupDriverActivity)
                                    builder.setMessage("Lanjutkan ke proses Antar ke Kantor?")
                                    builder.setPositiveButton("YES") { dialog, which ->
                                        Toast.makeText(
                                            applicationContext,
                                            "OK Lanjut",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        viewModel.postContinuePickup(this, items?.uid)
                                            .observe(this, Observer { result ->
                                                if (result.success!=null && result.success) {
                                                    this.finish()
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
                                } else {
                                    val builder =
                                        AlertDialog.Builder(this@DetailStatusPickupDriverActivity)
                                    builder.setMessage("Lanjutkan ke proses Antar ke Maskapai?")
                                    builder.setPositiveButton("YES") { dialog, which ->
                                        viewModel.postContinuePickup(this, items?.uid)
                                            .observe(this, Observer { result ->
                                                if (result.success!=null && result.success) {
                                                    finish()
                                                }else{
                                                    Toast.makeText(this,"Gagal Terhubung ke server..",Toast.LENGTH_SHORT).show()
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

                            }
                        })
                } else {
                    if (items != null && items?.antar_kantor!!) {
                        val builder = AlertDialog.Builder(this@DetailStatusPickupDriverActivity)
                        builder.setMessage("Lanjutkan ke proses Antar ke Kantor?")
                        builder.setPositiveButton("YES") { dialog, which ->
                            viewModel.postContinuePickup(this, items?.uid)
                                .observe(this, Observer { result ->
                                    if (result.success != null && result.success) {
                                        this.finish()
                                    }
                                })
                        }
                        builder.setNegativeButton("NO") { dialog, which ->
                            Toast.makeText(applicationContext, "Klik Delegasi", Toast.LENGTH_SHORT)
                                .show()
                        }
                        val dialog = builder.create()
                        dialog.show()
                    } else {
                        val builder = AlertDialog.Builder(this@DetailStatusPickupDriverActivity)
                        builder.setMessage("Lanjutkan ke proses Antar ke Maskapai?")
                        builder.setPositiveButton("YES") { dialog, which ->
                            viewModel.postContinuePickup(this, items?.uid)
                                .observe(this, Observer { result ->
                                    if (result.success != null && result.success) {
                                        this.finish()
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
            }
            R.id.btn_delegasi_pickup -> {
                val preference = getSharedPreferences("APP", Context.MODE_PRIVATE)
                var uid = preference.getString("UserId", null)
                val editText = EditText(this)
                val builder = AlertDialog.Builder(this@DetailStatusPickupDriverActivity)
                builder.setMessage("Lanjutkan ke proses Delegasi?")
                builder.setView(editText)
                builder.setPositiveButton("YES") { dialog, which ->
                    viewModel.postDelegasiPickup(this, items?.uid, uid, editText.text.toString())
                        .observe(this,
                            Observer { result ->
                                if (result.success!=null && result.success) {
                                    Toast.makeText(this, "Berhasil Delegasi", Toast.LENGTH_SHORT)
                                        .show()
                                    finish()
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