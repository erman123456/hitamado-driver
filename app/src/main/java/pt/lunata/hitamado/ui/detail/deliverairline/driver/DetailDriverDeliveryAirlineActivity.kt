package pt.lunata.hitamado.ui.detail.deliverairline.driver

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
import pt.lunata.hitamado.model.deliverairline.DeliverAirlineEntity
import pt.lunata.hitamado.ui.detail.office.driver.DetailDriverOfficeActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_detail_driver_delivery_airline.*

@AndroidEntryPoint
class DetailDriverDeliveryAirlineActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val viewModel: DetailDriverDeliveryAirlineViewModel by viewModels()
    private var items: DeliverAirlineEntity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_driver_delivery_airline)
        items =
            intent.getParcelableExtra(DetailDriverOfficeActivity.EXTRA_DATA) as DeliverAirlineEntity
        populateDeliverAirline(items!!)
        btn_arrive_at_airline.setOnClickListener(this)
        btn_delegasi_deliver_airline.setOnClickListener(this)
    }

    private fun populateDeliverAirline(item: DeliverAirlineEntity) {
        tv_po_master_number.text=item.po_master_number
        tv_airport_name_deliver_airline_driver.text=item.airportCode
        tv_berat_benda_deliver_airline.text = item.quantity_est
        tv_collie_deliver_airline.text = item.collie_est
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_arrive_at_airline -> {
                viewModel.postArrivedDeliverAirline(this, items?.uid)
                    .observe(this, Observer { result ->
                        if (result.error == false) {
                            Toast.makeText(this, "Sampai di Maskapai", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    })
            }
            R.id.btn_delegasi_deliver_airline -> {
                val preference = getSharedPreferences("APP", Context.MODE_PRIVATE)
                var uid = preference.getString("UserId", null)
                val editText = EditText(this)
                val builder = AlertDialog.Builder(this@DetailDriverDeliveryAirlineActivity)
                builder.setMessage("Lanjutkan ke proses Delegasi?")
                builder.setView(editText)
                builder.setPositiveButton("YES") { dialog, which ->
                    viewModel.postDelegasiDeliverAirline(
                        this,
                        items?.uid,
                        uid,
                        editText.text.toString()
                    ).observe(this,
                        Observer { result ->
                            if (result.error!=null && !result.error) {
                                Toast.makeText(this, "Berhasil Delegasi", Toast.LENGTH_SHORT).show()
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