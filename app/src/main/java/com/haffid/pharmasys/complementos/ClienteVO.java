package com.haffid.pharmasys.complementos;

public class ClienteVO {

    private int idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String direccionCliente;
    private String correoCliente;
    private String claveCliente;

    public ClienteVO() {
    }

    public ClienteVO(int idCliente, String nombreCliente, String apellidoCliente, String direccionCliente, String correoCliente, String claveCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.direccionCliente = direccionCliente;
        this.correoCliente = correoCliente;
        this.claveCliente = claveCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getClaveCliente() {
        return claveCliente;
    }

    public void setClaveCliente(String claveCliente) {
        this.claveCliente = claveCliente;
    }
}
