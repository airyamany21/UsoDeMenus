package com.example.mymenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu_a,menu);
        MenuItem switchItem=menu.findItem(R.id.switch_m);
        switchItem.setActionView(R.layout.switch_item);
        Switch switchMenu=switchItem.getActionView().findViewById(R.id.soyElSwitch);
        switchMenu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                elTostado("Estado:["+isChecked+"]");
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.buscador:
                elTostado("Buscador");
                break;
            case R.id.itemUno:
                elTostado("Item UNO");
                elIntento("Item UNO");
                break;
            case R.id.itemDos:
                elTostado("Item DOS");
                elIntento("Item DOS");
                break;
            case R.id.opciones:
                elTostado("opciones");
                elIntento("Item opciones");
                break;
            case R.id.switch_m:
                elTostado("Switch");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void elIntento(String texto) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra("texto","Hello "+texto);
        intent.setType("text/plain");
        Intent share=Intent.createChooser(intent,null);
        startActivity(share);
    }

    private void elTostado(String texto){
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
    }
}