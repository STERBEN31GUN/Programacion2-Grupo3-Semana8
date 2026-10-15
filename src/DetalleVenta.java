public class DetalleVenta { 
    private double subtotal;
    private String nombreProducto;
    private int cantidad;
    private double precioUnitario;

    public DetalleVenta(String nombreProducto, int cantidad, double precioUnitario) {
        this.nombreProducto = nombreProducto;
        setCantidad(cantidad);       // Usamos el setter para aplicar la validación
        setPrecioUnitario(precioUnitario); // Usamos el setter para aplicar la validación
        this.subtotal = calcularSubtotal();
    }

    public double calcularSubtotal() {
        return this.cantidad * this.precioUnitario; // Corregido el operador *
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        if (nombreProducto == null || nombreProducto.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero.");
        }
        this.cantidad = cantidad;
        this.subtotal = calcularSubtotal(); // Actualiza el subtotal automáticamente
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario <= 0) {
            throw new IllegalArgumentException("El precio unitario debe ser mayor a cero.");
        }
        this.precioUnitario = precioUnitario;
        this.subtotal = calcularSubtotal(); // Actualiza el subtotal automáticamente
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}