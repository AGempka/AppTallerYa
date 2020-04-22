package com.example.apptallerya;

public class Comentarios{


public String comentario, nombre_cliente, date, time;

    public Comentarios() {
    }

    public Comentarios(String comentario, String nombre_cliente, String date, String time) {
        this.comentario = comentario;
        this.nombre_cliente = nombre_cliente;
        this.date = date;
        this.time = time;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
