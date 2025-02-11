import Modelos.Consulta;
import Modelos.GeradorDeArquivos;
import Exception.CEPException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        var busca = "";

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.print("Escreva o(s) CEP(s) que você quer consultar (sem hífen)/digite 'SAIR' para encerrar o programa: ");
            busca = input.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                System.out.println("PROGRAMA ENCERRADO. ");
                break;
            }

            System.out.println();

            try {
                var consulta = new Consulta();
                var informacaoCEP = consulta.buscaCEP(busca);

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