package com.example.basesdedatos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tab3Fragment extends Fragment {

    private SQLiteDatabase sqLiteDatabase;
    private EditText tab3EditText1;
    private Button tab3Button1, tab3Button2;

    public Tab3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tab3, container, false);

        // Binding elements in this class
        tab3EditText1 = rootView.findViewById(R.id.tab3EditText1);

        tab3Button1 = rootView.findViewById(R.id.tab3Button1);
        tab3Button2 = rootView.findViewById(R.id.tab3Button2);

        // Adding listener
        tab3Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero = tab3EditText1.getText().toString();

                if (numero.compareTo("") != 0) {
                    borrar(numero);
                    tab3EditText1.setText("");
                    Toast.makeText(getActivity(), "Usuario Eliminado!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getActivity(), "Falta Algún Campo", Toast.LENGTH_SHORT).show();
            }
        });

        tab3Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tab3EditText1.setText("");
                Toast.makeText(getActivity(), "Campos Reseteados!", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }


    private void borrar(String numero) {
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this.getContext());
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        sqLiteDatabase.delete("agenda", "numero = " + numero, null);
        sqLiteDatabase.close();
    }
}
