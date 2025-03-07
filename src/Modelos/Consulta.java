package Modelos;

import Exception.CEPException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Consulta {
    public CEP buscaCEP(String cep, Integer tamanhoCEP) throws IOException, InterruptedException {
        if (cep.length() != tamanhoCEP) {
            throw new CEPException("O tamanho do CEP é inválido, tente novamente!");
        }

        var endereco = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new GsonBuilder()
                .create();

        var json = response.body();

        if (json.contains("erro")) {
            throw new CEPException("O CEP inserido é inválido, tente novamente!");
        }

        return gson.fromJson(json, CEP.class);
    }
}
