package com.example.basesdedatos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tab5Fragment extends Fragment {
    private SQLiteDatabase sqLiteDatabase;
    private TextView tab5TextView1;
    private EditText tab5EditText1;
    private Button tab5Button1, tab5Button2;

    public Tab5Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tab5, container, false);

        tab5TextView1 = rootView.findViewById(R.id.tab5TextView1);
        tab5EditText1 = rootView.findViewById(R.id.tab5EditText1);
        tab5Button1 = rootView.findViewById(R.id.tab5Button1);
        tab5Button2 = rootView.findViewById(R.id.tab5Button2);

        // Adding listener
        tab5Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero = tab5EditText1.getText().toString();

                if (numero.compareTo("") != 0) {
                    listar(numero);
                    tab5EditText1.setText("");
                    Toast.makeText(getActivity(), "Usuario Encontrado!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getActivity(), "Falta Algún Campo", Toast.LENGTH_SHORT).show();
            }
        });

        tab5Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tab5EditText1.setText("");
                tab5TextView1.setText("");
                Toast.makeText(getActivity(), "Campos Reseteados!", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    private void listar(String id) {
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this.getContext());
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

        String[] campos = new String[]{"numero", "nombre", "telefono"};
        Cursor cursor = sqLiteDatabase.query("agenda", campos, "numero = "+id,
                null, null, null, null);

        tab5TextView1.setText("");
        if (cursor.moveToFirst()) {
            do {
                String numero = cursor.getString(0);
                String nombre = cursor.getString(1);
                String telefono = cursor.getString(2);
                tab5TextView1.append("Id: "+ numero + "\nNombre: " + nombre + "\nTeléfono: (" + telefono + ")\n");
            } while (cursor.moveToNext());
        }
    }
}
