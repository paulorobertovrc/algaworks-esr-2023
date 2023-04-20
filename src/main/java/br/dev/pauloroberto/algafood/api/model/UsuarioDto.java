package br.dev.pauloroberto.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {
    @ApiModelProperty(example = "1")
    private Long id;

    @ApiModelProperty(example = "Paulo Roberto")
    private String nome;

    @ApiModelProperty(example = "paulo@email.com")
    private String email;
}
