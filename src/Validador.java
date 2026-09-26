public class Validador {
    
    public static boolean esTextoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static boolean esNumeroPositivo(int numero) {
        return numero > 0;
    }
}