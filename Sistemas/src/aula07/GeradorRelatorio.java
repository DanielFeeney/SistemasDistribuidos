package aula07;

public class GeradorRelatorio implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i< 50; i++) {
			System.out.println("Linha: "+i);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Início da Aplicação");
		
		//Criação do objeto executável
		GeradorRelatorio relatorio = new GeradorRelatorio();
		BarraDeProgresso barra = new BarraDeProgresso();
		
		//Criação da Thread
		Thread threadRelatorio = new Thread(relatorio);
		Thread threadBarra = new Thread(barra);
		
		//Início da execução da Thread
		threadRelatorio.start();
		threadBarra.start();
		
		//Faça o teste, execute com as duas linhas abaixo comentadas,
		//depois, remova os comentários e rode o programa novamente,
		//compare as saídas!
		
		  threadRelatorio.join(); 
		  threadBarra.join();
		 
		
		System.out.println("Fim da Aplicação");
	}

}
