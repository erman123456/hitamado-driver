package pt.lunata.hitamado.ui.detail.airline.operasional

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.airline.operational.DataItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_detail_operasional_maskapai.*

@AndroidEntryPoint
class DetailOperasionalMaskapaiActivity : AppCompatActivity() {
    companion object {
        val EXTRA_DATA = "extra data"
    }

    private val viewModel: DetailOperasionalMaskapaiViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_operasional_maskapai)
        val items = intent.getParcelableExtra(EXTRA_DATA) as DataItem
        tv_po_master_number.text=items.poMasterNumber
        btn_submit_weight_operational_airline.setOnClickListener {
            items.uid?.let { it1 ->
                viewModel.postCompletedAirline(
                    this,
                    it1, edt_weigh_1.text.toString(), edt_collie_1.text.toString(),edt_weigh_2.text.toString(),edt_collie_2.text.toString()
                ).observe(this,
                    Observer { result ->
                        if (!result.Error!!){
                            Toast.makeText(this,"Data Berhasil di Input..",Toast.LENGTH_SHORT).show()
                            this.finish()
                        }

                    })
            }
        }
    }
}