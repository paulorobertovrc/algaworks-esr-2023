package br.dev.pauloroberto.algafood.api.controller;

import br.dev.pauloroberto.algafood.api.assembler.PermissaoDomainObjectAssembler;
import br.dev.pauloroberto.algafood.api.assembler.PermissaoDtoAssembler;
import br.dev.pauloroberto.algafood.api.model.PermissaoDto;
import br.dev.pauloroberto.algafood.api.model.input.PermissaoInputDto;
import br.dev.pauloroberto.algafood.domain.exception.PermissaoNaoEncontradaException;
import br.dev.pauloroberto.algafood.domain.model.Permissao;
import br.dev.pauloroberto.algafood.domain.service.CadastroPermissaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/permissoes")
@Api(tags = "Permissões")
public class PermissaoController {
    @Autowired
    private CadastroPermissaoService cadastroPermissaoService;
    @Autowired
    private PermissaoDtoAssembler permissaoDtoAssembler;
    @Autowired
    private PermissaoDomainObjectAssembler permissaoDomainObjectAssembler;

    @GetMapping
    @ApiOperation("Lista as permissões")
    public List<PermissaoDto> listar() {
        return permissaoDtoAssembler.toDtoList(cadastroPermissaoService.listar());
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca uma permissão por ID")
    public PermissaoDto buscar(@PathVariable Long id) {
        return permissaoDtoAssembler.toDto(cadastroPermissaoService.verificarSeExiste(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Cadastra uma permissão")
    public PermissaoDto adicionar(@RequestBody @Valid PermissaoInputDto permissaoInput) {
        Permissao permissao = permissaoDomainObjectAssembler.toDomainObject(permissaoInput);

        return permissaoDtoAssembler.toDto(cadastroPermissaoService.salvar(permissao));
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualiza uma permissão")
    public PermissaoDto atualizar(@PathVariable Long id,
                                  @RequestBody @Valid PermissaoInputDto permissaoInput) {
        try {
            Permissao permissao = cadastroPermissaoService.verificarSeExiste(id);
            permissaoDomainObjectAssembler.copyToDomainObject(permissaoInput, permissao);

            return permissaoDtoAssembler.toDto(cadastroPermissaoService.salvar(permissao));
        } catch (Exception e) {
            throw new PermissaoNaoEncontradaException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Remove uma permissão")
    public void remover(@PathVariable Long id) {
        cadastroPermissaoService.remover(id);
    }

}
