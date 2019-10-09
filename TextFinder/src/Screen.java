import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Screen extends JFrame implements ActionListener {

    public Screen(){
        //Para poder cerrar la ventana
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        //Se agrega un layout
        setLayout( new BorderLayout() );

        //Se crea el editor de texto y se agrega a un scroll
        txp = new JTextPane();
        JScrollPane jsp = new JScrollPane();
        jsp.setViewportView( txp );

        add( jsp, BorderLayout.CENTER );

        //Se crea un boton para abrir el archivo
        JButton btn = new JButton( "Abrir" );
        btn.addActionListener( this );
        //btn.setIcon( new ImageIcon( getClass().getResource( "Abrir.png" ) ) );

        add( btn, BorderLayout.NORTH );

        //Tamaño de la ventana
        setSize( 500, 500 );

        //Esto sirve para centrar la ventana
        setLocationRelativeTo( null );

        //Hacemos visible la ventana
        setVisible( true );
    }




