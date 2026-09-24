public class Inventario {
    private String idProducto;
    private String nombre;
    private int cantidad;
    private double precio;

    public Inventario(String idProducto, String nombre, int cantidad, double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public void mostrarInfo() {
        System.out.println("Producto: " + nombre + " | Stock: " + cantidad + " | Precio: $" + precio);
    }
}