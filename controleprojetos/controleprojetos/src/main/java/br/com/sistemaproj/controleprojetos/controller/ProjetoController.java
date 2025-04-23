package br.com.sistemaproj.controleprojetos.controller;

import br.com.sistemaproj.controleprojetos.dto.DadosProjetoDTO;
import br.com.sistemaproj.controleprojetos.dto.ProjetoDTO;
import br.com.sistemaproj.controleprojetos.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService projetoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(@RequestBody ProjetoDTO dto) {
        projetoService.adicionar(dto);
    }

    @GetMapping("/{id}")
    public DadosProjetoDTO buscarProjetoPorId(@PathVariable Integer id) {
        return projetoService.buscarPorId(id);
    }

    @PutMapping("/{idProjeto}/vincular-funcionario/{idFuncionario}")
    public void vincularFuncionario(@PathVariable Integer idProjeto, @PathVariable Integer idFuncionario) {
        projetoService.vincularFuncionario(idProjeto, idFuncionario);
    }

    @GetMapping
    public List<DadosProjetoDTO> listarProjetos() {
        return projetoService.listarTodos();
    }
}
