package com.example.apptallerya;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.Serializable;

public class Taller implements Serializable {
    private String nombre_taller, direccion_taller, telefono_taller, correo_taller;
    private String img1_taller, img2_taller, img_logo, imagen_lista;
    private Long password_taller;
    private double evaluacion_taller;

    public String getCorreo_taller() {
        return correo_taller;
    }

    public void setCorreo_taller(String correo_taller) {
        this.correo_taller = correo_taller;
    }

    public String getImg1_taller() {
        return img1_taller;
    }

    public void setImg1_taller(String img1_taller) {
        this.img1_taller = img1_taller;
    }

    public String getImg2_taller() {
        return img2_taller;
    }

    public void setImg2_taller(String img2_taller) {
        this.img2_taller = img2_taller;
    }

    public String getImg_logo() {
        return img_logo;
    }

    public void setImg_logo(String img_logo) {
        this.img_logo = img_logo;
    }

    public void setImagen_lista(String imagen_lista) {
        this.imagen_lista = imagen_lista;
    }

    public Taller(String imagen_lista) {
        this.imagen_lista = imagen_lista;
    }

    public String getImagen_lista() {
        return imagen_lista;
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

    public Long getPassword_taller() {
        return password_taller;
    }

    public void setPassword_taller(Long password_taller) {
        this.password_taller = password_taller;
    }

    public double getEvaluacion_taller() {
        return evaluacion_taller;
    }

    public void setEvaluacion_taller(double evaluacion_taller) {
        this.evaluacion_taller = evaluacion_taller;
    }


    @Override
    public String toString() {
        return "Taller{" +
                "nombre_taller='" + nombre_taller + '\'' +
                ", direccion_taller='" + direccion_taller + '\'' +
                ", telefono_taller='" + telefono_taller + '\'' +
                ", img_logo='" + img_logo + '\'' +
                ", evaluacion_taller=" + evaluacion_taller +
                '}';
    }

    public Taller(String nombre_taller, String direccion_taller, String img_logo, double evaluacion_taller) {
        this.nombre_taller = nombre_taller;
        this.direccion_taller = direccion_taller;
        this.img_logo=img_logo;
        this.evaluacion_taller = evaluacion_taller;
    }


    public Taller() {
    }


}
