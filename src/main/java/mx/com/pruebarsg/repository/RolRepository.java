package mx.com.pruebarsg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.com.pruebarsg.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {

    @Query("SELECT r FROM Rol r WHERE r.nombre = ?1")
	public Rol findByNombre(String strnombre);
    
}
