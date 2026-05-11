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
import java.time.format.DateTimeFormatter;

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
        return "alertas";
    }

    @GetMapping("/registro")
    public String registro(Model model) {
        model.addAttribute("incidencias", incidenciaService.listarTodas());
        return "registro";
    }

    @PostMapping("/registro/mercaderia")
    public String registrarMercaderia(
            @RequestParam String nombre,
            @RequestParam String categoria,
            @RequestParam int cantidad,
            @RequestParam String loteVencimiento) {

        String lote = loteVencimiento;
        LocalDate fechaVencimiento = LocalDate.now().plusMonths(12);

        try {
            if (loteVencimiento.toLowerCase().contains("vence")) {
                String[] partes = loteVencimiento.split("Vence");
                lote = partes[0].trim();
                String fechaStr = partes[1].trim();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                fechaVencimiento = LocalDate.parse("01/" + fechaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        } catch (Exception e) {
            fechaVencimiento = LocalDate.now().plusMonths(12);
        }

        Producto producto = new Producto(nombre, categoria, lote, cantidad, new BigDecimal("1.00"), fechaVencimiento);
        productoService.guardar(producto);
        return "redirect:/inventario";
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
        return "redirect:/registro";
    }
}
