package br.com.sistemaproj.controleprojetos.controller;

import br.com.sistemaproj.controleprojetos.dto.DadosProjetoDTO;
import br.com.sistemaproj.controleprojetos.dto.FuncionarioDTO;
import br.com.sistemaproj.controleprojetos.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(@RequestBody FuncionarioDTO dto) {
        funcionarioService.adicionar(dto);
    }

    @GetMapping("/{idFuncionario}/projetos")
    public List<DadosProjetoDTO> buscarProjetos(@PathVariable Integer idFuncionario) {
        return funcionarioService.buscarProjetos(idFuncionario);
    }
}
