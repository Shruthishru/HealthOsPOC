package app.compassites.com.healthosapp.features.search

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.compassites.com.healthosapp.R
import app.compassites.com.healthosapp.features.utils.AnimationUtils
import app.compassites.com.healthosapp.model.Medicine
import kotlinx.android.synthetic.main.item_content_layout.view.*

class MedicineListAdapter(val itemClick: MedicineAdapterClick) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemList = ArrayList<Medicine>()


    fun updateAdapterData(itemList: ArrayList<Medicine>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SearchResultViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_content_layout, parent, false))
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = itemList.get(position)
        val viewHolder = holder as SearchResultViewHolder
        viewHolder.medicineType.text = item.name
        viewHolder.medicineStrength.text = item.manufacturer
        viewHolder.llItem.setOnClickListener {
            itemClick.onItemClick(item)
        }
        AnimationUtils.animateView(viewHolder.llItem, "translationX", 1000f, 0f, 500)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class SearchResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val medicineType = itemView.tv_name
        val medicineStrength = itemView.tv_strength
        val llItem = itemView.ll_item
    }
}

