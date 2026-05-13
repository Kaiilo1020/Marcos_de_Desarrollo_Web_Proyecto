package com.novafarma.app.repository;

import com.novafarma.app.model.entity.HistorialModificacion;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistorialModificacionRepository {

    private final List<HistorialModificacion> historial = new ArrayList<>();
    private Long nextId = 1L;

    public List<HistorialModificacion> findAll() {
        return new ArrayList<>(historial);
    }

    public HistorialModificacion save(HistorialModificacion h) {
        if (h.getId() == null) {
            h.setId(nextId++);
        }
        historial.add(h);
        return h;
    }
}
