package fernando.Conversor.Changes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChangeExtensor {
    private String original;
    private String cambio;
    private float rango;
    private float total;


    public ChangeExtensor() {
    }

    public ChangeExtensor(Change cambios) {
        this.original = cambios.base_code();
        this.cambio=cambios.target_code();
        this.rango=cambios.conversion_rate();
        this.total=cambios.conversion_result();

    }

    @Override
    public String toString() {

        return "Change Extensor \n" +
                "Moneda original=" + original + '\n' +
                "Moneda cambio=" + cambio + '\n' +
                "Tipo de cambio=" + rango +'\n' +
                "Total=" + total+'\n' ;

    }
}
