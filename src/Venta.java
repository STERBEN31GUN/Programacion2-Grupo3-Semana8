import java.util.ArrayList;

public class Venta {

    private int idVenta;
    private String fecha;
    private String cliente;
    private ArrayList<DetalleVenta> productos;

    public Venta(int idVenta, String fecha, String cliente) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }


    // Agrega un producto (DetalleVenta) ya construido a la venta
    public void agregarProducto(DetalleVenta detalle) {
        productos.add(detalle);
    }

    // Calcula el subtotal sumando todos los productos (sin impuestos)
    public double calcularSubtotal() {
        double subtotal = 0;
        for (DetalleVenta d : productos) {
            subtotal += d.getSubtotal();
        }
        return subtotal;
    }

    // Muestra el detalle completo de la venta en consola
    public void mostrarDetalle() {
        System.out.println("---- Venta #" + idVenta + " ----");
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + cliente);
        System.out.println("Productos:");
        for (DetalleVenta d : productos) {
            System.out.printf("  %-15s x%d  $%.2f c/u  = $%.2f%n",
                    d.getNombreProducto(), d.getCantidad(), d.getPrecioUnitario(), d.getSubtotal());
        }
        System.out.printf("Subtotal: $%.2f%n", calcularSubtotal());
    }

    
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public ArrayList<DetalleVenta> getProductos() {
        return productos;
    }
}