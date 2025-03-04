package com.emerson.usuario.infrastructure.repository; // Define o pacote onde a interface está localizada

// Importação da classe Usuario, que representa a entidade de usuário no banco de dados

import com.emerson.usuario.infrastructure.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Interface que define um repositório para a entidade Usuario.
// Estende JpaRepository, o que significa que a interface já possui
// os métodos básicos de CRUD (Create, Read, Update, Delete) para operar na tabela de usuários.
@Repository // Marca a interface como um repositório Spring
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Verifica se já existe um usuário no banco de dados com o email fornecido.
     *
     * @param email O email a ser verificado.
     * @return true se um usuário com o email fornecido já existir, caso contrário false.
     */
    boolean existsByEmail(String email);

    /**
     * Busca um usuário no banco de dados pelo seu email.
     *
     * @param email O email do usuário a ser buscado.
     * @return Um objeto Optional contendo o usuário, ou vazio se não encontrado.
     */
    Optional<Usuario> findByEmail(String email);

    /**
     * Deleta o usuário do banco de dados com base no seu email.
     * A anotação @Transactional garante que essa operação seja realizada dentro de uma transação.
     *
     * @param email O email do usuário a ser deletado.
     */
    @Transactional // Indica que a operação de delete deve ser tratada como uma transação, garantindo consistência no banco de dados
    void deleteByEmail(String email);
}
