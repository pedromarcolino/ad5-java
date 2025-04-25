package entities;

public class Filme {
	private String titulo;
	private String genero;
	private int duracao;
	
	public Filme(String titulo, String genero, int duracao) {
		this.titulo = titulo;
		this.genero = genero;
		this.duracao = duracao;
	}
	
	public void exibir() {
        System.out.println(titulo + " -> " + duracao + " minutos");
    }
	
	public String getGenero() {
        return genero;
    }
	
	public int getDuracao() {
        return duracao;
    }
	
	 public String getTitulo() {
	        return titulo;
	    }
}
