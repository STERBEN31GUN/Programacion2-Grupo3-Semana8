import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase de servicio para gestionar la lógica de los descuentos.
 * Integrante 10
 */
public class DescuentoService {

    private List<Descuento> listaDescuentos = new ArrayList<>(); // <-- Aquí agregamos <Descuento>

    public Descuento guardarDescuento(Descuento descuento) {
        listaDescuentos.add(descuento);
        return descuento;
    }

    public List<Descuento> obtenerTodos() {
        return listaDescuentos;
    }

    public Optional<Descuento> buscarPorCodigo(String codigo) {
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
        Optional<Descuento> descuentoOpt = buscarPorCodigo(codigo);

        if (descuentoOpt.isPresent() && esDescuentoValido(descuentoOpt.get())) {
            Double porcentaje = descuentoOpt.get().getPorcentaje();
            Double ahorro = montoOriginal * (porcentaje / 100.0);
            return montoOriginal - ahorro;
        }

        return montoOriginal;
    }
}
