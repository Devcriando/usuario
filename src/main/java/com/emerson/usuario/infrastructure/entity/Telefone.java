package com.emerson.usuario.infrastructure.entity; // Define o pacote onde essa classe está localizada

// Importação das anotações do Jakarta Persistence (para mapear a classe para a tabela do banco de dados)
import jakarta.persistence.*;
import lombok.*; // Importação do Lombok para reduzir código repetitivo

@Getter // Gera automaticamente os métodos "get" para todos os atributos da classe
@Setter // Gera automaticamente os métodos "set" para todos os atributos da classe
@AllArgsConstructor // Gera automaticamente um construtor com todos os atributos
@NoArgsConstructor // Gera automaticamente um construtor sem parâmetros
@Entity // Indica que essa classe é uma entidade JPA, ou seja, mapeada para uma tabela no banco de dados
@Table(name = "telefone") // Define o nome da tabela no banco de dados que essa entidade mapeia
@Builder // Permite usar o padrão Builder para criar objetos dessa classe
public class Telefone { // Declaração da classe Telefone, que representa um telefone de um usuário no banco de dados

    @Id // Indica que o atributo "id" é a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o valor do ID automaticamente no banco de dados
    private long id; // Atributo que representa o ID único de cada telefone

    @Column(name = "numero", length = 10) // Mapeia o atributo "numero" para a coluna "numero", com um comprimento máximo de 10 caracteres
    private String numero; // Atributo que armazena o número do telefone

    @Column(name = "ddd", length = 3) // Mapeia o atributo "ddd" para a coluna "ddd", com um comprimento máximo de 3 caracteres
    private String ddd; // Atributo que armazena o DDD do telefone (ex: 11, 21)
}
