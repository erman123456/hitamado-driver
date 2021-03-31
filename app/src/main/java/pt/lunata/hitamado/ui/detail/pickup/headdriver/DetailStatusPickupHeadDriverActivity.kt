package pt.lunata.hitamado.ui.detail.pickup.headdriver

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.pickup.PickupEntity
import kotlinx.android.synthetic.main.activity_detail_status_pickup_head_driver.*

class DetailStatusPickupHeadDriverActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_status_pickup_head_driver)
        val items = intent.getParcelableExtra(EXTRA_DATA) as PickupEntity
        populatePickup(items!!)
        btn_back_detail_pickup_head.setOnClickListener {
            finish()
        }
    }

    private fun populatePickup(item: PickupEntity) {
        tv_number_po_house.text = item.po_house_number
        tv_customer_name_pickup_head.text = item.customer_name
        tv_alamat_customer_pickup_head.text = item.customer_alamt
        tv_telepon_pickup_head.text = item.no_telepon
        tv_marketing_pickup_head.text = item.marketing_name
        tv_komoditi_pickup_head.text = item.comodity_name
        tv_berat_benda_pickup_head.text =item.quantity_est
        tv_collie_pickup_head.text = item.collie_est
        tv_driver_name_pickup_head.text = item.driverName
    }
}