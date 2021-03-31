package pt.lunata.hitamado.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import pt.lunata.hitamado.R
import pt.lunata.hitamado.ui.delegasi.DelegasiActivity
import pt.lunata.hitamado.ui.detail.search.airline.SearchAirlineItemActivity
import pt.lunata.hitamado.ui.detail.search.deliverAirline.SearchDeliverAirlineItemActivity
import pt.lunata.hitamado.ui.detail.search.newpo.SearchNewpoItemActivity
import pt.lunata.hitamado.ui.detail.search.office.SearchOfficeItemActivity
import pt.lunata.hitamado.ui.detail.search.pickup.SearchPickupItemActivity
import pt.lunata.hitamado.ui.detail.search.siapantar.SearchSiapantarItemActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home_driver.*
import kotlinx.android.synthetic.main.fragment_home_head_driver.*
import kotlinx.android.synthetic.main.fragment_home_operasional.*

@AndroidEntryPoint
class HomeFragment : Fragment(), View.OnClickListener {

    private val viewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val preference = requireContext().getSharedPreferences("APP", Context.MODE_PRIVATE)
        val jabatan = preference.getString("Jabatan", null)
        if (jabatan == "Driver Head Office") {
            return inflater.inflate(R.layout.fragment_home_head_driver, container, false)
        } else if (jabatan == "Driver Office") {
            return inflater.inflate(R.layout.fragment_home_driver, container, false)
        }
        return inflater.inflate(R.layout.fragment_home_operasional, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        populateItem()

    }

    override fun onResume() {
        super.onResume()
        val preference = requireContext().getSharedPreferences("APP", Context.MODE_PRIVATE)
        val jabatan = preference.getString("Jabatan", "Driver Head Office")
        if (jabatan == "Driver Head Office") {
            try {
                viewModel.getItemsNewpo(requireActivity())
                    .observe(requireActivity(), Observer { items ->
                        try {
                            if (items.size>9){
                                tv_badge_count_item.text = "9+"
                            }else{
                                tv_badge_count_item.text = items.size.toString()
                            }

                        }catch (e:Exception){
                            Log.d("Cek","Jangan pindah")
                        }

                    })
            } catch (e: Exception) {
                Toast.makeText(
                    requireContext(),
                    "Gagal Terhubung ke Internet..",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun populateItem(){
        val preference = requireContext().getSharedPreferences("APP", Context.MODE_PRIVATE)
        val jabatan = preference.getString("Jabatan", "Driver Head Office")
        Log.d("jabatan", jabatan)
        if (jabatan == "Driver Head Office") {
            crd_new_po.setOnClickListener {
                val intent = Intent(
                    requireContext(),
                    SearchNewpoItemActivity::class.java
                )
                requireContext().startActivity(intent)
            }
            crd_pickup_head_driver.setOnClickListener(this)
            crd_office_head_driver.setOnClickListener(this)
            crd_deliver_head_driver.setOnClickListener(this)
            crd_deliver_airline_head_driver.setOnClickListener(this)
            crd_airline_head_driver.setOnClickListener(this)
            try {
                viewModel.getItemsNewpo(requireActivity())
                    .observe(requireActivity(), Observer { items ->
                        try {
                            if (items.size>9){
                                tv_badge_count_item.text = "9+"
                            }else{
                                tv_badge_count_item.text = items.size.toString()
                            }
                        }catch (e:java.lang.Exception){
                            Toast.makeText(requireActivity(),"Gagal Terhubung ke Server...",Toast.LENGTH_SHORT).show()
                        }
                    })
                viewModel.getDataUser(requireActivity())
                    .observe(requireActivity(), Observer { items ->
                        Glide.with(requireContext())
                            .load(items.foto)
                            .apply(
                                RequestOptions.placeholderOf(R.drawable.ic_loading)
                                    .error(R.drawable.ic_loading)
                            )
                            .into(img_user_head_driver)
                        tv_jabatan_head_driver.text = items.jabatanAppend?.jabatan
                        tv_username_head_driver.text = items.nama
                    })
            } catch (e: Exception) {
                Toast.makeText(
                    requireContext(),
                    "Gagal Terhubung ke Internet..",
                    Toast.LENGTH_SHORT
                ).show()
            }
            crd_delegasi.setOnClickListener(this)

        } else if (jabatan == "Driver Office") {
            crd_pickup.setOnClickListener(this)
            crd_office.setOnClickListener(this)
            try {
                viewModel.getDataUser(requireActivity())
                    .observe(requireActivity(), Observer { items ->
                        Glide.with(requireContext())
                            .load(items.foto)
                            .apply(
                                RequestOptions.placeholderOf(R.drawable.ic_loading)
                                    .error(R.drawable.ic_loading)
                            )
                            .into(img_user_driver)
                        tv_jabatan_driver.text = items.jabatanAppend?.jabatan
                        tv_username_driver.text = items.nama
                    })
            } catch (e: Exception) {
                Toast.makeText(
                    requireContext(),
                    "Gagal Terhubung ke Internet..",
                    Toast.LENGTH_SHORT
                ).show()
            }
            crd_deliver_airline.setOnClickListener(this)
        } else if (jabatan == "Operational") {
            try {
                viewModel.getDataUser(requireActivity())
                    .observe(requireActivity(), Observer { items ->
                        Glide.with(requireContext())
                            .load(items.foto)
                            .apply(
                                RequestOptions.placeholderOf(R.drawable.ic_loading)
                                    .error(R.drawable.ic_loading)
                            )
                            .into(img_user_operasional)
                        tv_jabatan_operasional.text = items.jabatanAppend?.jabatan
                        tv_username_operasional.text = items.nama
                    })
            } catch (e: Exception) {
                Toast.makeText(
                    requireContext(),
                    "Gagal Terhubung ke Internet..",
                    Toast.LENGTH_SHORT
                ).show()
            }
            crd_airline.setOnClickListener(this)
        }
    }
    override fun onClick(v: View) {
        when (v.id) {
            /*R.id.crd_new_po->{
                val intent=Intent(context,
                    SearchNewpoItemActivity::class.java)
                startActivity(intent)
            }*/
            R.id.crd_pickup_head_driver -> {
                val intent = Intent(context, SearchPickupItemActivity::class.java)
                startActivity(intent)
            }
            R.id.crd_office_head_driver -> {
                val intent = Intent(context, SearchOfficeItemActivity::class.java)
                startActivity(intent)
            }
            R.id.crd_deliver_head_driver -> {
                val intent = Intent(context, SearchSiapantarItemActivity::class.java)
                startActivity(intent)
            }
            R.id.crd_deliver_airline_head_driver -> {
                val intent = Intent(context, SearchDeliverAirlineItemActivity::class.java)
                startActivity(intent)
            }
            R.id.crd_airline_head_driver -> {
                val intent = Intent(context, SearchAirlineItemActivity::class.java)
                startActivity(intent)
            }
            R.id.crd_delegasi -> {
                val intent = Intent(context, DelegasiActivity::class.java)
                startActivity(intent)
            }
            R.id.crd_pickup -> {
                val intent = Intent(context, SearchPickupItemActivity::class.java)
                startActivity(intent)
            }
            R.id.crd_office -> {
                val intent = Intent(context, SearchOfficeItemActivity::class.java)
                startActivity(intent)
            }
            /*R.id.crd_deliver->{
                val intent=Intent(context,SearchSiapantarItemActivity::class.java)
                startActivity(intent)
            }*/
            R.id.crd_deliver_airline -> {
                val intent = Intent(context, SearchDeliverAirlineItemActivity::class.java)
                startActivity(intent)
            }
            R.id.crd_airline -> {
                val intent = Intent(context, SearchAirlineItemActivity::class.java)
                startActivity(intent)
            }
        }
    }
}