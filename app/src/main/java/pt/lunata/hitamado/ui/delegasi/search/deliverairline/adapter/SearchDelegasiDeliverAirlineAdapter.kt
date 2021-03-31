package pt.lunata.hitamado.ui.delegasi.search.deliverairline.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.siapantar.SiapAntarEntity
import kotlinx.android.synthetic.main.item_delegasi_airline.view.*

class SearchDelegasiDeliverAirlineAdapter :
    RecyclerView.Adapter<SearchDelegasiDeliverAirlineAdapter.SearchItemViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null
    private var listItems = ArrayList<SiapAntarEntity>()
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setListItems(listData: List<SiapAntarEntity>?) {
        if (listData == null) return
        listItems.clear()
        listItems.addAll(listData)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_delegasi_airline, parent, false)
        return SearchItemViewHolder(view)
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(
        holder: SearchItemViewHolder,
        position: Int
    ) {
        val item = listItems[position]
        holder.bind(item)
    }

    inner class SearchItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: SiapAntarEntity) {
            with(itemView) {
                tv_mpo.text=item.po_master_number
                tv_driver_name_delegasi.text=item.driverName
                tv_keterangan_delegasi.text=item.keteranganDelegasi
                itemView.setOnClickListener {
                    onItemClickCallback?.onItemClicked(item)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: SiapAntarEntity)
    }
}