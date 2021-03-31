package pt.lunata.hitamado.ui.delegasi.search.deliverairline

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.siapantar.SiapAntarEntity
import pt.lunata.hitamado.ui.delegasi.search.deliverairline.adapter.SearchDelegasiDeliverAirlineAdapter
import pt.lunata.hitamado.ui.detail.siapantar.headdriver.DetailSiapAntarHeadDriverActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_search_delegasi_deliver_airline.*

@AndroidEntryPoint
class SearchDelegasiDeliverAirlineActivity : AppCompatActivity() {
    private val viewModel: SearchDelegasiDeliverAirlineViewModel by viewModels()
    private lateinit var adapter: SearchDelegasiDeliverAirlineAdapter

    companion object {
        private var listItems = ArrayList<SiapAntarEntity>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_delegasi_deliver_airline)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null
        adapter = SearchDelegasiDeliverAirlineAdapter()
        progressbar.visibility = View.VISIBLE
        adapter.setOnItemClickCallback(object :
            SearchDelegasiDeliverAirlineAdapter.OnItemClickCallback {
            override fun onItemClicked(data: SiapAntarEntity) {
                val intent = Intent(
                    this@SearchDelegasiDeliverAirlineActivity,
                    DetailSiapAntarHeadDriverActivity::class.java
                )
                intent.putExtra(DetailSiapAntarHeadDriverActivity.EXTRA_DATA, data)
                intent.putExtra(
                    DetailSiapAntarHeadDriverActivity.JENIS_DELEGASI,
                    "Delegasi Ke Maskapai"
                )
                startActivity(intent)
            }
        })
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                var listResult = ArrayList<SiapAntarEntity>()
                if (query != null) {
                    for (item in listItems) {
                        if (item.po_master_number!!.contains(query.toString())) {
                            listResult.add(item)
                        }
                    }
                    adapter.setListItems(listResult)
                    adapter.notifyDataSetChanged()
                } else {
                    adapter.setListItems(listItems)
                    adapter.notifyDataSetChanged()
                    listItems.clear()
                }
                listResult.clear()
                return true
            }

        })
        srl_data.setOnRefreshListener {
            srl_data.isRefreshing = true
            populateItems()
            srl_data.isRefreshing = false
        }
    }

    override fun onResume() {
        super.onResume()
        populateItems()
    }

    private fun populateItems() {
        viewModel.getItemDelegasiDeliverAirline(this@SearchDelegasiDeliverAirlineActivity)
            .observe(this@SearchDelegasiDeliverAirlineActivity, Observer { items ->
                Log.d("tes2", items.size.toString())
                progressbar.visibility = View.GONE
                if(items.size==0){
                    tv_notice_data_not_found.visibility=View.VISIBLE
                }else{
                    tv_notice_data_not_found.visibility=View.GONE
                }
                adapter.setListItems(items)
                adapter.notifyDataSetChanged()
                listItems.clear()
                listItems.addAll(items)
            })
        with(rv_delegasi_deliver_airline_item) {
            layoutManager = LinearLayoutManager(
                this@SearchDelegasiDeliverAirlineActivity,
                LinearLayoutManager.VERTICAL, false
            )
            setHasFixedSize(true)
            adapter = this@SearchDelegasiDeliverAirlineActivity.adapter
        }
    }
}