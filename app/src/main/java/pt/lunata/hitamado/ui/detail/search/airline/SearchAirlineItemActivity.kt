package pt.lunata.hitamado.ui.detail.search.airline

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.airline.operational.DataItem
import pt.lunata.hitamado.ui.detail.airline.headdriver.DetailHeadDriverMaskapaiActivity
import pt.lunata.hitamado.ui.detail.airline.operasional.DetailOperasionalMaskapaiActivity
import pt.lunata.hitamado.ui.detail.search.airline.adapter.SearchAirlineItemAdapter
import pt.lunata.hitamado.ui.detail.search.airline.adapter.SearchAirlineItemHeadAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_search_airline_item.*

@AndroidEntryPoint
class SearchAirlineItemActivity : AppCompatActivity() {
    private lateinit var adapterAirline: SearchAirlineItemAdapter
    private lateinit var adapterAirlineHead: SearchAirlineItemAdapter
    private lateinit var adapterSearch:SearchAirlineItemHeadAdapter
    private val viewModel: SearchAirlineItemViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_airline_item)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null
        val preference = this@SearchAirlineItemActivity.getSharedPreferences(
            "APP",
            Context.MODE_PRIVATE
        )
        adapterAirlineHead = SearchAirlineItemAdapter()
        adapterAirline = SearchAirlineItemAdapter()
        adapterSearch= SearchAirlineItemHeadAdapter()
        progressbarAirline.visibility= View.VISIBLE
        Toast.makeText(this,"Sedang Menuat Data...",Toast.LENGTH_LONG).show()

        val jabatan = preference.getString("Jabatan", null)
        if (jabatan == "Driver Head Office") {

            progressbarAirline.visibility= View.VISIBLE
            adapterAirlineHead.setOnItemClickCallback(object :
                SearchAirlineItemAdapter.OnItemClickCallback {
                override fun onItemClicked(data: DataItem) {
                    val intent = Intent(
                        this@SearchAirlineItemActivity,
                        DetailHeadDriverMaskapaiActivity::class.java
                    )
                    intent.putExtra(DetailHeadDriverMaskapaiActivity.EXTRA_DATA, data)
                    startActivity(intent)
                }
            })
        } else {
            progressbarAirline.visibility= View.VISIBLE
            with(rv_airline_item) {
                layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL, false
                )
                setHasFixedSize(true)
                adapter = adapterAirline
            }
            adapterAirline.setOnItemClickCallback(object :
                SearchAirlineItemAdapter.OnItemClickCallback {
                override fun onItemClicked(data: DataItem) {
                    val intent = Intent(
                        this@SearchAirlineItemActivity,
                        DetailOperasionalMaskapaiActivity::class.java
                    )
                    intent.putExtra(DetailOperasionalMaskapaiActivity.EXTRA_DATA, data)
                    startActivity(intent)
                }
            })
        }
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                val listItem=ArrayList<DataItem>()
                if (query!=null){
                    viewModel.getSearchItemAirline(this@SearchAirlineItemActivity,query).observe(this@SearchAirlineItemActivity, Observer {result->
                        if (result.poMasterNumber!=null){
                            listItem.add(result)
                            adapterSearch.setListItems(listItem)
                            adapterSearch.notifyDataSetChanged()
                            listItem.clear()

                            with(rv_airline_item) {
                                layoutManager = LinearLayoutManager(
                                    this@SearchAirlineItemActivity,
                                    LinearLayoutManager.VERTICAL, false
                                )
                                setHasFixedSize(true)
                                adapter = this@SearchAirlineItemActivity.adapterSearch
                            }
                        }else{
                            Toast.makeText(this@SearchAirlineItemActivity,"Data tidak ditemukan..",Toast.LENGTH_SHORT).show()
                        }
                    })
                    if (jabatan == "Driver Head Office") {
                        adapterSearch.setOnItemClickCallback(object :
                            SearchAirlineItemHeadAdapter.OnItemClickCallback {
                            override fun onItemClicked(data: DataItem) {
                                val intent = Intent(
                                    this@SearchAirlineItemActivity,
                                    DetailHeadDriverMaskapaiActivity::class.java
                                )
                                intent.putExtra(DetailHeadDriverMaskapaiActivity.EXTRA_DATA, data)
                                startActivity(intent)
                            }
                        })
                    }else{
                        adapterSearch.setOnItemClickCallback(object :
                            SearchAirlineItemHeadAdapter.OnItemClickCallback {
                            override fun onItemClicked(data: DataItem) {
                                val intent = Intent(
                                    this@SearchAirlineItemActivity,
                                    DetailOperasionalMaskapaiActivity::class.java
                                )
                                intent.putExtra(DetailOperasionalMaskapaiActivity.EXTRA_DATA, data)
                                startActivity(intent)
                            }
                        })
                    }

                }
                listItem.clear()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
        srl_data.setOnRefreshListener {
            srl_data.isRefreshing = true
            Toast.makeText(this,"Sedang Menuat Data...",Toast.LENGTH_LONG).show()
            loadDataAirline()
            srl_data.isRefreshing = false
        }
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"Sedang Menuat Data...",Toast.LENGTH_LONG).show()
        loadDataAirline()
    }

    private fun loadDataAirline() {
        val preference = this.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var jabatan = preference.getString("Jabatan", null)
        if (jabatan == "Driver Head Office") {
            viewModel.getItemAirlineOperational(this@SearchAirlineItemActivity)
                .observe(this, Observer { items ->
                    progressbarAirline.visibility= View.GONE
                    Log.d("tes2", items.size.toString())
                    adapterAirlineHead.submitList(items)
                    adapterAirlineHead.notifyDataSetChanged()
                    with(rv_airline_item) {
                        layoutManager = LinearLayoutManager(
                            this@SearchAirlineItemActivity,
                            LinearLayoutManager.VERTICAL, false
                        )
                        setHasFixedSize(true)
                        adapter = this@SearchAirlineItemActivity.adapterAirlineHead
                    }
                })/*
            viewModel.getItemTotal(this).observe(this, Observer { result->
                tv_total_items_airline.visibility=View.VISIBLE
                tv_total_items_airline.text=result.toString()
            })*/
        } else if (jabatan == "Operational") {
            viewModel.getItemAirlineOperational(this).observe(this@SearchAirlineItemActivity,
                Observer { items ->
                    progressbarAirline.visibility= View.GONE
                    if (items != null) {
                        rv_airline_item.setHasTransientState(true)
                        adapterAirline.submitList(items)
                        adapterAirline.notifyDataSetChanged()
                    }
                })/*
            viewModel.getItemTotal(this).observe(this, Observer { result->
                tv_total_items_airline.visibility=View.VISIBLE
                tv_total_items_airline.text=result.toString()
            })*/
        }
    }
}