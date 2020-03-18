package com.example.apptallerya;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TalleresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */public class TalleresFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView txtNombre;
    TextView txtTelefono;
    String nomTaller;
    String telTaller;

    public TalleresFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TalleresFragment newInstance(String nombre_taller, String telefono_taller) {
        TalleresFragment fragment = new TalleresFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, nombre_taller);
        args.putString(ARG_PARAM2, telefono_taller);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nomTaller = getArguments().getString(ARG_PARAM1);
            telTaller = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_talleres, container, false);
        txtNombre=(TextView) v.findViewById(R.id.txtNombreTa);
        txtTelefono=(TextView) v.findViewById(R.id.txtTelefonoTa);
        txtNombre.setText(nomTaller);
        txtTelefono.setText(telTaller);


        //imAgen.setImageResource(ima);
        return v;
    }

}