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

    //------------------------------Action Performed-------------------------------//
    public void actionPerformed( ActionEvent e ){
        JButton btn = (JButton)e.getSource();
        if( btn.getText().equals( "Abrir" ) )
        {
            if( abrirArchivo == null ) abrirArchivo = new JFileChooser();
            //Con esto solamente podamos abrir archivos
            abrirArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );

            int seleccion = abrirArchivo.showOpenDialog( this );

            if( seleccion == JFileChooser.APPROVE_OPTION )
            {
                File f = abrirArchivo.getSelectedFile();
                try
                {
                    String nombre = f.getName();
                    String path = f.getAbsolutePath();
                    String contenido = getArchivo( path );
                    //Colocamos en el titulo de la aplicacion el
                    //nombre del archivo
                    this.setTitle( nombre );

                    //En el editor de texto colocamos su contenido
                    txp.setText( contenido );

                }catch( Exception exp){}
            }
        }
    }
    //-----------------------------------------------------------------------------//



}


