import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class DataInsertionSort {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File arquivoData = new File("data/passwords_formated_data.csv");
        String arquivoPassClass = arquivoData.getAbsolutePath();

        File arquivoMelhor = new File("sort/passwords_data_insertionSort_medioCaso.csv");
        String arquivoMelhorCaso = arquivoMelhor.getAbsolutePath();

        File arquivoPior = new File("sort/passwords_data_insertionSort_melhorCasoDecrescente.csv");
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
            passwords[i][1] = valores[1];
            passwords[i][2] = valores[2];
            passwords[i][3] = valores[3];
            passwords[i][4] = valores[4];
            i++;
        }

        int ordenadas = 1;

        PrintWriter writer = new PrintWriter("sort/passwords_data_insertionSort_medioCaso.csv", "UTF-8");
        writer.print(",password,length,data,class\n");

        while (ordenadas < linhas) {
            int j = ordenadas;
            while (j > 0) {
                if (!passwords[j][2].equals("") && !passwords[j - 1][2].equals("")) {
                    // Obter a data como um inteiro
                    LocalDateTime data1 = LocalDateTime.parse(passwords[j][3], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                    LocalDateTime data2 = LocalDateTime.parse(passwords[j - 1][3], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

                    // Comparar pela data
                    if (data1.isBefore(data2)) {
                        // Trocar elementos
                        String[] temp = passwords[j];
                        passwords[j] = passwords[j - 1];
                        passwords[j - 1] = temp;
                    } else {
                        break;
                    }
                }
                j--;
            }
            ordenadas++;
        }

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
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas        passwords[i][0] = valores[0];
            passwords[i][1] = valores[1];
            passwords[i][2] = valores[2];
            passwords[i][3] = valores[3];
            passwords[i][4] = valores[4];
            i++;
        }

        int ordenadas = 1;

        PrintWriter writer = new PrintWriter("sort/passwords_data_insertionSort_melhorCaso.csv", "UTF-8");
        writer.print(",password,length,data,class\n");

        while (ordenadas < linhas) {
            int j = ordenadas;
            while (j > 0) {
                if (!passwords[j][2].equals("") && !passwords[j - 1][2].equals("")) {
                    // Obter a data como um inteiro
                    LocalDateTime data1 = LocalDateTime.parse(passwords[j][3], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                    LocalDateTime data2 = LocalDateTime.parse(passwords[j - 1][3], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

                    // Comparar pela data
                    if (data1.isBefore(data2)) {
                        // Trocar elementos
                        String[] temp = passwords[j];
                        passwords[j] = passwords[j - 1];
                        passwords[j - 1] = temp;
                    } else {
                        break;
                    }
                }
                j--;
            }
            ordenadas++;
        }

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
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas        passwords[i][0] = valores[0];
            passwords[i][1] = valores[1];
            passwords[i][2] = valores[2];
            passwords[i][3] = valores[3];
            passwords[i][4] = valores[4];
            i++;
        }

        int ordenadas = 1;

        PrintWriter writer = new PrintWriter("sort/passwords_data_insertionSort_melhorCasoDecrescente.csv", "UTF-8");
        writer.print(",password,length,data,class\n");

        while (ordenadas < linhas) {
            int j = ordenadas;
            while (j > 0) {
                if (!passwords[j][2].equals("") && !passwords[j - 1][2].equals("")) {
                    // Obter a data como um inteiro
                    LocalDateTime data1 = LocalDateTime.parse(passwords[j][3], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                    LocalDateTime data2 = LocalDateTime.parse(passwords[j - 1][3], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

                    // Comparar pela data
                    if (data2.isBefore(data1)) {
                        // Trocar elementos
                        String[] temp = passwords[j];
                        passwords[j] = passwords[j - 1];
                        passwords[j - 1] = temp;
                    } else {
                        break;
                    }
                }
                j--;
            }
            ordenadas++;
        }

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
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas        passwords[i][0] = valores[0];
            passwords[i][1] = valores[1];
            passwords[i][2] = valores[2];
            passwords[i][3] = valores[3];
            passwords[i][4] = valores[4];
            i++;
        }

        int ordenadas = 1;

        PrintWriter writer = new PrintWriter("sort/passwords_data_insertionSort_piorCaso.csv", "UTF-8");
        writer.print(",password,length,data,class\n");

        while (ordenadas < linhas) {
            int j = ordenadas;
            while (j > 0) {
                if (!passwords[j][2].equals("") && !passwords[j - 1][2].equals("")) {
                    // Obter a data como um inteiro
                    LocalDateTime data1 = LocalDateTime.parse(passwords[j][3], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                    LocalDateTime data2 = LocalDateTime.parse(passwords[j - 1][3], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

                    // Comparar pela data
                    if (data1.isBefore(data2)) {
                        // Trocar elementos
                        String[] temp = passwords[j];
                        passwords[j] = passwords[j - 1];
                        passwords[j - 1] = temp;
                    } else {
                        break;
                    }
                }
                j--;
            }
            ordenadas++;
        }

        // Impressão das senhas ordenadas
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + passwords[i][1] + "," + passwords[i][2] + "," + passwords[i][3] + "," + passwords[i][4]);
        }
        writer.close();
    }

}
