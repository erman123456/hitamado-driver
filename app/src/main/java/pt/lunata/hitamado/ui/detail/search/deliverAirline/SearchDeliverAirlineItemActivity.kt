package pt.lunata.hitamado.ui.detail.search.deliverAirline

import android.content.Context
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
import pt.lunata.hitamado.model.deliverairline.DeliverAirlineEntity
import pt.lunata.hitamado.ui.detail.deliverairline.driver.DetailDriverDeliveryAirlineActivity
import pt.lunata.hitamado.ui.detail.deliverairline.headdriver.DetailHeadDriverDeliveryAirlineActivity
import pt.lunata.hitamado.ui.detail.search.deliverAirline.adapter.SearchDeliverAirlineItemAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_search_deliver_airline_item.*

@AndroidEntryPoint
class SearchDeliverAirlineItemActivity : AppCompatActivity() {
    private lateinit var adapter: SearchDeliverAirlineItemAdapter
    private val viewModel: SearchDeliverAirlineItemViewModel by viewModels()

    companion object {
        var listItems = ArrayList<DeliverAirlineEntity>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_deliver_airline_item)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null
        adapter = SearchDeliverAirlineItemAdapter()
        progressbar.visibility = View.VISIBLE
        loadDataDeliverAirline()
        adapter.setOnItemClickCallback(object :
            SearchDeliverAirlineItemAdapter.OnItemClickCallback {
            override fun onItemClicked(data: DeliverAirlineEntity) {
                val preference = this@SearchDeliverAirlineItemActivity.getSharedPreferences(
                    "APP",
                    Context.MODE_PRIVATE
                )
                val jabatan = preference.getString("Jabatan", null)
                if (jabatan == "Driver Head Office") {
                    val intent = Intent(
                        this@SearchDeliverAirlineItemActivity,
                        DetailHeadDriverDeliveryAirlineActivity::class.java
                    )
                    intent.putExtra(DetailHeadDriverDeliveryAirlineActivity.EXTRA_DATA, data)
                    startActivity(intent)
                } else {
                    val intent = Intent(
                        this@SearchDeliverAirlineItemActivity,
                        DetailDriverDeliveryAirlineActivity::class.java
                    )
                    intent.putExtra(DetailDriverDeliveryAirlineActivity.EXTRA_DATA, data)
                    startActivity(intent)
                }
            }
        })
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                var listResult = ArrayList<DeliverAirlineEntity>()
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
            loadDataDeliverAirline()
            srl_data.isRefreshing = false
        }
    }


    override fun onResume() {
        super.onResume()
        loadDataDeliverAirline()
    }

    private fun loadDataDeliverAirline() {
        val preference = this.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var jabatan = preference.getString("Jabatan", null)
        val uid = preference.getString("UserId", null)
        Log.d("uidtes", uid)

        if (jabatan == "Driver Head Office") {
            viewModel.getItemDeliverAirline(this@SearchDeliverAirlineItemActivity)
                .observe(this, Observer { items ->
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

                    with(rv_deliver_airline_item) {
                        layoutManager = LinearLayoutManager(
                            this@SearchDeliverAirlineItemActivity,
                            LinearLayoutManager.VERTICAL, false
                        )
                        setHasFixedSize(true)
                        adapter = this@SearchDeliverAirlineItemActivity.adapter
                    }
                })
        } else if (jabatan == "Driver Office") {
            viewModel.getItemDeliverAirlineDriver(this@SearchDeliverAirlineItemActivity)
                .observe(this,
                    Observer { items ->
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

                        with(rv_deliver_airline_item) {
                            layoutManager = LinearLayoutManager(
                                this@SearchDeliverAirlineItemActivity,
                                LinearLayoutManager.VERTICAL, false
                            )
                            setHasFixedSize(true)
                            adapter = this@SearchDeliverAirlineItemActivity.adapter
                        }
                    })
        }
    }
}