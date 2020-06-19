package com.frede360.app.feature.home.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frede360.app.R
import com.frede360.app.commons.inflate
import kotlinx.android.synthetic.main.item_list_tags.view.*

class TagsAdapter(
    private var tagsList: List<String>
) : RecyclerView.Adapter<TagsAdapter.TagsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): TagsViewHolder {
        val inflatedView = parent.inflate(R.layout.item_list_tags, false)
        return TagsViewHolder(
            inflatedView
        ).listen { pos, _ ->
            val item = tagsList[pos]
        }
    }

    override fun getItemCount(): Int {
        return tagsList.size
    }

    override fun onBindViewHolder(viewHolder: TagsViewHolder, position: Int) {
        val tagValue: String = tagsList[position]

        viewHolder.itemView.tagField.text = tagValue
    }

    private fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(adapterPosition, itemViewType)
        }
        return this
    }

    class TagsViewHolder(v: View) : RecyclerView.ViewHolder(v)
}