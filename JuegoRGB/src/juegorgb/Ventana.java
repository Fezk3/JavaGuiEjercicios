package juegorgb;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Ventana extends JFrame {
    
    private JPanel panel;
    private JLabel etiqueta;
    private JButton rojo, verde, azul;
    private int pulsado = 0;
    private int contRojo = 0, contVerde = 0, contAzul = 0;
    
    Ventana(){
        
        this.setSize(600, 400);
        this.setTitle("Juego de colores RGB");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        iniciarComponentes();
        
    }
    
    private void iniciarComponentes(){
        
        colocarPanel();
        colocarEtiqueta();
        colocarBotones();
        
        //eventos
        eventoRuedaDeRaton();
    
    }
    
    private void colocarPanel(){
        
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        
    }
    
    private void colocarEtiqueta(){
        
        etiqueta = new JLabel("Color (Rojo, Verde, Azul)");
        etiqueta.setBounds(100, 30, 400, 50);
        etiqueta.setFont(new Font("arial", 0, 20));
        //Etiqueta centrada
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(etiqueta);
        
    }
    
    private void colocarBotones(){
        
        /*
            pulsado = 1 -> btnRojo
            pulsado = 2 -> btnVerde
            pulsado = 3 -> btnAzul
        */
        
        rojo = new JButton("Rojo");
        rojo.setBounds(50, 230, 130, 50);
        rojo.setForeground(Color.red);  // color de la fuente
        rojo.setFont(new Font("arial rounded mt bold", 0, 20));
        panel.add(rojo);
        // action del boton rojo
        rojo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = 1;
            }
        });
        
        
        verde = new JButton("Verde");
        verde.setBounds(230, 230, 130, 50);
        verde.setForeground(Color.green);  // color de la fuente
        verde.setFont(new Font("arial rounded mt bold", 0, 20));
        panel.add(verde);
        // action del boton verde
        verde.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = 2;
            }
        });
        
        
        azul = new JButton("Azul");
        azul.setBounds(410, 230, 130, 50);
        azul.setForeground(Color.blue);  // color de la fuente
        azul.setFont(new Font("arial rounded mt bold", 0, 20));
        panel.add(azul);
        // action del boton azul
        azul.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = 3;
            }
        });
        
    }
    
    private void eventoRuedaDeRaton(){
        
        MouseWheelListener eventoRueda = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                
                if(pulsado != 0){
                    
                    if(pulsado == 1){  // btnRojo 
                        
                        contRojo += e.getWheelRotation();  // aumenta/disminuye
                        if(contRojo < 0) contRojo = 0;
                        if(contRojo > 255) contRojo = 255;
                        
                    }else if (pulsado == 2){  // btnVerde
                        
                        contVerde += e.getWheelRotation();
                        if(contVerde < 0) contVerde = 0;
                        if(contVerde > 255) contVerde = 255;
                        
                    }else{  // btnAzul
                        
                       contAzul += e.getWheelRotation();
                        if(contAzul < 0) contAzul = 0;
                        if(contAzul > 255) contAzul = 255;
                        
                    } 
                    
                }
                
                etiqueta.setText("Color (Rojo = " + contRojo + ", Verde = " + contVerde + ", Azul = " + contAzul + ")" );
                panel.setBackground(new Color(contRojo, contVerde, contAzul));  // RGB
                
            }
        };
        
        panel.addMouseWheelListener(eventoRueda);  //cambia color
        
    }
    
}
