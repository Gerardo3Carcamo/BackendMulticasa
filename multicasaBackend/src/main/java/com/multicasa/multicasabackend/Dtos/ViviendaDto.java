package com.multicasa.multicasabackend.Dtos;

public class ViviendaDto {
    private String cp;
    private double precio;
    private String ciudad;
    private String estado;
    private int recamaras;
    private int banos;
    private String lat;
    private String lon;
    private String descripcion;

    public ViviendaDto(String cp, double precio, String ciudad, String estado, int recamaras, int banos, String lat, String lon, String descripcion) {
        this.cp = cp;
        this.precio = precio;
        this.ciudad = ciudad;
        this.estado = estado;
        this.recamaras = recamaras;
        this.banos = banos;
        this.lat = lat;
        this.lon = lon;
        this.descripcion = descripcion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getRecamaras() {
        return recamaras;
    }

    public void setRecamaras(int recamaras) {
        this.recamaras = recamaras;
    }

    public int getBanos() {
        return banos;
    }

    public void setBanos(int banos) {
        this.banos = banos;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
