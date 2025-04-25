package entities;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	private String nomePlataforma;
    private List<Filme> filmes;
    
    public Catalogo(String nomePlataforma) {
    	this.nomePlataforma = nomePlataforma;
        this.filmes = new ArrayList<>();
    }
    
    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }
    
    public void exibirFilmes() {
        for (Filme filme : filmes) {
            filme.exibir();
        }
    }
    
    public String getNomePlataforma() {
        return nomePlataforma;
    }
    
    public void exibirDetalhesPorGenero(String genero) {
        for (Filme filme : filmes) {
            if (filme.getGenero().equalsIgnoreCase(genero)) {
                filme.exibir();
            }
        }
    }
    
//    public void exibirDetalhesPorGenero(String genero) {
//        boolean encontrouFilme = false;
//        for (Filme filme : filmes) {
//            if (filme.getGenero().equalsIgnoreCase(genero)) {
//                filme.exibir();
//                encontrouFilme = true;
//            }
//        }
//        if (!encontrouFilme) {
//            System.out.println("Nenhum filme encontrado para o gênero: " + genero);
//        }
//    }
    
    public int contarFilmesPorGenero(String genero) {
        int count = 0;
        for (Filme filme : filmes) {
            if (filme.getGenero().equalsIgnoreCase(genero)) {
                count++;
            }
        }
        return count;
    }
    
    public int somarDuracaoPorGenero(String genero) {
        int total = 0;
        for (Filme filme : filmes) {
            if (filme.getGenero().equalsIgnoreCase(genero)) {
                total += filme.getDuracao();
            }
        }
        return total;
    }
}
