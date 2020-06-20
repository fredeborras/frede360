package com.frede360.app.feature.home.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.frede360.app.R
import com.frede360.app.commons.inflate
import com.frede360.app.feature.home.entities.Hit
import kotlinx.android.synthetic.main.item_list_pixabay_image.view.*

class HomePixabayImageAdapter(
    private var productList: List<Hit>,
    private val listener: OnPixabayImageClickedListener?
) : RecyclerView.Adapter<HomePixabayImageAdapter.HomePixabayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): HomePixabayViewHolder {
        val inflatedView = parent.inflate(R.layout.item_list_pixabay_image, false)
        return HomePixabayViewHolder(
            inflatedView
        ).listen { pos, _ ->
            val item = productList[pos]

            listener?.onPixabayImageClicked(item)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(viewHolder: HomePixabayViewHolder, position: Int) {
        val item: Hit = productList[position]

        Glide.with(viewHolder.itemView)
            .load(item.previewURL)
            .placeholder(R.color.generic_grey_light)
            .thumbnail(0.75f)
            .into(viewHolder.itemView.image)

        viewHolder.itemView.user.text = item.user
    }

    private fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(adapterPosition, itemViewType)
        }
        return this
    }

    class HomePixabayViewHolder(v: View) : RecyclerView.ViewHolder(v)
}