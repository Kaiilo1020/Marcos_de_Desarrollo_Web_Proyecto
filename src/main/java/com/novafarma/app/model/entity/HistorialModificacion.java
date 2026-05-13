package com.novafarma.app.model.entity;

import java.time.LocalDate;

public class HistorialModificacion {

    private Long id;
    private String tipoAccion;
    private String nombreProducto;
    private String detalle;
    private LocalDate fecha;

    public HistorialModificacion() {}

    public HistorialModificacion(String tipoAccion, String nombreProducto, String detalle, LocalDate fecha) {
        this.tipoAccion = tipoAccion;
        this.nombreProducto = nombreProducto;
        this.detalle = detalle;
        this.fecha = fecha;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTipoAccion() { return tipoAccion; }
    public void setTipoAccion(String tipoAccion) { this.tipoAccion = tipoAccion; }
    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }
    public String getDetalle() { return detalle; }
    public void setDetalle(String detalle) { this.detalle = detalle; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}
