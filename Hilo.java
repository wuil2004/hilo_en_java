import javax.swing.JLabel;
import java.awt.Color;


public class Hilo implements Runnable {
    Thread t;
    String nombre;
    JLabel personaje;
    JLabel labeFinal;
    private boolean paused = false;

    public static int lugar;
    public Hilo(String nombre, JLabel personaje, JLabel labeFinal) {
        this.nombre = nombre;
        this.labeFinal = labeFinal;
        this.personaje = personaje;
        t = new Thread(this, nombre);
        t.start();
    }

    @Override
    public void run() {
        int retardo;
        try {
            lugar = 1;
            retardo = (int) (Math.random() * 15) + 1;
            labeFinal.setForeground(Color.WHITE);
            labeFinal.setVisible(false);
            personaje.setVisible(true);

            for (int i = 50; i <= 500; i++) {
                synchronized (this) {
                    while (paused) {
                        wait();
                    }
                }
                personaje.setLocation(i, personaje.getY());
                Thread.sleep(retardo);
            }
            personaje.setVisible(false);
            labeFinal.setVisible(true);
            labeFinal.setText(nombre + " POSICION: " + lugar);
            lugar++;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public synchronized void pauseThread() {
        paused = true;
    }

    public synchronized void resumeThread() {
        paused = false;
        notify();
    }

}

