package pt.lunata.hitamado.ui.delegasi.search.pickup

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
import pt.lunata.hitamado.model.newpo.NewpoEntity
import pt.lunata.hitamado.ui.delegasi.search.pickup.adapter.SearchDelegasiPickupAdapter
import pt.lunata.hitamado.ui.detail.newpo.DetailNewPoActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_search_delegasi_pickup.*

@AndroidEntryPoint
class SearchDelegasiPickupActivity : AppCompatActivity() {
    private lateinit var adapter: SearchDelegasiPickupAdapter
    private val viewModel: SearchDelegasiPickupViewModel by viewModels()

    companion object {
        private var listItems = ArrayList<NewpoEntity>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_delegasi_pickup)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null
        adapter = SearchDelegasiPickupAdapter()
        progressbar.visibility = View.VISIBLE
        adapter.setOnItemClickCallback(object : SearchDelegasiPickupAdapter.OnItemClickCallback {
            override fun onItemClicked(data: NewpoEntity) {
                val intent = Intent(
                    this@SearchDelegasiPickupActivity,
                    DetailNewPoActivity::class.java
                )
                intent.putExtra(DetailNewPoActivity.EXTRA_DATA, data)
                intent.putExtra(DetailNewPoActivity.JENIS_DELEGASI, "Delegasi Pickup")
                startActivity(intent)
            }
        })
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                var listResult = ArrayList<NewpoEntity>()
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
        viewModel.getItemDelegasiPickup(this@SearchDelegasiPickupActivity)
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
            })
        with(rv_pickup_item) {
            layoutManager = LinearLayoutManager(
                this@SearchDelegasiPickupActivity,
                LinearLayoutManager.VERTICAL, false
            )
            setHasFixedSize(true)
            adapter = this@SearchDelegasiPickupActivity.adapter
        }
    }
}