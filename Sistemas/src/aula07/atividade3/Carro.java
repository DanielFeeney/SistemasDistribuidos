package aula07.atividade3;

public class Carro extends Thread {

	private String piloto;
	
	public Carro(String piloto) {
		this.piloto = piloto;
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}
	
	
	 @Override
	   public void run() {
         try {
            Thread.sleep(100);
         } catch (final Exception e) {
         }
	  }
}
