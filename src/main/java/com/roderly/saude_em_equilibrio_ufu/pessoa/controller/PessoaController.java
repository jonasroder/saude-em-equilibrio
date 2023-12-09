package com.roderly.saude_em_equilibrio_ufu.pessoa.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @PostMapping("/teste")
    public String testarConexao() {
        return "Requisição do back-end OK";
    }


}
