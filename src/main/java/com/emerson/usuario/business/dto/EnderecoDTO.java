package com.emerson.usuario.business.dto; // Define o pacote onde essa classe está localizada

// Importação das anotações do Lombok para reduzir código repetitivo
import lombok.*;

@Getter // Gera automaticamente os métodos "get" para todos os atributos da classe
@Setter // Gera automaticamente os métodos "set" para todos os atributos da classe
@AllArgsConstructor // Gera automaticamente um construtor com todos os atributos
@NoArgsConstructor // Gera automaticamente um construtor sem parâmetros
@Builder // Permite usar o padrão Builder para criar objetos dessa classe

public class EnderecoDTO { // Declaração da classe EnderecoDTO (Data Transfer Object)

    private Long id;
    private String rua; // Armazena o nome da rua
    private String cep; // Armazena o CEP do endereço
    private Long numero; // Armazena o número da residência
    private String bairro; // Armazena o nome do bairro
    private String cidade; // Armazena o nome da cidade
    private String estado; // Armazena o nome do estado
    private String complemento; // Armazena informações adicionais do endereço (ex: apto, bloco, etc.)
}
