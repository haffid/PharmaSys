package com.haffid.pharmasys.complementos;

public class PedidoVO {
    private int idPedidoP;
    private String fechaPedidoP;
    private int idClienteP;
    private int idProductoP;
    private String descripcionPedidoP;
    private double precioPedidoP;
    private int cantidadPedidoP;
    private double totalPedidoP;
    private int idEstadoP;

    public PedidoVO() {
    }

    public PedidoVO(int idPedidoP, String fechaPedidoP, int idClienteP, int idProductoP, String descripcionPedidoP, double precioPedidoP, int cantidadPedidoP, double totalPedidoP, int idEstadoP) {
        this.idPedidoP = idPedidoP;
        this.fechaPedidoP = fechaPedidoP;
        this.idClienteP = idClienteP;
        this.idProductoP = idProductoP;
        this.descripcionPedidoP = descripcionPedidoP;
        this.precioPedidoP = precioPedidoP;
        this.cantidadPedidoP = cantidadPedidoP;
        this.totalPedidoP = totalPedidoP;
        this.idEstadoP = idEstadoP;
    }

    public int getIdPedidoP() {
        return idPedidoP;
    }

    public void setIdPedidoP(int idPedidoP) {
        this.idPedidoP = idPedidoP;
    }

    public String getFechaPedidoP() {
        return fechaPedidoP;
    }

    public void setFechaPedidoP(String fechaPedidoP) {
        this.fechaPedidoP = fechaPedidoP;
    }

    public int getIdClienteP() {
        return idClienteP;
    }

    public void setIdClienteP(int idClienteP) {
        this.idClienteP = idClienteP;
    }

    public int getIdProductoP() {
        return idProductoP;
    }

    public void setIdProductoP(int idProductoP) {
        this.idProductoP = idProductoP;
    }

    public String getDescripcionPedidoP() {
        return descripcionPedidoP;
    }

    public void setDescripcionPedidoP(String descripcionPedidoP) {
        this.descripcionPedidoP = descripcionPedidoP;
    }

    public double getPrecioPedidoP() {
        return precioPedidoP;
    }

    public void setPrecioPedidoP(double precioPedidoP) {
        this.precioPedidoP = precioPedidoP;
    }

    public int getCantidadPedidoP() {
        return cantidadPedidoP;
    }

    public void setCantidadPedidoP(int cantidadPedidoP) {
        this.cantidadPedidoP = cantidadPedidoP;
    }

    public double getTotalPedidoP() {
        return totalPedidoP;
    }

    public void setTotalPedidoP(double totalPedidoP) {
        this.totalPedidoP = totalPedidoP;
    }

    public int getIdEstadoP() {
        return idEstadoP;
    }

    public void setIdEstadoP(int idEstadoP) {
        this.idEstadoP = idEstadoP;
    }
}
