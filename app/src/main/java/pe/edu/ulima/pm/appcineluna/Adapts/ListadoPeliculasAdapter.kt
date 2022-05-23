package pe.edu.ulima.pm.appcineluna.Adapts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.listadosapp.Pelicula
import pe.edu.ulima.pm.appcineluna.R

class ListadoPeliculasAdapter(private val obtenerPeliculas : List<Pelicula>,
    private val onItemClickListener : (pelicula : Pelicula ) -> Unit)
    : RecyclerView.Adapter<ListadoPeliculasAdapter.ViewHolder>() {
    class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val itPelicula : TextView
        val itPeliculaHora : TextView
        //val itPeliculaDescr : TextView

        init{
            itPelicula = view.findViewById(R.id.itPelicula)
            itPeliculaHora = view.findViewById(R.id.itPeliculaHora)
            //itPeliculaDescr = view.findViewById(R.id.itPeliculaDescr)

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
        //holder.itPeliculaDescr.text = pelicula.resena
        holder.itemView.setOnClickListener{
            onItemClickListener(pelicula)
        }
    }


}