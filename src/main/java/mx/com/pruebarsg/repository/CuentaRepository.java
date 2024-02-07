package mx.com.pruebarsg.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import mx.com.pruebarsg.entity.Cuenta;


public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{
  
}
