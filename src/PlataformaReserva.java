import java.util.List;

public class PlataformaReserva {

    private SalaCine sala; // asociación: referencia a la sala

    public PlataformaReserva(SalaCine sala) {
        this.sala = sala;
    }

    public void reservar(String usuario, List<String> codigosButacas) {

        System.out.println("\n" + usuario + " solicita las butacas " + codigosButacas
                + " en " + sala.getNombre() + ".");

        boolean exito = sala.bloquearButacas(codigosButacas);

        if (exito) {
            for (String codigo : codigosButacas) {
                System.out.println("Ticket emitido: " + usuario + " - " + sala.getNombre() + " - Butaca " + codigo);
            }
        } else {
            System.out.println("Plataforma: no se pudo completar la reserva de " + usuario + ".");
        }
    }
}