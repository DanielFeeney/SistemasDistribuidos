package aula07.atividade3;

public class Exercicio2 implements Runnable{
	
	private int[] vetor = new int [100];
	
	public Exercicio2() {
		for(int i = 0; i < 100; i++) {
			vetor[i] = (int)(Math.random() * 10);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public synchronized void conta(int coluna, int valor)
    {
		for(int i = coluna; i < coluna + 10; i++) {
			vetor[i] = vetor[i] * valor;
			System.out.println("Resulatado da posicao "+ (i + 1) +":"+vetor[i]);
		}
		
    }
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Inicializando o vetor!!");
		
		Exercicio2 ex02 = new Exercicio2();
		
		int constante = 5;
		
		for(int i = 0; i < 100; i+=10 ) {
			int j = i;
			new Thread (() -> ex02.conta(j,constante)).start();		
		}
		
		try{
            Thread.sleep(100); 
        } 
        catch (InterruptedException ex) {
            System.out.println(ex);
        }		 
		
		System.out.println("Término do Programa!");
	}

}
