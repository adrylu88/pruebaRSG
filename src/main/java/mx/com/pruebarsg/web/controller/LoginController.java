package mx.com.pruebarsg.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    @GetMapping({ "/", "/login" })
	public String ingresar() {
		return "login";
	}

	@GetMapping("/home")
	public String pantallaPrincipal(Model model) {

		return "index";
	}

	@GetMapping("/logout")
	public String cerrarSesion() {
		System.out.println("Controlador Login");
		return "redirect:/";
	}
}
