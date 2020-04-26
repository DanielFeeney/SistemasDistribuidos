package aula07.parte2;
public class Conta implements Runnable
{
    private double saldo = 1000.0;
    
    public Conta( )
    {
    }

    //REGIÃO CRÍTICA (ver slides 25 e 26 Aula_07)
    //public synchronized void sacar( double valor )
    public synchronized void sacar( double valor )
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

    //REGIÃO CRÍTICA (ver slides 25 e 26 Aula_07)	
    //public synchronized void depositar( double valor )
    public synchronized void depositar( double valor )
    {
        saldo += valor;
    }


    public void run( )
    {
        for ( long i = 0; i < 1000000; i++ )
        {
            this.depositar(1);
            this.depositar(1);
            this.depositar(1);
            this.depositar(1);
            this.depositar(1);

            this.sacar(1);
            this.sacar(1);
            this.sacar(1);
            this.sacar(1);
            this.sacar(1);
        }
    }
    public static void main( String[] args )
    {
        long t = System.currentTimeMillis( );
        Conta c1 = new Conta( );

        Thread t1 = new Thread( c1 );
        Thread t2 = new Thread( c1 );

        t1.start( );
        t2.start( );

        try
        {
            t1.join( );
            t2.join( );
        }
        catch ( InterruptedException e )
        {
            System.out.println( "Erro" + e.getMessage( ) );
        }
        System.out.println( " Saldo da conta é de: " + c1.saldo );
        System.out.println( " Tempo: " + (System.currentTimeMillis( ) - t) );
    }
}