package com.robin.firstkotlinproject.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.robin.firstkotlinproject.ui.activity.ViewAnkoComponent
import com.robin.firstkotlinproject.ui.util.singleClick
import kotlin.properties.Delegates

/**
 * Created by Robin Yang on 11/20/17.
 */
abstract class BaseAdapter<Item, Component : ViewAnkoComponent<RecyclerView>>(val listener: (Item) -> Unit = {})
    : RecyclerView.Adapter<BaseAdapter.BaseViewHolder<Component>>() {

    abstract val bind: Component.(item: Item) -> Unit

    var items: List<Item> by Delegates.observable(emptyList()){_, _, _ -> notifyDataSetChanged()}

    abstract fun onCreateComponent(parent: RecyclerView): Component

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Component> {
        return BaseViewHolder(onCreateComponent(parent as RecyclerView))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Component>, position: Int) {
        val item = items[position]
        holder.itemView.singleClick { listener(item) }
        holder.ui.bind(item)
    }

    override fun getItemCount() = items.size

    class BaseViewHolder<out Component : ViewAnkoComponent<RecyclerView>>(val ui: Component) : RecyclerView.ViewHolder(ui.inflate())
}