package fernando.Conversor.Consultas;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fernando.Conversor.Changes.ChangeExtensor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Consultas {

    public Consultas() {
    }

    public Consultas(List<ChangeExtensor> cambios) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String fechaHoraFormateada = LocalDateTime.now().format(formatter);


        String directorio="consultaspordia";

        File dir=new File(directorio);

        if(!dir.exists())
        {dir.mkdir();}

        String nombreArchivo = directorio + File.separator + "Consultas_" + fechaHoraFormateada + ".txt";

        FileWriter consultas = new FileWriter(nombreArchivo);
        Gson gson=new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setPrettyPrinting()
                .create();
        consultas.write(gson.toJson(cambios));
        consultas.close();
    }
}
