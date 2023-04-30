import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DataMergeSort {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File arquivoData = new File("data/passwords_formated_data.csv");
        String arquivoPassClass = arquivoData.getAbsolutePath();

        File arquivoMelhor = new File("sort/passwords_data_mergeSort_medioCaso.csv");
        String arquivoMelhorCaso = arquivoMelhor.getAbsolutePath();

        File arquivoPior = new File("sort/passwords_data_mergeSort_melhorCasoDecrescente.csv");
        String arquivoPiorCaso = arquivoPior.getAbsolutePath();

        long tempoInicial = System.currentTimeMillis();
        medioCaso(arquivoPassClass); //Ordena o aleatorio em ordem crescente
        long tempoFinal = System.currentTimeMillis();
        System.out.printf("%.3fs%n", (tempoFinal - tempoInicial) / 1000f);

        long tempoInicial2 = System.currentTimeMillis();
        melhorCaso(arquivoMelhorCaso); //Verifica o já ordenado
        long tempoFinal2 = System.currentTimeMillis();
        System.out.printf("%.3fs%n", (tempoFinal2 - tempoInicial2) / 1000d);

        inverter(arquivoMelhorCaso); //Cria um arquivo em ordem decrescente
        long tempoInicial3 = System.currentTimeMillis();
        piorCaso(arquivoPiorCaso); //Ordena o arquivo que está em ordem decrescente
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

        String[][] passwords = new String[linhas][5];
        scanner = new Scanner(new File(arquivoPassClass));
        scanner.nextLine(); // pular a primeira linha
        int i = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas                passwords[i][0] = valores[0];
            passwords[i][1] = valores[1];
            passwords[i][2] = valores[2];
            passwords[i][3] = valores[3];
            passwords[i][4] = valores[4];
            i++;
        }

        // Ordenação pelo valor da data
        mergeSortCrescente(passwords, 0, linhas - 1);

        PrintWriter writer = new PrintWriter("sort/passwords_data_mergeSort_medioCaso.csv", "UTF-8");
        writer.print(",password,length,data,class\n");
        // Impressão das senhas ordenadas
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + passwords[i][1] + "," + passwords[i][2] + "," + passwords[i][3] + "," + passwords[i][4]);
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

        String[][] passwords = new String[linhas][5];
        scanner = new Scanner(new File(arquivoMelhorCaso));
        scanner.nextLine(); // pular a primeira linha
        int i = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas                passwords[i][0] = valores[0];
            passwords[i][1] = valores[1];
            passwords[i][2] = valores[2];
            passwords[i][3] = valores[3];
            passwords[i][4] = valores[4];
            i++;
        }

        // Ordenação pelo valor da data
        mergeSortCrescente(passwords, 0, linhas - 1);

        PrintWriter writer = new PrintWriter("sort/passwords_data_mergeSort_melhorCaso.csv", "UTF-8");
        writer.print(",password,length,data,class\n");
        // Impressão das senhas ordenadas
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + passwords[i][1] + "," + passwords[i][2] + "," + passwords[i][3] + "," + passwords[i][4]);
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

        String[][] passwords = new String[linhas][5];
        scanner = new Scanner(new File(arquivoMelhorCaso));
        scanner.nextLine(); // pular a primeira linha
        int i = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas                passwords[i][0] = valores[0];
            passwords[i][1] = valores[1];
            passwords[i][2] = valores[2];
            passwords[i][3] = valores[3];
            passwords[i][4] = valores[4];
            i++;
        }

        // Ordenação pelo valor da data
        mergeSort(passwords, 0, linhas - 1);

        PrintWriter writer = new PrintWriter("sort/passwords_data_mergeSort_melhorCasoDecrescente.csv", "UTF-8");
        writer.print(",password,length,data,class\n");
        // Impressão das senhas ordenadas
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + passwords[i][1] + "," + passwords[i][2] + "," + passwords[i][3] + "," + passwords[i][4]);
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

        String[][] passwords = new String[linhas][5];
        scanner = new Scanner(new File(arquivoPiorCaso));
        scanner.nextLine(); // pular a primeira linha
        int i = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas                passwords[i][0] = valores[0];
            passwords[i][1] = valores[1];
            passwords[i][2] = valores[2];
            passwords[i][3] = valores[3];
            passwords[i][4] = valores[4];
            i++;
        }

        // Ordenação pelo valor da data
        mergeSortCrescente(passwords, 0, linhas - 1);

        PrintWriter writer = new PrintWriter("sort/passwords_data_mergeSort_piorCaso.csv", "UTF-8");
        writer.print(",password,length,data,class\n");
        // Impressão das senhas ordenadas
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + passwords[i][1] + "," + passwords[i][2] + "," + passwords[i][3] + "," + passwords[i][4]);
        }
        writer.close();
    }

    public static void mergeSort(String[][] arr, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            mergeSort(arr, esquerda, meio);
            mergeSort(arr, meio + 1, direita);
            merge(arr, esquerda, meio, direita);
        }
    }

    public static void mergeSortCrescente(String[][] arrayData, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            mergeSortCrescente(arrayData, esquerda, meio);
            mergeSortCrescente(arrayData, meio + 1, direita);
            mergeCrescente(arrayData, esquerda, meio, direita);
        }
    }

    public static void merge(String[][] arrayData, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        String[][] esq = new String[n1][5];
        String[][] dir = new String[n2][5];

        for (int i = 0; i < n1; i++) {
            esq[i] = arrayData[esquerda + i];
        }
        for (int j = 0; j < n2; j++) {
            dir[j] = arrayData[meio + 1 + j];
        }
        int i = 0, j = 0, k = esquerda;

        while (i < n1 && j < n2) {
            // Obter a data como um inteiro
            LocalDateTime data1 = LocalDateTime.parse(esq[i][3], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            LocalDateTime data2 = LocalDateTime.parse(dir[j][3], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

            // Comparar a data
            if (data1.isAfter(data2) || data1.equals(data2)) {
                arrayData[k] = esq[i];
                i++;
            } else {
                arrayData[k] = dir[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arrayData[k] = esq[i];
            i++;
            k++;
        }

        while (j < n2) {
            arrayData[k] = dir[j];
            j++;
            k++;
        }
    }

    public static void mergeCrescente(String[][] arrayData, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        String[][] esq = new String[n1][5];
        String[][] dir = new String[n2][5];

        for (int i = 0; i < n1; i++) {
            esq[i] = arrayData[esquerda + i];
        }
        for (int j = 0; j < n2; j++) {
            dir[j] = arrayData[meio + 1 + j];
        }
        int i = 0, j = 0, k = esquerda;

        while (i < n1 && j < n2) {
            // Obter a data como um inteiro
            LocalDateTime data1 = LocalDateTime.parse(esq[i][3], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            LocalDateTime data2 = LocalDateTime.parse(dir[j][3], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

            // Comparar a data
            if (data1.isBefore(data2) || data1.equals(data2)) {
                arrayData[k] = esq[i];
                i++;
            } else {
                arrayData[k] = dir[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arrayData[k] = esq[i];
            i++;
            k++;
        }

        while (j < n2) {
            arrayData[k] = dir[j];
            j++;
            k++;
        }
    }
}


