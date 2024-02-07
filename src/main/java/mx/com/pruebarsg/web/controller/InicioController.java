package mx.com.pruebarsg.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import mx.com.pruebarsg.entity.Transferencia;
import mx.com.pruebarsg.service.BalanceTranferenciasService;

@Controller
public class InicioController {

    @Autowired
    private BalanceTranferenciasService currentBalance;

    @GetMapping("/pagina_principal")
    public String pantallaPrincipal(Model model) {
 
        model = currentBalance.obtenerListadoCurrentBalance(model);
        return "index";
    }

    @GetMapping("/transferencia")
    public String pantallaTransferencia(Model model) {
 
        model = currentBalance.listaCuentas(model);
        model.addAttribute("confirmacion", 0);
        return "transferencias";
    }

    @PostMapping("/realizarTransferencia")
    public String realizarTransferencia(Model model, Transferencia datos) {
 
        currentBalance.guardarTransferencia(model, datos);
        return "transferencias";
    }
 
    

    
}
