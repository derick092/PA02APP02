package poa.senac.a02a02

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var agua = cbxAgua
        var luz = cbxLuz
        var telefone = cbxTelefone
        var celular = cbxCelular
        var finalizar = btnFinalizar

        finalizar.setOnClickListener {

            var total:Double = 0.0

            if(agua.isChecked){
                total += agua.tag.toString().toInt()
            }

            if(luz.isChecked){
                total += luz.tag.toString().toInt()
            }

            if(telefone.isChecked){
                total += telefone.tag.toString().toInt()
            }

            if(celular.isChecked){
                total += celular.tag.toString().toInt()
            }

            var builder = AlertDialog.Builder(this)
                    .setTitle("Confirmação de pagamento")
                    .setMessage("Total à pagar: R$ ${total}")
                    .setCancelable(true)
                    .setPositiveButton("Confirmar", DialogInterface.OnClickListener {
                        dialogInterface, i ->
                        Toast.makeText(this, "Pagamento finalizado",Toast.LENGTH_SHORT).show()
                        agua.isChecked = false
                        luz.isChecked = false
                        telefone.isChecked = false
                        celular.isChecked = false
                    })
                    .setNegativeButton("Cancelar", DialogInterface.OnClickListener {
                        dialogInterface, i ->
                        Toast.makeText(this, "Pagamento cancelado",Toast.LENGTH_SHORT).show()
                    })

            var alert = builder.create()
            alert.show()
        }
    }
}
