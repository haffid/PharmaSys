package com.haffid.pharmasys.complementos;

public class ProductoVO {
    private int idProducto;
    private String nombreProducto;
    private String tipoProducto;
    private String descripcionProducto;
    private double precioProducto;

    public ProductoVO() {
    }

    public ProductoVO(int idProducto, String nombreProducto, String tipoProducto, String descripcionProducto, double precioProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.tipoProducto = tipoProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
}
