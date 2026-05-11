package com.novafarma.app.repository;

import com.novafarma.app.model.entity.Incidencia;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IncidenciaRepository {

    private final List<Incidencia> incidencias = new ArrayList<>();
    private Long nextId = 1L;

    public List<Incidencia> findAll() {
        return new ArrayList<>(incidencias);
    }

    public Incidencia save(Incidencia incidencia) {
        if (incidencia.getId() == null) {
            incidencia.setId(nextId++);
        }
        incidencias.add(incidencia);
        return incidencia;
    }

    public long count() {
        return incidencias.size();
    }
}
