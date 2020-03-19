package com.example.apptallerya;

import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";
    private static final String ARG_PARAM5 = "param5";
    private static final String ARG_PARAM6 = "param6";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView txtNombre;
    TextView txtTelefono;
    TextView txtDireccion;
    TextView txtEvaluacion;
    ImageView img1logo;
    ImageView img2;
    String nomTaller;
    String telTaller;
    String dirTaller;
    Double evaTaller;
    String img1Taller;
    String img2Taller;

    public TalleresFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TalleresFragment newInstance(String nombre_taller, String telefono_taller, String direccion_taller,
                                              Double evaluacion_taller, String imagen1_taller, String imagen2_taller) {
        TalleresFragment fragment = new TalleresFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, nombre_taller);
        args.putString(ARG_PARAM2, telefono_taller);
        args.putString(ARG_PARAM3, direccion_taller);
        args.putString(ARG_PARAM4, String.valueOf(evaluacion_taller));
        args.putString(ARG_PARAM5, imagen1_taller);
        args.putString(ARG_PARAM6, imagen2_taller);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nomTaller = getArguments().getString(ARG_PARAM1);
            telTaller = getArguments().getString(ARG_PARAM2);
            dirTaller= getArguments().getString(ARG_PARAM3);
            evaTaller=getArguments().getDouble(ARG_PARAM4);
            img1Taller=getArguments().getString(ARG_PARAM5);
            img2Taller=getArguments().getString(ARG_PARAM6);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_talleres, container, false);
        txtNombre=(TextView) v.findViewById(R.id.txtNombreTaller);
        txtTelefono=(TextView) v.findViewById(R.id.txtTelefonoTaller);
        img1logo=(ImageView) v.findViewById(R.id.img1Logo);
        //poner acá evaluacion
        txtDireccion=(TextView)v.findViewById(R.id.txtDireccionTaller);
        //ver cómo carajos se agrega imagen y transformar imagen2 en la clase Taller
        txtNombre.setText(nomTaller);
        txtTelefono.setText(telTaller);
        txtDireccion.setText(dirTaller);
        byte[] byteCode= Base64.decode(img1Taller,Base64.DEFAULT);
       img1logo.setImageBitmap(BitmapFactory.decodeByteArray(byteCode,0,byteCode.length));

        //imAgen.setImageResource(ima);
        return v;
    }

}