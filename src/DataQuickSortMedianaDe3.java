import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DataQuickSortMedianaDe3 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File arquivoData = new File("data/passwords_formated_data.csv");
        String arquivoPassClass = arquivoData.getAbsolutePath();

        File arquivoMelhor = new File("sort/passwords_data_quickSortMedianaDe3_medioCaso.csv");
        String arquivoMelhorCaso = arquivoMelhor.getAbsolutePath();

        File arquivoPior = new File("sort/passwords_data_quickSortMedianaDe3_melhorCasoDecrescente.csv");
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

        quicksortMedianaDeTres(passwords, 0, linhas - 1);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_data_quickSortMedianaDe3_medioCaso.csv", "UTF-8");
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

        quicksortMedianaDeTres(passwords, 0, linhas - 1);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_data_quickSortMedianaDe3_melhorCaso.csv", "UTF-8");
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

        quicksortMedianaDeTresDecrescente(passwords, 0, linhas - 1);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_data_quickSortMedianaDe3_melhorCasoDecrescente.csv", "UTF-8");
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

        quicksortMedianaDeTres(passwords, 0, linhas - 1);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_data_quickSortMedianaDe3_piorCaso.csv", "UTF-8");
        writer.println(",password,length,data,class");
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + passwords[i][1] + "," + passwords[i][2] + "," + passwords[i][3] + "," + passwords[i][4]);
        }
        writer.close();
    }

    public static void quicksortMedianaDeTres(String[][] senhas, int esquerda, int direita) {
        if (esquerda < direita) {
            int posicaoPivo = particionaMedianaDeTres(senhas, esquerda, direita);
            quicksortMedianaDeTres(senhas, esquerda, posicaoPivo - 1);
            quicksortMedianaDeTres(senhas, posicaoPivo + 1, direita);
        }
    }

    public static int particionaMedianaDeTres(String[][] senhas, int esquerda, int direita) {
        int meio = (esquerda + direita) / 2;
        LocalDateTime pivo = obterData(senhas[meio][3]);
        LocalDateTime dataEsquerda = obterData(senhas[esquerda][3]);
        LocalDateTime dataDireita = obterData(senhas[direita][3]);

        if (dataEsquerda.isAfter(dataDireita)) {
            trocar(senhas, esquerda, direita);
        }
        if (pivo.isBefore(dataEsquerda)) {
            trocar(senhas, esquerda, meio);
        }
        if (pivo.isAfter(dataDireita)) {
            trocar(senhas, meio, direita);
        }

        LocalDateTime pivoAtual = obterData(senhas[meio][3]);
        trocar(senhas, meio, direita - 1);
        int i = esquerda + 1;
        int j = direita - 2;
        while (i <= j) {
            LocalDateTime dataI = obterData(senhas[i][3]);
            LocalDateTime dataJ = obterData(senhas[j][3]);
            if (dataI.isBefore(pivoAtual)) {
                i++;
            } else if (dataJ.isAfter(pivoAtual)) {
                j--;
            } else {
                trocar(senhas, i, j);
                i++;
                j--;
            }
        }
        trocar(senhas, direita - 1, i);
        return i;
    }

    public static void quicksortMedianaDeTresDecrescente(String[][] senhas, int esquerda, int direita) {
        if (esquerda < direita) {
            int posicaoPivo = particionaMedianaDeTresDecrescente(senhas, esquerda, direita);
            quicksortMedianaDeTresDecrescente(senhas, esquerda, posicaoPivo - 1);
            quicksortMedianaDeTresDecrescente(senhas, posicaoPivo + 1, direita);
        }
    }

    public static int particionaMedianaDeTresDecrescente(String[][] senhas, int esquerda, int direita) {
        int meio = (esquerda + direita) / 2;
        LocalDateTime pivo = obterData(senhas[meio][3]);
        LocalDateTime dataEsquerda = obterData(senhas[esquerda][3]);
        LocalDateTime dataDireita = obterData(senhas[direita][3]);

        if (dataEsquerda.isBefore(dataDireita)) {
            trocar(senhas, esquerda, direita);
        }
        if (pivo.isAfter(dataEsquerda)) {
            trocar(senhas, esquerda, meio);
        }
        if (pivo.isBefore(dataDireita)) {
            trocar(senhas, meio, direita);
        }

        LocalDateTime pivoAtual = obterData(senhas[meio][3]);
        trocar(senhas, meio, direita - 1);
        int i = esquerda + 1;
        int j = direita - 2;
        while (i <= j) {
            LocalDateTime dataI = obterData(senhas[i][3]);
            LocalDateTime dataJ = obterData(senhas[j][3]);
            if (dataI.isAfter(pivoAtual)) {
                i++;
            } else if (dataJ.isBefore(pivoAtual)) {
                j--;
            } else {
                trocar(senhas, i, j);
                i++;
                j--;
            }
        }
        trocar(senhas, direita - 1, i);
        return i;
    }

    public static LocalDateTime obterData(String dataString) {
        return LocalDateTime.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public static void trocar(String[][] senhas, int i, int j) {
        String[] temp = senhas[i];
        senhas[i] = senhas[j];
        senhas[j] = temp;
    }
}
