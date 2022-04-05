package com.example.navigationdrawer;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SalesReportActivity extends AppCompatActivity {
    private EditText textMonedaEntrada;
    private TextView textEuro;
    private TextView textLibras;
    private TextView textRupias;
    private TextView textReal;
    private TextView textYuan;
    private TextView textYen;
    private TextView textDolares;
    private TextView textSoles;
    private Button btnConv;
    private Spinner spinner;

    private int progress = 0;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_sales_report);

        btnConv = findViewById(R.id.btnConvertir);
        textMonedaEntrada = (EditText) findViewById(R.id.etValorIngresado);
        textEuro = (TextView) findViewById(R.id.tvEuro);
        textLibras = (TextView) findViewById(R.id.tvLibra);
        textRupias = (TextView) findViewById(R.id.tvRupia);
        textReal = (TextView) findViewById(R.id.tvReal);
        textYuan = (TextView) findViewById(R.id.tvYuan);
        textYen = (TextView) findViewById(R.id.tvYen);
        textDolares = (TextView) findViewById(R.id.tvDolar);
        textSoles = (TextView) findViewById(R.id.tvSoles);
        spinner = findViewById(R.id.spinnerMoneda);

        limpiarTV();
        llenarSpinner();

        progressDialog();
    }

    public void progressDialog() {
        progressDialog = new ProgressDialog(SalesReportActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMax(100);
        progressDialog.setMessage("Working on it");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
        progressDialog.setCancelable(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress < 100) {
                    try {
                        Thread.sleep(200);
                        progress++;
                        progressDialog.setProgress(progress);
                        if (progress == 100) {
                            progressDialog.dismiss();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void calcular(View view) {
        String txtValor = textMonedaEntrada.getText().toString();
        float valor_float = Float.parseFloat(txtValor);
        String seleccion = spinner.getSelectedItem().toString();

        /*if (textMonedaEntrada.getText().length() == 0) {
            Toast.makeText(this, "Ingresa un número válido", Toast.LENGTH_LONG).show();
            return;
        }*/

        switch (seleccion) {
            case "Euro":
                limpiarTV();
                textEuro.setText(String.valueOf(convierteSolesEuros(valor_float)));
                break;
            case "Libras":
                limpiarTV();
                textLibras.setText(String.valueOf(convierteSolesLibras(valor_float)));
                break;
            case "Rupias":
                limpiarTV();
                textRupias.setText(String.valueOf(convierteSolesRupias(valor_float)));
                break;
            case "Real":
                limpiarTV();
                textReal.setText(String.valueOf(convierteSolesReal(valor_float)));
                break;
            case "Yuan":
                limpiarTV();
                textYuan.setText(String.valueOf(convierteSolesYuan(valor_float)));
                break;
            case "Yen":
                limpiarTV();
                textYen.setText(String.valueOf(convierteSolesYen(valor_float)));
                break;
            case "Dolares":
                limpiarTV();
                textDolares.setText(String.valueOf(convierteSolesDolares(valor_float)));
                break;
            case "Soles":
                limpiarTV();
                textSoles.setText(String.valueOf(convierteSolesSoles(valor_float)));
                break;
            default:
                Toast.makeText(SalesReportActivity.this, "Ingrese un número válido", Toast.LENGTH_LONG).show();
                break;
        }
    }

    // Convierte Euros
    private double convierteSolesEuros(float soles) {
        return (soles * 0.24);
    }

    // Convierte Libras
    private double convierteSolesLibras(float soles) {
        return (soles * 0.20);
    }

    // Convierte Rupias
    private double convierteSolesRupias(float soles) {
        return (soles * 20.41);
    }

    // Convierte Real
    private double convierteSolesReal(float soles) {
        return (soles * 1.29);
    }

    // Convierte Yuan
    private double convierteSolesYuan(float soles) {
        return (soles * 1.70);
    }

    // Convierte Yen
    private double convierteSolesYen(float soles) {
        return (soles * 32.62);
    }

    // Convierte Dólares
    private double convierteSolesDolares(float soles) {
        return (soles * 0.27);
    }

    // Convierte Soles
    private double convierteSolesSoles(float soles) {
        return (soles * 1);
    }

    private void limpiarTV() {
        textEuro.setText("0.0");
        textLibras.setText("0.0");
        textRupias.setText("0.0");
        textReal.setText("0.0");
        textYuan.setText("0.0");
        textYen.setText("0.0");
        textDolares.setText("0.0");
        textSoles.setText("0.0");
    }

    private void llenarSpinner() {
        ArrayList<String> moneda = new ArrayList<>();
        moneda.add(new String("Euro"));
        moneda.add(new String("Libra"));
        moneda.add(new String("Rupia"));
        moneda.add(new String("Real"));
        moneda.add(new String("Yuan"));
        moneda.add(new String("Yen"));
        moneda.add(new String("Dolares"));
        moneda.add(new String("Soles"));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, moneda);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SalesReportActivity.this, "Usted selecciono " + moneda.get(i), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}