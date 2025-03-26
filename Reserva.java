import java.time.LocalDate;
/**
 * Clase que representa una reserva para una pista deportiva.
 * 
 * @author Kimberly Montoya
 */

public class Reserva {
    private int idPista;
    private LocalDate fecha ;
    private int duracion;
    /**
     * Constructor para inicializar una reserva.
     * 
     * @param idPista ID único de la pista.
     * @param fecha Fecha de la reserva.
     * @param duracion Duración de la reserva en días.
     */

    public Reserva(int idPista, LocalDate fecha, int duracion) {
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }
    /**
     * Obtiene el ID único de la pista.
     * 
     * @return ID de la pista.
     */

    public int getIdPista() {
        return idPista;
    }
    /**
     * Obtiene la fecha de la reserva.
     * 
     * @return Fecha de la reserva.
     */

    public LocalDate getFecha() {
        return fecha;
    }
    /**
     * Obtiene la duración de la reserva.
     * 
     * @return Duración en días.
     */

    public int getDuracion() {
        return duracion;
    }
}