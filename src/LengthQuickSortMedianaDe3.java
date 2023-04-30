import java.io.*;
import java.util.Scanner;

public class LengthQuickSortMedianaDe3 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File arquivoData = new File("data/passwords_formated_data.csv");
        String arquivoPassClass = arquivoData.getAbsolutePath();

        File arquivoMelhor = new File("sort/passwords_length_quickSortMedianaDe3_medioCaso.csv");
        String arquivoMelhorCaso = arquivoMelhor.getAbsolutePath();

        File arquivoPior = new File("sort/passwords_length_quickSortMedianaDe3_melhorCasoCrescente.csv");
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

        quicksort(senhas, 0, linhas - 1);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_length_quicksortMedianaDe3_medioCaso.csv", "UTF-8");
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

        quicksort(senhas, 0, linhas - 1);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_length_quicksortMedianaDe3_piorCaso.csv", "UTF-8");
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

        quicksort(senhas, 0, linhas - 1);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_length_quicksortMedianaDe3_medioCaso.csv", "UTF-8");
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

        quicksortCrescente(senhas, 0, linhas - 1);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_length_quicksortMedianaDe3_melhorCasoCrescente.csv", "UTF-8");
        writer.print(",password,length,data,class\n");
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + senhas[i][1] + "," + senhas[i][2] + "," + senhas[i][3] + "," + senhas[i][4]);
        }
        writer.close();
    }

    public static void quicksort(String[][] senhas, int inicio, int fim) {
        if (inicio < fim) {
            int pivot = medianaDeTres(senhas, inicio, fim);
            int i = inicio;
            int j = fim;

            while (i <= j) {
                while (senhas[i][1].length() > senhas[pivot][1].length()) {
                    i++;
                }

                while (senhas[j][1].length() < senhas[pivot][1].length()) {
                    j--;
                }

                if (i <= j) {
                    String[] temp = senhas[i];
                    senhas[i] = senhas[j];
                    senhas[j] = temp;
                    i++;
                    j--;
                }
            }

            if (inicio < j) {
                quicksort(senhas, inicio, j);
            }

            if (i < fim) {
                quicksort(senhas, i, fim);
            }
        }
    }

    public static void quicksortCrescente(String[][] senhas, int inicio, int fim) {
        if (inicio < fim) {
            int pivot = medianaDeTres(senhas, inicio, fim);
            int i = inicio;
            int j = fim;

            while (i <= j) {
                while (senhas[i][1].length() < senhas[pivot][1].length()) {
                    i++;
                }

                while (senhas[j][1].length() > senhas[pivot][1].length()) {
                    j--;
                }

                if (i <= j) {
                    String[] temp = senhas[i];
                    senhas[i] = senhas[j];
                    senhas[j] = temp;
                    i++;
                    j--;
                }
            }

            if (inicio < j) {
                quicksortCrescente(senhas, inicio, j);
            }

            if (i < fim) {
                quicksortCrescente(senhas, i, fim);
            }
        }
    }

    public static int medianaDeTres(String[][] senhas, int inicio, int fim) {
        int meio = (inicio + fim) / 2;
        int ultimo = fim;

        // Seleciona o elemento do meio como pivô
        if (senhas[inicio][1].length() > senhas[meio][1].length()) {
            String[] temp = senhas[inicio];
            senhas[inicio] = senhas[meio];
            senhas[meio] = temp;
        }

        if (senhas[inicio][1].length() > senhas[ultimo][1].length()) {
            String[] temp = senhas[inicio];
            senhas[inicio] = senhas[ultimo];
            senhas[ultimo] = temp;
        }

        if (senhas[meio][1].length() > senhas[ultimo][1].length()) {
            String[] temp = senhas[meio];
            senhas[meio] = senhas[ultimo];
            senhas[ultimo] = temp;
        }

        String[] temp = senhas[meio];
        senhas[meio] = senhas[inicio + 1];
        senhas[inicio + 1] = temp;

        int pivot = inicio + 1;
        int i = pivot + 1;
        int j = fim;

        while (true) {
            while (i <= j && senhas[i][1].length() <= senhas[pivot][1].length()) {
                i++;
            }

            while (j >= i && senhas[j][1].length() >= senhas[pivot][1].length()) {
                j--;
            }

            if (i > j) {
                break;
            } else {
                temp = senhas[i];
                senhas[i] = senhas[j];
                senhas[j] = temp;
            }
        }

        temp = senhas[pivot];
        senhas[pivot] = senhas[j];
        senhas[j] = temp;

        return j;
    }
}
