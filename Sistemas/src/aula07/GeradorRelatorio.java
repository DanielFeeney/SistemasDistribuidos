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
		System.out.println("In�cio da Aplica��o");
		
		//Cria��o do objeto execut�vel
		GeradorRelatorio relatorio = new GeradorRelatorio();
		BarraDeProgresso barra = new BarraDeProgresso();
		
		//Cria��o da Thread
		Thread threadRelatorio = new Thread(relatorio);
		Thread threadBarra = new Thread(barra);
		
		//In�cio da execu��o da Thread
		threadRelatorio.start();
		threadBarra.start();
		
		//Fa�a o teste, execute com as duas linhas abaixo comentadas,
		//depois, remova os coment�rios e rode o programa novamente,
		//compare as sa�das!
		
		  threadRelatorio.join(); 
		  threadBarra.join();
		 
		
		System.out.println("Fim da Aplica��o");
	}

}
