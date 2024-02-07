package mx.com.pruebarsg.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.*;



@Entity
@Table(name="USUARIO",  uniqueConstraints = @UniqueConstraint(columnNames = "MAIL"))
public class Usuario implements Serializable{

     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuario_id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDOP")
    private String apellidop;
    @Column(name = "APELLIDOM")
    private String apellidom;
    @Column(name = "MAIL")
    private String mail;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "FECHAN")
    private Date fechan;
    @Column(name = "FECHAC")
    private Date fechac;
    @Column(name = "ROL")
    private int rol;
    
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_roles",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
			)
    private Set<Rol> roles = new HashSet<>();
    public Usuario() {
    }
   public boolean hasRole(String roleName) {
    Iterator<Rol> iterator = this.roles.iterator();
    while (iterator.hasNext()) {
        Rol role = iterator.next();
        if (role.getNombre().equals(roleName)) {
            return true;
        }
    }
     
    return false;
}
    public Set<Rol> getRoles() {
        return roles;
    }
    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
    public Long getUsuario_id() {
        return usuario_id;
    }
    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidop() {
        return apellidop;
    }
    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }
    public String getApellidom() {
        return apellidom;
    }
    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getFechan() {
        return fechan;
    }
    public void setFechan(Date fechan) {
        this.fechan = fechan;
    }
    public Date getFechac() {
        return fechac;
    }
    public void setFechac(Date fechac) {
        this.fechac = fechac;
    }
    public int getRol() {
        return rol;
    }
    public void setRol(int rol) {
        this.rol = rol;
    }

    public void addRole(Rol role) {
		this.roles.add(role);
	}
    @Override
    public String toString() {
        return "Usuario [usuario_id=" + usuario_id + ", nombre=" + nombre + ", apellidop=" + apellidop + ", apellidom="
                + apellidom + ", mail=" + mail + ", password=" + password + ", fechan=" + fechan + ", fechac=" + fechac
                + ", rol=" + rol + ", roles=" + roles + "]";
    }
    

    
}
