public class Inventario {
    private int idInventario;
    private String codigoProducto;
    private int stockActual;
    private int stockMinimo;
    private String ubicacion;

    // Constructor vacío
    public Inventario() {
    }

    // Constructor con parámetros
    public Inventario(int idInventario, String codigoProducto, int stockActual, int stockMinimo, String ubicacion) {
        this.idInventario = idInventario;
        this.codigoProducto = codigoProducto;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.ubicacion = ubicacion;
    }

    // Getters y Setters (Encapsulamiento)
    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // Método de negocio para actualizar stock
    public void actualizarStock(int cantidad) {
        this.stockActual += cantidad;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "idInventario=" + idInventario +
                ", codigoProducto='" + codigoProducto + '\'' +
                ", stockActual=" + stockActual +
                ", stockMinimo=" + stockMinimo +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}    

