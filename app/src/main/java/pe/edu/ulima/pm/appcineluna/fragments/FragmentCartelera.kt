package pe.edu.ulima.pm.appcineluna.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.listadosapp.GestorPeliculas
import pe.edu.ulima.listadosapp.Pelicula
import pe.edu.ulima.pm.appcineluna.Adapts.ListadoPeliculasAdapter
import pe.edu.ulima.pm.appcineluna.R

class FragmentCartelera:Fragment() {
    private lateinit var mrcyPeliculas : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cartelera,container,false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_peliculas,menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mrcyPeliculas = view.findViewById(R.id.rcyPeliculas)

        val listaPeliculas : List<Pelicula> = GestorPeliculas().obtenerPeliculas()
        val adapter = ListadoPeliculasAdapter(listaPeliculas){
            Log.i( "PeliculasFragment","Se hizo click en la pelicula " + it.nombre)
        }
        mrcyPeliculas.adapter = adapter
    }
}