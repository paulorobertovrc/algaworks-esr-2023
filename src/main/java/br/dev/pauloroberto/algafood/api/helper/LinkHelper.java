package br.dev.pauloroberto.algafood.api.helper;

import br.dev.pauloroberto.algafood.api.controller.*;
import org.springframework.hateoas.*;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class LinkHelper {
    public static final TemplateVariables PAGE_VARIABLES = new TemplateVariables(
            new TemplateVariable("page", TemplateVariable.VariableType.REQUEST_PARAM),
            new TemplateVariable("size", TemplateVariable.VariableType.REQUEST_PARAM),
            new TemplateVariable("sort", TemplateVariable.VariableType.REQUEST_PARAM));

    public static final TemplateVariables FILTER_VARIABLES = new TemplateVariables(
                new TemplateVariable("clienteId", TemplateVariable.VariableType.REQUEST_PARAM),
                new TemplateVariable("restauranteId", TemplateVariable.VariableType.REQUEST_PARAM),
                new TemplateVariable("dataCriacaoInicio", TemplateVariable.VariableType.REQUEST_PARAM),
                new TemplateVariable("dataCriacaoFim", TemplateVariable.VariableType.REQUEST_PARAM));

    public Link linkToPedido(String codigo, String rel) {
        return linkTo(methodOn(PedidoController.class).buscar(codigo)).withRel(rel);
    }

    public Link linkToPedido(String codigo) {
        return linkToPedido(codigo, IanaLinkRelations.SELF.value());
    }

    public Link linkToPedidos() {
        return Link.of(UriTemplate.of(String.valueOf(linkTo(PedidoController.class).toUri()),
                PAGE_VARIABLES.concat(FILTER_VARIABLES)), "pedidos");
    }

    public Link linkToRestaurante(Long restauranteId, String rel) {
        return linkTo(methodOn(RestauranteController.class).buscar(restauranteId)).withRel(rel);
    }

    public Link linkToRestaurante(Long restauranteId) {
        return linkToRestaurante(restauranteId, IanaLinkRelations.SELF.value());
    }

    public Link linkToUsuario(Long usuarioId, String rel) {
        return linkTo(methodOn(UsuarioController.class).buscar(usuarioId)).withRel(rel);
    }

    public Link linkToUsuario(Long usuarioId) {
        return linkToUsuario(usuarioId, IanaLinkRelations.SELF.value());
    }

    public Link linkToUsuarios(String rel) {
        return linkTo(UsuarioController.class).withRel(rel);
    }

    public Link linkToUsuarios() {
        return linkToUsuarios(IanaLinkRelations.SELF.value());
    }

    public Link linkToGruposUsuario(Long usuarioId, String rel) {
        return linkTo(methodOn(UsuarioGrupoController.class).listar(usuarioId)).withRel(rel);
    }

    public Link linkToGruposUsuario(Long usuarioId) {
        return linkToGruposUsuario(usuarioId, IanaLinkRelations.SELF.value());
    }

    public Link linkToResponsaveisRestaurante(Long restauranteId, String rel) {
        return linkTo(methodOn(RestauranteUsuarioResponsavelController.class).listar(restauranteId)).withRel(rel);
    }

    public Link linkToResponsaveisRestaurante(Long restauranteId) {
        return linkToResponsaveisRestaurante(restauranteId, IanaLinkRelations.SELF.value());
    }

    public Link linkToFormasPagamento(Long formaPagamentoId, String rel) {
        return linkTo(methodOn(FormaPagamentoController.class).buscar(formaPagamentoId, null)).withRel(rel);
    }

    public Link linkToFormasPagamento(Long formaPagamentoId) {
        return linkToFormasPagamento(formaPagamentoId, IanaLinkRelations.SELF.value());
    }

    public Link linkToCidade(Long cidadeId, String rel) {
        return linkTo(methodOn(CidadeController.class).buscar(cidadeId)).withRel(rel);
    }

    public Link linkToCidade(Long cidadeId) {
        return linkToCidade(cidadeId, IanaLinkRelations.SELF.value());
    }

    public Link linkToCidades(String rel) {
        return linkTo(CidadeController.class).withRel(rel);
    }

    public Link linkToEstado(Long estadoId, String rel) {
        return linkTo(methodOn(EstadoController.class).buscar(estadoId)).withRel(rel);
    }

    public Link linkToEstado(Long estadoId) {
        return linkToEstado(estadoId, IanaLinkRelations.SELF.value());
    }

    public Link linkToEstados(String rel) {
        return linkTo(EstadoController.class).withRel(rel);
    }

    public Link linkToEstados() {
        return linkToEstados(IanaLinkRelations.SELF.value());
    }

    public Link linkToProduto(Long restauranteId, Long produtoId, String rel) {
        return linkTo(methodOn(RestauranteProdutoController.class)
                .buscar(restauranteId, produtoId)).withRel(rel);
    }

    public Link linkToProduto(Long restauranteId, Long produtoId) {
        return linkToProduto(restauranteId, produtoId, IanaLinkRelations.SELF.value());
    }

    public Link linkToCozinhas(String rel) {
        return linkTo(CozinhaController.class).withRel(rel);
    }

    public Link linkToCozinhas() {
        return linkToCozinhas(IanaLinkRelations.SELF.value());
    }

    public Link linkToCozinha(Long cozinhaId, String rel) {
        return linkTo(methodOn(CozinhaController.class).buscar(cozinhaId)).withRel(rel);
    }

    public Link linkToCozinha(Long cozinhaId) {
        return linkToCozinha(cozinhaId, IanaLinkRelations.SELF.value());
    }

}
