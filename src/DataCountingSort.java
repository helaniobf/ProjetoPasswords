import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DataCountingSort {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File arquivoData = new File("data/passwords_formated_data.csv");
        String arquivoPassClass = arquivoData.getAbsolutePath();

        File arquivoMelhor = new File("sort/passwords_data_countingSort_medioCaso.csv");
        String arquivoMelhorCaso = arquivoMelhor.getAbsolutePath();

        File arquivoPior = new File("sort/passwords_data_countingSort_melhorCasoDecrescente.csv");
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

        countingSort(passwords);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_data_countingSort_medioCaso.csv", "UTF-8");
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

        countingSort(passwords);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_data_countingSort_melhorCaso.csv", "UTF-8");
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

        countingSortDecrescente(passwords);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_data_countingSort_melhorCasoDecrescente.csv", "UTF-8");
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

        countingSort(passwords);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_data_countingSort_piorCaso.csv", "UTF-8");
        writer.println(",password,length,data,class");
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + passwords[i][1] + "," + passwords[i][2] + "," + passwords[i][3] + "," + passwords[i][4]);
        }
        writer.close();
    }

    public static void countingSort(String[][] arr) {
        // Encontra a data máxima e mínima
        LocalDate maxDate = null;
        LocalDate minDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        for (int i = 0; i < arr.length; i++) {
            LocalDate date = LocalDate.parse(arr[i][3], formatter);
            if (maxDate == null || date.compareTo(maxDate) > 0) {
                maxDate = date;
            }
            if (minDate == null || date.compareTo(minDate) < 0) {
                minDate = date;
            }
        }

        // Calcula o tamanho do vetor de contagem
        long tam = maxDate.toEpochDay() - minDate.toEpochDay() + 1;

        // Inicializa o vetor de contagem com zeros
        int[] count = new int[(int)tam];
        for (int i = 0; i < tam; i++) {
            count[i] = 0;
        }

        // Conta o número de ocorrências de cada data
        for (int i = 0; i < arr.length; i++) {
            LocalDate date = LocalDate.parse(arr[i][3], formatter);
            int index = (int)(date.toEpochDay() - minDate.toEpochDay());
            count[index]++;
        }

        // Calcula as posições finais de cada data no vetor ordenado
        for (int i = 1; i < tam; i++) {
            count[i] += count[i - 1];
        }

        // Cria o vetor de saída
        String[][] saida = new String[arr.length][5];

        // Ordena o vetor de entrada pela data usando o vetor de contagem
        for (int i = arr.length - 1; i >= 0; i--) {
            LocalDate date = LocalDate.parse(arr[i][3], formatter);
            int index = (int)(date.toEpochDay() - minDate.toEpochDay());
            saida[count[index] - 1] = arr[i];
            count[index]--;
        }

        // Copia o vetor de saída de volta para o vetor de entrada
        for (int i = 0; i < arr.length; i++) {
            arr[i] = saida[i];
        }
    }

    public static void countingSortDecrescente(String[][] arr) {
        // Encontra a data máxima e mínima
        String maxDate = "01/01/0001";
        String minDate = "31/12/9999";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][3].compareTo(maxDate) > 0) {
                maxDate = arr[i][3];
            }
            if (arr[i][3].compareTo(minDate) < 0) {
                minDate = arr[i][3];
            }
        }

        // Calcula o tamanho do vetor de contagem
        int tam = arr.length;

        // Inicializa o vetor de contagem com zeros
        int[] count = new int[tam];
        for (int i = 0; i < tam; i++) {
            count[i] = 0;
        }

        // Conta o número de ocorrências de cada data
        for (int i = 0; i < arr.length; i++) {
            count[arr.length - 1 - i]++;
        }

        // Calcula as posições finais de cada data no vetor ordenado
        for (int i = tam - 2; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        // Cria o vetor de saída
        String[][] saida = new String[arr.length][5];

        // Ordena o vetor de entrada pela data usando o vetor de contagem
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = count[arr.length - 1 - i] - 1;
            saida[index][0] = arr[i][0];
            saida[index][1] = arr[i][1];
            saida[index][2] = arr[i][2];
            saida[index][3] = arr[i][3];
            saida[index][4] = arr[i][4];
            count[arr.length - 1 - i]--;
        }

        // Copia o vetor de saída de volta para o vetor de entrada
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = saida[arr.length - 1 - i][0];
            arr[i][1] = saida[arr.length - 1 - i][1];
            arr[i][2] = saida[arr.length - 1 - i][2];
            arr[i][3] = saida[arr.length - 1 - i][3];
            arr[i][4] = saida[arr.length - 1 - i][4];
        }
    }

    private static int extrairDiaDaData(String data) {
        return Integer.parseInt(data.substring(0, 2));
    }

    private static int contarDiasEntreDatas(String data1, String data2) {
        LocalDate ld1 = LocalDate.parse(data1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate ld2 = LocalDate.parse(data2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return (int) ChronoUnit.DAYS.between(ld1, ld2);
    }
}