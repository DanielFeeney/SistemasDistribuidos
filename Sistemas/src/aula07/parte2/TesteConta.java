package aula07.parte2;
public class TesteConta {
    private double saldo = 1000.0;
    public TesteConta( )
    {
    }

    public synchronized double getSaldo() {
        return this.saldo;
    }

    public void sacar(double valor) {
        new Thread (() -> saque(valor)).start();	
    }

    public void depositar(double valor) {
        new Thread (() -> deposito(valor)).start();
    }

    public synchronized void saque( double valor )
    //public void sacar( double valor )
    {
        if ( valor <= saldo )
        {
            saldo -= valor;
        }
        else
        {
            System.out.println( "Saldo Insuficiente" );
        }
    }

    public synchronized void deposito( double valor )
    //public void depositar( double valor )
    {
        saldo += valor;
    }

    public static void main( String[] args ) {
        long t = System.currentTimeMillis( );
        TesteConta c1 = new TesteConta( );

        for ( long i = 0; i < 10000; i++ )
        {
            c1.depositar(1);
            c1.depositar(1);
            c1.depositar(1);
            c1.depositar(1);
            c1.depositar(1);

            c1.sacar(1);
            c1.sacar(1);
            c1.sacar(1);
            c1.sacar(1);
            c1.sacar(1);
        }
        System.out.println( " Verificação 1: Saldo da conta é de: " + c1.getSaldo() );
        try{
            Thread.sleep(10); 
        } 
        catch (InterruptedException ex) {
            System.out.println(ex);
        }	
        
        System.out.println( " Verificação 2: Saldo da conta é de: " + c1.getSaldo() );
        System.out.println( " Tempo: " + (System.currentTimeMillis( ) - t) );
    }
}
