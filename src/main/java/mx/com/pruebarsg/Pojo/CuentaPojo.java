package mx.com.pruebarsg.Pojo;



public class CuentaPojo {



    
	private Integer cuentaId;
    
    private Double balance;

    private String nombreCuenta;
    
    private String fecha;

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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "CuentaPojo [cuentaId=" + cuentaId + ", balance=" + balance + ", nombreCuenta=" + nombreCuenta
                + ", fecha=" + fecha + "]";
    }

    
}
