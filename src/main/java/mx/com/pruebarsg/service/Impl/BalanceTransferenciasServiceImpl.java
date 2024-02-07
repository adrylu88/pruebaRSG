package mx.com.pruebarsg.service.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import mx.com.pruebarsg.Pojo.CuentaPojo;
import mx.com.pruebarsg.entity.Cuenta;
import mx.com.pruebarsg.entity.Transferencia;
import mx.com.pruebarsg.repository.CuentaRepository;
import mx.com.pruebarsg.repository.TransferenciaRepository;
import mx.com.pruebarsg.service.BalanceTranferenciasService;


@Service
public class BalanceTransferenciasServiceImpl implements BalanceTranferenciasService{

    @Autowired
    private CuentaRepository cuentaRep;

    @Autowired
    private TransferenciaRepository transferenciaRep;

    @Override
    public Model obtenerListadoCurrentBalance(Model datosVista) {

        //Obtener el listado de las cuentas
        List<Cuenta>cuentas = cuentaRep.findAll();
        List<CuentaPojo> datosCuenta=new ArrayList<>();

        if(!cuentas.isEmpty()){
            //Obtener la fecha de la ultima transferencia y llenar el pojo de envío
            for(Cuenta cu: cuentas){
                CuentaPojo datos = new CuentaPojo();
                Date fechaTransferencia = transferenciaRep.obtenerUltimafecha(cu.getCuentaId());

                datos.setCuentaId(cu.getCuentaId());
                datos.setBalance(cu.getBalance());
                String fechaStr= "";
                if(fechaTransferencia !=null){
                    fechaStr=new SimpleDateFormat("dd-MM-yyyy").format(fechaTransferencia);
                }
                datos.setFecha(fechaStr);

                datosCuenta.add(datos);


                


            }
        }
        datosVista.addAttribute("listaCuentas", datosCuenta);



        return datosVista;


       
    }

    @Override
    public Model listaCuentas(Model datosVista) {
        List<Cuenta>listaCuentas= cuentaRep.findAll();
        datosVista.addAttribute("lista", listaCuentas);

        return datosVista;
        
    }

    @Override
    public Model guardarTransferencia(Model model, Transferencia datos) {
        //Realizar las validaciones necesarias para la transferencia
        int confirmacion=2;
        Transferencia guardar = new Transferencia();
        //Validar fondos suficientes
        Cuenta cuentaOrigen = cuentaRep.getById(datos.getCuentaOrigen());
        if(cuentaOrigen!=null){
            if(cuentaOrigen.getBalance()!=null && datos.getCantidad()<=cuentaOrigen.getBalance()){
               //Validar la existencia de la cuenta destino
               Cuenta cuentaDestino = cuentaRep.getById(datos.getCuentaDestino());
               Integer nextId;
               if(cuentaDestino !=null){
                List<Transferencia> contador= transferenciaRep.findAll();
                if(contador!=null && contador.size()>0){
                    nextId= contador.size()+1;
                }
                else
                {
                    nextId=1;
                }
                 
                //procedemos a guardar la transferencia y ejecutar los balances
                guardar.setCuentaOrigen(cuentaOrigen.getCuentaId());
                guardar.setCuentaDestino(cuentaDestino.getCuentaId());
                guardar.setCantidad(datos.getCantidad());
                guardar.setTransferenciaId(nextId);
                Date fechaActual=new Date();
                guardar.setFecha(fechaActual);

                transferenciaRep.saveAndFlush(guardar);

                //actualizar saldos
                cuentaDestino.setBalance(cuentaDestino.getBalance()+datos.getCantidad());
                cuentaRep.saveAndFlush(cuentaDestino);

                cuentaOrigen.setBalance(cuentaOrigen.getBalance()-datos.getCantidad());
                cuentaRep.saveAndFlush(cuentaOrigen);

               confirmacion=1;

               }
            }

        }
        



        model.addAttribute("confirmacion", confirmacion);


        return model;
    }
    
}
