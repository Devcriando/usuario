package com.emerson.usuario.infrastructure.repository; // Define o pacote onde essa interface está localizada

// Importação da classe Telefone que representa a entidade de telefone no banco de dados
import com.emerson.usuario.infrastructure.entity.Telefone;
// Importação do JpaRepository para fornecer os métodos padrão de acesso a dados
import org.springframework.data.jpa.repository.JpaRepository;
// Importação da anotação Repository para marcar a interface como um repositório do Spring
import org.springframework.stereotype.Repository;

/**
 * Interface responsável pela manipulação dos dados de Telefone no banco de dados.
 * Estende JpaRepository, o que proporciona métodos prontos para operações como salvar, deletar e consultar
 * registros da entidade Telefone no banco de dados.
 *
 * A anotação @Repository indica que essa interface é um repositório do Spring Data JPA,
 * responsável por interagir com o banco de dados para a entidade Telefone.
 */
@Repository // Anotação que marca a interface como um repositório de dados para o Spring
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    // O JpaRepository fornece métodos para realizar operações CRUD (Create, Read, Update, Delete)
    // na tabela de Telefones, sem a necessidade de escrever a implementação desses métodos.
    // O Telefone é a entidade manipulada, e o "Long" é o tipo do identificador (ID) da entidade.
}
