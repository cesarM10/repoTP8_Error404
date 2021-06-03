package ar.edu.unju.fi.tp6.model;

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("compraObj")
@Entity
@Table(name = "compras")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "com_id")
	private Long id ;
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pro_codigo", nullable = false)
	private Producto producto ;
	
	@Column(name = "com_cantidad", nullable =  false)
	private int cantidad ;

	//No se considera la validacion ya que el calculo del total se realiza luego de guardar la compra.
	@Column(name = "com_total", nullable = false)
	private double total;
	
	public Compra() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param id
	 * @param producto
	 * @param cantidad
	 * @param total
	 */
	public Compra(Long id, Producto producto, int cantidad, double total) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = total;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	public void setTotal() {
		String totalString = "";
		DecimalFormat df = new DecimalFormat("#.##");
		
		totalString = df.format(this.cantidad * this.producto.getPrecio());
		this.total = Double.parseDouble(totalString);
	}


	@Override
	public String toString() {
		return "Compra [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", total=" + total + "]";
	}

	
	


	
	
	
 
 
	

}