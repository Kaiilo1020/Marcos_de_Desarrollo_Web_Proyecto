package com.novafarma.app.service;

import com.novafarma.app.model.entity.Incidencia;
import com.novafarma.app.repository.IncidenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenciaService {

    private final IncidenciaRepository incidenciaRepository;

    public IncidenciaService(IncidenciaRepository incidenciaRepository) {
        this.incidenciaRepository = incidenciaRepository;
    }

    public List<Incidencia> listarTodas() {
        return incidenciaRepository.findAll();
    }

    public Incidencia guardar(Incidencia incidencia) {
        return incidenciaRepository.save(incidencia);
    }
}
