import java.io.*;
import java.util.Scanner;

public class LengthMergeSort {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File arquivoData = new File("data/passwords_formated_data.csv");
        String arquivoPassClass = arquivoData.getAbsolutePath();

        File arquivoMelhor = new File("sort/passwords_length_mergeSort_medioCaso.csv");
        String arquivoMelhorCaso = arquivoMelhor.getAbsolutePath();

        File arquivoPior = new File("sort/passwords_length_mergeSort_melhorCasoCrescente.csv");
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
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas
            senhas[i][0] = valores[0];
            senhas[i][1] = valores[1];
            senhas[i][2] = valores[2];
            senhas[i][3] = valores[3];
            senhas[i][4] = valores[4];
            i++;
        }

        // Ordenação pelo tamanho da senha utilizando Merge Sort
        mergeSort(senhas, 0, linhas - 1);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_length_mergeSort_medioCaso.csv", "UTF-8");
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
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas
            senhas[i][0] = valores[0];
            senhas[i][1] = valores[1];
            senhas[i][2] = valores[2];
            senhas[i][3] = valores[3];
            senhas[i][4] = valores[4];
            i++;
        }

        // Ordenação pelo tamanho da senha utilizando Merge Sort
        mergeSort(senhas, 0, linhas - 1);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_length_mergeSort_melhorCaso.csv", "UTF-8");
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
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas
            senhas[i][0] = valores[0];
            senhas[i][1] = valores[1];
            senhas[i][2] = valores[2];
            senhas[i][3] = valores[3];
            senhas[i][4] = valores[4];
            i++;
        }

        // Ordenação pelo tamanho da senha utilizando Merge Sort
        mergeSortCrescente(senhas, 0, linhas - 1);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_length_mergeSort_melhorCasoCrescente.csv", "UTF-8");
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
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas
            senhas[i][0] = valores[0];
            senhas[i][1] = valores[1];
            senhas[i][2] = valores[2];
            senhas[i][3] = valores[3];
            senhas[i][4] = valores[4];
            i++;
        }

        // Ordenação pelo tamanho da senha utilizando Merge Sort
        mergeSort(senhas, 0, linhas - 1);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_length_mergeSort_piorCaso.csv", "UTF-8");
        writer.print(",password,length,data,class\n");
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + senhas[i][1] + "," + senhas[i][2] + "," + senhas[i][3] + "," + senhas[i][4]);
        }
        writer.close();
    }

    public static void mergeSort(String[][] senhas, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(senhas, inicio, meio);
            mergeSort(senhas, meio + 1, fim);
            mergeDecrescente(senhas, inicio, meio, fim);
        }
    }

    public static void mergeSortCrescente(String[][] senhas, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(senhas, inicio, meio);
            mergeSort(senhas, meio + 1, fim);
            mergeCrescente(senhas, inicio, meio, fim);
        }
    }

    public static void mergeDecrescente(String[][] senhas, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        String[][] esquerda = new String[n1][5];
        String[][] direita = new String[n2][5];

        for (int i = 0; i < n1; i++) {
            esquerda[i] = senhas[inicio + i];
        }

        for (int j = 0; j < n2; j++) {
            direita[j] = senhas[meio + 1 + j];
        }

        int i = 0, j = 0, k = inicio;

        while (i < n1 && j < n2) {
            if (esquerda[i][1].length() >= direita[j][1].length()) {
                senhas[k] = esquerda[i];
                i++;
            } else {
                senhas[k] = direita[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            senhas[k] = esquerda[i];
            i++;
            k++;
        }

        while (j < n2) {
            senhas[k] = direita[j];
            j++;
            k++;
        }
    }

    public static void mergeCrescente(String[][] senhas, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        String[][] esquerda = new String[n1][5];
        String[][] direita = new String[n2][5];

        for (int i = 0; i < n1; i++) {
            esquerda[i] = senhas[inicio + i];
        }

        for (int j = 0; j < n2; j++) {
            direita[j] = senhas[meio + 1 + j];
        }

        int i = 0, j = 0, k = inicio;

        while (i < n1 && j < n2) {
            if (esquerda[i][1].length() <= direita[j][1].length()) {
                senhas[k] = esquerda[i];
                i++;
            } else {
                senhas[k] = direita[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            senhas[k] = esquerda[i];
            i++;
            k++;
        }

        while (j < n2) {
            senhas[k] = direita[j];
            j++;
            k++;
        }
    }
}