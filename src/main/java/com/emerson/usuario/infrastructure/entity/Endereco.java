package com.emerson.usuario.infrastructure.entity; // Define o pacote onde essa classe está localizada

// Importação das anotações do Jakarta Persistence (para mapear a classe para a tabela do banco de dados)
import jakarta.persistence.*;
import lombok.*; // Importação do Lombok para reduzir código repetitivo

@Getter // Gera automaticamente os métodos "get" para todos os atributos da classe
@Setter // Gera automaticamente os métodos "set" para todos os atributos da classe
@AllArgsConstructor // Gera automaticamente um construtor com todos os atributos
@NoArgsConstructor // Gera automaticamente um construtor sem parâmetros
@Entity // Indica que essa classe é uma entidade JPA, ou seja, mapeada para uma tabela no banco de dados
@Table(name = "endereco") // Define o nome da tabela no banco de dados que essa entidade mapeia
@Builder // Permite usar o padrão Builder para criar objetos dessa classe
public class Endereco { // Declaração da classe Endereco, que representa um endereço de um usuário no banco de dados

    @Id // Indica que o atributo "id" é a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o valor do ID automaticamente no banco de dados
    private long id; // Atributo que representa o ID único de cada endereço

    @Column(name = "rua", length = 200) // Mapeia o atributo "rua" para a coluna "rua" na tabela, com um comprimento máximo de 200 caracteres
    private String rua; // Atributo que armazena o nome da rua

    @Column(name = "cep", length = 9) // Mapeia o atributo "cep" para a coluna "cep", com um comprimento máximo de 9 caracteres
    private String cep; // Atributo que armazena o código postal (CEP)

    @Column(name = "numero", length = 5) // Mapeia o atributo "numero" para a coluna "numero", com um comprimento máximo de 5 caracteres
    private long numero; // Atributo que armazena o número do endereço (ex: 123)

    @Column(name = "bairro", length = 50) // Mapeia o atributo "bairro" para a coluna "bairro", com um comprimento máximo de 50 caracteres
    private String bairro; // Atributo que armazena o bairro do endereço

    @Column(name = "cidade", length = 150) // Mapeia o atributo "cidade" para a coluna "cidade", com um comprimento máximo de 150 caracteres
    private String cidade; // Atributo que armazena o nome da cidade

    @Column(name = "estado", length = 2) // Mapeia o atributo "estado" para a coluna "estado", com um comprimento máximo de 2 caracteres (ex: SP, RJ)
    private String estado; // Atributo que armazena o nome do estado (sigla)

    @Column(name = "complemento", length = 15) // Mapeia o atributo "complemento" para a coluna "complemento", com um comprimento máximo de 15 caracteres
    private String complemento; // Atributo que armazena o complemento do endereço (ex: apartamento, bloco)
}
