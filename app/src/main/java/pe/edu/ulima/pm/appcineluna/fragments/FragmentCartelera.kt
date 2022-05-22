package pe.edu.ulima.pm.appcineluna.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.listadosapp.GestorPeliculas
import pe.edu.ulima.listadosapp.Pelicula
import pe.edu.ulima.pm.appcineluna.R
import pe.edu.ulima.pm.appcineluna.adapters.ListadoPeliculasAdapter

class FragmentCartelera:Fragment() {
    private lateinit var mRviPeliculas : RecyclerView
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

    //override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
    //    super.onCreateOptionsMenu(menu, inflater)
    //    inflater.inflate(R.menu.menu_peliculas,menu)
    //}
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRviPeliculas = view.findViewById(R.id.rviPeliculas)

        val listaPeliculas : List<Pelicula> = GestorPeliculas().obtenerPeliculas()
        val adapter = ListadoPeliculasAdapter(listaPeliculas) {
            Log.i("fragment_cartelera","Se hizo click en la Pelicula " + it.nombre);
        }
        mRviPeliculas.adapter = adapter

    }
}