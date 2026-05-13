package com.novafarma.app.service;

import com.novafarma.app.model.entity.Producto;
import com.novafarma.app.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public long contarTotal() {
        return productoRepository.count();
    }

    public List<Producto> obtenerAlertas() {
        return productoRepository.findAll().stream()
                .filter(p -> p.isStockBajo() || p.isVencido() || p.isVenceProximo())
                .collect(Collectors.toList());
    }

    public long contarAlertasCriticas() {
        return productoRepository.findAll().stream()
                .filter(p -> p.isStockBajo() || p.isVencido())
                .count();
    }

    public Producto buscarPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    public boolean eliminarPorNombre(String nombre) {
        return productoRepository.deleteByNombre(nombre);
    }

    public void restarStockOEliminar(String nombre, int cantidad) {
        productoRepository.restarStockOEliminar(nombre, cantidad);
    }
}
