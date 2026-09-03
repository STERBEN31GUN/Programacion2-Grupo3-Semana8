import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Scanner utilizado para recibir información del usuario
    private static final Scanner scanner = new Scanner(System.in);

    // Lista donde se almacenarán temporalmente los productos
    private static final ArrayList<Producto> inventario = new ArrayList<>();

    /**
     * 
     *
     * @param args 
     */
    public static void main(String[] args) {

        int opcion;

        System.out.println("========================================");
        System.out.println("       SISTEMA DE TIENDA - JAVA");
        System.out.println("========================================");
        System.out.println("Bienvenido al sistema de gestión.");
        System.out.println();

        // El menú se mantiene activo hasta seleccionar la opción 6
        do {

            mostrarMenu();

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {

                case 1:
                    agregarProducto();
                    break;

                case 2:
                    mostrarInventario();
                    break;

                case 3:
                    buscarProducto();
                    break;

                case 4:
                    modificarProducto();
                    break;

                case 5:
                    eliminarProducto();
                    break;

                case 6:
                    System.out.println();
                    System.out.println("========================================");
                    System.out.println("Gracias por utilizar el sistema.");
                    System.out.println("Programa finalizado correctamente.");
                    System.out.println("========================================");
                    break;

                default:
                    System.out.println();
                    System.out.println("ERROR: La opción seleccionada no existe.");
                    System.out.println("Por favor, seleccione una opción del 1 al 6.");
            }

        } while (opcion != 6);

        scanner.close();
    }

    //Muestra las opciones disponibles en el menú principal.

    private static void mostrarMenu() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("             MENÚ PRINCIPAL");
        System.out.println("========================================");
        System.out.println("1. Agregar producto");
        System.out.println("2. Ver inventario");
        System.out.println("3. Buscar producto");
        System.out.println("4. Modificar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Salir");
        System.out.println("========================================");
    }

    //Permite agregar un nuevo producto al inventario.

    private static void agregarProducto() {

        System.out.println();
        System.out.println("---------- AGREGAR PRODUCTO ----------");

        String nombre;

        // Validar que el nombre no esté vacío
        do {
            System.out.print("Ingrese el nombre del producto: ");
            nombre = scanner.nextLine().trim();

            if (nombre.isEmpty()) {
                System.out.println("ERROR: El nombre no puede estar vacío.");
            }

        } while (nombre.isEmpty());

        double precio;

        // Solicitar precio válido
        do {
            precio = leerDouble("Ingrese el precio del producto: ");

            if (precio < 0) {
                System.out.println("ERROR: El precio no puede ser negativo.");
            }

        } while (precio < 0);

        int cantidad;

        // Solicitar cantidad válida
        do {
            cantidad = leerEntero("Ingrese la cantidad disponible: ");

            if (cantidad < 0) {
                System.out.println("ERROR: La cantidad no puede ser negativa.");
            }

        } while (cantidad < 0);

        // Crear el objeto Producto
        Producto nuevoProducto = new Producto(nombre, precio, cantidad);

        // Agregar el producto al inventario
        inventario.add(nuevoProducto);

        System.out.println();
        System.out.println("Producto agregado correctamente.");
    }

    //Muestra todos los productos registrados.
    private static void mostrarInventario() {

        System.out.println();
        System.out.println("---------- INVENTARIO ----------");

        if (inventario.isEmpty()) {

            System.out.println("El inventario está vacío.");

            return;
        }

        for (int i = 0; i < inventario.size(); i++) {

            Producto producto = inventario.get(i);

            System.out.println();
            System.out.println("Producto #" + (i + 1));
            System.out.println("------------------------------");

            producto.mostrarInformacion();
        }
    }

    //Busca un producto utilizando su nombre.
    private static void buscarProducto() {

        System.out.println();
        System.out.println("---------- BUSCAR PRODUCTO ----------");

        if (inventario.isEmpty()) {

            System.out.println("No existen productos registrados.");

            return;
        }

        System.out.print("Ingrese el nombre del producto: ");

        String nombreBuscado = scanner.nextLine().trim();

        boolean encontrado = false;

        for (Producto producto : inventario) {

            if (producto.getNombre().equalsIgnoreCase(nombreBuscado)) {

                System.out.println();
                System.out.println("Producto encontrado.");
                System.out.println("------------------------------");

                producto.mostrarInformacion();

                encontrado = true;

                break;
            }
        }

        if (!encontrado) {

            System.out.println();
            System.out.println("No se encontró un producto con ese nombre.");
        }
    }

    // Permite modificar el precio y la cantidad de un producto.
    private static void modificarProducto() {

        System.out.println();
        System.out.println("---------- MODIFICAR PRODUCTO ----------");

        if (inventario.isEmpty()) {

            System.out.println("No existen productos registrados.");

            return;
        }

        System.out.print("Ingrese el nombre del producto a modificar: ");

        String nombreBuscado = scanner.nextLine().trim();

        Producto productoEncontrado = null;

        for (Producto producto : inventario) {

            if (producto.getNombre().equalsIgnoreCase(nombreBuscado)) {

                productoEncontrado = producto;

                break;
            }
        }

        if (productoEncontrado == null) {

            System.out.println("No se encontró el producto.");

            return;
        }

        System.out.println();
        System.out.println("Producto encontrado:");
        productoEncontrado.mostrarInformacion();

        System.out.println();

        double nuevoPrecio;

        do {

            nuevoPrecio = leerDouble("Ingrese el nuevo precio: ");

            if (nuevoPrecio < 0) {
                System.out.println("ERROR: El precio no puede ser negativo.");
            }

        } while (nuevoPrecio < 0);

        int nuevaCantidad;

        do {

            nuevaCantidad = leerEntero("Ingrese la nueva cantidad: ");

            if (nuevaCantidad < 0) {
                System.out.println("ERROR: La cantidad no puede ser negativa.");
            }

        } while (nuevaCantidad < 0);

        productoEncontrado.setPrecio(nuevoPrecio);
        productoEncontrado.setCantidad(nuevaCantidad);

        System.out.println();
        System.out.println("Producto modificado correctamente.");
    }

    /**
     * Permite eliminar un producto del inventario.
     */
    private static void eliminarProducto() {

        System.out.println();
        System.out.println("---------- ELIMINAR PRODUCTO ----------");

        if (inventario.isEmpty()) {

            System.out.println("No existen productos registrados.");

            return;
        }

        System.out.print("Ingrese el nombre del producto a eliminar: ");

        String nombreBuscado = scanner.nextLine().trim();

        Producto productoEncontrado = null;

        for (Producto producto : inventario) {

            if (producto.getNombre().equalsIgnoreCase(nombreBuscado)) {

                productoEncontrado = producto;

                break;
            }
        }

        if (productoEncontrado == null) {

            System.out.println("No se encontró el producto.");

            return;
        }

        inventario.remove(productoEncontrado);

        System.out.println();
        System.out.println("Producto eliminado correctamente.");
    }

    /**
     * Lee un número entero evitando que el programa se detenga
     * cuando el usuario introduce texto.
     *
     * @param mensaje mensaje que se mostrará al usuario
     * @return número entero válido
     */
    private static int leerEntero(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            String entrada = scanner.nextLine().trim();

            try {

                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {

                System.out.println(
                        "ERROR: Debe ingresar un número entero válido."
                );
            }
        }
    }

    /**
     * Lee un número decimal evitando errores de entrada.
     *
     * @param mensaje mensaje que se mostrará al usuario
     * @return número decimal válido
     */
    private static double leerDouble(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            String entrada = scanner.nextLine().trim();

            try {

                return Double.parseDouble(entrada);

            } catch (NumberFormatException e) {

                System.out.println(
                        "ERROR: Debe ingresar un número válido."
                );
            }
        }
    }
}