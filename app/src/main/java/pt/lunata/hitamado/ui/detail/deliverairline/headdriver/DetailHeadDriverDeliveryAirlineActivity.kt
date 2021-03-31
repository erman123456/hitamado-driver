package pt.lunata.hitamado.ui.detail.deliverairline.headdriver

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.deliverairline.DeliverAirlineEntity
import kotlinx.android.synthetic.main.activity_detail_head_driver_delivery_airline.*

class DetailHeadDriverDeliveryAirlineActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_head_driver_delivery_airline)
        val items = intent.getParcelableExtra(EXTRA_DATA) as DeliverAirlineEntity
        populateDeliverAirline(items!!)
        btn_back_detail_deliver_airline_head.setOnClickListener {
            finish()
        }
    }

    private fun populateDeliverAirline(item: DeliverAirlineEntity) {
        tv_po_master_number_deliver_airline_head.text=item.po_master_number
        tv_airport_name_deliver_airline_head.text=item.airportCode
        tv_berat_benda_deliver_airline_head.text = item.quantity_est
        tv_collie_deliver_airline_head.text = item.collie_est
        tv_driver_name_deliver_airline_head.text=item.driverName
    }
}