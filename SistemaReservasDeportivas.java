import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase que gestiona el sistema de reservas de pistas deportivas y la iluminación.
 * Permite realizar reservas, cancelar reservas, y administrar la iluminación de las pistas.
 * 
 * @author Kimberly Montoya
 */

public class SistemaReservasDeportivas {
	 /**
     * Lista de todas las reservas realizadas.
     */

    private List<Reserva> reservas;
    /**
     * Array que representa el estado de la iluminación de cada pista.
     */

    private boolean[] iluminacion;
    /**
     * Constante que define el máximo número de pistas disponibles.
     */

    private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas
    /**
     * Constructor que inicializa el sistema de reservas y la iluminación.
     */

    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        iluminacion = new boolean[MAX_PISTAS];
    }
    /**
     * Reserva una pista para una fecha y duración específicas.
     * 
     * @param reserva Objeto que contiene los detalles de la reserva.
     * @return true si la reserva se realiza exitosamente, false si no está disponible.
     */
    public boolean reservarPista(Reserva reserva) {
        if (reserva.getIdPista() < 0 || reserva.getIdPista() >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        if (!esFechaDisponible(reserva.getIdPista(), reserva.getFecha())) {
            return false; // La pista ya está reservada en esa fecha
        }
        reservas.add(reserva);
        return true;
    }

    /**
     * Cancela una reserva por su ID.
     * 
     * @param idReserva ID único de la reserva.
     * @return true si la reserva se cancela exitosamente, false si no se encuentra.
     */


    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }
    /**
     * Método privado que verifica si una fecha está disponible para una pista específica.
     * 
     * @param idPista ID único de la pista.
     * @param fecha Fecha de la reserva.
     * @return true si la pista está disponible, false en caso contrario.
     */
    @SuppressWarnings("unused")
	private boolean esFechaDisponible(int idPista, LocalDate fecha) {
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false;
            }
        }
        return true;
    }

    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = true;
        return true;
    }

    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }

    public boolean verificarDisponibilidad(int idPista, LocalDate fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista no está disponible en esa fecha
            }
        }
        return true; // La pista está disponible
    }
}