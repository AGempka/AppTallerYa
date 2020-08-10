package com.example.apptallerya;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.Serializable;

public class Taller implements Serializable {
    private String nombre_taller, direccion_taller, telefono_taller, correo_taller, key, latitud, longitud;
    private String img1_taller, img2_taller, img_logo, imagen_lista;
    private Long password_taller;
    private double evaluacion_taller;


    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

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
                ", key='" + key + '\'' +
                ", latitud='" + latitud + '\'' +
                ", longitud='" + longitud + '\'' +
                ", img_logo='" + img_logo + '\'' +
                ", evaluacion_taller=" + evaluacion_taller +
                '}';
    }

    public Taller(String nombre_taller, String direccion_taller, String img_logo, double evaluacion_taller, String key, String  latitud, String longitud) {
        this.nombre_taller = nombre_taller;
        this.direccion_taller = direccion_taller;
        this.img_logo=img_logo;
        this.evaluacion_taller = evaluacion_taller;
        this.key=key;
        this.latitud=latitud;
        this.longitud=longitud;
    }


    public Taller() {
    }


}
