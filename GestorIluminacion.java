/**
 * Clase que gestiona la iluminación de las pistas deportivas.
 * 
 * @author Kimberly
 */
public class GestorIluminacion {
    private boolean[] iluminacion;

    /**
     * Constructor que inicializa el gestor de iluminación.
     * 
     * @param maxPistas Número máximo de pistas.
     */
    public GestorIluminacion(int maxPistas) {
        iluminacion = new boolean[maxPistas];
    }

    /**
     * Enciende las luces de una pista específica.
     * 
     * @param idPista ID único de la pista.
     * @return true si las luces se encienden exitosamente, false si el ID es inválido.
     */
    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= iluminacion.length) {
            return false;
        }
        iluminacion[idPista] = true;
        return true;
    }

    /**
     * Apaga las luces de una pista específica.
     * 
     * @param idPista ID único de la pista.
     * @return true si las luces se apagan exitosamente, false si el ID es inválido.
     */
    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= iluminacion.length) {
            return false;
        }
        iluminacion[idPista] = false;
        return true;
    }
}