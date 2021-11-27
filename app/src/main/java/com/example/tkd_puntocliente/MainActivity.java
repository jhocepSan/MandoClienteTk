package com.example.tkd_puntocliente;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    private ImageButton headBlue,headRed,fistRed,fistBlue,bodyRed,bodyBlue;
    private String ip;
    private int port;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        headBlue = (ImageButton) findViewById(R.id.headBlue);
        headRed = (ImageButton) findViewById(R.id.headRed);
        bodyBlue = (ImageButton) findViewById(R.id.bodyBlue);
        bodyRed = (ImageButton) findViewById(R.id.bodyRed);
        fistRed = (ImageButton) findViewById(R.id.fistRed);
        fistBlue = (ImageButton) findViewById(R.id.fistBlue);
        setContentView(R.layout.activity_main);
        /**pantalla = (TextView) findViewById(R.id.msgIni);
        cont = (TextView) findViewById(R.id.cont);
        c=0;
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        ejecutaCliente();**/
    }

    public void desplegarInfo(View info){
        Intent inf = new Intent(this,InfoAplicacion.class);
        startActivity(inf);
    }
    public void desplegarConfig(View config){
        Intent conf = new Intent(this,ConfigCliente.class);
        startActivityForResult(conf,100);
    }
    /**private void ejecutaCliente(){
        String ip = "192.168.1.103";
        int puerto = 2020;
        log(" socket " + ip + " " + puerto);
        c +=1;
        cont.append("contador = "+c);
        try{
            Socket sk = new Socket(ip,puerto);
            BufferedReader entrada = new BufferedReader(new
                    InputStreamReader(sk.getInputStream()));
            PrintWriter salida = new PrintWriter(new OutputStreamWriter(sk.getOutputStream()),true);
            log("enviando ... Hola Mundo!");
            salida.println("Hola mundo");
            log("recibiendo ... " + entrada.readLine());
            sk.close();
        }
        catch (Exception e){
            log("error: " + e.toString());
        }
    }

    private void log(String cadena){
        pantalla.append(cadena + "\n");
    }**/
    @Override protected void onActivityResult(int requestCode,int resultCode,@Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==100){
            if(resultCode== Activity.RESULT_OK){
                Bundle datos = data.getExtras();
                ip = datos.getStringArray("dato")[1];
                port = Integer.parseInt(datos.getStringArray("dato")[0]);
                Toast.makeText(this,
                        "IP: "+datos.getStringArray("dato")[1]+"\nPuerto:"+datos.getStringArray("dato")[0],
                        Toast.LENGTH_SHORT).show();
            }
            if(resultCode == Activity.RESULT_CANCELED){
                Toast.makeText(this,"No configurado",Toast.LENGTH_SHORT);
            }
        }
    }

    @Override public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_inicial,mimenu);
        return true;
    }
    @Override public boolean onOptionsItemSelected(MenuItem opcion){
        int id=opcion.getItemId();
        if(id==R.id.configuracion){
            desplegarConfig(null);
            return true;
        }
        if(id==R.id.informacion){
            desplegarInfo(null);
            return true;
        }
        return super.onOptionsItemSelected(opcion);
    }
}