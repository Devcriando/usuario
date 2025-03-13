package com.emerson.usuario.controller;

import com.emerson.usuario.business.UsuarioService;
import com.emerson.usuario.business.dto.EnderecoDTO;
import com.emerson.usuario.business.dto.TelefoneDTO;
import com.emerson.usuario.business.dto.UsuarioDTO;
import com.emerson.usuario.infrastructure.entity.Usuario;
import com.emerson.usuario.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    // Método para salvar o usuário
    @PostMapping
    public ResponseEntity<UsuarioDTO> salvaUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuarioDTO));
    }

    // Método para login
    @PostMapping("/login")
    public String login(@RequestBody UsuarioDTO usuarioDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioDto.getEmail(), usuarioDto.getSenha())
        );
        return "Bearer " + jwtUtil.generateToken(authentication.getName());
    }

    // Buscar usuário por email
    @GetMapping
    public ResponseEntity<Usuario> buscaUsuarioPorEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    // Deletar usuário por email
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deletaUsuarioPorEmail(@PathVariable String email) {
        usuarioService.deletaUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    // Atualizar dados do usuário
    @PutMapping
    public ResponseEntity<UsuarioDTO> atualizaDadosDoUsuario(@RequestBody UsuarioDTO dto,
                                                             @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(usuarioService.atualizaDadosUsuario(token, dto));
    }

    // Atualizar endereço do usuário
    @PutMapping("/endereco/{id}")
    public ResponseEntity<EnderecoDTO> atualizaEndereco(@RequestBody EnderecoDTO dto,
                                                        @PathVariable("id") long id) {
        return ResponseEntity.ok(usuarioService.atualizaEndereco(id, dto)); // Chama o método específico para atualizar o endereço
    }

    // Atualizar telefone do usuário
    @PutMapping("/telefone/{id}")
    public ResponseEntity<TelefoneDTO> atualizaTelefone(@RequestBody TelefoneDTO dto,
                                                        @PathVariable("id") long id) {
        return ResponseEntity.ok(usuarioService.atualizaTelefone(id, dto)); // Chama o método específico para atualizar o telefone
    }
}
