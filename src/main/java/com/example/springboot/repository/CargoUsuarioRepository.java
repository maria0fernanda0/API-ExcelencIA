package com.example.springboot.repository;

import com.example.springboot.model.CargoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoUsuarioRepository extends JpaRepository<CargoUsuario,Long> {


}
