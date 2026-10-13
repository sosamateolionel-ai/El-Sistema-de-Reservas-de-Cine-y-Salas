public class Butaca {

    private String fila;
    private int numero;
    private boolean ocupada;

    public Butaca(String fila, int numero) {
        this.fila = fila;
        this.numero = numero;
        this.ocupada = false; // arranca disponible
    }

    public String getFila() {
        return fila;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    // Código único de la butaca, por ejemplo "A3"
    public String getCodigo() {
        return fila + numero;
    }
}