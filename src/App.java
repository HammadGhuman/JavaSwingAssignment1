import javax.swing.JFrame;

public class App {
    public static void main(String args[]) {
        Card card = new Card();
        card.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        card.setVisible(true);
        System.out.println("started");
    }
}
