public class Factura {

    private int numeroFactura;
    private String fechaEmision;
    private Venta venta;

    // ---- Constructor ----
    public Factura(int numeroFactura, String fechaEmision, Venta venta) {
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.venta = venta;
    }


    public double calcularTotal() {
        return venta.calcularSubtotal();
    }


    public void mostrarFactura() {
        System.out.println("======================================");
        System.out.println("           FACTURA #" + numeroFactura);
        System.out.println("======================================");
        System.out.println("Fecha de emisión: " + fechaEmision);
        System.out.println();
        venta.mostrarDetalle();
        System.out.println();
        System.out.printf("TOTAL:      $%.2f%n", calcularTotal());
        System.out.println("======================================");
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}
