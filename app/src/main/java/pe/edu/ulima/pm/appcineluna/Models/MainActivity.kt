package pe.edu.ulima.pm.appcineluna.Models

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import pe.edu.ulima.pm.appcineluna.R
import pe.edu.ulima.pm.appcineluna.R.*
import pe.edu.ulima.pm.appcineluna.fragments.FragmentCartelera
import pe.edu.ulima.pm.appcineluna.fragments.FragmentSobreNosotros

class MainActivity : FragmentActivity() {
    private lateinit var drawLy : DrawerLayout
    private lateinit var navVw : NavigationView
    private lateinit var toolbar: Toolbar

    private var menuHeader:TextView?=null
    private val fragmentCartelera = FragmentCartelera()
    private val fragmentSobreNosotros = FragmentSobreNosotros()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        drawLy = findViewById(id.drawLy)
        navVw = findViewById(id.navVw)
        toolbar = findViewById(id.tbNombre)


        //Obtenemos los datos guardados en el intent
        val nombre=intent.getStringExtra("nombre")
        //Poner nombre en el toolbar
        val toolNombre=findViewById<Toolbar>(id.tbNombre)
        toolNombre.title="Hola "+nombre
        //Poner nombre en menu
        menuHeader=findViewById<TextView>(R.id.nombreHeader)
        menuHeader?.setText(nombre)


        //setSupportActionBar(mToolbar)

        navVw.setNavigationItemSelectedListener {
            it.setChecked(true)

            val ft = supportFragmentManager.beginTransaction()

            when (it.itemId) {
                id.Cartelera -> mostrarFragmentCartelera(ft)
                id.Sobre_nosotros -> mostrarFragmentSobreNosotros(ft)

            }
            ft.addToBackStack(null)

            ft.commit()

            drawLy.closeDrawers()
            true
        }
        // Cargar el fragment por defecto
        val ft = supportFragmentManager.beginTransaction()
        ft.add(id.secciones, fragmentCartelera)
        ft.commit()

        //Configurando toolbar
        //val toolbar = findViewById<Toolbar>(R.id.toolbar)
        //setSupportActionBar(toolbar)
    }

    private fun mostrarFragmentSobreNosotros(ft: FragmentTransaction) {
        ft.replace(id.secciones,fragmentSobreNosotros)
    }

    private fun mostrarFragmentCartelera(ft: FragmentTransaction) {
        ft.replace(id.secciones,fragmentCartelera)
    }


}