package ar.edu.unju.fi.tp6.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("productoObj")
@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pro_codigo")
	private Long codigo;
	
	@NotEmpty(message = "El campo no debe estar vacio.")
	@Size(min = 3, max = 150,  message = "El campo nombre debe tener como minimo 3 caracteres.")
	@Column(name = "pro_nombre")
	private String nombre;
	
	@Min(value = 1, message = "El valor no debe ser negativo.")
	@Max(value = 100000, message = "El valor no debe ser mayor a 100000.")
	@Column(name = "pro_precio")
	private double precio;

	@NotEmpty(message = "El campo no debe estar vacio.")
	@Size(min = 1, max = 150,  message = "El campo marca debe tener como minimo 1 caracter.")
	@Column(name = "pro_marca")
	private String marca;
	
	@Min(value = 1, message = "El valor no puede ser cero o negativo.")
	@Column(name = "pro_stock")
	private int stock;
	
	@Valid
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "com_id")
	private Compra compra;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(Long codigo, String nombre, double precio, String marca, int stock) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
	}

	
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", marca=" + marca
				+ ", stock=" + stock + ", compra=" + compra + "]";
	}

 
}
