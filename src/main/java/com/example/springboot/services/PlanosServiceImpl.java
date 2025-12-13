package com.example.springboot.services;

import com.example.springboot.model.Planos;
import com.example.springboot.repository.PlanosRepository;
import com.example.springboot.services.PlanosService;
import org.springframework.stereotype.Service;




import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class PlanosServiceImpl implements PlanosService{

    private final PlanosRepository planosRepository;


    public PlanosServiceImpl(PlanosRepository planosRepository) {
        this.planosRepository = planosRepository;
    }


    @Override
    public List<Planos> listarTodos() {
        return planosRepository.findAll();
    }


    @Override
    public Optional<Planos> buscarPorId(Long id) {
        return planosRepository.findById(id);
    }


    @Override
    public Planos criar(Planos plano) {
        plano.setCreatedAt(LocalDateTime.now());
        plano.setUpdatedAt(LocalDateTime.now());
        return planosRepository.save(plano);
    }


    @Override
    public Optional<Planos> atualizar(Long id, Planos plano) {
        return planosRepository.findById(id).map(existing -> {
            existing.setNome(plano.getNome());
            existing.setDescricao(plano.getDescricao());
            existing.setMaxSimulacoesPorMes(plano.getMaxSimulacoesPorMes());
            existing.setPermiteIaAvancada(plano.getPermiteIaAvancada());
            existing.setUpdatedAt(LocalDateTime.now());
            return planosRepository.save(existing);
        });
    }


    @Override
    public boolean deletar(Long id) {
        if (!planosRepository.existsById(id)) return false;
        planosRepository.deleteById(id);
        return true;
    }
}


