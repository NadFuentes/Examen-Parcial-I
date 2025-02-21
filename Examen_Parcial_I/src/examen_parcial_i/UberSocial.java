/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_parcial_i;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Nadiesda Fuentes
 */
public class UberSocial {
    private static ArrayList<SocialClass> redes = new ArrayList<>();

    public static SocialClass buscar(String username) {
        return buscarRecursivo(username, 0);
    }

    private static SocialClass buscarRecursivo(String username, int index) {
        if (index >= redes.size()) {
            return null;
        }
        SocialClass usuario = redes.get(index);
        if (usuario.getUsername().equals(username)) {
            return usuario;
        }
        return buscarRecursivo(username, index + 1);
    }

    public static void agregarCuenta(String username, String tipo) {
        if (buscar(username) == null) {
            if (tipo.equalsIgnoreCase("FACEBOOK")) {
                redes.add(new Facebook(username));
                JOptionPane.showMessageDialog(null, "Agregado exitosamente");
                System.out.println("Se creó una cuenta en Facebook con nombre de " + username);
            } else if (tipo.equalsIgnoreCase("TWITTER")) {
                redes.add(new Twitter(username));
                JOptionPane.showMessageDialog(null, "Agregado exitosamente");
                System.out.println("Se creó una cuenta en Twitter con nombre de " + username);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nombre de usuario no válido.");
            System.out.println("Nombre INVALIDO");
        }
    }

    public static void agregarPost(String username, String post) {
        SocialClass account = buscar(username);
        if (account != null) {
            if (account instanceof Twitter) {
                ((Twitter) account).addPost(post);
                System.out.println("Se agregó el post en Twitter");
            } else if (account instanceof Facebook) {
                ((Facebook) account).addPost(post);
                System.out.println("Se agregó el post en Facebook");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no existe.");
            System.out.println("Usuario no existente");
        }
    }

    public static void agregarComment(String user, int postID, String autor, String comment) {
        SocialClass account = buscar(user);
        if (account != null && account instanceof Facebook) {
            Comment comentario = new Comment(postID, autor, comment);
            ((Facebook) account).addComment(comentario);
            JOptionPane.showMessageDialog(null, "Agregado exitosamente");
            System.out.println("Se agregó comentario " + comentario);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no existe o no es de tipo Facebook.");
        }
    }

    public static void agregarAmigo(String user1, String user2) {
        SocialClass usuario1 = buscar(user1);
        SocialClass usuario2 = buscar(user2);
        if (usuario1 != null && usuario2 != null) {
            if ((usuario1 instanceof Twitter && usuario2 instanceof Twitter) || (usuario1 instanceof Facebook && usuario2 instanceof Facebook)) {
                usuario1.addFriend(user2);
                usuario2.addFriend(user1);
                JOptionPane.showMessageDialog(null, "Agregado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Ambos usuarios deben ser del mismo tipo de cuenta.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo completar la acción.");
        }
    }

    public static void profileFrom(String user) {
        SocialClass account = buscar(user);
        if (account != null) {
            account.myProfile();
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no existe.");
        }
    }
}