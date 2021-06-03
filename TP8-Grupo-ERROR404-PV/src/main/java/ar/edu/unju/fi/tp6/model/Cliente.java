package ar.edu.unju.fi.tp6.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Component("clienteObj")
@Entity
@Table(name = "clientes")
public class Cliente {
	@NotEmpty(message="Seleccione una opcion.")
	@Column(name = "cli_tipoDocumento")
	private String tipoDocumento;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cli_id")
	private Long id;
	
	@Min(value = 1, message = "El valor no puede ser negativo.")
	@Column(name = "cli_nroDocumento")
	private Long nroDocumento;
	
	@NotEmpty(message = "El campo no debe estar vacio.")
	@Size(min = 3, max = 150,  message = "El campo Nombre y Apellido debe tener como minimo 3 caracteres.")
	@Column(name = "cli_nombreApellido")
	private String nombreApellido;
	
	@Email(message = "Ingrese un formato de email valido.")
	@Column(name = "cli_email")
	private String email;
	
	@Size(min = 8, message = "El campo password debe tener como minimo 8 caracteres.")
	@NotBlank(message = "El campo contraseña no puede ser vacio.")
	@Column(name = "cli_password")
	private String password;
	
	@NotNull(message = "El campo Fecha de nacimiento no debe ser nulo.")
	@Column(name = "cli_fechaNacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	
	@Min(value = 1, message = "El campo no debe ser negativo")
	@Column(name = "cli_codigoAreaTelefono")
	private int codigoAreaTelefono;
	
	@Min(value = 1, message = "El campo no debe ser negativo")
	@Column(name = "cli_nroTelefono")
	private int nroTelefono;
	
	@NotNull(message = "El campo Fecha Ultima Compra no debe ser nulo.")
	@Column(name = "cli_fechaUltimaCompra")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaUltimaCompra;
	
	@Valid
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cta_id", nullable = false)
	private Cuenta cuenta;
	
		
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Cliente(String tipoDocumento, Long id, Long nroDocumento, String nombreApellido, String email, String password,
			LocalDate fechaNacimiento, int codigoAreaTelefono, int nroTelefono, LocalDate fechaUltimaCompra) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nombreApellido = nombreApellido;
		this.email = email;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.codigoAreaTelefono = codigoAreaTelefono;
		this.nroTelefono = nroTelefono;
		this.fechaUltimaCompra = fechaUltimaCompra;
	}



	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Long getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(Long nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}

	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}

	public int getNroTelefono() {
		return nroTelefono;
	}

	public void setNroTelefono(int nroTelefono) {
		this.nroTelefono = nroTelefono;
	}

	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}


	public int getEdad() {
		int edad = 0;
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(this.fechaNacimiento, hoy);
		edad = periodo.getYears();
		return edad;
	}
		
	public String calculoTiempoUltimaCompra() {
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(fechaUltimaCompra, hoy);
		String tiempoUltimaCompra = "Año: " + periodo.getYears() + " Mes: " + periodo.getMonths() + " Dia: " + periodo.getDays();
		
		return tiempoUltimaCompra; 
	}
	
	public long calculoTiempoDesdeNacimiento(){
		Calendar hoy = Calendar.getInstance();
		Calendar fechaNac = Calendar.getInstance();
		fechaNac.set(this.fechaNacimiento.getYear(),this.fechaNacimiento.getMonthValue()-1,this.fechaNacimiento.getDayOfMonth());
		
		long milisec = hoy.getTimeInMillis() - fechaNac.getTimeInMillis();
		long dias = milisec / 1000 / 60 / 60 / 24;
		
		return dias;
	}	
	
	public String calculoTiempoHastaCumple() {
		String texto = "";
		LocalDate hoy = LocalDate.now();
		int varanio=hoy.getYear();;
		if(hoy.getMonthValue() >= this.fechaNacimiento.getMonthValue()) {
			if(hoy.getMonthValue() == this.fechaNacimiento.getMonthValue() && hoy.getDayOfMonth() < this.fechaNacimiento.getDayOfMonth() ) {
				varanio = hoy.getYear()+1;
			}
			
			if(hoy.getMonthValue() > this.fechaNacimiento.getMonthValue()) {
				varanio = hoy.getYear()+1;
			}
			
		}else {
			varanio =hoy.getYear();
		}
		LocalDate fechaProxCumple = LocalDate.of(varanio, this.fechaNacimiento.getMonthValue(), this.fechaNacimiento.getDayOfMonth());
		
		Period periodo = Period.between(hoy,  fechaProxCumple);
		texto = "Mes: " + periodo.getMonths() + " Dia: " + periodo.getDays();
				
		return texto;
	}
	
	
	public Cuenta getCuenta() {
		return cuenta;
	}



	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Cliente [tipoDocumento=" + tipoDocumento + ", id=" + id + ", nroDocumento=" + nroDocumento
				+ ", nombreApellido=" + nombreApellido + ", email=" + email + ", password=" + password
				+ ", fechaNacimiento=" + fechaNacimiento + ", codigoAreaTelefono=" + codigoAreaTelefono
				+ ", nroTelefono=" + nroTelefono + ", fechaUltimaCompra=" + fechaUltimaCompra + ", cuenta=" + cuenta
				+ "]";
	}



	
	
	

	
}