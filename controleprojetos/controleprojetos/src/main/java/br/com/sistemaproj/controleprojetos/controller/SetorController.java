package br.com.sistemaproj.controleprojetos.controller;

import br.com.sistemaproj.controleprojetos.dto.DadosSetorDTO;
import br.com.sistemaproj.controleprojetos.dto.SetorDTO;
import br.com.sistemaproj.controleprojetos.service.SetorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/setores")
@RequiredArgsConstructor
public class SetorController {

    private final SetorService setorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(@RequestBody SetorDTO dto) {
        setorService.adicionar(dto);
    }

    @GetMapping("/{id}")
    public DadosSetorDTO buscarSetorPorId(@PathVariable Integer id) {
        return setorService.buscarPorId(id);
    }
}
