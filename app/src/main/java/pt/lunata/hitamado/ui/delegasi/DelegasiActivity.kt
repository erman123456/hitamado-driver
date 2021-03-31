package pt.lunata.hitamado.ui.delegasi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import pt.lunata.hitamado.R
import pt.lunata.hitamado.ui.delegasi.search.deliverairline.SearchDelegasiDeliverAirlineActivity
import pt.lunata.hitamado.ui.delegasi.search.office.SearchDelegasiOfficeActivity
import pt.lunata.hitamado.ui.delegasi.search.pickup.SearchDelegasiPickupActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_delegasi.*

@AndroidEntryPoint
class DelegasiActivity : AppCompatActivity(), View.OnClickListener {
    private val viewModel:DelegasiViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delegasi)
        populateBadge()
        cl_penjemputan.setOnClickListener(this)
        cl_kantor.setOnClickListener(this)
        cl_ke_maskapai.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        populateBadge()
    }
    fun populateBadge(){
        try {
            viewModel.getItemDelegasiPickup(this).observe(this, Observer { result->
                if (result.size>0){
                    tv_badge_count_item_delegasi_pickup.visibility=View.VISIBLE
                }else{
                    tv_badge_count_item_delegasi_pickup.visibility=View.GONE
                }
            })
            viewModel.getItemDelegasiOffice(this).observe(this, Observer { result->
                if (result.size>0){
                    tv_badge_count_item_delegasi_office.visibility=View.VISIBLE
                }else{
                    tv_badge_count_item_delegasi_office.visibility=View.GONE
                }
            })
            viewModel.getItemDelegasiDeliverAirline(this).observe(this, Observer { result->
                if (result.size>0){
                    tv_badge_count_item_delegasi_ke_maskapai.visibility=View.VISIBLE
                }else{
                    tv_badge_count_item_delegasi_ke_maskapai.visibility=View.GONE
                }
            })
        }catch (e:Exception){
            Toast.makeText(this,"Gagal Terhubung ke Server..",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.cl_penjemputan -> {
                val intent = Intent(this, SearchDelegasiPickupActivity::class.java)
                startActivity(intent)
            }
            R.id.cl_kantor -> {
                val intent = Intent(this, SearchDelegasiOfficeActivity::class.java)
                startActivity(intent)
            }
            R.id.cl_ke_maskapai -> {
                val intent = Intent(this, SearchDelegasiDeliverAirlineActivity::class.java)
                startActivity(intent)
            }
        }
    }
}