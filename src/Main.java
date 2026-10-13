import java.util.List;

void main() {

    SalaCine sala = new SalaCine("Sala 1", 3, 5); // 3 filas x 5 butacas
    PlataformaReserva plataforma = new PlataformaReserva(sala);

    sala.mostrarEstado();

    // Reserva múltiple exitosa
    plataforma.reservar("Ana", Arrays.asList("A2", "A3", "A4"));

    // Reserva que choca con una butaca ya ocupada (A4)
    plataforma.reservar("Martín", Arrays.asList("A4", "B1"));

    sala.mostrarEstado();

}