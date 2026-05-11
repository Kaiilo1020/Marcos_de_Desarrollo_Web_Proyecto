package com.novafarma.app.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Producto {

    private Long id;
    private String nombre;
    private String categoria;
    private String lote;
    private int stock;
    private BigDecimal precio;
    private LocalDate fechaVencimiento;

    public Producto() {}

    public Producto(String nombre, String categoria, String lote, int stock, BigDecimal precio, LocalDate fechaVencimiento) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.lote = lote;
        this.stock = stock;
        this.precio = precio;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getLote() { return lote; }
    public void setLote(String lote) { this.lote = lote; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public boolean isStockBajo() { return this.stock < 10; }
    public boolean isVencido() { return LocalDate.now().isAfter(this.fechaVencimiento); }
    public boolean isVenceProximo() {
        LocalDate hoy = LocalDate.now();
        LocalDate limite = hoy.plusDays(30);
        return !isVencido() && (this.fechaVencimiento.isBefore(limite) || this.fechaVencimiento.isEqual(limite));
    }
}
