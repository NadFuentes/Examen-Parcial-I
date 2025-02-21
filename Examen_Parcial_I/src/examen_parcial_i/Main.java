/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen_parcial_i;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Nadiesda Fuentes
 */
public class Main{
    public static void main(String[] args) {
        // Crear la instancia de UberSocial
        UberSocial uberSocial = new UberSocial();
        
             // Crear la ventana principal
        JFrame frame = new JFrame("UberSocial GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());
        
            // Panel para agregar cuentas
        JPanel accountPanel = new JPanel();
        accountPanel.setLayout(new GridLayout(3, 2));
        
          JTextField facebookUserField = new JTextField();
        JTextField twitterUserField = new JTextField();
        JButton addFacebookButton = new JButton("Agregar Facebook");
        JButton addTwitterButton = new JButton("Agregar Twitter");

        accountPanel.add(new JLabel("Usuario de Facebook:"));
        accountPanel.add(facebookUserField);
        accountPanel.add(addFacebookButton);
        accountPanel.add(new JLabel("Usuario de Twitter:"));
        accountPanel.add(twitterUserField);
        accountPanel.add(addTwitterButton);

        frame.add(accountPanel, BorderLayout.NORTH);

        // Área de texto para mostrar perfiles y timelines
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Panel para agregar amigos, posts y comentarios
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new GridLayout(4, 2));

        JTextField friendField = new JTextField();
        JTextField postField = new JTextField();
        JTextField commentField = new JTextField();
        JButton addFriendButton = new JButton("Agregar Amigo");
        JButton addPostButton = new JButton("Agregar Post");
        JButton addCommentButton = new JButton("Agregar Comentario");
        JButton showProfilesButton = new JButton("Mostrar Perfiles y Timelines");

        actionPanel.add(new JLabel("Amigo:"));
        actionPanel.add(friendField);
        actionPanel.add(addFriendButton);
        actionPanel.add(new JLabel("Post:"));
        actionPanel.add(postField);
        actionPanel.add(addPostButton);
        actionPanel.add(new JLabel("Comentario:"));
        actionPanel.add(commentField);
        actionPanel.add(addCommentButton);
        actionPanel.add(showProfilesButton);

        frame.add(actionPanel, BorderLayout.SOUTH);

        // Acciones de los botones
        addFacebookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = facebookUserField.getText();
                FacebookAccount facebookAccount = new FacebookAccount(user);
                uberSocial.addAccount(facebookAccount);
                displayArea.append("Cuenta de Facebook agregada: " + user + "\n");
            }
        });

        addTwitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = twitterUserField.getText();
                TwitterAccount twitterAccount = new TwitterAccount(user);
                uberSocial.addAccount(twitterAccount);
                displayArea.append("Cuenta de Twitter agregada: " + user + "\n");
            }
        });

        addFriendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String friend = friendField.getText();
                // Aquí puedes agregar lógica para determinar a qué cuenta agregar el amigo
                // Por simplicidad, se agrega al primer FacebookAccount
                if (!uberSocial.getFacebookAccounts().isEmpty()) {
                    uberSocial.getFacebookAccounts().get(0).addFriend(friend);
                    displayArea.append("Amigo agregado a Facebook: " + friend + "\n");
                }
            }
        });

        addPostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String post = postField.getText();
                // Aquí puedes agregar lógica para determinar a qué cuenta agregar el post
                // Por simplicidad, se agrega al primer FacebookAccount
                if (!uberSocial.getFacebookAccounts().isEmpty()) {
                    uberSocial.getFacebookAccounts().get(0).addPost(post);
                    displayArea.append("Post agregado a Facebook: " + post + "\n");
                }
            }
        });

        addCommentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String comment = commentField.getText();
                // Aquí puedes agregar lógica para determinar a qué post agregar el comentario
                // Por simplicidad, se agrega al primer post del primer FacebookAccount
                if (!uberSocial.getFacebookAccounts().isEmpty() && !uberSocial.getFacebookAccounts().get(0).getPosts().isEmpty()) {
                    uberSocial.getFacebookAccounts().get(0).addCommentToPost(0, comment);
                    displayArea.append("Comentario agregado al primer post de Facebook: " + comment + "\n");
                }
            }
        });

        showProfilesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.append("Perfiles y Timelines:\n");
                for (FacebookAccount fbAccount : uberSocial.getFacebookAccounts()) {
                    displayArea.append("Perfil de Facebook:\n" + fbAccount.getProfile() + "\n");
                    displayArea.append("Timeline de Facebook:\n" + fbAccount.getTimeline() + "\n");
                }
                for (TwitterAccount twAccount : uberSocial.getTwitterAccounts()) {
                    displayArea.append("Perfil de Twitter:\n" + twAccount.getProfile() + "\n");
                    displayArea.append("Timeline de Twitter:\n" + twAccount.getTimeline() + "\n");
                }
            }
        });

        // Mostrar la ventana
        frame.setVisible(true);
    }
}
    