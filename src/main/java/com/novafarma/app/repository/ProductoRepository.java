package com.novafarma.app.repository;

import com.novafarma.app.model.entity.Producto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductoRepository {

    private final List<Producto> productos = new ArrayList<>();
    private Long nextId = 1L;

    public ProductoRepository() {
        // Datos de prueba precargados
        save(new Producto("Paracetamol 500mg", "Analgesicos", "PF-2025-014", 240, new BigDecimal("0.55"), LocalDate.of(2027, 6, 15)));
        save(new Producto("Ibuprofeno 400mg", "Antiinflamatorio", "IB-2024-882", 96, new BigDecimal("0.80"), LocalDate.of(2026, 12, 20)));
        save(new Producto("Loratadina 10mg", "Antihistaminicos", "LR-2025-033", 5, new BigDecimal("3.20"), LocalDate.of(2026, 5, 10)));
        save(new Producto("Metformina 850mg", "Antidiabeticos", "MT-2025-008", 3, new BigDecimal("8.90"), LocalDate.of(2026, 8, 15)));
        save(new Producto("Diclofenaco 50mg", "Antiinflamatorio", "DC-2024-156", 18, new BigDecimal("1.20"), LocalDate.of(2026, 5, 5)));
        save(new Producto("Aspirina 100mg", "Analgesicos", "AS-2025-042", 156, new BigDecimal("0.45"), LocalDate.of(2027, 3, 30)));
        save(new Producto("Salbutamol Inhalador", "Broncodilatadores", "SB-2025-019", 42, new BigDecimal("15.50"), LocalDate.of(2027, 1, 10)));
        save(new Producto("Omeprazol 20mg", "Antiulceroso", "OM-2024-112", 8, new BigDecimal("2.50"), LocalDate.of(2026, 2, 28)));
    }

    public List<Producto> findAll() {
        return new ArrayList<>(productos);
    }

    public Producto save(Producto producto) {
        if (producto.getId() == null) {
            producto.setId(nextId++);
        }
        productos.add(producto);
        return producto;
    }

    public long count() {
        return productos.size();
    }

    public Producto findByNombre(String nombre) {
        return productos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public boolean deleteByNombre(String nombre) {
        return productos.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    public void restarStockOEliminar(String nombre, int cantidad) {
        Optional<Producto> encontrado = productos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst();

        if (encontrado.isPresent()) {
            Producto p = encontrado.get();
            int nuevoStock = p.getStock() - cantidad;
            if (nuevoStock <= 0) {
                productos.removeIf(prod -> prod.getNombre().equalsIgnoreCase(nombre));
            } else {
                p.setStock(nuevoStock);
            }
        }
    }
}
