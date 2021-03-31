package pt.lunata.hitamado.ui.detail.search.office

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
import pt.lunata.hitamado.model.office.OfficeEntity
import pt.lunata.hitamado.ui.detail.office.driver.DetailDriverOfficeActivity
import pt.lunata.hitamado.ui.detail.office.headdriver.DetailHeadDriverOfficeActivity
import pt.lunata.hitamado.ui.detail.search.office.adapter.SearchOfficeItemAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_search_office_item.*

@AndroidEntryPoint
class SearchOfficeItemActivity : AppCompatActivity() {
    private lateinit var adapter: SearchOfficeItemAdapter

    companion object {
        var listItems = ArrayList<OfficeEntity>()
    }

    private val viewModel: SearcOfficeItemViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_office_item)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null
        adapter = SearchOfficeItemAdapter()
        progressbar.visibility = View.VISIBLE
        loadDataOffice()
        adapter.setOnItemClickCallback(object : SearchOfficeItemAdapter.OnItemClickCallback {
            override fun onItemClicked(data: OfficeEntity) {
                val preference =
                    this@SearchOfficeItemActivity.getSharedPreferences("APP", Context.MODE_PRIVATE)
                val jabatan = preference.getString("Jabatan", null)
                if (jabatan == "Driver Head Office") {
                    val intent = Intent(
                        this@SearchOfficeItemActivity,
                        DetailHeadDriverOfficeActivity::class.java
                    )
                    intent.putExtra(DetailHeadDriverOfficeActivity.EXTRA_DATA, data)
                    startActivity(intent)
                } else {
                    val intent = Intent(
                        this@SearchOfficeItemActivity,
                        DetailDriverOfficeActivity::class.java
                    )
                    intent.putExtra(DetailDriverOfficeActivity.EXTRA_DATA, data)
                    startActivity(intent)
                }
            }
        })
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                var listResult = ArrayList<OfficeEntity>()
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
            loadDataOffice()
            srl_data.isRefreshing = false
        }
    }

    override fun onResume() {
        super.onResume()
        loadDataOffice()
    }

    private fun loadDataOffice() {
        val preference = this.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var jabatan = preference.getString("Jabatan", null)
        val uid = preference.getString("UserId", null)
        Log.d("uidtes", uid)

        if (jabatan == "Driver Head Office") {
            viewModel.getItemOffice(this@SearchOfficeItemActivity).observe(this, Observer { items ->
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

                with(rv_office_item) {
                    layoutManager = LinearLayoutManager(
                        this@SearchOfficeItemActivity,
                        LinearLayoutManager.VERTICAL, false
                    )
                    setHasFixedSize(true)
                    adapter = this@SearchOfficeItemActivity.adapter
                }
            })
        } else if (jabatan == "Driver Office") {
            viewModel.getItemDriverOffice(this@SearchOfficeItemActivity)
                .observe(this, Observer { items ->
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
                    with(rv_office_item) {
                        layoutManager = LinearLayoutManager(
                            this@SearchOfficeItemActivity,
                            LinearLayoutManager.VERTICAL, false
                        )
                        setHasFixedSize(true)
                        adapter = this@SearchOfficeItemActivity.adapter
                    }
                })
        }

    }
}