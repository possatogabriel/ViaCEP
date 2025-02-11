package Modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivos {
    public void geraArquivoJSON(CEP cep) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter arquivo = new FileWriter("src/CEPs_Buscados/" + cep.cep() + ".json");
        arquivo.write(gson.toJson(cep));
        arquivo.close();
    }
}
