package pt.lunata.hitamado.ui.detail.search.siapantar

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
import pt.lunata.hitamado.model.siapantar.SiapAntarEntity
import pt.lunata.hitamado.ui.detail.search.siapantar.adapter.SearchSiapAntarItemAdapter
import pt.lunata.hitamado.ui.detail.siapantar.driver.DetailSiapAntarDriverActivity
import pt.lunata.hitamado.ui.detail.siapantar.headdriver.DetailSiapAntarHeadDriverActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_search_deliver_item.*

@AndroidEntryPoint
class SearchSiapantarItemActivity : AppCompatActivity() {
    private lateinit var adapter: SearchSiapAntarItemAdapter
    private val viewModel: SearchSiapantarItemViewModel by viewModels()

    companion object {
        var listItems = ArrayList<SiapAntarEntity>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_deliver_item)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null
        adapter = SearchSiapAntarItemAdapter()
        progressbar.visibility = View.VISIBLE
        loadDataDeliver()
        adapter.setOnItemClickCallback(object : SearchSiapAntarItemAdapter.OnItemClickCallback {
            override fun onItemClicked(data: SiapAntarEntity) {
                val preference = this@SearchSiapantarItemActivity.getSharedPreferences(
                    "APP",
                    Context.MODE_PRIVATE
                )
                val jabatan = preference.getString("Jabatan", null)
                if (jabatan == "Driver Head Office") {
                    val intent = Intent(
                        this@SearchSiapantarItemActivity,
                        DetailSiapAntarHeadDriverActivity::class.java
                    )
                    intent.putExtra(DetailSiapAntarHeadDriverActivity.EXTRA_DATA, data)
                    startActivity(intent)
                } else {
                    val intent = Intent(
                        this@SearchSiapantarItemActivity,
                        DetailSiapAntarDriverActivity::class.java
                    )
                    intent.putExtra(DetailSiapAntarDriverActivity.EXTRA_DATA, data)
                    startActivity(intent)
                }
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
            loadDataDeliver()
            srl_data.isRefreshing = false
        }
    }

    override fun onResume() {
        super.onResume()
        loadDataDeliver()
    }

    private fun loadDataDeliver() {
        val preference = this.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var jabatan = preference.getString("Jabatan", null)
        val uid = preference.getString("UserId", null)
        Log.d("uidtes", uid)

        if (jabatan == "Driver Head Office") {
            viewModel.getItemSiapAntar(this@SearchSiapantarItemActivity)
                .observe(this, Observer { items ->
                    Log.d("tes2", items.size.toString())
                    progressbar.visibility = View.GONE
                    if(items.size==0){
                        tv_notice_data_not_found.visibility=View.VISIBLE
                    }else{
                        tv_notice_data_not_found.visibility=View.GONE
                    }
                    val listData=ArrayList<SiapAntarEntity>()
                    for (item in items){
                        if (item.itemsAllHouse?.size!=0){
                            listData.add(item)
                        }
                    }
                    if (listData.size==0){
                        tv_notice_data_not_found.visibility=View.VISIBLE
                    }
                    adapter.setListItems(listData)
                    adapter.notifyDataSetChanged()
                    listItems.clear()
                    listItems.addAll(listData)

                    with(rv_deliver_item) {
                        layoutManager = LinearLayoutManager(
                            this@SearchSiapantarItemActivity,
                            LinearLayoutManager.VERTICAL, false
                        )
                        setHasFixedSize(true)
                        adapter = this@SearchSiapantarItemActivity.adapter
                    }
                })
        } else if (jabatan == "Driver Office") {
            viewModel.getItemSiapAntarDriver(this@SearchSiapantarItemActivity).observe(this,
                Observer { items ->
                    progressbar.visibility = View.GONE
                    if(items.size==0){
                        tv_notice_data_not_found.visibility=View.VISIBLE
                    }else{
                        tv_notice_data_not_found.visibility=View.GONE
                    }
                    val listData=ArrayList<SiapAntarEntity>()
                    for (item in items){
                        if (item.itemsAllHouse?.size!=0){
                            listData.add(item)
                        }
                    }
                    adapter.setListItems(listData)
                    adapter.notifyDataSetChanged()
                    listItems.clear()
                    listItems.addAll(listData)

                    with(rv_deliver_item) {
                        layoutManager = LinearLayoutManager(
                            this@SearchSiapantarItemActivity,
                            LinearLayoutManager.VERTICAL, false
                        )
                        setHasFixedSize(true)
                        adapter = this@SearchSiapantarItemActivity.adapter
                    }
                })
        }

    }

}