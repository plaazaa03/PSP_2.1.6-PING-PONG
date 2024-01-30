/**
 * Imprime ping pong
 *
 *
 */

public class ThreadSync extends Thread{


    //Atributos

    private SharedObject sharedObject;
    private String msg;

    //Constructor
    public ThreadSync(SharedObject sharedObject, String msg){
        this.sharedObject = sharedObject;
        this.msg = msg;
    }

    @Override
    public void run(){

        synchronized (sharedObject){
            for (int i = 1; i < 50; i++){
                sharedObject.printMsg(msg);

                //Aviso de ya se ha usado el objeto
                sharedObject.notify();

                try{
                    //Espera la llegada de un notify
                    sharedObject.wait();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                //Despierata a todos los que esten esperando (wait)

                sharedObject.notify();
            }
        }
    }
}
