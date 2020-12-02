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

public class Tab2Fragment extends Fragment {

    private SQLiteDatabase sqLiteDatabase;
    private EditText tab2EditText1, tab2EditText2, tab2EditText3;
    private Button tab2Button1, tab2Button2;

    public Tab2Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tab2, container, false);

        // Binding elements in this class
        tab2EditText1 = rootView.findViewById(R.id.tab2EditText1);
        tab2EditText2 = rootView.findViewById(R.id.tab2EditText2);
        tab2EditText3 = rootView.findViewById(R.id.tab2EditText3);

        tab2Button1 = rootView.findViewById(R.id.tab2Button1);
        tab2Button2 = rootView.findViewById(R.id.tab2Button2);

        // Adding listener
        tab2Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero = tab2EditText1.getText().toString();
                String nombre = tab2EditText2.getText().toString();
                String telefono = tab2EditText3.getText().toString();

                if(numero.compareTo("")!=0){
                    actualizar(numero, nombre, telefono);
                    cleanData();
                    Toast.makeText(getActivity(), "Datos Actualizados!", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getActivity(), "Falta Algún Campo", Toast.LENGTH_SHORT).show();
            }
        });

        tab2Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanData();
                Toast.makeText(getActivity(), "Campos Reseteados!", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    public void cleanData(){
        tab2EditText1.setText("");
        tab2EditText2.setText("");
        tab2EditText3.setText("");
    }

    private void actualizar(String numero, String nombre, String telefono){
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this.getContext());
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

        if(nombre.compareTo("")!=0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nombre", nombre);
            sqLiteDatabase.update("agenda", contentValues, "numero = "+numero, null);
        }
        if(telefono.compareTo("")!=0){
            ContentValues contentValues = new ContentValues();
            contentValues.put("telefono", telefono);
            sqLiteDatabase.update("agenda", contentValues, "numero = "+numero, null);
        }
        sqLiteDatabase.close();
    }
}
