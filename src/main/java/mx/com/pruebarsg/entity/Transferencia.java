package mx.com.pruebarsg.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRANSFERENCIA", schema = "PRUEBA")
public class Transferencia implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TRANSFERENCIA_ID")
	private Integer transferenciaId;
    
    @Column(name="CUENTA_ORIGEN")
    private Integer cuentaOrigen;

    @Column(name="CUENTA_DESTINO")
    private Integer cuentaDestino;

    @Column(name="FECHA")
    private Date fecha;

    @Column(name="CANTIDAD")
    private Double cantidad;

    public Integer getTransferenciaId() {
        return transferenciaId;
    }

    public void setTransferenciaId(Integer transferenciaId) {
        this.transferenciaId = transferenciaId;
    }

    public Integer getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(Integer cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public Integer getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Integer cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Transferencia [transferenciaId=" + transferenciaId + ", cuentaOrigen=" + cuentaOrigen
                + ", cuentaDestino=" + cuentaDestino + ", fecha=" + fecha + ", cantidad=" + cantidad + "]";
    }

    

}
