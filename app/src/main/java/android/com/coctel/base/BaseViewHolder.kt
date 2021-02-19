package android.com.tragosdigitales.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
//Soporte de vista Base
abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T, position:Int)
}