package pe.edu.ulima.pm.appcineluna.Adapts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.listadosapp.Pelicula
import pe.edu.ulima.pm.appcineluna.R
import pe.edu.ulima.pm.appcineluna.Models.PeliculaActivity

class ListadoPeliculasAdapter(private val obtenerPeliculas : List<Pelicula>,
    private val onItemClickListener : (pelicula : Pelicula ) -> Unit)
    : RecyclerView.Adapter<ListadoPeliculasAdapter.ViewHolder>() {
    class ViewHolder(view:View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val itPelicula : TextView
        val itPeliculaHora : TextView
        val itPeliculaDesc:TextView
        val context:Context
        var item:View

        init{
            context=view.context
            itPelicula = view.findViewById(R.id.itPelicula)
            itPeliculaHora = view.findViewById(R.id.itPeliculaHora)
            itPeliculaDesc=view.findViewById(R.id.itPeliculaDesc)
            item=view.findViewById(R.id.itemPelicula)

        }
        fun setonClickListeners(){
            item.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val intent:Intent=Intent()
            intent.setClass(context, PeliculaActivity::class.java)
            val data= Bundle()
            data.putString("nombre",itPelicula.text.toString())
            data.putString("desc",itPeliculaDesc.text.toString())
            intent.putExtras(data)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return obtenerPeliculas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula,parent,false)
        val ViewHolder = ViewHolder(view)
        return ViewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = obtenerPeliculas[position]
        holder.itPelicula.text = pelicula.nombre
        holder.itPeliculaHora.text = pelicula.hora
        holder.itPeliculaDesc.text=pelicula.resena
        holder.setonClickListeners()
    }

}