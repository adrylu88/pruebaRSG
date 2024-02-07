package mx.com.pruebarsg.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUENTA", schema = "PRUEBA")
public class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUENTA_ID")
	private Integer cuentaId;
    
    @Column(name="BALANCE")
    private Double balance;

    @Column(name="NOMBRE_CUENTA")
    private String nombreCuenta;

    public Integer getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Integer cuentaId) {
        this.cuentaId = cuentaId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    @Override
    public String toString() {
        return "Cuenta [cuentaId=" + cuentaId + ", balance=" + balance + ", nombreCuenta=" + nombreCuenta + "]";
    }

    
    
}
