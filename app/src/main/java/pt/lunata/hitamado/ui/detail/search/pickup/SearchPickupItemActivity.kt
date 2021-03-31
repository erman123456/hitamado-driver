package pt.lunata.hitamado.ui.detail.search.pickup

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
import pt.lunata.hitamado.model.pickup.PickupEntity
import pt.lunata.hitamado.ui.detail.pickup.driver.DetailStatusPickupDriverActivity
import pt.lunata.hitamado.ui.detail.pickup.headdriver.DetailStatusPickupHeadDriverActivity
import pt.lunata.hitamado.ui.detail.search.pickup.adapter.SearchPickupItemAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_search_pickup_item.*

@AndroidEntryPoint
class SearchPickupItemActivity : AppCompatActivity() {

    private lateinit var adapter: SearchPickupItemAdapter

    companion object {
        var listItems = ArrayList<PickupEntity>()
    }

    private val viewModel: SearchPickupItemViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_pickup_item)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null
        adapter = SearchPickupItemAdapter()
        progressbar.visibility = View.VISIBLE
        populateItems()

        adapter.setOnItemClickCallback(object : SearchPickupItemAdapter.OnItemClickCallback {
            override fun onItemClicked(data: PickupEntity) {
                val preference =
                    this@SearchPickupItemActivity.getSharedPreferences("APP", Context.MODE_PRIVATE)
                val jabatan = preference.getString("Jabatan", null)
                if (jabatan == "Driver Head Office") {
                    val intent = Intent(
                        this@SearchPickupItemActivity,
                        DetailStatusPickupHeadDriverActivity::class.java
                    )
                    intent.putExtra(DetailStatusPickupHeadDriverActivity.EXTRA_DATA, data)
                    startActivity(intent)
                } else {
                    val intent = Intent(
                        this@SearchPickupItemActivity,
                        DetailStatusPickupDriverActivity::class.java
                    )
                    intent.putExtra(DetailStatusPickupDriverActivity.EXTRA_DATA, data)
                    startActivity(intent)
                }
            }
        })
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                var listResult = ArrayList<PickupEntity>()
                if (query != null) {
                    for (item in listItems) {
                        if (item.po_house_number!!.contains(query.toString())) {
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
        val preference = this.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var jabatan = preference.getString("Jabatan", null)
        val uid = preference.getString("UserId", null)
        Log.d("uidtes", uid)
        if (jabatan == "Driver Head Office") {
            viewModel.getItemPickup(this@SearchPickupItemActivity).observe(this, Observer { items ->
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

                with(rv_pickup_item) {
                    layoutManager = LinearLayoutManager(
                        this@SearchPickupItemActivity,
                        LinearLayoutManager.VERTICAL, false
                    )
                    setHasFixedSize(true)
                    adapter = this@SearchPickupItemActivity.adapter
                }
            })
        } else if (jabatan == "Driver Office") {
            viewModel.getItemDriverPickup(this@SearchPickupItemActivity)
                .observe(this, Observer { items ->
                    progressbar.visibility = View.GONE
                    if(items.size==0){
                        tv_notice_data_not_found.visibility=View.VISIBLE
                    }else{
                        tv_notice_data_not_found.visibility=View.GONE
                    }
                    adapter.setListItems(items)
                    listItems.clear()
                    listItems.addAll(items)
                    adapter.notifyDataSetChanged()

                    with(rv_pickup_item) {
                        layoutManager = LinearLayoutManager(
                            this@SearchPickupItemActivity,
                            LinearLayoutManager.VERTICAL, false
                        )
                        setHasFixedSize(true)
                        adapter = this@SearchPickupItemActivity.adapter
                    }
                })
        }
    }

}