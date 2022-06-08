package ac.cr.cenfotec.davidrodriguezcotolaboratorio2.entity;


import javax.persistence.*;

@Entity
@Table(name = "TABLA_PRODUCTOS_LABORATORIO2")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(length = 45, nullable = false)
    private String nombre;

    @Column(length = 100, nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private double precio;

    public Producto() {
    }

    public Producto(int id, String nombre, String descripcion, int cantidad, double precio) {
        Id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
