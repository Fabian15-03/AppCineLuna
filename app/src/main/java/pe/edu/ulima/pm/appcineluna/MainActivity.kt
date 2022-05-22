package pe.edu.ulima.pm.appcineluna

import android.content.ClipData
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.MenuRes
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import pe.edu.ulima.pm.appcineluna.fragments.FragmentCartelera
import pe.edu.ulima.pm.appcineluna.fragments.FragmentSobreNosotros
import java.security.acl.Group

class MainActivity : FragmentActivity() {
    private lateinit var drawLy : DrawerLayout
    private lateinit var navVw : NavigationView
    private var menuHeader:TextView?=null
    private val fragmentCartelera = FragmentCartelera()
    private val fragmentSobreNosotros = FragmentSobreNosotros()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawLy = findViewById(R.id.drawLy)
        navVw = findViewById(R.id.navVw)
        //Obtenemos los datos guardados en el intent
        val nombre=intent.getStringExtra("nombre")
        //Poner nombre en el toolbar
        val toolNombre=findViewById<Toolbar>(R.id.tbNombre)
        toolNombre.title="Hola "+nombre
        //Poner nombre en menu
        menuHeader=findViewById<TextView>(R.id.nombreHeader)
        if(menuHeader==null){
            menuHeader?.setText(nombre)
        }

        //setSupportActionBar(mToolbar)

        navVw.setNavigationItemSelectedListener {
            it.setChecked(true)

            val ft = supportFragmentManager.beginTransaction()

            when (it.itemId) {
                R.id.fragment_cartelera -> mostrarFragmentCartelera(ft)
                R.id.fragment_sobrenosotros -> mostrarFragmentSobreNosotros(ft)

            }
            ft.addToBackStack(null)

            ft.commit()

            drawLy.closeDrawers()
            true
        }
        // Cargar el fragment por defecto
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.secciones, fragmentCartelera)
        ft.commit()

        //Configurando toolbar
        //val toolbar = findViewById<Toolbar>(R.id.toolbar)
        //setSupportActionBar(toolbar)
    }

    private fun mostrarFragmentSobreNosotros(ft: FragmentTransaction) {
        ft.replace(R.id.secciones,fragmentSobreNosotros)
    }

    private fun mostrarFragmentCartelera(ft: FragmentTransaction) {
        ft.replace(R.id.secciones,fragmentCartelera)
    }


}