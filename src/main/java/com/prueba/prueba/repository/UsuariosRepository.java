package com.prueba.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.prueba.entity.Usuarios;
import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
	Optional<Usuarios> findByUsername(String username);
	long countByState(boolean state);
}
