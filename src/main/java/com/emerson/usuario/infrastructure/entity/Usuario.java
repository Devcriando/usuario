package com.emerson.usuario.infrastructure.entity; // Define o pacote onde essa classe está localizada

// Importação das anotações do Jakarta Persistence para mapear a classe para a tabela no banco de dados
import jakarta.persistence.*;
// Importação das anotações do Lombok para reduzir código repetitivo
import lombok.*;
// Importação das interfaces do Spring Security para autenticação e controle de usuários
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Classe de entidade que representa um usuário no sistema.
 * A classe também implementa a interface UserDetails do Spring Security,
 * permitindo que o usuário seja autenticado e tenha seu gerenciamento feito pelo sistema de segurança.
 *
 * Ela contém informações como nome, email, senha e listas de endereços e telefones associados ao usuário.
 * O uso de @Entity e @Table mapeia esta classe para uma tabela de banco de dados chamada "usuario".
 * A classe permite o gerenciamento de dados do usuário na aplicação, incluindo suas credenciais e detalhes de contato.
 */
@Getter // Gera automaticamente os métodos "get" para todos os atributos da classe
@Setter // Gera automaticamente os métodos "set" para todos os atributos da classe
@AllArgsConstructor // Gera automaticamente um construtor com todos os atributos
@NoArgsConstructor // Gera automaticamente um construtor sem parâmetros
@Entity // Indica que essa classe é uma entidade JPA, mapeada para uma tabela do banco de dados
@Table(name = "usuario") // Define o nome da tabela no banco de dados para esta entidade
@Builder // Permite o uso do padrão Builder para criar objetos dessa classe
public class Usuario implements UserDetails { // A classe Usuario implementa a interface UserDetails para integração com o Spring Security

    @Id // Indica que o atributo "id" é a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera automaticamente o valor do ID no banco de dados
    private long id; // Atributo que representa o ID único do usuário na tabela

    @Column(name = "nome", length = 100) // Mapeia o atributo "nome" para a coluna "nome", com comprimento máximo de 100 caracteres
    private String nome; // Atributo que armazena o nome do usuário

    @Column(name = "email", length = 100) // Mapeia o atributo "email" para a coluna "email", com comprimento máximo de 100 caracteres
    private String email; // Atributo que armazena o e-mail do usuário

    @Column(name = "senha") // Mapeia o atributo "senha" para a coluna "senha"
    private String senha; // Atributo que armazena a senha do usuário

    // Relacionamento OneToMany com a classe Endereco
    @OneToMany(cascade = CascadeType.ALL) // Indica que cada usuário pode ter múltiplos endereços
    @JoinColumn(name = "usuario.id", referencedColumnName = "id") // Define a chave estrangeira para o relacionamento
    private List<Endereco> enderecos; // Lista de endereços do usuário

    // Relacionamento OneToMany com a classe Telefone
    @OneToMany(cascade = CascadeType.ALL) // Indica que cada usuário pode ter múltiplos telefones
    @JoinColumn(name = "usuario.id", referencedColumnName = "id") // Define a chave estrangeira para o relacionamento
    private List<Telefone> telefones; // Lista de telefones do usuário

    // Métodos implementados da interface UserDetails para integração com o Spring Security

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(); // Retorna uma lista vazia de autoridades (sem permissões atribuídas ao usuário, pode ser expandido conforme necessidade)
    }

    @Override
    public String getPassword() {
        return senha; // Retorna a senha do usuário, que será usada na autenticação
    }

    @Override
    public String getUsername() {
        return email; // Retorna o e-mail do usuário, que será usado como nome de usuário na autenticação
    }
}
