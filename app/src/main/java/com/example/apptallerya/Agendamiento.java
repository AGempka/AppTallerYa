package com.example.apptallerya;

class Agendamiento {

   private String nombre_cliente, telefono_cliente, correo_cliente;
   private Boolean whatsApp, chaperiaypintura,lubricacion, limpieza, mecanica,electricidad, inyeccion;

    public Agendamiento(String nombre_cliente, String telefono_cliente, String correo_cliente, Boolean whatsApp, Boolean chaperiaypintura, Boolean lubricacion, Boolean limpieza, Boolean mecanica, Boolean electricidad, Boolean inyeccion) {
        this.nombre_cliente = nombre_cliente;
        this.telefono_cliente = telefono_cliente;
        this.correo_cliente = correo_cliente;
        this.whatsApp = whatsApp;
        this.chaperiaypintura = chaperiaypintura;
        this.lubricacion = lubricacion;
        this.limpieza = limpieza;
        this.mecanica = mecanica;
        this.electricidad = electricidad;
        this.inyeccion = inyeccion;
    }

    @Override
    public String toString() {
        return "Agendamiento{" +
                "nombre_cliente='" + nombre_cliente + '\'' +
                ", telefono_cliente='" + telefono_cliente + '\'' +
                ", correo_cliente='" + correo_cliente + '\'' +
                ", whatsApp=" + whatsApp +
                ", chaperiaypintura=" + chaperiaypintura +
                ", lubricacion=" + lubricacion +
                ", limpieza=" + limpieza +
                ", mecanica=" + mecanica +
                ", electricidad=" + electricidad +
                ", inyeccion=" + inyeccion +
                '}';
    }

    public Agendamiento() {
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public String getCorreo_cliente() {
        return correo_cliente;
    }

    public void setCorreo_cliente(String correo_cliente) {
        this.correo_cliente = correo_cliente;
    }

    public Boolean getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(Boolean whatsApp) {
        this.whatsApp = whatsApp;
    }

    public Boolean getChaperiaypintura() {
        return chaperiaypintura;
    }

    public void setChaperiaypintura(Boolean chaperiaypintura) {
        this.chaperiaypintura = chaperiaypintura;
    }

    public Boolean getLubricacion() {
        return lubricacion;
    }

    public void setLubricacion(Boolean lubricacion) {
        this.lubricacion = lubricacion;
    }

    public Boolean getLimpieza() {
        return limpieza;
    }

    public void setLimpieza(Boolean limpieza) {
        this.limpieza = limpieza;
    }

    public Boolean getMecanica() {
        return mecanica;
    }

    public void setMecanica(Boolean mecanica) {
        this.mecanica = mecanica;
    }

    public Boolean getElectricidad() {
        return electricidad;
    }

    public void setElectricidad(Boolean electricidad) {
        this.electricidad = electricidad;
    }

    public Boolean getInyeccion() {
        return inyeccion;
    }

    public void setInyeccion(Boolean inyeccion) {
        this.inyeccion = inyeccion;
    }
}
