package pt.lunata.hitamado.ui.detail.search.newpo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.newpo.NewpoEntity
import kotlinx.android.synthetic.main.item_delivery.view.*

class SearchNewpoItemsAdapter :
    RecyclerView.Adapter<SearchNewpoItemsAdapter.SearchItemViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null
    private var listItems = ArrayList<NewpoEntity>()

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setListItems(listData: List<NewpoEntity>?) {
        if (listData == null) return
        listItems.clear()
        listItems.addAll(listData)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchNewpoItemsAdapter.SearchItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_delivery, parent, false)
        return SearchItemViewHolder(view)
    }

    override fun getItemCount(): Int = listItems.size
    override fun onBindViewHolder(
        holder: SearchNewpoItemsAdapter.SearchItemViewHolder,
        position: Int
    ) {
        val item = listItems[position]
        holder.bind(item)
    }

    inner class SearchItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: NewpoEntity) {
            with(itemView) {
                tv_hpo.text = item.po_house_number
                tv_mpo.text = item.mpo_number
                tv_customer_name.text = item.customer_name
                tv_airport_code.text = item.airport_code
                itemView.setOnClickListener {
                    onItemClickCallback?.onItemClicked(item)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: NewpoEntity)
    }
}