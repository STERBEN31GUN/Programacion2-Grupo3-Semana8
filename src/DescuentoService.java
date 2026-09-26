import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase de servicio para gestionar la lógica de los descuentos.
 * Integrante 10
 */
public class DescuentoService {

    private List listaDescuentos = new ArrayList<>();

    public Descuento guardarDescuento(Descuento descuento) {
        listaDescuentos.add(descuento);
        return descuento;
    }

    public List obtenerTodos() {
        return listaDescuentos;
    }

    public Optional buscarPorCodigo(String codigo) {
        return listaDescuentos.stream()
                .filter(d -> d.getCodigo().equalsIgnoreCase(codigo))
                .findFirst();
    }

    public boolean esDescuentoValido(Descuento descuento) {
        if (descuento == null || !descuento.getActivo()) {
            return false;
        }
        LocalDate hoy = LocalDate.now();
        return (hoy.isEqual(descuento.getFechaInicio()) || hoy.isAfter(descuento.getFechaInicio())) &&
               (hoy.isEqual(descuento.getFechaFin()) || hoy.isBefore(descuento.getFechaFin()));
    }

    public Double calcularMontoConDescuento(Double montoOriginal, String codigo) {
        Optional descuentoOpt = buscarPorCodigo(codigo);

        if (descuentoOpt.isPresent() && esDescuentoValido(descuentoOpt.get())) {
            Double porcentaje = descuentoOpt.get().getPorcentaje();
            Double ahorro = montoOriginal * (porcentaje / 100.0);
            return montoOriginal - ahorro;
        }

        return montoOriginal;
    }
}
