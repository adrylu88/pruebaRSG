package mx.com.pruebarsg.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mx.com.pruebarsg.entity.Usuario;
import mx.com.pruebarsg.repository.UsuarioRepository;
import mx.com.pruebarsg.service.UsuarioDetalles;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
	private UsuarioRepository usuarioRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByEmail(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		return new UsuarioDetalles(usuario);
	}
    
}
