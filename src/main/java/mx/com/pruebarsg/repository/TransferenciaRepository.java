package mx.com.pruebarsg.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import mx.com.pruebarsg.entity.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia,Integer> {
    
   /**
    * Obtener fecha más reciente de una transferencia de una cuenta
    */
    @Query(value="select max(fecha) from transferencia where cuenta_origen= ?1",nativeQuery=true)
	public Date obtenerUltimafecha(Integer idCuenta);
    

}
