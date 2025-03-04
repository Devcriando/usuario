package com.emerson.usuario.business.converter; // Define o pacote onde essa classe está localizada

// Importação das classes DTO (Data Transfer Object), que representam os dados que vêm da camada de negócios
import com.emerson.usuario.business.dto.EnderecoDTO;
import com.emerson.usuario.business.dto.TelefoneDTO;
import com.emerson.usuario.business.dto.UsuarioDTO;

// Importação das classes de entidade, que representam os dados no banco de dados
import com.emerson.usuario.infrastructure.entity.Endereco;
import com.emerson.usuario.infrastructure.entity.Telefone;
import com.emerson.usuario.infrastructure.entity.Usuario;

// Importação do Spring, tornando essa classe um componente gerenciado pelo Spring
import org.springframework.stereotype.Component;

import java.util.List; // Importação da classe List para trabalhar com listas de objetos

@Component // Indica que essa classe será gerenciada pelo Spring como um "Bean"
public class UsuarioConverter { // Declaração da classe responsável por converter DTOs para entidades

    public Usuario paraUsuario(UsuarioDTO usuarioDTO){ // Método que converte um UsuarioDTO para um Usuario (entidade do banco)
        return Usuario.builder() // Usa o padrão Builder para criar um objeto Usuario
                .nome(usuarioDTO.getNome()) // Define o nome do usuário com o valor do DTO
                .email(usuarioDTO.getEmail()) // Define o email do usuário com o valor do DTO
                .senha(usuarioDTO.getSenha()) // Define a senha do usuário com o valor do DTO
                .enderecos(paraListaEndereco(usuarioDTO.getEndereco())) // Converte e define a lista de endereços do usuário
                .telefones(paraListaTelefones(usuarioDTO.getTelefone())) // Converte e define a lista de telefones do usuário
                .build(); // Finaliza a criação do objeto Usuario
    }

    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTOS){ // Método que converte uma lista de EnderecoDTO para uma lista de Endereco
        return enderecoDTOS.stream() // Inicia um fluxo (stream) de elementos da lista
                .map(this::paraEndereco) // Para cada elemento da lista, chama o método `paraEndereco`
                .toList(); // Converte o fluxo de dados de volta para uma lista
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO) { // Método que converte um EnderecoDTO para um Endereco (entidade do banco)
        return Endereco.builder() // Usa o padrão Builder para criar um objeto Endereco
                .rua(enderecoDTO.getRua()) // Define a rua com o valor do DTO
                .numero(enderecoDTO.getNumero()) // Define o número com o valor do DTO
                .bairro(enderecoDTO.getBairro()) // Define o bairro com o valor do DTO
                .complemento(enderecoDTO.getComplemento()) // Define o complemento com o valor do DTO
                .cep(enderecoDTO.getCep()) // Define o CEP com o valor do DTO
                .cidade(enderecoDTO.getCidade()) // Define a cidade com o valor do DTO
                .estado(enderecoDTO.getEstado()) // Define o estado com o valor do DTO
                .build(); // Finaliza a criação do objeto Endereco
    }

    public List<Telefone> paraListaTelefones(List<TelefoneDTO> telefoneDTOS) { // Método que converte uma lista de TelefoneDTO para uma lista de Telefone
        return telefoneDTOS.stream() // Inicia um fluxo (stream) de elementos da lista
                .map(this::paraTelefone) // Para cada elemento da lista, chama o método `paraTelefone`
                .toList(); // Converte o fluxo de dados de volta para uma lista
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO){ // Método que converte um TelefoneDTO para um Telefone (entidade do banco)
        return Telefone.builder() // Usa o padrão Builder para criar um objeto Telefone
                .numero(telefoneDTO.getNumero()) // Define o número de telefone com o valor do DTO
                .ddd(telefoneDTO.getDdd()) // Define o código de área (DDD) com o valor do DTO
                .build(); // Finaliza a criação do objeto Telefone
    }
    //
    public UsuarioDTO paraUsuarioDTO(Usuario usuarioDTO){ // Método que converte um UsuarioDTO para um Usuario (entidade do banco)
        return UsuarioDTO.builder() // Usa o padrão Builder para criar um objeto Usuario
                .nome(usuarioDTO.getNome()) // Define o nome do usuário com o valor do DTO
                .email(usuarioDTO.getEmail()) // Define o email do usuário com o valor do DTO
                .senha(usuarioDTO.getSenha()) // Define a senha do usuário com o valor do DTO
                .endereco(paraListaEnderecoDTO(usuarioDTO.getEnderecos())) // Converte e define a lista de endereços do usuário
                .telefone(paraListaTelefonesDTO(usuarioDTO.getTelefones())) // Converte e define a lista de telefones do usuário
                .build(); // Finaliza a criação do objeto Usuario
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecoDTOS){ // Método que converte uma lista de EnderecoDTO para uma lista de Endereco
        return enderecoDTOS.stream() // Inicia um fluxo (stream) de elementos da lista
                .map(this::paraEnderecoDTO) // Para cada elemento da lista, chama o método `paraEndereco`
                .toList(); // Converte o fluxo de dados de volta para uma lista
    }

    public EnderecoDTO paraEnderecoDTO(Endereco enderecoDTO) { // Método que converte um EnderecoDTO para um Endereco (entidade do banco)
        return EnderecoDTO.builder() // Usa o padrão Builder para criar um objeto Endereco
                .rua(enderecoDTO.getRua()) // Define a rua com o valor do DTO
                .numero(enderecoDTO.getNumero()) // Define o número com o valor do DTO
                .bairro(enderecoDTO.getBairro()) // Define o bairro com o valor do DTO
                .complemento(enderecoDTO.getComplemento()) // Define o complemento com o valor do DTO
                .cep(enderecoDTO.getCep()) // Define o CEP com o valor do DTO
                .cidade(enderecoDTO.getCidade()) // Define a cidade com o valor do DTO
                .estado(enderecoDTO.getEstado()) // Define o estado com o valor do DTO
                .build(); // Finaliza a criação do objeto Endereco
    }

    public List<TelefoneDTO> paraListaTelefonesDTO(List<Telefone> telefoneDTOS) { // Método que converte uma lista de TelefoneDTO para uma lista de Telefone
        return telefoneDTOS.stream() // Inicia um fluxo (stream) de elementos da lista
                .map(this::paraTelefoneDTO) // Para cada elemento da lista, chama o método `paraTelefone`
                .toList(); // Converte o fluxo de dados de volta para uma lista
    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefoneDTO){ // Método que converte um TelefoneDTO para um Telefone (entidade do banco)
        return TelefoneDTO.builder() // Usa o padrão Builder para criar um objeto Telefone
                .numero(telefoneDTO.getNumero()) // Define o número de telefone com o valor do DTO
                .ddd(telefoneDTO.getDdd()) // Define o código de área (DDD) com o valor do DTO
                .build(); // Finaliza a criação do objeto Telefone
    }
}

