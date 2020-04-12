package com.example.apptallerya;



    public class Cliente {
        private Integer idcliente;
        private String password_cliente;
        private String nombre_cliente;
        private String correo_cliente;
        private String telefono_cliente;
        private String foto_cliente;

        public Cliente() {
        }

        public Cliente(Integer idcliente, String password_cliente, String nombre_cliente, String correo_cliente, String direccion_cliente, String telefono_cliente, String foto_cliente) {
            this.idcliente = idcliente;
            this.password_cliente = password_cliente;
            this.nombre_cliente = nombre_cliente;
            this.correo_cliente = correo_cliente;
            this.telefono_cliente = telefono_cliente;
            this.foto_cliente=foto_cliente;
        }

        public String getFoto_cliente() {
            return foto_cliente;
        }

        public void setFoto_cliente(String foto_cliente) {
            this.foto_cliente = foto_cliente;
        }

        public Integer getIdcliente() {
            return idcliente;
        }

        public void setIdcliente(Integer idcliente) {
            this.idcliente = idcliente;
        }

        public String getPassword_cliente() {
            return password_cliente;
        }

        public void setPassword_cliente(String password_cliente) {
            this.password_cliente = password_cliente;
        }


        public String getNombre_cliente() {
            return nombre_cliente;
        }

        public void setNombre_cliente(String nombre_cliente) {
            this.nombre_cliente = nombre_cliente;
        }

        public String getCorreo_cliente() {
            return correo_cliente;
        }

        public void setCorreo_cliente(String correo_cliente) {
            this.correo_cliente = correo_cliente;
        }


        public String getTelefono_cliente() {
            return telefono_cliente;
        }

        public void setTelefono_cliente(String telefono_cliente) {
            this.telefono_cliente = telefono_cliente;
        }

    }
