package br.com.sistemaproj.controleprojetos.service;

import br.com.sistemaproj.controleprojetos.dto.DadosProjetoDTO;
import br.com.sistemaproj.controleprojetos.dto.FuncionarioDTO;
import br.com.sistemaproj.controleprojetos.exception.RegraNegocioException;
import br.com.sistemaproj.controleprojetos.model.Funcionario;
import br.com.sistemaproj.controleprojetos.model.Setor;
import br.com.sistemaproj.controleprojetos.repository.FuncionarioRepository;
import br.com.sistemaproj.controleprojetos.repository.SetorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final SetorRepository setorRepository;

    @Override
    public void adicionar(FuncionarioDTO dto) {
        Setor setor = setorRepository.findById(dto.getIdSetor())
                .orElseThrow(() -> new RegraNegocioException("Setor não encontrado"));

        Funcionario f = new Funcionario(null, dto.getNome(), setor, null);
        funcionarioRepository.save(f);
    }

    @Override
public List<DadosProjetoDTO> buscarProjetos(Integer idFuncionario) {
    if (!funcionarioRepository.existsById(idFuncionario)) {
        throw new RegraNegocioException("Funcionário não encontrado");
    }

    return funcionarioRepository.buscarProjetosPorFuncionario(idFuncionario).stream()
            .map(p -> new DadosProjetoDTO(
                    p.getId(),
                    p.getDescricao(),
                    p.getDataInicio(),
                    p.getDataFim(),
                    p.getFuncionarios()))
            .collect(Collectors.toList());
}

}
