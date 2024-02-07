package mx.com.pruebarsg.service;

import org.springframework.ui.Model;

import mx.com.pruebarsg.entity.Transferencia;

public interface BalanceTranferenciasService {

   public Model obtenerListadoCurrentBalance(Model model);
   public Model listaCuentas(Model model);
   public Model guardarTransferencia(Model model, Transferencia datos);
    
}
