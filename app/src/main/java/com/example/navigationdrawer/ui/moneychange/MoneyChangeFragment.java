package com.example.navigationdrawer.ui.moneychange;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.navigationdrawer.R;
import com.example.navigationdrawer.databinding.FragmentMoneychangeBinding;

import java.util.ArrayList;

public class MoneyChangeFragment extends Fragment {

    private FragmentMoneychangeBinding binding;
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

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MoneyChangeViewModel moneyChangeViewModel = new ViewModelProvider(this).get(MoneyChangeViewModel.class);

        binding = FragmentMoneychangeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*textMonedaEntrada = binding.etValorIngresado;
        textEuro = binding.tvEuro;
        textLibras = binding.tvLibra;
        textRupias = binding.tvRupia;
        textReal = binding.tvReal;
        textYuan = binding.tvYuan;
        textYen = binding.tvYen;
        textDolares = binding.tvDolar;
        textSoles = binding.tvSoles;
        btnConv = binding.btnConvertir;
        spinner = binding.spinnerMoneda;*/

//        limpiarTV();
//        llenarSpinner();

//        moneyChangeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    /*public void calcular(View view) {
        String txtValor = textMonedaEntrada.getText().toString();
        float valor_float = Float.parseFloat(txtValor);
        String seleccion = spinner.getSelectedItem().toString();

        *//*if (textMonedaEntrada.getText().length() == 0) {
            Toast.makeText(this, "Ingresa un número válido", Toast.LENGTH_LONG).show();
            return;
        }*//*

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

                break;
        }
    }*/

/*
    // Convierte Euros
    private double convierteSolesEuros(float soles) {
        return (soles*0.24);
    }

    // Convierte Libras
    private double convierteSolesLibras(float soles) {
        return (soles*0.20);
    }

    // Convierte Rupias
    private double convierteSolesRupias(float soles) {
        return (soles*20.41);
    }

    // Convierte Real
    private double convierteSolesReal(float soles) {
        return (soles*1.29);
    }

    // Convierte Yuan
    private double convierteSolesYuan(float soles) {
        return (soles*1.70);
    }

    // Convierte Yen
    private double convierteSolesYen(float soles) {
        return (soles*32.62);
    }

    // Convierte Dólares
    private double convierteSolesDolares(float soles) {
        return (soles*0.27);
    }

    // Convierte Soles
    private double convierteSolesSoles(float soles) {
        return (soles*1);
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

        @SuppressLint("ResourceType") ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                */
/*Toast.makeText(SalesReportActivity.this, "Usted selecciono " + moneda.get(i), Toast.LENGTH_LONG).show();*//*

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}