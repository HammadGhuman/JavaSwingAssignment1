import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.*;

public class Card extends JFrame {

    private int currentCard = 1;
    private int like[] = new int[5];
    private CardLayout cardLayoutObject;

    public Card() {
        try {
            File file1 = new File("1.txt");
            File file2 = new File("2.txt");
            File file3 = new File("3.txt");
            File file4 = new File("4.txt");
            File file5 = new File("5.txt");

            if (!file1.exists()) {
                file1.createNewFile();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
            if (!file3.exists()) {
                file3.createNewFile();
            }
            if (!file4.exists()) {
                file4.createNewFile();
            }
            if (!file5.exists()) {
                file5.createNewFile();
            }

            FileInputStream fin1 = new FileInputStream("1.txt");
            FileInputStream fin2 = new FileInputStream("2.txt");
            FileInputStream fin3 = new FileInputStream("3.txt");
            FileInputStream fin4 = new FileInputStream("4.txt");
            FileInputStream fin5 = new FileInputStream("5.txt");

            like[0] = fin1.read();
            like[1] = fin2.read();
            like[2] = fin3.read();
            like[3] = fin4.read();
            like[4] = fin5.read();
            fin1.close();
            fin2.close();
            fin3.close();
            fin4.close();
            fin5.close();
        } catch (

        IOException e1) {
            e1.printStackTrace();
        }

        setTitle("Photo Album");
        setSize(720, 900);

        JPanel cardPanel = new JPanel();

        cardLayoutObject = new CardLayout();
        cardPanel.setLayout(cardLayoutObject);

        JPanel jpPic1 = new JPanel();
        JPanel jpPic2 = new JPanel();
        JPanel jpPic3 = new JPanel();
        JPanel jpPic4 = new JPanel();
        JPanel jpPic5 = new JPanel();

        JLabel jLabel[] = new JLabel[5];

        jLabel[0] = new JLabel();
        jLabel[0].setText("Picture 1 \n Likes " + like[0]);
        jLabel[0].setIcon(new ImageIcon("/Volumes/External/JavaProjects/JavaAssignment-1/K20-1720/src/pic1.jpeg"));
        jLabel[0].setSize(720, 720);
        jLabel[0].setHorizontalTextPosition(JLabel.CENTER);
        jLabel[0].setVerticalTextPosition(JLabel.BOTTOM);

        jLabel[1] = new JLabel();
        jLabel[1].setText("Picture 2 \n Likes " + like[1]);
        jLabel[1].setIcon(new ImageIcon("/Volumes/External/JavaProjects/JavaAssignment-1/K20-1720/src/pic2.jpeg"));
        jLabel[1].setSize(720, 720);
        jLabel[1].setHorizontalTextPosition(JLabel.CENTER);
        jLabel[1].setVerticalTextPosition(JLabel.BOTTOM);

        jLabel[2] = new JLabel();
        jLabel[2].setText("Picture 3 \n Likes " + like[2]);
        jLabel[2].setIcon(new ImageIcon("/Volumes/External/JavaProjects/JavaAssignment-1/K20-1720/src/pic3.jpeg"));
        jLabel[2].setSize(720, 720);
        jLabel[2].setHorizontalTextPosition(JLabel.CENTER);
        jLabel[2].setVerticalTextPosition(JLabel.BOTTOM);

        jLabel[3] = new JLabel();
        jLabel[3].setText("Picture 4 \n Likes " + like[3]);
        jLabel[3].setIcon(new ImageIcon("/Volumes/External/JavaProjects/JavaAssignment-1/K20-1720/src/pic4.jpeg"));
        jLabel[3].setSize(720, 720);
        jLabel[3].setHorizontalTextPosition(JLabel.CENTER);
        jLabel[3].setVerticalTextPosition(JLabel.BOTTOM);

        jLabel[4] = new JLabel();
        jLabel[4].setText("Picture 5 \n Likes " + like[4]);
        jLabel[4].setIcon(new ImageIcon("/Volumes/External/JavaProjects/JavaAssignment-1/K20-1720/src/pic5.jpeg"));
        jLabel[4].setSize(720, 720);
        jLabel[4].setHorizontalTextPosition(JLabel.CENTER);
        jLabel[4].setVerticalTextPosition(JLabel.BOTTOM);

        jpPic1.add(jLabel[0]);
        jpPic2.add(jLabel[1]);
        jpPic3.add(jLabel[2]);
        jpPic4.add(jLabel[3]);
        jpPic5.add(jLabel[4]);

        cardPanel.add(jpPic1, "1");
        cardPanel.add(jpPic2, "2");
        cardPanel.add(jpPic3, "3");
        cardPanel.add(jpPic4, "4");
        cardPanel.add(jpPic5, "5");

        JPanel jpButton1 = new JPanel();
        JPanel jpButton2 = new JPanel();
        JPanel jpButton3 = new JPanel();

        JButton nextButton = new JButton("Next");
        JButton previousButton = new JButton("Previous");
        JButton likeButton = new JButton("Like");
        JButton dislikeButton = new JButton("Dislike");

        jpButton1.add(nextButton);
        jpButton2.add(previousButton);
        jpButton3.add(likeButton);
        jpButton3.add(dislikeButton);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (currentCard < 5) {
                    currentCard = currentCard + 1;
                    cardLayoutObject.show(cardPanel, "" + (currentCard));
                }
            }
        });
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                if (currentCard > 1) {
                    currentCard = currentCard - 1;
                    cardLayoutObject.show(cardPanel, "" + (currentCard));
                }
            }
        });

        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileInputStream fin = new FileInputStream(currentCard + ".txt");
                    like[currentCard - 1] = fin.read();
                    fin.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                like[currentCard - 1] = like[currentCard - 1] + 1;
                jLabel[currentCard - 1].setText("Picture " + currentCard + "    Likes " + like[currentCard - 1]);
                try {
                    FileOutputStream fout = new FileOutputStream(currentCard + ".txt");
                    fout.write(like[currentCard - 1]);
                    fout.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        });

        dislikeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileInputStream fin = new FileInputStream(currentCard + ".txt");
                    like[currentCard - 1] = fin.read();
                    fin.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                if (like[currentCard - 1] > 0) {
                    like[currentCard - 1] = like[currentCard - 1] - 1;
                    jLabel[currentCard - 1].setText("Picture " + currentCard + "    Likes " + like[currentCard - 1]);
                }
                try {
                    FileOutputStream fout = new FileOutputStream(currentCard + ".txt");
                    fout.write(like[currentCard - 1]);
                    fout.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }

            }
        });
        getContentPane().add(cardPanel, BorderLayout.NORTH);
        getContentPane().add(jpButton1, BorderLayout.EAST);
        getContentPane().add(jpButton3, BorderLayout.SOUTH);
        getContentPane().add(jpButton2, BorderLayout.WEST);

    }
}
