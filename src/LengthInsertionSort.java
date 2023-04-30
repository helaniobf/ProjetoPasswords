import java.io.*;
import java.util.Scanner;

public class LengthInsertionSort {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File arquivoData = new File("data/passwords_formated_data.csv");
        String arquivoPassClass = arquivoData.getAbsolutePath();

        File arquivoMelhor = new File("sort/passwords_length_insertionSort_medioCaso.csv");
        String arquivoMelhorCaso = arquivoMelhor.getAbsolutePath();

        File arquivoPior = new File("sort/passwords_length_insertionSort_melhorCasoCrescente.csv");
        String arquivoPiorCaso = arquivoPior.getAbsolutePath();

        long tempoInicial = System.currentTimeMillis();
        medioCaso(arquivoPassClass); //Ordena o aleatorio em ordem decrescente
        long tempoFinal = System.currentTimeMillis();
        System.out.printf("%.3fs%n", (tempoFinal - tempoInicial) / 1000f);

        long tempoInicial2 = System.currentTimeMillis();
        melhorCaso(arquivoMelhorCaso); //Verifica o já ordenado
        long tempoFinal2 = System.currentTimeMillis();
        System.out.printf("%.3fs%n", (tempoFinal2 - tempoInicial2) / 1000d);

        inverter(arquivoMelhorCaso); //Cria um arquivo em ordem crescente
        long tempoInicial3 = System.currentTimeMillis();
        piorCaso(arquivoPiorCaso); //Ordena o arquivo que está em ordem crescente
        long tempoFinal3 = System.currentTimeMillis();
        System.out.printf("%.3fs%n", (tempoFinal3 - tempoInicial3) / 1000d);
    }

    public static void medioCaso(String arquivoPassClass) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner scanner = new Scanner(new File(arquivoPassClass));

        int linhas = 0;
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            linhas++;
        }

        String[][] senhas = new String[linhas][5];
        scanner = new Scanner(new File(arquivoPassClass));
        scanner.nextLine(); // pular a primeira linha
        int i = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas        passwords[i][0] = valores[0];
            senhas[i][0] = valores[0];
            senhas[i][1] = valores[1];
            senhas[i][2] = valores[2];
            senhas[i][3] = valores[3];
            senhas[i][4] = valores[4];
            i++;
        }

        // Ordenação pelo tamanho da senha
        for (i = 1; i < linhas; i++) {
            String[] valorAtual = senhas[i];
            int currentPasswordLength = valorAtual[1].length();
            int j = i - 1;
            while (j >= 0 && senhas[j][1].length() < currentPasswordLength) {
                senhas[j + 1] = senhas[j];
                j--;
            }
            senhas[j + 1] = valorAtual;
        }

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_length_insertionSort_medioCaso.csv", "UTF-8");
        writer.print(",password,length,data,class\n");
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + senhas[i][1] + "," + senhas[i][2] + "," + senhas[i][3] + "," + senhas[i][4]);
        }
        writer.close();
    }

    public static void melhorCaso(String arquivoMelhorCaso) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner scanner = new Scanner(new File(arquivoMelhorCaso));

        int linhas = 0;
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            linhas++;
        }

        String[][] senhas = new String[linhas][5];
        scanner = new Scanner(new File(arquivoMelhorCaso));
        scanner.nextLine(); // pular a primeira linha
        int i = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas        passwords[i][0] = valores[0];
            senhas[i][0] = valores[0];
            senhas[i][1] = valores[1];
            senhas[i][2] = valores[2];
            senhas[i][3] = valores[3];
            senhas[i][4] = valores[4];
            i++;
        }

        // Ordenação pelo tamanho da senha
        for (i = 1; i < linhas; i++) {
            String[] valorAtual = senhas[i];
            int currentPasswordLength = valorAtual[1].length();
            int j = i - 1;
            while (j >= 0 && senhas[j][1].length() < currentPasswordLength) {
                senhas[j + 1] = senhas[j];
                j--;
            }
            senhas[j + 1] = valorAtual;
        }

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_length_insertionSort_melhorCaso.csv", "UTF-8");
        writer.print(",password,length,data,class\n");
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + senhas[i][1] + "," + senhas[i][2] + "," + senhas[i][3] + "," + senhas[i][4]);
        }
        writer.close();
    }

    public static void inverter(String arquivoMelhorCaso) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner scanner = new Scanner(new File(arquivoMelhorCaso));

        int linhas = 0;
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            linhas++;
        }

        String[][] senhas = new String[linhas][5];
        scanner = new Scanner(new File(arquivoMelhorCaso));
        scanner.nextLine(); // pular a primeira linha
        int i = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas        passwords[i][0] = valores[0];
            senhas[i][0] = valores[0];
            senhas[i][1] = valores[1];
            senhas[i][2] = valores[2];
            senhas[i][3] = valores[3];
            senhas[i][4] = valores[4];
            i++;
        }

        // Ordenação pelo tamanho da senha
        for (i = 1; i < linhas; i++) {
            String[] valorAtual = senhas[i];
            int currentPasswordLength = valorAtual[1].length();
            int j = i - 1;
            while (j >= 0 && senhas[j][1].length() > currentPasswordLength) {
                senhas[j + 1] = senhas[j];
                j--;
            }
            senhas[j + 1] = valorAtual;
        }

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_length_insertionSort_melhorCasoCrescente.csv", "UTF-8");
        writer.print(",password,length,data,class\n");
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + senhas[i][1] + "," + senhas[i][2] + "," + senhas[i][3] + "," + senhas[i][4]);
        }
        writer.close();
    }

    public static void piorCaso(String arquivoPiorCaso) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner scanner = new Scanner(new File(arquivoPiorCaso));

        int linhas = 0;
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            linhas++;
        }

        String[][] senhas = new String[linhas][5];
        scanner = new Scanner(new File(arquivoPiorCaso));
        scanner.nextLine(); // pular a primeira linha
        int i = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas        passwords[i][0] = valores[0];
            senhas[i][0] = valores[0];
            senhas[i][1] = valores[1];
            senhas[i][2] = valores[2];
            senhas[i][3] = valores[3];
            senhas[i][4] = valores[4];
            i++;
        }

        // Ordenação pelo tamanho da senha
        for (i = 1; i < linhas; i++) {
            String[] valorAtual = senhas[i];
            int currentPasswordLength = valorAtual[1].length();
            int j = i - 1;
            while (j >= 0 && senhas[j][1].length() < currentPasswordLength) {
                senhas[j + 1] = senhas[j];
                j--;
            }
            senhas[j + 1] = valorAtual;
        }

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_length_insertionSort_piorCaso.csv", "UTF-8");
        writer.print(",password,length,data,class\n");
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + senhas[i][1] + "," + senhas[i][2] + "," + senhas[i][3] + "," + senhas[i][4]);
        }
        writer.close();
    }
}