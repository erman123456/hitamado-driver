package pt.lunata.hitamado.ui.detail.search.newpo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.newpo.NewpoEntity
import pt.lunata.hitamado.ui.detail.newpo.DetailNewPoActivity
import pt.lunata.hitamado.ui.detail.search.newpo.adapter.SearchNewpoItemsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_search_item_newpo.*

@AndroidEntryPoint
class SearchNewpoItemActivity : AppCompatActivity() {
    private lateinit var adapter: SearchNewpoItemsAdapter
    private val viewModel: SearchNewpoItemViewModel by viewModels()

    companion object {
        var listItems = ArrayList<NewpoEntity>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_item_newpo)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null
        adapter = SearchNewpoItemsAdapter()
        progressbar.visibility = View.VISIBLE
        adapter.setOnItemClickCallback(object : SearchNewpoItemsAdapter.OnItemClickCallback {
            override fun onItemClicked(data: NewpoEntity) {
                val intent = Intent(
                    this@SearchNewpoItemActivity,
                    DetailNewPoActivity::class.java
                )
                intent.putExtra(DetailNewPoActivity.EXTRA_DATA, data)
                intent.putExtra(DetailNewPoActivity.JENIS_DELEGASI, "Null")
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
            loadNewpo()
            srl_data.isRefreshing = false
        }
    }

    override fun onResume() {
        super.onResume()
        loadNewpo()
    }

    fun loadNewpo() {
        viewModel.getItemsNewpo(this@SearchNewpoItemActivity).observe(this, Observer { items ->
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
        with(rv_item) {
            layoutManager = LinearLayoutManager(
                this@SearchNewpoItemActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            setHasFixedSize(true)
            adapter = this@SearchNewpoItemActivity.adapter
        }
    }
}