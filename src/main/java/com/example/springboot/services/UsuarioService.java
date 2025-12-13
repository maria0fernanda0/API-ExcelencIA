package com.example.springboot.services;

import com.example.springboot.model.Usuario;
import com.example.springboot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service

public class UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    // CREATE
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // READ - todos
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // READ - por ID
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Usuario atualizarUsuario(Long id, Usuario novoUsuario) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNome(novoUsuario.getNome());
            usuario.setEmail(novoUsuario.getEmail());
            usuario.setSenhaHash(novoUsuario.getSenhaHash());
            return usuarioRepository.save(usuario);
        }).orElse(null);
    }

    // DELETE
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
