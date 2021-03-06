package app.compassites.com.healthosapp.features.drawer

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.compassites.com.healthosapp.R
import kotlinx.android.synthetic.main.drawer_items.view.*

class DrawerItemAdapter(private val itemClickCallback: DraweritemCallBack) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var itemList = ArrayList<DrawerItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DrawerViewHolder(inflater.inflate(R.layout.drawer_items, parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item = itemList.get(position)
        val viewHolder = holder as DrawerViewHolder
        viewHolder.tvTitle.text = item.title

        viewHolder.tvTitle.setOnClickListener {
            itemClickCallback.onItemClick(item)
        }

    }

    class DrawerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.tv_title

    }

    fun updateItems(itemList: ArrayList<DrawerItem>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }
}
