package aula07.atividade3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import aula07.parte2.fatorialParalelo;

public class Exercicio3{


	public static void main(String[] args) throws InterruptedException {
		System.out.println("Inicio da corrida!!");
		
		Carro carro1 = new Carro("Ayrton Senna");
		Carro carro2 = new Carro("Alain Prost");
		
		Long tempoFinal1 = 0L;
		Long tempoFinal2 = 0L;
		
		for(int i = 1; i <= 5; i++) {
			long startTime=System.currentTimeMillis();
			ExecutorService executar = Executors.newFixedThreadPool(1);
	        executar.execute(carro1);
	        executar.shutdown();
	        while (!executar.awaitTermination(120L, TimeUnit.SECONDS)) {
	            System.out.println("Not yet. Still waiting for termination");
	        }
	        tempoFinal1 += System.currentTimeMillis()-startTime;
		}
		
		for(int i = 1; i <= 5; i++) {
			long startTime=System.currentTimeMillis();
			ExecutorService executar = Executors.newFixedThreadPool(1); 
	        executar.execute(carro2);
	        executar.shutdown();
	        while (!executar.awaitTermination(120L, TimeUnit.SECONDS)) {
	            System.out.println("Not yet. Still waiting for termination");
	        }
	        tempoFinal2 += System.currentTimeMillis()-startTime;
		}
        
		if(tempoFinal1 == tempoFinal2) {
			System.out.println("Empatou");
		}
		else {
			System.out.println("O ganhador foi ");
			if(tempoFinal1 > tempoFinal2) {
				System.out.println(carro2.getPiloto());
			}
			else {
				System.out.println(carro1.getPiloto());
			}
		}
        

		
		System.out.println("Término do Programa!");
	}
	
	
	
}
