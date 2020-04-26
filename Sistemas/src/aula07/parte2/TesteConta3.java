package aula07.parte2;
public class TesteConta3 {
    private double saldo = 1000.0;
    public TesteConta3( )
    {
    }

    public double getSaldo() {
        return this.saldo;
    }

    public synchronized void saque( double valor )
    //public void saque( double valor )
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
    //public void deposito( double valor )
    {
        saldo += valor;
    }

    public static void main( String[] args ) {
        long t = System.currentTimeMillis( );
        TesteConta3 c1 = new TesteConta3( );

        for ( long i = 0; i < 10000; i++ )
        {
            new Thread (() -> c1.deposito(1)).start();
            new Thread (() -> c1.deposito(1)).start();
            new Thread (() -> c1.deposito(1)).start();
            new Thread (() -> c1.deposito(1)).start();
            new Thread (() -> c1.deposito(1)).start();

            new Thread (() -> c1.saque(1)).start();	
            new Thread (() -> c1.saque(1)).start();	
            new Thread (() -> c1.saque(1)).start();	
            new Thread (() -> c1.saque(1)).start();	
            new Thread (() -> c1.saque(1)).start();	
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

