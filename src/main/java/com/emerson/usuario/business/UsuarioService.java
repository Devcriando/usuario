package com.emerson.usuario.business; // Define o pacote onde essa classe está localizada

// Importação do repositório responsável pelo acesso aos dados dos usuários
import com.emerson.usuario.business.converter.UsuarioConverter;
import com.emerson.usuario.business.dto.UsuarioDTO;
import com.emerson.usuario.infrastructure.entity.Usuario;
import com.emerson.usuario.infrastructure.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor; // Anotação do Lombok que gera um construtor com os atributos "final"
import org.springframework.stereotype.Service; // Define que essa classe é um serviço do Spring

@Service // Indica que essa classe é um serviço gerenciado pelo Spring (Service Layer)
@RequiredArgsConstructor // Gera automaticamente um construtor com os atributos marcados como "final"
public class UsuarioService { // Declaração da classe UsuarioService (responsável pela lógica de negócio do usuário)

    private final UsuarioRepository usuarioRepository; // Repositório que faz a comunicação com o banco de dados
    private final UsuarioConverter usuarioConverter;


    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return usuarioConverter.paraUsuarioDTO(usuario);
    }
}
