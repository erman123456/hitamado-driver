package pt.lunata.hitamado.ui.detail.search.airline.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.airline.operational.DataItem
import kotlinx.android.synthetic.main.item_airline.view.tv_airport_code
import kotlinx.android.synthetic.main.item_airline.view.tv_po_master_number
import kotlinx.android.synthetic.main.item_airline.view.tv_smu

class SearchAirlineItemHeadAdapter :
    RecyclerView.Adapter<SearchAirlineItemHeadAdapter.SearchItemViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null
    private var listItems = ArrayList<DataItem>()
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setListItems(listData: List<DataItem>?) {
        if (listData == null) return
        listItems.clear()
        listItems.addAll(listData)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchAirlineItemHeadAdapter.SearchItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_airline, parent, false)
        return SearchItemViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: SearchAirlineItemHeadAdapter.SearchItemViewHolder,
        position: Int
    ) {
        val item = listItems[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = listItems.size

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