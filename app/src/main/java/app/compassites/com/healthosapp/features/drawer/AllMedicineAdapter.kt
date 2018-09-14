package app.compassites.com.healthosapp.features.drawer

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.compassites.com.healthosapp.R
import app.compassites.com.healthosapp.model.Medicine

class AllMedicineAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var itemList = ArrayList<Medicine>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DrawerViewHolder(inflater.inflate(R.layout.medicine_item, parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item = itemList[position]
        val viewHolder = holder as DrawerViewHolder


    }

    class DrawerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    fun updateItems(itemList: ArrayList<Medicine>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }
}
