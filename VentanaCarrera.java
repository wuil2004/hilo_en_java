import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCarrera extends JFrame {
    private Hilo tpikachu;
    private Hilo tgatito;
    private Hilo tgoku;
    private Hilo tosito;

    public VentanaCarrera() {
        super("CARRERA EPICA");
        JLabel pikachu, gatito, goku, osito, pika_pos, gatito_pos, goku_pos, osito_pos;
        JButton btnIniciar;
        JButton btnPausar;
        JButton btnContinuar;

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("src/img/images.png");
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        Image imagen_pika = new ImageIcon("src/img/pikachu.gif").getImage();
        ImageIcon iconPika = new ImageIcon(imagen_pika.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        pikachu = new JLabel();
        pikachu.setIcon(iconPika);
        pikachu.setBounds(50, 50, 50, 50);

        Image imagen_gatito = new ImageIcon("src/img/gatito.gif").getImage();
        ImageIcon iconGatito = new ImageIcon(imagen_gatito.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        gatito = new JLabel();
        gatito.setIcon(iconGatito);
        gatito.setBounds(50, 100, 50, 50);

        Image imagen_goku = new ImageIcon("src/img/goku.gif").getImage();
        ImageIcon iconGoku = new ImageIcon(imagen_goku.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        goku = new JLabel();
        goku.setIcon(iconGoku);
        goku.setBounds(50, 200, 50, 50);

        Image imagen_osito = new ImageIcon("src/img/osito.gif").getImage();
        ImageIcon iconOsito = new ImageIcon(imagen_osito.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        osito = new JLabel();
        osito.setIcon(iconOsito);
        osito.setBounds(50, 250, 50, 50);

        pika_pos = new JLabel();
        pika_pos.setBounds(200, 50, 300, 50);

        gatito_pos = new JLabel();
        gatito_pos.setBounds(200, 100, 300, 50);

        goku_pos = new JLabel();
        goku_pos.setBounds(200, 200, 300, 50);

        osito_pos = new JLabel();
        osito_pos.setBounds(200, 250, 300, 50);

        btnIniciar = new JButton("Iniciar");
        btnIniciar.setBounds(100, 300, 100, 50);

        btnPausar = new JButton("Pausar");
        btnPausar.setBounds(210, 300, 100, 50);
        btnPausar.setEnabled(false);

        btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(320, 300, 100, 50);
        btnContinuar.setEnabled(false);

        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnIniciar.setEnabled(false);
                btnPausar.setEnabled(true);
                btnContinuar.setEnabled(false);

                tpikachu = new Hilo("pikachu", pikachu, pika_pos, btnIniciar, btnPausar, btnContinuar);
                tgatito = new Hilo("gatito", gatito, gatito_pos, btnIniciar, btnPausar, btnContinuar);
                tgoku = new Hilo("goku", goku, goku_pos, btnIniciar, btnPausar, btnContinuar);
                tosito = new Hilo("osito", osito, osito_pos, btnIniciar, btnPausar, btnContinuar);
            }
        });

        btnPausar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tpikachu != null && tgatito != null && tgoku != null && tosito != null) {
                    tpikachu.pausar();
                    tgatito.pausar();
                    tgoku.pausar();
                    tosito.pausar();
                    btnPausar.setEnabled(false);
                    btnContinuar.setEnabled(true);
                }
            }
        });

        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tpikachu != null && tgatito != null && tgoku != null && tosito != null) {
                    tpikachu.reanudar();
                    tgatito.reanudar();
                    tgoku.reanudar();
                    tosito.reanudar();
                    btnPausar.setEnabled(true);
                    btnContinuar.setEnabled(false);
                }
            }
        });

        panel.add(pikachu);
        panel.add(pika_pos);
        panel.add(gatito);
        panel.add(gatito_pos);
        panel.add(goku);
        panel.add(goku_pos);
        panel.add(osito);
        panel.add(osito_pos);
        panel.add(btnIniciar);
        panel.add(btnPausar);
        panel.add(btnContinuar);

        add(panel); 
        setVisible(true);
    }
}
