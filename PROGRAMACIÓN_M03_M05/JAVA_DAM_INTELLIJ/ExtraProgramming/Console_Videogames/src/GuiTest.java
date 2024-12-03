import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiTest {

    public static void main(String[] args)
    {
        JFrame ventana = new JFrame("Formulario de Ejemplo");

        // Configurar el tamaño de la ventana
        ventana.setSize(400, 300);

        // Configurar el cierre de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un panel para organizar los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 5, 10)); // 4 filas, 2 columnas, espaciado

        // Crear componentes del formulario
        JLabel etiquetaNombre = new JLabel("Nombre:");
        JTextField campoNombre = new JTextField();

        JLabel etiquetaEmail = new JLabel("Email:");
        JTextField campoEmail = new JTextField();

        JLabel etiquetaPassword = new JLabel("Contraseña:");
        JPasswordField campoPassword = new JPasswordField();

        JButton botonEnviar = new JButton("Enviar");

        // Añadir funcionalidad al botón
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                String email = campoEmail.getText();
                String password = new String(campoPassword.getPassword());
                JOptionPane.showMessageDialog(ventana,
                        "Datos ingresados:\nNombre: " + nombre + "\nEmail: " + email);
            }
        });

        // Añadir componentes al panel
        panel.add(etiquetaNombre);
        panel.add(campoNombre);
        panel.add(etiquetaEmail);
        panel.add(campoEmail);
        panel.add(etiquetaPassword);
        panel.add(campoPassword);
        panel.add(new JLabel()); // Espacio vacío
        panel.add(botonEnviar);

        // Añadir el panel a la ventana
        ventana.add(panel);

        // Hacer la ventana visible
        ventana.setVisible(true);
    }
}