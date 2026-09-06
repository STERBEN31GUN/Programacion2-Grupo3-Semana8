public class Cliente {

    private String nombre;
    private String telefono;
    private String correo;

    // Constructor
    public Cliente(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Obtener nombre
    public String getNombre() {
        return nombre;
    }

    // Cambiar nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Obtener teléfono
    public String getTelefono() {
        return telefono;
    }

    // Cambiar teléfono
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Obtener correo
    public String getCorreo() {
        return correo;
    }

    // Cambiar correo
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Mostrar información del cliente
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Correo: " + correo);
    }
}