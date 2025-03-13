package com.emerson.usuario.business; // Define o pacote onde essa classe está localizada

// Importação do repositório responsável pelo acesso aos dados dos usuários

import com.emerson.usuario.business.converter.UsuarioConverter;
import com.emerson.usuario.business.dto.EnderecoDTO;
import com.emerson.usuario.business.dto.TelefoneDTO;
import com.emerson.usuario.business.dto.UsuarioDTO;
import com.emerson.usuario.infrastructure.entity.Endereco;
import com.emerson.usuario.infrastructure.entity.Telefone;
import com.emerson.usuario.infrastructure.entity.Usuario;
import com.emerson.usuario.infrastructure.exceptions.ConflictException;
import com.emerson.usuario.infrastructure.exceptions.ResourceNotFoundException;
import com.emerson.usuario.infrastructure.repository.EnderecoRepository;
import com.emerson.usuario.infrastructure.repository.TelefoneRepository;
import com.emerson.usuario.infrastructure.repository.UsuarioRepository;
import com.emerson.usuario.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service // Indica que essa classe é um serviço gerenciado pelo Spring (Service Layer)
@RequiredArgsConstructor // Gera automaticamente um construtor com os atributos marcados como "final"
public class UsuarioService { // Declaração da classe UsuarioService (responsável pela lógica de negócio do usuário)

    private final UsuarioRepository usuarioRepository; // Repositório que faz a comunicação com o banco de dados
    private final UsuarioConverter usuarioConverter;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final EnderecoRepository enderecoRepository;
    private final TelefoneRepository telefoneRepository;





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

    public UsuarioDTO atualizaDadosUsuario(String token, UsuarioDTO dto){

        String email = jwtUtil.extrairEmailTOken(token.substring(7));

        dto.setSenha(dto.getSenha() != null ? passwordEncoder.encode(dto.getSenha()) : null);

        Usuario usuarioEntity = usuarioRepository.findByEmail(email).orElseThrow(() ->
                new ResourceNotFoundException("Email não localizado"));

        Usuario usuario = usuarioConverter.updateUsuario(dto, usuarioEntity);

        return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));
        
    }

    public EnderecoDTO atualizaEndereco(long idEndereco, EnderecoDTO enderecoDTO){

        Object entity;
        entity = enderecoRepository.findById(idEndereco) .orElseThrow(() ->
                new ResourceNotFoundException("Id não encontrado " + idEndereco));

        Endereco endereco = usuarioConverter.updateEndereco(enderecoDTO, (Endereco) entity);

        return usuarioConverter.paraEnderecoDTO(enderecoRepository.save(endereco));
    }

    public TelefoneDTO atualizaTelefone(long idTelefone, TelefoneDTO telefoneDTO){

        Telefone entity = telefoneRepository.findById(idTelefone) .orElseThrow(() ->
                new ResourceNotFoundException("Id não encontrado " + idTelefone));

        Telefone telefone = usuarioConverter.updateTelefone(telefoneDTO, entity);

        return usuarioConverter.paraTelefoneDTO(telefoneRepository.save(telefone));

    }


}
