package pt.lunata.hitamado.ui.detail.siapantar.headdriver

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pt.lunata.hitamado.R
import pt.lunata.hitamado.model.siapantar.ItemAllHouseEntity
import pt.lunata.hitamado.model.siapantar.ItemHouseBelumTibaEntity
import kotlinx.android.synthetic.main.item_status_po.view.*

class DetailItemPoHouseSiapAntarAdapter:RecyclerView.Adapter<DetailItemPoHouseSiapAntarAdapter.SearchItemViewHolder>() {
    private var listItems = ArrayList<ItemAllHouseEntity>()
    companion object{
        var listItemsNotArrived=ArrayList<ItemHouseBelumTibaEntity>()
    }
    fun setListItems(listData: List<ItemAllHouseEntity>?, listDataNotArrived:List<ItemHouseBelumTibaEntity>?){
        if (listData == null) return
        listItems.clear()
        listItems.addAll(listData)
        if (listDataNotArrived==null)return
        listItemsNotArrived.clear()
        listItemsNotArrived.addAll(listDataNotArrived)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_status_po, parent, false)
        return SearchItemViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: SearchItemViewHolder,
        position: Int
    ) {
        val item = listItems[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = listItems.size
    class SearchItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(item:ItemAllHouseEntity){
            with(itemView){
                val poHouseNotArrived=DetailItemPoHouseSiapAntarAdapter.listItemsNotArrived
                for (po in poHouseNotArrived){
                    if (po.uid==item.uid){
                        img_checklist.visibility=View.GONE
                    }
                }
                tv_po_house_number.text=item.po_house_number
            }
        }
    }
}