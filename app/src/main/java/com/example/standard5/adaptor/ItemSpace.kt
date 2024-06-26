package com.example.standard5.adaptor

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemSpace(private val context: Context, private val spacing: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.bottom = spacing

        if (parent.getChildAdapterPosition(view) != 0) {
            outRect.top = spacing
        } else {
            outRect.top = 0
        }
    }
}