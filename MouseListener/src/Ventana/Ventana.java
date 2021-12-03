package Ventana;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

/*
    
    MouseListener & ActionListener -> boton
    MouseMotionListener & MouseWheelListener -> panel (p1)
    KeyListener -> TextField

*/

public class Ventana extends JFrame {
    
    private JPanel p1;
    private JTextArea area;
    private JButton btn;
    private JLabel saludo;
    private JTextField text;
    
    Ventana(){
        
        this.setSize(600,600);
        this.setTitle("MouseListener Ejemplo");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        colocaComponentes();
        
    }
    
    private void colocaComponentes(){
        
        colocaPanel();
        colocaCampoTexto();
        colocaAreaTexto();
        //colocaBoton();
        colocaSaludo();
        
    }
    
    private void colocaPanel(){
        
        p1 = new JPanel();
        p1.setLayout(null);  // para usar el setbounds
        
        // EVENTO MOVIMIENTO DEL RATON
        //eventoMovimientoMouse();
        //eventoMovimientoRuedaRaton();
        
        this.add(p1);
        
    }
    
    private void colocaCampoTexto(){
        
        text = new JTextField();
        text.setBounds(20, 20, 200, 30);
        p1.add(text);
        
        // Eventos del teclado
        eventosTeclado();
        
    }
    
    private void colocaAreaTexto(){
        
        area = new JTextArea();
        //area.setBounds(280, 20, 200, 300);    
        //p1.add(area); no es necesario aniadir el area, con solo scroll basta
        
        // Barras de desplazamiento (HORIZONTAL Y VERTICAL)
        JScrollPane barrasDesplazamiento = new JScrollPane(area);
        barrasDesplazamiento.setBounds(280, 20, 200, 300);
        // Barra Vertical solo cuando se necesite
        barrasDesplazamiento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        // Barra Horizontal solo cuando se necesite
        barrasDesplazamiento.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        p1.add(barrasDesplazamiento);
        
    }
    
    private void colocaBoton(){
        
        btn = new JButton("Presiona aqui!");
        btn.setBounds(150, 350, 150, 40);
        btn.setFont(new Font("arial", 0, 15));
        p1.add(btn);
        
        //eventoAction();
        //eventoMouse();
        
    }
    
    private void eventosTeclado(){
        
        KeyListener eventoTeclado = new KeyListener() {
            @Override  // solo letras, numeros, simbolos (chars unicode)
            public void keyTyped(KeyEvent e) {
                //area.append("keyTyped\n");
                
            }

            @Override  // Presion de tecla incluso si se mantiene presionada
            public void keyPressed(KeyEvent e) {
                //area.append("keyPressed\n");
                
            }

            @Override  // presionar y soltar cualquiera
            public void keyReleased(KeyEvent e) {
                //area.append("keyReleased\n");
                
                // Saber que tecla es precionada
                if(e.getKeyChar() == '\n'){
                    area.append("Enter\n");
                }
                if(e.getKeyChar() == ' '){
                    area.append("Espacio\n");
                }
                
            }
        };
        
        text.addKeyListener(eventoTeclado);
        
    }
    
    private void eventoMovimientoRuedaRaton(){
        
        MouseWheelListener ruedaRaton = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                
                // Determinando la direccion en la que se mueve el mouse wheel
                if(e.getPreciseWheelRotation() < 0){
                    
                    area.append("Rueda movida hacia arriba\n");
                    
                }else{
                    
                    area.append("Rueda movida hacia abajo\n");
                    
                }

            }
        };
        
        p1.addMouseWheelListener(ruedaRaton);
        
    }
    
    private void eventoMovimientoMouse(){
        
        MouseMotionListener movimientoMouse = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                area.append("mouseDragged\n");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                 area.append("mouseMoved\n");
            }
        };
        
        p1.addMouseMotionListener(movimientoMouse);
        
    }
    
    private void eventoMouse(){
        
        MouseListener mouseL = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //area.append("mouseClicked\n");
                
                // si el click + alt
                if(e.isAltDown()){
                    area.append("Alt\n");
                }else if(e.isControlDown()){
                    area.append("Ctrl\n");
                }else if(e.isShiftDown()){
                    area.append("Shift\n");
                }else if(e.isMetaDown()){
                    area.append("Click Derecho\n");
                }else{
                    area.append("Click Izquierdo\n");
                }
                
                // retorna contador de clicks
                if(e.getClickCount() == 5){
                    
                    area.setText("");
                    
                }
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //area.append("mousePressed\n");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //area.append("mouseReleased\n");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //area.append("mouseEntered\n");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //area.append("mouseExited\n");
            }
        };
        
        btn.addMouseListener(mouseL);
        
    }
    
    private void eventoAction(){
        
        ActionListener oyenteAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                saludo.setText("Hola " + area.getText());
                //area.setText("");
                
            }
        };
        
                
        btn.addActionListener(oyenteAction);
                
    }
    
    private void colocaSaludo(){
        
        saludo = new JLabel("", SwingConstants.CENTER);
        saludo.setBounds(150, 420, 100, 40);
        saludo.setFont(new Font("arial", 0, 15));
        p1.add(saludo);
        
    }
     
}
