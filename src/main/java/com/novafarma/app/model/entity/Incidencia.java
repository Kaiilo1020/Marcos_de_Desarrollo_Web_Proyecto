package com.novafarma.app.model.entity;

import java.time.LocalDate;

public class Incidencia {

    private Long id;
    private String tipo;
    private String medicamentoAfectado;
    private int cantidadAfectada;
    private LocalDate fechaIncidente;
    private String descripcion;

    public Incidencia() {}

    public Incidencia(String tipo, String medicamentoAfectado, int cantidadAfectada, LocalDate fechaIncidente, String descripcion) {
        this.tipo = tipo;
        this.medicamentoAfectado = medicamentoAfectado;
        this.cantidadAfectada = cantidadAfectada;
        this.fechaIncidente = fechaIncidente;
        this.descripcion = descripcion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getMedicamentoAfectado() { return medicamentoAfectado; }
    public void setMedicamentoAfectado(String medicamentoAfectado) { this.medicamentoAfectado = medicamentoAfectado; }
    public int getCantidadAfectada() { return cantidadAfectada; }
    public void setCantidadAfectada(int cantidadAfectada) { this.cantidadAfectada = cantidadAfectada; }
    public LocalDate getFechaIncidente() { return fechaIncidente; }
    public void setFechaIncidente(LocalDate fechaIncidente) { this.fechaIncidente = fechaIncidente; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
