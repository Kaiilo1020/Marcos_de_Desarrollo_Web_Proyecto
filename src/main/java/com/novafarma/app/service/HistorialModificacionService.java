package com.novafarma.app.service;

import com.novafarma.app.model.entity.HistorialModificacion;
import com.novafarma.app.repository.HistorialModificacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialModificacionService {

    private final HistorialModificacionRepository historialRepository;

    public HistorialModificacionService(HistorialModificacionRepository historialRepository) {
        this.historialRepository = historialRepository;
    }

    public List<HistorialModificacion> listarTodas() {
        return historialRepository.findAll();
    }

    public HistorialModificacion guardar(HistorialModificacion h) {
        return historialRepository.save(h);
    }
}
