package com.example.basesdedatos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tab1Fragment extends Fragment {

    private SQLiteDatabase sqLiteDatabase;
    private EditText tab1EditText1, tab1EditText2, tab1EditText3;
    private Button tab1Button1, tab1Button2;

    public Tab1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tab1, container, false);

        // Binding elements in this class
        tab1EditText1 = rootView.findViewById(R.id.tab1EditText1);
        tab1EditText2 = rootView.findViewById(R.id.tab1EditText2);
        tab1EditText3 = rootView.findViewById(R.id.tab1EditText3);

        tab1Button1 = rootView.findViewById(R.id.tab1Button1);
        tab1Button2 = rootView.findViewById(R.id.tab1Button2);

        // Adding listener
        tab1Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero = tab1EditText1.getText().toString();
                String nombre = tab1EditText2.getText().toString();
                String telefono = tab1EditText3.getText().toString();

                if (numero.compareTo("") != 0 && nombre.compareTo("") != 0 && telefono.compareTo("") != 0) {
                    insertar(numero, nombre, telefono);
                    cleanData();
                    Toast.makeText(getActivity(), "Datos Guardados!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getActivity(), "Falta Algún Campo", Toast.LENGTH_SHORT).show();
            }
        });

        tab1Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanData();
                Toast.makeText(getActivity(), "Campos Reseteados!", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    public void cleanData() {
        tab1EditText1.setText("");
        tab1EditText2.setText("");
        tab1EditText3.setText("");
    }

    private void insertar(String numero, String nombre, String telefono) {
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this.getContext());
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("numero", numero);
        contentValues.put("nombre", nombre);
        contentValues.put("telefono", telefono);
        sqLiteDatabase.insert("agenda", null, contentValues);

        sqLiteDatabase.close();
    }
}
