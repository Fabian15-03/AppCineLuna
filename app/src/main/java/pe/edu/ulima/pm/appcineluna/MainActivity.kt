package pe.edu.ulima.pm.appcineluna

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import pe.edu.ulima.pm.appcineluna.fragments.FragmentCartelera
import pe.edu.ulima.pm.appcineluna.fragments.FragmentSobreNosotros

class MainActivity : AppCompatActivity() {
    private lateinit var drawLy : DrawerLayout
    private lateinit var navVw : NavigationView


    private val fragmentCartelera = FragmentCartelera()
    private val fragmentSobreNosotros = FragmentSobreNosotros()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawLy = findViewById(R.id.drawLy)
        navVw = findViewById(R.id.navVw)


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
        ft.add(R.id.secciones, fragmentSobreNosotros)
        ft.commit()

        // Configurando toolbar
        //val toolbar = findViewById<Toolbar>(R.id.toolbar)
        //setSupportActionBar(toolbar)
    }

    private fun mostrarFragmentSobreNosotros(ft: FragmentTransaction) {
        ft.replace(R.id.secciones,fragmentCartelera)
    }

    private fun mostrarFragmentCartelera(ft: FragmentTransaction) {
        ft.replace(R.id.secciones,fragmentSobreNosotros)
    }


}