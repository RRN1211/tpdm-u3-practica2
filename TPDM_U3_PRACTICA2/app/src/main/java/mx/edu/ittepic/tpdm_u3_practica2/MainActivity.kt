package mx.edu.ittepic.tpdm_u3_practica2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.net.URL

class MainActivity : AppCompatActivity() {
    var desc : EditText?= null
    var monto : EditText?= null
    var fecha : EditText?= null
    var pagado : EditText?= null
    var insertar : Button?= null
    var cargar : Button?= null
    var consulta : TextView?= null

    var jsonRegreso = ArrayList<org.json.JSONObject>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        desc = findViewById(R.id.idescripcion)
        monto = findViewById(R.id.idmonto)
        fecha = findViewById(R.id.idfecha)
        pagado = findViewById(R.id.idpagado)
        insertar = findViewById(R.id.idinsertar)
        cargar = findViewById(R.id.idcargar)
        consulta = findViewById(R.id.idconsulta)

        insertar?.setOnClickListener {
            var conexionWeb = ConexionWeb(this)
            conexionWeb.agregarVariables("descripcion",desc?.text.toString())
            conexionWeb.agregarVariables("monto",monto?.text.toString())
            conexionWeb.agregarVariables("fechaVencimiento",fecha?.text.toString())
            conexionWeb.agregarVariables("pagado",pagado?.text.toString())
            conexionWeb.execute(URL(""))
        }
        cargar?.setOnClickListener {
            var conexionWeb = ConexionWeb(this)
            conexionWeb.execute(URL(""))
        }
    }
    fun mostrarRespuesta(cadena: String){
        var jsonArray = org.json.JSONArray(cadena)
        var total=jsonArray.length()
        (0..total).forEach {
            jsonRegreso.add((jsonArray.getJSONObject(it)))
        }
    }
}

