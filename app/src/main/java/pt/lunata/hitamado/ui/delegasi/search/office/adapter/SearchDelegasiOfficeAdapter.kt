package pt.lunata.hitamado.ui.delegasi.search.office.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.newpo.NewpoEntity
import kotlinx.android.synthetic.main.item_delegasi.view.*

class SearchDelegasiOfficeAdapter :
    RecyclerView.Adapter<SearchDelegasiOfficeAdapter.SearchItemViewHolder>() {
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
    ): SearchDelegasiOfficeAdapter.SearchItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_delegasi, parent, false)
        return SearchItemViewHolder(view)
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(
        holder: SearchDelegasiOfficeAdapter.SearchItemViewHolder,
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
                tv_driver_name_delegasi.text=item.driverName
                tv_keterangan_delegasi.text=item.keteranganDelegasi
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