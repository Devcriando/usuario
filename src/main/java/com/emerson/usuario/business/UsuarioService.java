package com.emerson.usuario.business; // Define o pacote onde essa classe está localizada

// Importação do repositório responsável pelo acesso aos dados dos usuários

import com.emerson.usuario.business.converter.UsuarioConverter;
import com.emerson.usuario.business.dto.UsuarioDTO;
import com.emerson.usuario.infrastructure.entity.Usuario;
import com.emerson.usuario.infrastructure.exceptions.ConflictException;
import com.emerson.usuario.infrastructure.exceptions.ResourceNotFoundException;
import com.emerson.usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service // Indica que essa classe é um serviço gerenciado pelo Spring (Service Layer)
@RequiredArgsConstructor // Gera automaticamente um construtor com os atributos marcados como "final"
public class UsuarioService { // Declaração da classe UsuarioService (responsável pela lógica de negócio do usuário)

    private final UsuarioRepository usuarioRepository; // Repositório que faz a comunicação com o banco de dados
    private final UsuarioConverter usuarioConverter;
    private final PasswordEncoder passwordEncoder;



    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
        emailExiste(usuarioDTO.getEmail());
        usuarioDTO.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return usuarioConverter.paraUsuarioDTO(usuario);
    }

    public void emailExiste(String email){  // verifica se o e-mail já existe
        try {
            boolean existe = verificaEmailExistente(email);
            if(existe){
                throw new ConflictException("Email já cadastrado" + email);
            }
        }catch (ConflictException e){
            throw new ConflictException("Email já cadastrado" + e.getCause());
        }
    }

    public boolean verificaEmailExistente(String email) { // linhas chama o metodo na (repository)
        return usuarioRepository.existsByEmail(email);
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Email não encontrado" + email)
        );
    }
    public void deletaUsuarioPorEmail(String email){
        usuarioRepository.deleteByEmail(email);
    }


}
