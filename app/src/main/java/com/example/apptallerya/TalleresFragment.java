package com.example.apptallerya;

import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


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
    private static final String ARG_PARAM7 = "param7";
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
    String img3Taller;



    ArrayList<Taller> list;
    AdapterListaImg adapter;
    RecyclerView recyclerView;

    public TalleresFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TalleresFragment newInstance(String nombre_taller, String telefono_taller, String direccion_taller,
                                              Double evaluacion_taller, String imagen1_taller, String imagen2_taller, String imagen3_taller) {
        TalleresFragment fragment = new TalleresFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, nombre_taller);
        args.putString(ARG_PARAM2, telefono_taller);
        args.putString(ARG_PARAM3, direccion_taller);
        args.putDouble(ARG_PARAM4, evaluacion_taller);
        args.putString(ARG_PARAM5, imagen1_taller);
        args.putString(ARG_PARAM6, imagen2_taller);
        args.putString(ARG_PARAM7, imagen3_taller);
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
            img3Taller=getArguments().getString(ARG_PARAM7);
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

        txtNombre.setText(nomTaller);
        txtTelefono.setText(telTaller);
        txtDireccion.setText(dirTaller);

        byte[] byteCode= Base64.decode(img1Taller,Base64.DEFAULT);
        img1logo.setImageBitmap(BitmapFactory.decodeByteArray(byteCode,0,byteCode.length));

        String[] imagen_lista ={img2Taller, img3Taller};
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerviewFotos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        list = new ArrayList<>();
        adapter = new AdapterListaImg(this.getContext(), list);
        for (int i= 0 ; i<imagen_lista.length ; i++) {

            Taller taller = new Taller(imagen_lista[i]);
            taller.setImagen_lista(imagen_lista[i]);
            list.add(taller);

        }
        recyclerView.setAdapter(adapter);
        return v;
    }

}