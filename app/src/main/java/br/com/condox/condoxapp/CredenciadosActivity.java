package br.com.condox.condoxapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

import java.util.ArrayList;
import java.util.List;

import br.com.condox.condoxapp.R;
import br.com.condox.condoxapp.bean.Credenciado;
import br.com.condox.condoxapp.bean.ResultadoBusca;

@EActivity(R.layout.activity_credenciados)
public class CredenciadosActivity extends Activity {

    @RestService
    buscaService buscaService;

    @ViewById
    ListView listaCredenciado;

    @AfterViews
    void carregarListaCredenciado() {
        buscarCredenciados();
    }

    @UiThread
    void preencherLista(List<String> listaCredenciados) {
        listaCredenciado.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaCredenciados));
        listaCredenciado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CredenciadosActivity.this, String.valueOf(i), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Background
    void buscarCredenciados() {
        ResultadoBusca resultadoBusca = buscaService.buscarCredenciados("cardiologia", -22, -44, 30);

        List<String> listaCredenciados = new ArrayList<String>();
        for (Credenciado credenciado: resultadoBusca.credenciados) {
            listaCredenciados.add(credenciado.nome);
        }

        preencherLista(listaCredenciados);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.credenciados, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
