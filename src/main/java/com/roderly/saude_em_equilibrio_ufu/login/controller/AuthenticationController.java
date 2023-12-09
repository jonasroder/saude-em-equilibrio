package com.roderly.saude_em_equilibrio_ufu.login.controller;


import com.roderly.saude_em_equilibrio_ufu.infra.security.TokenService;
import com.roderly.saude_em_equilibrio_ufu.login.dto.AuthenticationDTO;
import com.roderly.saude_em_equilibrio_ufu.login.dto.LoginResponseDTO;
import com.roderly.saude_em_equilibrio_ufu.login.dto.RegisterDTO;
import com.roderly.saude_em_equilibrio_ufu.login.model.UsuarioModel;
import com.roderly.saude_em_equilibrio_ufu.login.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.usuario(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UsuarioModel) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));

    }

    @PostMapping("/register")
    public ResponseEntity register (@RequestBody @Valid RegisterDTO data) {

        if(this.repository.findByUsuario(data.usuario()) != null) return ResponseEntity.badRequest().body("Nome de Usuário Não Disponível!");

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        UsuarioModel novoUsuraio = new UsuarioModel(data.id_pessoa(), data.usuario(), encryptedPassword, data.id_situacao());

        this.repository.save(novoUsuraio);

        return ResponseEntity.ok().build();
    }


}
