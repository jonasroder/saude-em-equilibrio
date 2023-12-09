package com.roderly.saude_em_equilibrio_ufu.login.repository;

import com.roderly.saude_em_equilibrio_ufu.login.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    UserDetails findByUsuario(String usuario);
}
