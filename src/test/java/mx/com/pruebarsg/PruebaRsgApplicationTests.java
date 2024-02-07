package mx.com.pruebarsg;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mx.com.pruebarsg.entity.Usuario;
import mx.com.pruebarsg.repository.UsuarioRepository;

@SpringBootTest
class PruebaRsgApplicationTests {

	@Autowired
	private UsuarioRepository testUsuario;


	@Test
	void usuarioRepository() {

	List<Usuario> mostrar = testUsuario.mostraUsuario();
	assertNotNull(mostrar);
	
		


	}

}
