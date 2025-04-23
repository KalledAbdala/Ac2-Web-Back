package br.com.sistemaproj.controleprojetos.service;

import br.com.sistemaproj.controleprojetos.dto.DadosProjetoDTO;
import br.com.sistemaproj.controleprojetos.dto.ProjetoDTO;
import br.com.sistemaproj.controleprojetos.exception.RegraNegocioException;
import br.com.sistemaproj.controleprojetos.model.Funcionario;
import br.com.sistemaproj.controleprojetos.model.Projeto;
import br.com.sistemaproj.controleprojetos.repository.FuncionarioRepository;
import br.com.sistemaproj.controleprojetos.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetoServiceImpl implements ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final FuncionarioRepository funcionarioRepository;

    @Override
    public void adicionar(ProjetoDTO dto) {
        Projeto projeto = new Projeto(null, dto.getDescricao(), dto.getDataInicio(), dto.getDataFim(), new ArrayList<>());
        projetoRepository.save(projeto);
    }

    @Override
    public DadosProjetoDTO buscarPorId(Integer id) {
        Projeto p = projetoRepository.buscarProjetoComFuncionarios(id);
        if (p == null) throw new RegraNegocioException("Projeto não encontrado");
        return new DadosProjetoDTO(p.getId(), p.getDescricao(), p.getDataInicio(), p.getDataFim(), p.getFuncionarios());
    }

    @Override
    public void vincularFuncionario(Integer idProjeto, Integer idFuncionario) {
        Projeto projeto = projetoRepository.findById(idProjeto)
                .orElseThrow(() -> new RegraNegocioException("Projeto não encontrado"));

        Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
                .orElseThrow(() -> new RegraNegocioException("Funcionário não encontrado"));

        projeto.getFuncionarios().add(funcionario);
        projetoRepository.save(projeto);
    }

    @Override
    public List<DadosProjetoDTO> listarTodos() {
        List<Projeto> projetos = projetoRepository.findAll();
        return projetos.stream().map(p ->
            new DadosProjetoDTO(p.getId(), p.getDescricao(), p.getDataInicio(), p.getDataFim(), p.getFuncionarios())
        ).toList();
    }
}
