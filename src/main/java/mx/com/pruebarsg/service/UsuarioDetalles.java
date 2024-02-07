package mx.com.pruebarsg.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import mx.com.pruebarsg.entity.Rol;
import mx.com.pruebarsg.entity.Usuario;

public class UsuarioDetalles implements UserDetails{
    
    private static final long serialVersionUID = 1L;
	private Usuario usuario;
	
	public UsuarioDetalles(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Rol> roles = usuario.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Rol rol : roles) {
            authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
         
        return authorities;
	}
	

	@Override
	public String getPassword() {
		return usuario.getPassword();
	}

	@Override
	public String getUsername() {
		return usuario.getMail();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public String getFullName() {
		return usuario.getNombre() + " " + usuario.getApellidop();
	}

	public String getUserName() {
		return usuario.getMail();
	}


	public boolean hasRole(String roleName) {
        return this.usuario.hasRole(roleName);
    }
}
