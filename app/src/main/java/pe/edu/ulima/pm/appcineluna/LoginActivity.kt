package pe.edu.ulima.pm.appcineluna

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
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
                val intent: Intent = Intent()
                intent.setClass(this,MainActivity::class.java)
                //Lanzar el intent
                startActivity(intent)
            }else {
                Toast.makeText(applicationContext,"Ingrese su nombre",Toast.LENGTH_LONG).show()
            }
        }
    }
}