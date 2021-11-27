package com.example.tkd_puntocliente;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ConfigCliente extends Activity {
    public EditText numPuerto,dirServer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracion);
        numPuerto = (EditText) findViewById(R.id.numPuerto);
        dirServer = (EditText) findViewById(R.id.dirServer);
    }

    public void guardarInfo(View v){
        Intent i = new Intent();
        if(!numPuerto.getText().toString().isEmpty() && !dirServer.getText().toString().isEmpty()){
            String[] dato={numPuerto.getText().toString(),dirServer.getText().toString()};
            i.putExtra("dato",dato);
            setResult(Activity.RESULT_OK,i);
            finish();
        }
        setResult(Activity.RESULT_CANCELED,i);
        finish();
    }
    public void cancelar(View v){
        Intent i = new Intent();
        setResult(Activity.RESULT_CANCELED,i);
        finish();
    }
}
