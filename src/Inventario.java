public class Inventario {

    private int id;
    private String nombreProducto;
    private int cantidad;
    private double precioUnitario;
    private Categoria categoria;

    public Inventario() {
    }

    public Inventario(int id, String nombreProducto, int cantidad, double precioUnitario, Categoria categoria) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double calcularValorTotal() {
        return cantidad * precioUnitario;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "id=" + id +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", categoria=" + (categoria != null ? categoria.getNombre() : "N/A") +
                '}';
    }
}
