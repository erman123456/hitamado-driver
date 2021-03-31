package pt.lunata.hitamado.ui.detail.airline.headdriver

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.airline.operational.DataItem
import pt.lunata.hitamado.ui.detail.airline.operasional.DetailOperasionalMaskapaiActivity
import kotlinx.android.synthetic.main.activity_detail_head_driver_maskapai.*

class DetailHeadDriverMaskapaiActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_head_driver_maskapai)
        val items = intent.getParcelableExtra(DetailOperasionalMaskapaiActivity.EXTRA_DATA) as DataItem
        populateItemAirline(items)
        btn_back_detail_airline_head.setOnClickListener{
            finish()
        }
    }
    private fun populateItemAirline(item:DataItem){
        tv_po_master_number_airline_head.text=item.poMasterNumber
        tv_airport_name_airline_head.text=item.maskapai
        tv_berat_benda_airline_head.text=item.quantityEst
        tv_collie_airline_head.text=item.collieEst
    }
}