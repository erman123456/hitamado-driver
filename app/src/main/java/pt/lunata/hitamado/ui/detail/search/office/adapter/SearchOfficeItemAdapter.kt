package pt.lunata.hitamado.ui.detail.search.office.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.office.OfficeEntity
import kotlinx.android.synthetic.main.item_delivery.view.*

class SearchOfficeItemAdapter :
    RecyclerView.Adapter<SearchOfficeItemAdapter.SearchItemViewHolder>() {
    private var onItemClickCallback: SearchOfficeItemAdapter.OnItemClickCallback? = null
    private var listItems = ArrayList<OfficeEntity>()
    fun setOnItemClickCallback(onItemClickCallback: SearchOfficeItemAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setListItems(listData: List<OfficeEntity>?) {
        if (listData == null) return
        listItems.clear()
        listItems.addAll(listData)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchOfficeItemAdapter.SearchItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_delivery, parent, false)
        return SearchItemViewHolder(view)
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(
        holder: SearchOfficeItemAdapter.SearchItemViewHolder,
        position: Int
    ) {
        val item = listItems[position]
        holder.bind(item)
    }

    inner class SearchItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: OfficeEntity) {
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
        fun onItemClicked(data: OfficeEntity)
    }
}