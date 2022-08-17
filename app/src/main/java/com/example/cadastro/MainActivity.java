package com.example.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cadastro.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private Formulario form;
    private ActivityMainBinding acb;

    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private CheckBox cbJoin;
    private RadioButton rbMasc;
    private RadioButton rbFem;
    private EditText etCity;
    private Spinner spUF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        cbJoin = findViewById(R.id.cbJoin);
        rbMasc = findViewById(R.id.rbMasc);
        rbFem = findViewById(R.id.rbFem);
        etCity = findViewById(R.id.etCidade);
        spUF = findViewById(R.id.spinnerUF);

        acb.buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etName.setText("");
                etPhone.setText("");
                etEmail.setText("");
                etCity.setText("");
                cbJoin.setChecked(false);
                rbMasc.setChecked(false);
                rbFem.setChecked(false);
                spUF.setSelection(0);
            }
        });

        acb.buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Formulario form = new Formulario();
                form.setNome(etName.getText().toString());
                form.setTelefone(etPhone.getText().toString());
                form.setEmail(etEmail.getText().toString());
                form.setIngressar(cbJoin.isChecked());
                form.setSexo(String.valueOf(rbFem.isChecked() ? rbFem.getText() : rbMasc.getText()));
                form.setCidade(etCity.getText().toString());
                form.setUF(((TextView) spUF.getSelectedView()).getText().toString());
                Toast.makeText(MainActivity.this, form.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}