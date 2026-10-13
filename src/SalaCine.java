import java.util.ArrayList;
import java.util.List;

public class SalaCine {

    private String nombre;
    private int butacasPorFila;
    private List<Butaca> butacas;

    public SalaCine(String nombre, int filas, int butacasPorFila) {
        this.nombre = nombre;
        this.butacasPorFila = butacasPorFila;
        this.butacas = new ArrayList<>();

        // Genera las butacas: filas A, B, C... con números 1..butacasPorFila
        for (int f = 0; f < filas; f++) {
            String letraFila = String.valueOf((char) ('A' + f));
            for (int n = 1; n <= butacasPorFila; n++) {
                butacas.add(new Butaca(letraFila, n));
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    private Butaca buscarButaca(String codigo) {
        for (Butaca b : butacas) {
            if (b.getCodigo().equals(codigo)) {
                return b;
            }
        }
        return null;
    }

    public boolean bloquearButacas(List<String> codigosButacas) {

        // Paso 1: validar TODAS antes de tocar ninguna
        for (String codigo : codigosButacas) {
            Butaca b = buscarButaca(codigo);

            if (b == null) {
                System.out.println(nombre + ": la butaca " + codigo + " no existe. Reserva cancelada, no se bloqueó ninguna butaca.");
                return false;
            }

            if (b.isOcupada()) {
                System.out.println(nombre + ": la butaca " + codigo + " ya está ocupada. Reserva cancelada, no se bloqueó ninguna butaca.");
                return false;
            }
        }

        // Paso 2: recién ahora se bloquean
        for (String codigo : codigosButacas) {
            buscarButaca(codigo).setOcupada(true);
        }

        System.out.println(nombre + ": butacas " + codigosButacas + " bloqueadas.");
        return true;
    }

    public void mostrarEstado() {
        System.out.println("\n=== " + nombre + " ===");

        for (Butaca b : butacas) {
            if (b.getNumero() == 1) {
                System.out.print(b.getFila() + ": ");
            }

            System.out.print(b.isOcupada() ? "[XX] " : "[" + b.getCodigo() + "] ");

            if (b.getNumero() == butacasPorFila) {
                System.out.println();
            }
        }
    }
}