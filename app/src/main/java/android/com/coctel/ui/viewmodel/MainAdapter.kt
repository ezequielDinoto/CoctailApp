package android.com.coctel.ui.viewmodel

import android.com.coctel.R
import android.com.coctel.data.model.Drink
import android.com.tragosdigitales.base.BaseViewHolder
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.tragos_row.view.*

class MainAdapter(private val context: Context, private val tragosList: List<Drink>,
private val itemClickLister : OnTragoClickListener ) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnTragoClickListener {
        //mando el trago a la otra pantalla y pongo , position: Int
        fun onTragoClick(drink: Drink/*, position: Int*/)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(
            LayoutInflater.from(context).inflate(R.layout.tragos_row, parent, false)
        )
    }


    override fun getItemCount(): Int {

        return tragosList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(tragosList[position], position)

        }
    }

        inner class MainViewHolder(itemView: View):BaseViewHolder<Drink>(itemView) {
            //trae todos los elemetos de lalista
            override fun bind(item: Drink, position: Int) {
//glide trae las imagenes
                Glide.with(context).load(item.imagen).centerCrop().into(itemView.img_trago)
                itemView.txt_titulo.text = item.nombre
                itemView.txt_descripcion.text = item.descripcion
              itemView.setOnClickListener{itemClickLister.onTragoClick(item/*, position*/)}

            }
        }
}