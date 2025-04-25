package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import entities.Catalogo;
import entities.Filme;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        // 1. Solicitar o número de plataformas
        System.out.println("Seja bem-vindo(a)!");
        System.out.print("Quantas plataformas serão cadastradas? ");
        int numeroPlataformas = scanner.nextInt();
        scanner.nextLine();  // Consumir o '\n' da entrada do número
        
        // 2. Carregar os catálogos a partir dos arquivos
        List<Catalogo> catalogos = new ArrayList<>();

        for (int i = 1; i <= numeroPlataformas; i++) {
            System.out.print("Arquivo da Plataforma " + i + ": ");
            String arquivo = scanner.nextLine();

            // Criar o catálogo a partir do arquivo
            Catalogo catalogo = carregarCatalogo(arquivo);
            catalogos.add(catalogo);
        }
        
        // 3. Interagir com o usuário para escolher o gênero
        while (true) {
            System.out.print("Escolha um gênero, ou digite “0” para encerrar: ");
            String genero = scanner.nextLine();

            if (genero.equals("0")) {
                break; // Encerra o programa
            }

            // Exibir o total de filmes e a duração por gênero para cada plataforma
            int totalFilmes = 0;
            int totalDuracao = 0;

            for (Catalogo catalogo : catalogos) {
                int quantidade = catalogo.contarFilmesPorGenero(genero);
                int duracao = catalogo.somarDuracaoPorGenero(genero);
                totalFilmes += quantidade;
                totalDuracao += duracao;

                System.out.println(catalogo.getNomePlataforma() + ": Quantidade = " + quantidade + ", Duração = " + duracao + " minutos");
            }

            // Exibir o total geral
            System.out.println("Total: Quantidade = " + totalFilmes + ", Duração = " + totalDuracao + " minutos");

            // Perguntar se o usuário quer exibir os detalhes
            System.out.print("Exibir Detalhes (“s” ou “n”)? ");
            String exibirDetalhes = scanner.nextLine();

            if (exibirDetalhes.equalsIgnoreCase("s")) {
                for (Catalogo catalogo : catalogos) {
                    System.out.println(catalogo.getNomePlataforma() + ":");
                    catalogo.exibirDetalhesPorGenero(genero);
                }
            }
        }

        scanner.close();
    }
	
	// Função que carrega o catálogo de filmes a partir de um arquivo
	public static Catalogo carregarCatalogo(String arquivo) {
	    try {
	        Scanner fileScanner = new Scanner(new File(arquivo));

	        // Lê a primeira linha como nome da plataforma
	        String nomePlataforma = fileScanner.nextLine().trim();
	        Catalogo catalogo = new Catalogo(nomePlataforma);

	        // Agora lê os filmes
	        while (fileScanner.hasNextLine()) {
	            String linha = fileScanner.nextLine();
	            String[] dadosFilme = linha.split(";");
	            if (dadosFilme.length == 3) {
	                String titulo = dadosFilme[0].trim();
	                String genero = dadosFilme[1].trim();
	                int duracao = Integer.parseInt(dadosFilme[2].trim());
	                Filme filme = new Filme(titulo, genero, duracao);
	                catalogo.adicionarFilme(filme);
	            }
	        }
	        fileScanner.close();
	        return catalogo;

	    } catch (FileNotFoundException e) {
	        System.out.println("Erro ao abrir o arquivo: " + arquivo);
	    }
	    return null;  
	}
}

