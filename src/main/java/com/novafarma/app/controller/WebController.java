package com.novafarma.app.controller;

import com.novafarma.app.model.entity.Producto;
import com.novafarma.app.model.entity.Incidencia;
import com.novafarma.app.service.ProductoService;
import com.novafarma.app.service.IncidenciaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
public class WebController {

    private final ProductoService productoService;
    private final IncidenciaService incidenciaService;

    public WebController(ProductoService productoService, IncidenciaService incidenciaService) {
        this.productoService = productoService;
        this.incidenciaService = incidenciaService;
    }

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("totalProductos", productoService.contarTotal());
        model.addAttribute("ventasHoy", new BigDecimal("3450.00"));
        model.addAttribute("movimientosHoy", 87);
        model.addAttribute("alertasCriticas", productoService.contarAlertasCriticas());
        model.addAttribute("productos", productoService.listarTodos());
        return "inicio";
    }

    @GetMapping("/inventario")
    public String inventario(Model model) {
        model.addAttribute("productos", productoService.listarTodos());
        return "inventario";
    }

    @GetMapping("/alertas")
    public String alertas(Model model) {
        model.addAttribute("alertas", productoService.obtenerAlertas());
        model.addAttribute("incidencias", incidenciaService.listarTodas());
        return "alertas";
    }

    @GetMapping("/registro")
    public String registro(Model model) {
        model.addAttribute("productos", productoService.listarTodos());
        return "registro";
    }

    @PostMapping("/registro/mercaderia")
    public String registrarMercaderia(
            @RequestParam String nombre,
            @RequestParam String categoria,
            @RequestParam int cantidad,
            @RequestParam BigDecimal precio,
            @RequestParam String lote,
            @RequestParam String fechaVencimiento) {

        LocalDate fechaVenc = LocalDate.parse(fechaVencimiento);
        Producto producto = new Producto(nombre, categoria, lote, cantidad, precio, fechaVenc);
        productoService.guardar(producto);
        return "redirect:/inventario?exito=true";
    }

    @PostMapping("/registro/incidencia")
    public String registrarIncidencia(
            @RequestParam String tipo,
            @RequestParam String medicamento,
            @RequestParam int cantidad,
            @RequestParam String fecha,
            @RequestParam String descripcion) {

        Incidencia incidencia = new Incidencia(tipo, medicamento, cantidad, LocalDate.parse(fecha), descripcion);
        incidenciaService.guardar(incidencia);

        // Si es "Registro incorrecto", eliminar el producto del inventario
        if ("Registro incorrecto".equals(tipo)) {
            Producto p = productoService.buscarPorNombre(medicamento);
            if (p != null) {
                productoService.eliminarPorNombre(medicamento);
            }
        }

        return "redirect:/registro?exito=true";
    }

    @PostMapping("/alertas/retirar")
    public String retirarProducto(@RequestParam String nombre) {
        Producto p = productoService.buscarPorNombre(nombre);
        if (p != null) {
            String tipo = p.isVencido() ? "Retiro por vencimiento" : "Retiro por stock bajo";
            Incidencia incidencia = new Incidencia(tipo, nombre, p.getStock(), LocalDate.now(), "Producto retirado desde Sistema de Alertas");
            incidenciaService.guardar(incidencia);
            productoService.eliminarPorNombre(nombre);
        }
        return "redirect:/alertas?exito=true";
    }
}
