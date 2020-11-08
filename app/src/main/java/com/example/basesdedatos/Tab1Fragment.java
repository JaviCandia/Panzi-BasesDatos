package com.example.basesdedatos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Fragment extends Fragment {

    public Tab1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tab1, container, false);

        // Binding elements in this class
        final ViewHolder viewHolder = new ViewHolder();
        viewHolder.tab1EditText1 = rootView.findViewById(R.id.tab1EditText1);
        viewHolder.tab1EditText2 = rootView.findViewById(R.id.tab1EditText2);
        viewHolder.tab1EditText3 = rootView.findViewById(R.id.tab1EditText3);

        viewHolder.tab1Button1 = rootView.findViewById(R.id.tab1Button1);
        viewHolder.tab1Button2 = rootView.findViewById(R.id.tab1Button2);

        // Adding listener
        viewHolder.tab1EditText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero = viewHolder.tab1EditText1.getText().toString();
                String nombre = viewHolder.tab1EditText1.getText().toString();
                String telefono = viewHolder.tab1EditText1.getText().toString();

                if(numero.compareTo("")!=0 && nombre.compareTo("")!=0 && telefono.compareTo("")!=0){
                    //Inserta(numero, nombre, telefono);
                }

                viewHolder.tab1EditText1.setText("");
                viewHolder.tab1EditText2.setText("");
                viewHolder.tab1EditText3.setText("");
            }
        });

        return rootView;
    }

    private class ViewHolder {
        EditText tab1EditText1, tab1EditText2, tab1EditText3;

        Button tab1Button1, tab1Button2;
    }
}
