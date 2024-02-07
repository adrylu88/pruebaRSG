package mx.com.pruebarsg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mx.com.pruebarsg.entity.Rol;
import mx.com.pruebarsg.entity.Usuario;
import mx.com.pruebarsg.repository.RolRepository;
import mx.com.pruebarsg.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
	private UsuarioRepository usuarioRepositorio;
	
	@Autowired RolRepository rolRepositorio;
	
	@Autowired PasswordEncoder passwordEncoder;
	
	public void registerDefaultUser(Usuario usuario) {
		Rol roleUser = rolRepositorio.findByNombre("Usuario");
		usuario.addRole(roleUser);
		encodePassword(usuario);
		usuarioRepositorio.save(usuario);
	}
	
	public List<Usuario> listAll() {
		return usuarioRepositorio.findAll();
	}

	public Usuario get(Long id) {
		return usuarioRepositorio.findById(id).get();
	}
	
	public List<Rol> listRoles() {
		return rolRepositorio.findAll();
	}
	
	public void save(Usuario usuario) {
		encodePassword(usuario);		
		usuarioRepositorio.save(usuario);
	}
	
	private void encodePassword(Usuario usuario) {
		String encodedPassword = passwordEncoder.encode(usuario.getPassword());
		usuario.setPassword(encodedPassword);		
	}
    
}
