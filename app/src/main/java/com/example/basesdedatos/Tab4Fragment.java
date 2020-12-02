package com.example.basesdedatos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tab4Fragment extends Fragment {

    private SQLiteDatabase sqLiteDatabase;
    private TextView tab4TextView1;
    private Button tab4Button1;

    public Tab4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tab4, container, false);

        tab4TextView1 = rootView.findViewById(R.id.tab4TextView1);
        tab4Button1 = rootView.findViewById(R.id.tab4Button1);

        // Adding listener
        tab4Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listar();
                Toast.makeText(getActivity(), "Usuarios Listados!", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    private void listar(){
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this.getContext());
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

        String [] campos = new String[] {"numero", "nombre", "telefono"};
        Cursor cursor = sqLiteDatabase.query("agenda", campos, null,
                null, null, null, null);

        tab4TextView1.setText("");
        if(cursor.moveToFirst()){
            do {
                String numero = cursor.getString(0);
                String nombre = cursor.getString(1);
                String telefono = cursor.getString(2);
                tab4TextView1.append(numero + " - " + " " + nombre + " (" + telefono + ")\n");
            }while (cursor.moveToNext());
        }
    }
}
