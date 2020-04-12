package com.example.apptallerya;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class Taller {
    private Integer idcliente;
    private String nombre_taller, direccion_taller, telefono_taller, password_taller;
    private String imagen1_taller, imagen2_taller, imagen3_taller, imagen_lista;
    private Bitmap img1, img2, img3;
    private double evaluacion_taller;

    public Taller(String imagen_lista) {
        this.imagen_lista = imagen_lista;
    }

    public String getImagen_lista() {
        return imagen_lista;
    }

    public void setImagen1_taller(String imagen1_taller) {

        this.imagen1_taller = imagen1_taller;

        try {
            byte[] byteCode = Base64.decode(imagen1_taller, Base64.DEFAULT);
            this.img1 = BitmapFactory.decodeByteArray(byteCode, 0, byteCode.length);

            //  int alto = 150;//alto en pixeles
            // int ancho = 200;//ancho en pixeles
            //Bitmap foto = BitmapFactory.decodeByteArray(byteCode, 0, byteCode.length);
            // this.img1 = Bitmap.createScaledBitmap(foto, ancho, alto, true);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setImagen_lista(String imagen_lista) {
        this.imagen_lista = imagen_lista;

        try {
            byte[] byteCode = Base64.decode(imagen_lista, Base64.DEFAULT);
            int alto = 500;//alto en pixeles
            int ancho = 550;//ancho en pixeles
            Bitmap foto = BitmapFactory.decodeByteArray(byteCode, 0, byteCode.length);
            this.img2 = Bitmap.createScaledBitmap(foto, ancho, alto, true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre_taller() {
        return nombre_taller;
    }

    public void setNombre_taller(String nombre_taller) {
        this.nombre_taller = nombre_taller;
    }

    public String getDireccion_taller() {
        return direccion_taller;
    }

    public void setDireccion_taller(String direccion_taller) {
        this.direccion_taller = direccion_taller;
    }

    public String getTelefono_taller() {
        return telefono_taller;
    }

    public void setTelefono_taller(String telefono_taller) {
        this.telefono_taller = telefono_taller;
    }

    public String getPassword_taller() {
        return password_taller;
    }

    public void setPassword_taller(String password_taller) {
        this.password_taller = password_taller;
    }

    public String getImagen1_taller() {
        return imagen1_taller;
    }

    public String getImagen2_taller() {
        return imagen2_taller;
    }

    public void setImagen2_taller(String imagen2_taller) {
        this.imagen2_taller = imagen2_taller;
    }

    public String getImagen3_taller() {
        return imagen3_taller;
    }

    public void setImagen3_taller(String imagen3_taller) {
        this.imagen3_taller = imagen3_taller;
    }

    public double getEvaluacion_taller() {
        return evaluacion_taller;
    }

    public void setEvaluacion_taller(double evaluacion_taller) {
        this.evaluacion_taller = evaluacion_taller;
    }

    public Bitmap getImg2() {
        return img2;
    }

    public void setImg2(Bitmap img2) {
        this.img2 = img2;
    }

    public Bitmap getImg3() {
        return img3;
    }

    public void setImg3(Bitmap img3) {
        this.img3 = img3;
    }


    @Override
    public String toString() {
        return "Taller{" +
                "idcliente=" + idcliente +
                ", nombre_taller='" + nombre_taller + '\'' +
                ", direccion_taller='" + direccion_taller + '\'' +
                ", telefono_taller='" + telefono_taller + '\'' +
                ", password_taller='" + password_taller + '\'' +
                ", imagen1_taller='" + imagen1_taller + '\'' +
                ", imagen2_taller='" + imagen2_taller + '\'' +
                ", imagen3_taller='" + imagen3_taller + '\'' +
                ", imagen_lista='" + imagen_lista + '\'' +
                ", img1=" + img1 +
                ", img2=" + img2 +
                ", img3=" + img3 +
                ", evaluacion_taller=" + evaluacion_taller +
                '}';
    }

    public Taller(String nombre_taller, String direccion_taller, String imagen1_taller, double evaluacion_taller) {
        this.nombre_taller = nombre_taller;
        this.direccion_taller = direccion_taller;
        this.imagen1_taller = imagen1_taller;
        this.evaluacion_taller = evaluacion_taller;
    }

    public Bitmap getImg1() {
        return img1;
    }

    public void setImg1(Bitmap img1) {
        this.img1 = img1;
    }

    public Taller() {
    }

    public Taller(Integer idcliente) {
        this.idcliente = idcliente;
    }
}
