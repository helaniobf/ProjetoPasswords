import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class LengthCountingSort {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File arquivoData = new File("data/passwords_formated_data.csv");
        String arquivoPassClass = arquivoData.getAbsolutePath();

        File arquivoMelhor = new File("sort/passwords_length_countingSort_medioCaso.csv");
        String arquivoMelhorCaso = arquivoMelhor.getAbsolutePath();

        File arquivoPior = new File("sort/passwords_length_countingSort_melhorCasoCrescente.csv");
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

        String[][] passwords = new String[linhas][5];
        scanner = new Scanner(new File(arquivoPassClass));
        scanner.nextLine(); // pular a primeira linha
        int i = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas
            passwords[i][0] = valores[0];
            passwords[i][1] = valores[1];
            passwords[i][2] = valores[2];
            passwords[i][3] = valores[3];
            passwords[i][4] = valores[4];
            i++;
        }

        // Encontrar a menor senha
        int menor = Integer.MAX_VALUE;
        for (i = 0; i < linhas; i++) {
            int tamanho = Integer.parseInt(passwords[i][2]);
            if (tamanho < menor) {
                menor = tamanho;
            }
        }

        // Encontrar a maior senha
        int maior = Integer.MIN_VALUE;
        for (i = 0; i < linhas; i++) {
            int tamanho = Integer.parseInt(passwords[i][2]);
            if (tamanho > maior) {
                maior = tamanho;
            }
        }

        // Contar o número de senhas de cada tamanho
        int[] contagem = new int[maior - menor + 1];
        for (i = 0; i < linhas; i++) {
            int tamanho = Integer.parseInt(passwords[i][2]);
            contagem[tamanho - menor]++;
        }

        // Acumular o número de senhas até cada tamanho
        for (i = 1; i < contagem.length; i++) {
            contagem[i] += contagem[i - 1];
        }

        // Ordenar as senhas pelo tamanho
        String[][] ordenadas = new String[linhas][5];
        for (i = linhas - 1; i >= 0; i--) {
            int tamanho = Integer.parseInt(passwords[i][2]);
            ordenadas[linhas - contagem[tamanho - menor]] = passwords[i];
            contagem[tamanho - menor]--;
        }

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_length_countingSort_medioCaso.csv", "UTF-8");
        writer.print(",password,length,data,class\n");
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + ordenadas[i][1] + "," + ordenadas[i][2] + "," + ordenadas[i][3] + "," + ordenadas[i][4]);
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
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas
            passwords[i][0] = valores[0];
            passwords[i][1] = valores[1];
            passwords[i][2] = valores[2];
            passwords[i][3] = valores[3];
            passwords[i][4] = valores[4];
            i++;
        }

        // Encontrar a menor senha
        int menor = Integer.MAX_VALUE;
        for (i = 0; i < linhas; i++) {
            int tamanho = Integer.parseInt(passwords[i][2]);
            if (tamanho < menor) {
                menor = tamanho;
            }
        }

        // Encontrar a maior senha
        int maior = Integer.MIN_VALUE;
        for (i = 0; i < linhas; i++) {
            int tamanho = Integer.parseInt(passwords[i][2]);
            if (tamanho > maior) {
                maior = tamanho;
            }
        }

        // Contar o número de senhas de cada tamanho
        int[] contagem = new int[maior - menor + 1];
        for (i = 0; i < linhas; i++) {
            int tamanho = Integer.parseInt(passwords[i][2]);
            contagem[tamanho - menor]++;
        }

        // Acumular o número de senhas até cada tamanho
        for (i = 1; i < contagem.length; i++) {
            contagem[i] += contagem[i - 1];
        }

        // Ordenar as senhas pelo tamanho
        String[][] ordenadas = new String[linhas][5];
        for (i = linhas - 1; i >= 0; i--) {
            int tamanho = Integer.parseInt(passwords[i][2]);
            ordenadas[linhas - contagem[tamanho - menor]] = passwords[i];
            contagem[tamanho - menor]--;
        }

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_length_countingSort_melhorCaso.csv", "UTF-8");
        writer.print(",password,length,data,class\n");
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + ordenadas[i][1] + "," + ordenadas[i][2] + "," + ordenadas[i][3] + "," + ordenadas[i][4]);
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
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas
            passwords[i][0] = valores[0];
            passwords[i][1] = valores[1];
            passwords[i][2] = valores[2];
            passwords[i][3] = valores[3];
            passwords[i][4] = valores[4];
            i++;
        }

        // Encontrar a menor senha
        int menor = Integer.MAX_VALUE;
        for (i = 0; i < linhas; i++) {
            int tamanho = Integer.parseInt(passwords[i][2]);
            if (tamanho < menor) {
                menor = tamanho;
            }
        }

        // Encontrar a maior senha
        int maior = Integer.MIN_VALUE;
        for (i = 0; i < linhas; i++) {
            int tamanho = Integer.parseInt(passwords[i][2]);
            if (tamanho > maior) {
                maior = tamanho;
            }
        }

        // Contar o número de senhas de cada tamanho
        int[] contagem = new int[maior - menor + 1];
        for (i = 0; i < linhas; i++) {
            int tamanho = Integer.parseInt(passwords[i][2]);
            contagem[tamanho - menor]++;
        }

        // Acumular o número de senhas até cada tamanho
        for (i = 1; i < contagem.length; i++) {
            contagem[i] += contagem[i - 1];
        }

        // Ordenar as senhas pelo tamanho
        String[][] ordenadas = new String[linhas][5];
        for (i = linhas - 1; i >= 0; i--) {
            int tamanho = Integer.parseInt(passwords[i][2]);
            ordenadas[contagem[tamanho - menor] - 1] = passwords[i];
            contagem[tamanho - menor]--;
        }

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_length_countingSort_melhorCasoCrescente.csv", "UTF-8");
        writer.print(",password,length,data,class\n");
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + ordenadas[i][1] + "," + ordenadas[i][2] + "," + ordenadas[i][3] + "," + ordenadas[i][4]);
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
            String[] valores = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // expressão regular para separar apenas vírgulas fora de aspas
            passwords[i][0] = valores[0];
            passwords[i][1] = valores[1];
            passwords[i][2] = valores[2];
            passwords[i][3] = valores[3];
            passwords[i][4] = valores[4];
            i++;
        }

        // Encontrar a menor senha
        int menor = Integer.MAX_VALUE;
        for (i = 0; i < linhas; i++) {
            int tamanho = Integer.parseInt(passwords[i][2]);
            if (tamanho < menor) {
                menor = tamanho;
            }
        }

        // Encontrar a maior senha
        int maior = Integer.MIN_VALUE;
        for (i = 0; i < linhas; i++) {
            int tamanho = Integer.parseInt(passwords[i][2]);
            if (tamanho > maior) {
                maior = tamanho;
            }
        }

        // Contar o número de senhas de cada tamanho
        int[] contagem = new int[maior - menor + 1];
        for (i = 0; i < linhas; i++) {
            int tamanho = Integer.parseInt(passwords[i][2]);
            contagem[tamanho - menor]++;
        }

        // Acumular o número de senhas até cada tamanho
        for (i = 1; i < contagem.length; i++) {
            contagem[i] += contagem[i - 1];
        }

        // Ordenar as senhas pelo tamanho
        String[][] ordenadas = new String[linhas][5];
        for (i = linhas - 1; i >= 0; i--) {
            int tamanho = Integer.parseInt(passwords[i][2]);
            ordenadas[linhas - contagem[tamanho - menor]] = passwords[i];
            contagem[tamanho - menor]--;
        }

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_length_countingSort_piorCaso.csv", "UTF-8");
        writer.print(",password,length,data,class\n");
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + ordenadas[i][1] + "," + ordenadas[i][2] + "," + ordenadas[i][3] + "," + ordenadas[i][4]);
        }
        writer.close();
    }

}