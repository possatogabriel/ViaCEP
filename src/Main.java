import Modelos.Consulta;
import Modelos.GeradorDeArquivos;
import Exception.CEPException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        var busca = "";
        var tamanhoCEP = 0;

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.print("Escreva o(s) CEP(s) que você quer consultar/digite 'SAIR' para encerrar o programa: ");
            busca = input.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                System.out.println("PROGRAMA ENCERRADO. ");
                break;
            }

            if (busca.contains("-")) {
                tamanhoCEP = 9;
            } else {
                tamanhoCEP = 8;
            }

            System.out.println();

            try {
                var consulta = new Consulta();
                var informacaoCEP = consulta.buscaCEP(busca, tamanhoCEP);

                System.out.println(informacaoCEP);
                System.out.println();

                var geradorDeArquivos = new GeradorDeArquivos();
                geradorDeArquivos.geraArquivoJSON(informacaoCEP);
            } catch (CEPException e) {
                System.out.println("ERRO: " + e.getMessage());
                System.out.println("PROGRAMA ENCERRADO.");
                break;
            }
        }
    }
}