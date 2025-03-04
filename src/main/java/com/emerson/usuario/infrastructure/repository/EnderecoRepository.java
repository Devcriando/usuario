package com.emerson.usuario.infrastructure.repository; // Define o pacote onde essa interface está localizada

// Importação do JpaRepository para fornecer métodos padrão de acesso a dados de forma simplificada
import com.emerson.usuario.infrastructure.entity.Endereco;
// Importação da anotação Repository para indicar que essa interface é um repositório do Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface responsável pela manipulação dos dados de Endereço no banco de dados.
 * Extende o JpaRepository, o que proporciona métodos prontos para operações como salvar, deletar e consultar
 * registros da entidade Endereco no banco de dados.
 *
 * A anotação @Repository indica que essa interface é um componente do Spring,
 * que será responsável por interagir com o banco de dados.
 */
@Repository // Anotação que indica que a interface é um repositório de dados
public interface EnderecoRepository extends JpaRepository<Endereco, String> {
    // O JpaRepository fornece métodos para realizar operações CRUD (Create, Read, Update, Delete)
    // na tabela de Endereços, sem precisar escrever as implementações.
    // O Endereco é o tipo de entidade que será manipulado, e o "String" é o tipo do identificador (ID) da entidade.
}
