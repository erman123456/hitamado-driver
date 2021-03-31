package pt.lunata.hitamado.ui.detail.search.deliverAirline.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.deliverairline.DeliverAirlineEntity
import kotlinx.android.synthetic.main.item_deliver_airline.view.*
import kotlinx.android.synthetic.main.item_deliver_airline.view.tv_airport_code
import kotlinx.android.synthetic.main.item_deliver_airline.view.tv_po_master_number
import kotlinx.android.synthetic.main.item_deliver_airline.view.tv_smu

class SearchDeliverAirlineItemAdapter :
    RecyclerView.Adapter<SearchDeliverAirlineItemAdapter.SearchItemViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null
    private var listItems = ArrayList<DeliverAirlineEntity>()

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setListItems(listData: List<DeliverAirlineEntity>?) {
        if (listData == null) return
        listItems.clear()
        listItems.addAll(listData)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchDeliverAirlineItemAdapter.SearchItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_deliver_airline, parent, false)
        return SearchItemViewHolder(view)
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(
        holder: SearchDeliverAirlineItemAdapter.SearchItemViewHolder,
        position: Int
    ) {
        val item = listItems[position]
        holder.bind(item)
    }

    inner class SearchItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: DeliverAirlineEntity) {
            with(itemView) {
                tv_po_master_number.text = item.po_master_number
                if (item.dateDelivery!="null"){
                    val date=item.dateDelivery?.split(" ")
                    tv_date_airline.text= date?.get(0) ?: "null"
                }else{
                    tv_date_airline.text="Belum dikirim"
                }
                if(item.smu=="null"){
                    tv_smu.text="SMU : Not set yet!"
                }else{
                    tv_smu.text="SMU : ${item.smu}"
                }

                tv_airport_code.text=item.airportCode
                itemView.setOnClickListener {
                    onItemClickCallback?.onItemClicked(item)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DeliverAirlineEntity)
    }
}