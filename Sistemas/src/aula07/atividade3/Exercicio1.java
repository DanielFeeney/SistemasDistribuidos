package aula07.atividade3;

import aula07.BarraDeProgresso;
import aula07.GeradorRelatorio;

public class Exercicio1 implements Runnable {
	
	private int[][] vetor;
	
	public Exercicio1(int a, int b) {
		this.vetor = new int[a][b];
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < b; j++) {
				vetor[i][j] = (int)(Math.random() * 10);
				System.out.print(vetor[i][j]+",");
			}
			System.out.println();
		}
	};

	@Override
	public void run() {
		
		
	}
	
	public synchronized void conta( int linha, int coluna )
    {
		int result = 0;
		for(int j = 0; j < coluna; j++) {
			result += vetor[linha][j];			
		}
		System.out.println("Soma Linha "+ (linha + 1) +":"+result);
    }
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Inicializando a matriz!!");
		
		Exercicio1 ex01 = new Exercicio1(5, 5);
		
		for(int i = 0; i < 5; i++ ) {
			int j = i;
			new Thread (() -> ex01.conta(j,5)).start();		
		}
		
		try{
            Thread.sleep(10); 
        } 
        catch (InterruptedException ex) {
            System.out.println(ex);
        }		 
		
		System.out.println("Término do Programa!");
	}

}
