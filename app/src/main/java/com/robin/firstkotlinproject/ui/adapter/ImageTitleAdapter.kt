package com.robin.firstkotlinproject.ui.adapter

import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.widget.ImageView
import android.widget.TextView
import com.robin.firstkotlinproject.R
import com.robin.firstkotlinproject.ui.activity.ViewAnkoComponent
import com.robin.firstkotlinproject.ui.custom.squareImageView
import com.robin.firstkotlinproject.ui.entity.ImageTitle
import com.robin.firstkotlinproject.ui.util.loadUrl
import com.robin.firstkotlinproject.ui.util.setTextAppearanceC
import org.jetbrains.anko.*

/**
 * Created by Robin Yang on 11/17/17.
 */
class ImageTitleAdapter(listener: (ImageTitle) -> Unit) :
        BaseAdapter<ImageTitle, ImageTitleAdapter.Component>(listener) {

    override val bind: Component.(item: ImageTitle) -> Unit = { item ->
        title.text = item.name
        item.url?.let { image.loadUrl(it) }
    }

    override fun onCreateComponent(parent: RecyclerView) = Component(parent)

    fun findPositionById(id: String): Int = items.withIndex().first{it.value.id == id}.index

    class Component(override val view: RecyclerView) : ViewAnkoComponent<RecyclerView> {

        lateinit var title: TextView
        lateinit var image: ImageView

        override fun createView(ui: AnkoContext<RecyclerView>) = with(ui) {
            frameLayout {

                verticalLayout {

                    image = squareImageView {
                        scaleType = ImageView.ScaleType.CENTER_CROP
                        backgroundResource = R.color.cardview_dark_background
                    }
                    title = textView {
                        padding = dip(16)
                        backgroundResource = R.color.cardview_dark_background
                        setTextAppearanceC(R.style.TextAppearance_AppCompat_Subhead_Inverse)
                        maxLines = 1
                        ellipsize = TextUtils.TruncateAt.END
                    }.lparams(width = matchParent)

                }.lparams(width = matchParent)
            }
        }
    }
}