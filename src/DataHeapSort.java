import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DataHeapSort {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File arquivoData = new File("data/passwords_formated_data.csv");
        String arquivoPassClass = arquivoData.getAbsolutePath();

        File arquivoMelhor = new File("sort/passwords_data_heapSort_medioCaso.csv");
        String arquivoMelhorCaso = arquivoMelhor.getAbsolutePath();

        File arquivoPior = new File("sort/passwords_data_heapSort_melhorCasoDecrescente.csv");
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

        heapsort(passwords);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_data_heapSort_medioCaso.csv", "UTF-8");
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

        heapsort(passwords);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_data_heapSort_melhorCaso.csv", "UTF-8");
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

        heapsortDecrescente(passwords);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_data_heapSort_melhorCasoDecrescente.csv", "UTF-8");
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

        heapsort(passwords);

        // Impressão das senhas ordenadas
        PrintWriter writer = new PrintWriter("sort/passwords_data_heapSort_piorCaso.csv", "UTF-8");
        writer.println(",password,length,data,class");
        for (i = 0; i < linhas; i++) {
            writer.println(i + "," + passwords[i][1] + "," + passwords[i][2] + "," + passwords[i][3] + "," + passwords[i][4]);
        }
        writer.close();
    }

    public static void heapsort(String[][] senhas) {
        if (senhas == null || senhas.length == 0) {
            return;
        }
        int n = senhas.length;

        // construir heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(senhas, n, i);

        // extrair elementos do heap um a um
        for (int i = n - 1; i >= 0; i--) {
            // mover a raiz (maior elemento) para o fim
            trocar(senhas, 0, i);

            // chamar heapify no heap reduzido
            heapify(senhas, i, 0);
        }
    }

    public static void heapify(String[][] senhas, int n, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        // verificar se o filho esquerdo é maior que a raiz
        LocalDateTime dataRaiz = obterData(senhas[maior][3]);
        if (esquerda < n) {
            LocalDateTime dataEsquerda = obterData(senhas[esquerda][3]);
            if (dataEsquerda.isAfter(dataRaiz))
                maior = esquerda;
        }

        // verificar se o filho direito é maior que a raiz e o filho esquerdo
        if (direita < n && esquerda < n) {
            LocalDateTime dataDireita = obterData(senhas[direita][3]);
            if (dataDireita.isAfter(obterData(senhas[maior][3])) && dataDireita.isAfter(obterData(senhas[esquerda][3])))
                maior = direita;
        }

        // trocar a raiz se necessário e chamar heapify no filho afetado
        if (maior != i) {
            trocar(senhas, i, maior);
            heapify(senhas, n, maior);
        }
    }

    public static void heapsortDecrescente(String[][] senhas) {
        int n = senhas.length;

        // construir heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyDecrescente(senhas, n, i);

        // extrair elementos do heap um a um
        for (int i = n - 1; i >= 0; i--) {
            // mover a raiz (maior elemento) para o fim
            trocar(senhas, 0, i);

            // chamar heapify no heap reduzido
            heapifyDecrescente(senhas, i, 0);
        }
    }

    public static void heapifyDecrescente(String[][] senhas, int n, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        // verificar se o filho esquerdo é menor que a raiz
        if (esquerda < n) {
            LocalDateTime dataRaiz = obterData(senhas[maior][3]);
            LocalDateTime dataEsquerda = obterData(senhas[esquerda][3]);
            if (dataEsquerda.isBefore(dataRaiz))
                maior = esquerda;
        }

        // verificar se o filho direito é menor que a raiz e o filho esquerdo
        if (direita < n) {
            LocalDateTime dataDireita = obterData(senhas[direita][3]);
            if (dataDireita.isBefore(obterData(senhas[maior][3])) && dataDireita.isBefore(obterData(senhas[esquerda][3])))
                maior = direita;
        }

        // trocar a raiz se necessário e chamar heapify no filho afetado
        if (maior != i) {
            trocar(senhas, i, maior);
            heapifyDecrescente(senhas, n, maior);
        }
    }

    public static void trocar(String[][] senhas, int i, int j) {
        String[] temp = senhas[i];
        senhas[i] = senhas[j];
        senhas[j] = temp;
    }

    public static LocalDateTime obterData(String dataString) {
        return LocalDateTime.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}