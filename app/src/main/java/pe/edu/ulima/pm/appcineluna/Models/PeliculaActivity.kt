package pe.edu.ulima.pm.appcineluna.Models

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import pe.edu.ulima.pm.appcineluna.R

class PeliculaActivity:FragmentActivity() {
    private var mtvNombre: TextView?=null
    private var mtvDesc: TextView?=null
    private var mbtRegresar:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_pelicula)
        mtvNombre=findViewById(R.id.titulopelicula)
        mtvDesc=findViewById(R.id.textopelicula)
        mbtRegresar=findViewById(R.id.btRegresar)
        val nombre=intent.getStringExtra("nombre")
        val desc=intent.getStringExtra("desc")
        mtvNombre!!.setText(nombre)
        mtvDesc!!.setText(desc)
        mbtRegresar!!.setOnClickListener {v->
            super.onBackPressed()
        }
    }
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout., container, false)
//    }
}