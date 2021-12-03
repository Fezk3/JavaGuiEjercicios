package contabilizarclicks;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyFrame extends JFrame implements ActionListener {
    
    private JPanel p1;
    private JLabel lab;
    private JButton btn;
    private int cont = 0;
    
    MyFrame(){
        
        this.setSize(400, 400);
        this.setTitle("Contabilizador de Clicks");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        iniciarComponentes();
        
        this.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(btn)){
            
            cont++;
            
            if(cont == 1){
                
                lab.setText("Boton Pulsado 1 vez");
                
            }
            else{
                
                lab.setText("Boton Pulsado " + cont + " veces");
                
            }
            
        }
        
    }
    
    public void iniciarComponentes(){
        
        colocarPanel();
        colocarEtiqueta();
        colocarBoton();
        
    }
    
    public void colocarPanel(){
        
        p1 = new JPanel();
        p1.setLayout(null);
        this.add(p1);
        
    }
    
    public void colocarEtiqueta(){
        
        lab = new JLabel("Pulsa el boton");
        lab.setBounds(0, 50, 400, 40);
        p1.add(lab);
        // Centrando la etiqueta
        lab.setHorizontalAlignment(SwingConstants.CENTER);
        
        lab.setFont(new Font("arial", 0, 20));
        
    }
    
    public void colocarBoton(){
        
        btn = new JButton("Pulsa aqui");
        btn.setBounds(90, 250, 200, 50);
        btn.setFont(new Font("cooper black", 0, 20));
        btn.addActionListener(this);
        p1.add(btn);
        
    }
    
}
