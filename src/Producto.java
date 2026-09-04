public class Producto {

    private String nombre;
    private double precio;
    private int cantidad;

    // Constructor
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Obtener nombre
    public String getNombre() {
        return nombre;
    }

    // Cambiar nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Obtener precio
    public double getPrecio() {
        return precio;
    }

    // Cambiar precio
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Obtener cantidad
    public int getCantidad() {
        return cantidad;
    }

    // Cambiar cantidad
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Mostrar información del producto
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + String.format("%.2f", precio));
        System.out.println("Cantidad: " + cantidad);
    }
}