package mx.com.pruebarsg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.com.pruebarsg.entity.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

    @Query(value = "select count(*)  from usuario where mail=?1",nativeQuery = true)
    int checkUser(String user);
    @Query("SELECT u FROM Usuario u WHERE u.mail = ?1")
	public Usuario findByEmail(String mail);

    @Query(value = "select *  from usuario ",nativeQuery = true)
    List<Usuario>mostraUsuario();
    
}
