package pt.lunata.hitamado.ui.detail.office.headdriver

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.office.OfficeEntity
import kotlinx.android.synthetic.main.activity_detail_head_driver_office.*

class DetailHeadDriverOfficeActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private var items: OfficeEntity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_head_driver_office)
        items = intent.getParcelableExtra(EXTRA_DATA) as OfficeEntity
        populateOffice(items!!)
        btn_back_detail_office_head.setOnClickListener(this)
    }

    private fun populateOffice(item: OfficeEntity) {
        tv_number_po_house.text = item.po_house_number
        tv_customer_name_office_head.text = item.customer_name
        tv_alamat_customer_office_head.text = item.customer_alamt
        tv_telepon_office_head.text = item.no_telepon
        tv_marketing_office_head.text = item.marketing_name
        tv_komoditi_office_head.text = item.comodity_name
        tv_berat_benda_office_head.text =item.quantity_est
        tv_collie_office_head.text = item.collie_est
        tv_driver_name_office_head.text = item.driverName
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_back_detail_office_head -> {
                finish()
            }
        }
    }
}