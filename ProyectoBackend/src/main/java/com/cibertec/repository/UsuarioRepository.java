package com.cibertec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	 Optional<Usuario> findByNombreUsuario(String nombreUsuario);
	    boolean existsByNombreUsuario(String nombreUsuario);
	    boolean existsByEmail(String email);
}