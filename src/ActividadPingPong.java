/*
* PSP
* Raul plaza galvez
* Actividad 2.1.6 Ping Pong
* */

public class ActividadPingPong {
    public static void main(String[] args) {

        //Crea el recurso compartido
        SharedObject consola = new SharedObject();


        //Crea dos hilos
        ThreadSync threadSync1 = new ThreadSync(consola, "[PING]");
        ThreadSync threadSync2 = new ThreadSync(consola, "[PONG]");

        //Ejecuta
        threadSync1.start();
        threadSync2.start();
    }
}