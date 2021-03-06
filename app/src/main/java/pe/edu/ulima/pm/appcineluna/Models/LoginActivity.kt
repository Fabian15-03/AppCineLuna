package pe.edu.ulima.pm.appcineluna.Models

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import pe.edu.ulima.pm.appcineluna.R

class LoginActivity : FragmentActivity() {
    private var mitNombre:EditText?=null
    private var mbtLogin:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mitNombre=findViewById(R.id.itNombre)
        mbtLogin=findViewById(R.id.btLogin)
        mbtLogin!!.setOnClickListener{v:View->
            val nombre:String=mitNombre!!.text.toString()
            if(nombre!=""){
                //Camiando de view
                var menuHeader=findViewById<TextView>(R.id.nombreHeader)
                menuHeader?.setText(nombre)
                val intent: Intent = Intent()
                intent.setClass(this, MainActivity::class.java)

                //Pasar parametros
                val data=Bundle()
                data.putString("nombre",nombre)
                intent.putExtras(data)
                //Lanzar el intent
                startActivity(intent)
            }else {
                Toast.makeText(applicationContext,"Ingrese su nombre",Toast.LENGTH_LONG).show()
            }
        }
    }
}