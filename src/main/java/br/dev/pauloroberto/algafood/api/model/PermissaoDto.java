package br.dev.pauloroberto.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Setter
@Getter
@Relation(collectionRelation = "permissoes")
public class PermissaoDto extends RepresentationModel<PermissaoDto> {
    @ApiModelProperty(example = "1")
    private Long id;

    @ApiModelProperty(example = "CONSULTAR_COZINHAS")
    private String nome;

    @ApiModelProperty(example = "Permite consultar cozinhas")
    private String descricao;
}
