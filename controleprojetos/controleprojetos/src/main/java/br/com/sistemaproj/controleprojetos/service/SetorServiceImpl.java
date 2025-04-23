package br.com.sistemaproj.controleprojetos.service;

import br.com.sistemaproj.controleprojetos.dto.DadosSetorDTO;
import br.com.sistemaproj.controleprojetos.dto.SetorDTO;
import br.com.sistemaproj.controleprojetos.exception.RegraNegocioException;
import br.com.sistemaproj.controleprojetos.model.Setor;
import br.com.sistemaproj.controleprojetos.repository.SetorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SetorServiceImpl implements SetorService {

    private final SetorRepository setorRepository;

    @Override
    public void adicionar(SetorDTO dto) {
        Setor s = new Setor(null, dto.getNome(), null);
        setorRepository.save(s);
    }

    @Override
    public DadosSetorDTO buscarPorId(Integer id) {
        Setor s = setorRepository.buscarSetorComFuncionarios(id);
        if (s == null) throw new RegraNegocioException("Setor não encontrado");

        return DadosSetorDTO.builder()
                .id(s.getId())
                .nome(s.getNome())
                .funcionarios(s.getFuncionarios())
                .build();
    }
}
