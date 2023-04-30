import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class DateMonthHeapSort {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File arquivoData = new File("data/passwords_formated_data.csv");
        String arquivoPassClass = arquivoData.getAbsolutePath();

        File arquivoMelhor = new File("sort/passwords_data_month_heapSort_medioCaso.csv");
        String arquivoMelhorCaso = arquivoMelhor.getAbsolutePath();

        File arquivoPior = new File("sort/passwords_data_month_heapSort_melhorCasoDecrescente.csv");
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
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas        passwords[i][0] = valores[0];
            passwords[i][0] = valores[0];
            passwords[i][1] = valores[1];
            passwords[i][2] = valores[2];
            passwords[i][3] = valores[3];
            passwords[i][4] = valores[4];
            i++;
        }

        heapSort(passwords);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_data_month_heapSort_medioCaso.csv", "UTF-8");
        writer.println(",password,length,data,class");
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
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas        passwords[i][0] = valores[0];
            passwords[i][0] = valores[0];
            passwords[i][1] = valores[1];
            passwords[i][2] = valores[2];
            passwords[i][3] = valores[3];
            passwords[i][4] = valores[4];
            i++;
        }

        heapSort(passwords);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_data_month_heapSort_melhorCaso.csv", "UTF-8");
        writer.println(",password,length,data,class");
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
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas        passwords[i][0] = valores[0];
            passwords[i][0] = valores[0];
            passwords[i][1] = valores[1];
            passwords[i][2] = valores[2];
            passwords[i][3] = valores[3];
            passwords[i][4] = valores[4];
            i++;
        }

        heapSortDecrescente(passwords);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_data_month_heapSort_melhorCasoDecrescente.csv", "UTF-8");
        writer.println(",password,length,data,class");
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
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas        passwords[i][0] = valores[0];
            passwords[i][0] = valores[0];
            passwords[i][1] = valores[1];
            passwords[i][2] = valores[2];
            passwords[i][3] = valores[3];
            passwords[i][4] = valores[4];
            i++;
        }

        heapSort(passwords);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_data_month_heapSort_piorCaso.csv", "UTF-8");
        writer.println(",password,length,data,class");
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + passwords[i][1] + "," + passwords[i][2] + "," + passwords[i][3] + "," + passwords[i][4]);
        }
        writer.close();
    }

    public static void heapSort(String[][] arr) {
        int n = arr.length;

        // Construir o heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extrair o elemento máximo do heap e reconstruir o heap
        for (int i = n - 1; i >= 0; i--) {
            String[] temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapSortDecrescente(String[][] arr) {
        int n = arr.length;

        // Construir o heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDecrescente(arr, n, i);
        }

        // Extrair o elemento máximo do heap e reconstruir o heap
        for (int i = n - 1; i >= 0; i--) {
            String[] temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapifyDecrescente(arr, i, 0);
        }
    }

    public static void heapify(String[][] arr, int n, int i) {
        int maior = i;
        int esq = 2 * i + 1;
        int dir = 2 * i + 2;

        // Encontrar o maior elemento entre raiz, esquerda e direita
        if (esq < n && Integer.parseInt(arr[esq][3].split("/")[1]) > Integer.parseInt(arr[maior][3].split("/")[1])) {
            maior = esq;
        }

        if (dir < n && Integer.parseInt(arr[dir][3].split("/")[1]) > Integer.parseInt(arr[maior][3].split("/")[1])) {
            maior = dir;
        }

        // Se o maior elemento não for a raiz, trocá-los e reconstruir o heap
        if (maior != i) {
            String[] temp = arr[i];
            arr[i] = arr[maior];
            arr[maior] = temp;

            heapify(arr, n, maior);
        }
    }

    public static void heapifyDecrescente(String[][] arr, int n, int i) {
        int maior = i;
        int esq = 2 * i + 1;
        int dir = 2 * i + 2;

        // Encontrar o maior elemento entre raiz, esquerda e direita
        if (esq < n && Integer.parseInt(arr[esq][3].split("/")[1]) < Integer.parseInt(arr[maior][3].split("/")[1])) {
            maior = esq;
        }

        if (dir < n && Integer.parseInt(arr[dir][3].split("/")[1]) < Integer.parseInt(arr[maior][3].split("/")[1])) {
            maior = dir;
        }

        // Se o maior elemento não for a raiz, trocá-los e reconstruir o heap
        if (maior != i) {
            String[] temp = arr[i];
            arr[i] = arr[maior];
            arr[maior] = temp;

            heapify(arr, n, maior);
        }
    }
}