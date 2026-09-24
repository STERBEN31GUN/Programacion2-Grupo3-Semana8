public class Categoria {
    private String idCategoria;
    private String nombreCategoria;

    public Categoria(String idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }
}