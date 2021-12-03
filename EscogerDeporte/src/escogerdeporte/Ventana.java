package escogerdeporte;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ventana extends JFrame {

    private JPanel panel;
    private JLabel etiqueta;
    private JRadioButton rb1, rb2, rb3, rb4;
    // Imagenes en JLabel
    private JLabel imagen;

    Ventana() {

        this.setSize(800, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Escoge un Video Juego!");
        this.setLocationRelativeTo(null);

        iniciarComponentes();

        this.setVisible(true);

    }

    private void iniciarComponentes() {

        colocarPanel();
        colocarEtiqueta();
        colocarRadioBotones();

    }

    private void colocarPanel() {

        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);

    }

    private void colocarEtiqueta() {

        etiqueta = new JLabel("Escoja su Juego favorito");
        etiqueta.setBounds(20, 20, 250, 40);
        etiqueta.setFont(new Font("arial", 0, 18));
        panel.add(etiqueta);

    }

    private void colocarRadioBotones() {

        rb1 = new JRadioButton("Halo");
        rb1.setBounds(20, 80, 100, 40);
        rb1.setFont(new Font("arial", 0, 18));
        panel.add(rb1);

        rb2 = new JRadioButton("Cookie Clicker");
        rb2.setBounds(20, 150, 150, 40);
        rb2.setFont(new Font("arial", 0, 18));
        panel.add(rb2);

        rb3 = new JRadioButton("TBoI");
        rb3.setBounds(20, 220, 100, 40);
        rb3.setFont(new Font("arial", 0, 18));
        panel.add(rb3);

        rb4 = new JRadioButton("Terraria");
        rb4.setBounds(20, 290, 100, 40);
        rb4.setFont(new Font("arial", 0, 18));
        panel.add(rb4);

        // Solo 1 seleccionado a la vez
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rb1);
        grupo.add(rb2);
        grupo.add(rb3);
        grupo.add(rb4);

        //EVENTO
        eventoDeAccion();

    }

    private void eventoDeAccion() {

        imagen = new JLabel();
        imagen.setBounds(300, 80, 400, 220);
        panel.add(imagen);

        // buen modo de poner imagenes!
        final ImageIcon imagenHalo = new ImageIcon(getClass().getResource("/Imagenes/Halo.jpg"));
        final ImageIcon imagenCookie = new ImageIcon(getClass().getResource("/Imagenes/Cookie.jpg"));
        final ImageIcon imagenIsaac = new ImageIcon(getClass().getResource("/Imagenes/TBoI.jpg"));
        final ImageIcon imagenTerraria = new ImageIcon(getClass().getResource("/Imagenes/Terraria.jpg"));

        ActionListener evento1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                imagen.setIcon(new ImageIcon(imagenHalo.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
            }
        };
        rb1.addActionListener(evento1);

        ActionListener evento2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                imagen.setIcon(new ImageIcon(imagenCookie.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
            }
        };
        rb2.addActionListener(evento2);

        ActionListener evento3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                imagen.setIcon(new ImageIcon(imagenIsaac.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
            }
        };
        rb3.addActionListener(evento3);

        ActionListener evento4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                imagen.setIcon(new ImageIcon(imagenTerraria.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
            }
        };
        rb4.addActionListener(evento4);

    }

}
