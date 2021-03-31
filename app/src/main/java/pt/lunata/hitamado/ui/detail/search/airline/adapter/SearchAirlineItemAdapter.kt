package pt.lunata.hitamado.ui.detail.search.airline.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.airline.operational.DataItem
import kotlinx.android.synthetic.main.item_airline.view.*

class SearchAirlineItemAdapter :
    PagedListAdapter<DataItem, SearchAirlineItemAdapter.SearchItemViewHolder>(
        callback
    ) {
    companion object {
        val callback = object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem.poMasterNumber == newItem.poMasterNumber
            }

            override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }
        }
    }

    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchAirlineItemAdapter.SearchItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_airline, parent, false)
        return SearchItemViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: SearchAirlineItemAdapter.SearchItemViewHolder,
        position: Int
    ) {
        val item = getItem(position) ?: DataItem()
        holder.bind(item)
    }

    inner class SearchItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: DataItem) {
            with(itemView) {
                tv_po_master_number.text = item?.poMasterNumber
                if(item.smu=="null"){
                    tv_smu.text="SMU : Not set yet!"
                }else{
                    tv_smu.text="SMU : ${item.smu}"
                }

                tv_airport_code.text=item.maskapai
                itemView.setOnClickListener {
                    onItemClickCallback?.onItemClicked(item)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DataItem)
    }
}