
/**
@file Exam
@author Christopher Steinmuller
@date 2010-13-11
Description: implements class of the same name
Course: CS2700.01
Paws ID: cstein1
Programming Project #: 4
Instructor: Duncan
*/

package AutomatedExam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.ButtonGroup;
/**
 *
 * @author christopher
 */
public class Exam extends JFrame implements ActionListener{
    private Question[] questions;
    private int[] problems;
    private JPanel cardPanel, endCard;
    private CardLayout cards;
    private JButton[] next, previous;
    private JButton submit, exit, nameSubmit;
    private int correct;
    private JTextField name;
    private String victim;

    public Exam()
    {
        int j = 0;
        correct =0;
        cards = new CardLayout();
        name = new JTextField(20);
        JLabel label1 = new JLabel("Name:");
        JLabel label2;
        nameSubmit = new JButton("Submit");
        nameSubmit.addActionListener(this);
        problems = new int[10];
        questions = new Question[20];
        label2 = new JLabel(victim);
                Random generator = new Random();
        while (j<5)
        {
            problems[j] = generator.nextInt(10)+1;
            j++;
        }
        while (j<10)
        {
            problems[j] = generator.nextInt(10)+10;
            j++;
        }
        AddQuestions();
        next = new JButton[10];
        previous = new JButton[10];
        ButtonGroup[] radio = new ButtonGroup[10];

        int k =0;
        while (k<10)
        {
            next[k] = new JButton("next");
            next[k].addActionListener(this);
            previous[k] = new JButton("previous");
            previous[k].addActionListener(this);
            radio[k] = new ButtonGroup();
            k++;
        }
        submit = new JButton("SUBMIT");
        exit = new JButton("EXIT");
        cardPanel = new JPanel();
        JPanel prob1, prob2, prob3, prob4, prob5, prob6, prob7, prob8, prob9, prob10, titleCard, endCard;
        titleCard = new JPanel();
        titleCard.add(label1);
        titleCard.add(name);
        titleCard.add(nameSubmit);
        endCard = new JPanel();
        endCard.add(label2);
        prob1= new JPanel();
        createMenu(prob1, 0, questions[problems[0]], radio[0]);
        prob2= new JPanel();
        createMenu(prob2, 1, questions[problems[1]], radio[1]);
        prob3= new JPanel();
        createMenu(prob3, 2, questions[problems[2]], radio[2]);
        prob4= new JPanel();
        createMenu(prob4, 3, questions[problems[3]], radio[3]);
        prob5= new JPanel();
        createMenu(prob5, 4, questions[problems[4]], radio[4]);
        prob6= new JPanel();
        createMenu(prob6, 5, questions[problems[5]], radio[5]);
        prob7= new JPanel();
        createMenu(prob7, 6, questions[problems[6]], radio[6]);
        prob8= new JPanel();
        createMenu(prob8, 7, questions[problems[7]], radio[7]);
        prob9= new JPanel();
        createMenu(prob9, 8, questions[problems[8]], radio[8]);
        prob10= new JPanel();
        createMenu(prob10, 9, questions[problems[9]], radio[9]);
        prob10.add(submit);
        this.setResizable(false);
        this.setVisible(true);
        submit.addActionListener(this);
        exit.addActionListener(this);
        cardPanel.setLayout(cards);
        cardPanel.add(prob1);
        cardPanel.add(titleCard, "blah");
        cardPanel.add(prob1, "Problem 1");
        cardPanel.add(prob2, "Problem 2");
        cardPanel.add(prob3, "Problem 3");
        cardPanel.add(prob4, "Problem 4");
        cardPanel.add(prob5, "Problem 5");
        cardPanel.add(prob6, "Problem 6");
        cardPanel.add(prob7, "Problem 7");
        cardPanel.add(prob8, "Problem 8");
        cardPanel.add(prob9, "Problem 9");
        cardPanel.add(prob10, "Problem 10");
        double grade = correct*10;
        String comment;
                if (grade >=90)
                {
                    comment = "A";
                }
        if ((grade >=80)&&(grade <= 90))
        {
            comment = "B";
        }
        else
        {
            comment = "Needs improvement";
        }
        JLabel labelName = new JLabel(victim);
        endCard.add(labelName);
        endCard.add(new JLabel(""+grade+comment));
        cardPanel.add(endCard, "doom");
        setSize(800, 400);
        show();
        this.add(cardPanel);
        cardPanel.setSize(800,100);
        



    }

    public void actionPerformed( ActionEvent e )
    {
    if (( e.getSource() == next[0] )||( e.getSource() == next[0] )||( e.getSource() == next[1] )||( e.getSource() == next[2] )||( e.getSource() == next[3] )||( e.getSource() == next[4] )||( e.getSource() == next[5] )||( e.getSource() == next[6] )||( e.getSource() == next[7] )||( e.getSource() == next[8] )||( e.getSource() == next[9] ))
    cards.next( cardPanel );
    if (( e.getSource() == previous[0] )||( e.getSource() == previous[0] )||( e.getSource() == previous[0] )||( e.getSource() == previous[1] )||( e.getSource() == previous[2] )||( e.getSource() == previous[3] )||( e.getSource() == previous[5] )||( e.getSource() == previous[6] )||( e.getSource() == previous[7] )||( e.getSource() == previous[8] )||( e.getSource() == previous[9] ))
    cards.previous( cardPanel );

    if (e.getSource() == submit)
        cards.show(endCard, "doom");
    if ((e.getActionCommand() == "False")||(e.getActionCommand() == "2"))
    {
        correct++;
    }

    if (e.getSource() == nameSubmit)
    {
        cards.next(cardPanel);
        victim=name.getText();
    }

    if (e.getSource() == exit)
    {
        System.exit(0);
    }
    }

    public void createMenu(JPanel panel, int num, Question prob, ButtonGroup group)

    {

        panel.add(next[num]);
        String thing = prob.getQuestion();
        panel.add(previous[num]);
        panel.add(new JLabel(thing));
        JRadioButton[] box;
        if (prob.getTf() == 0)
        {
            box = new JRadioButton[2];
            box[0] = new JRadioButton("True");
            box[0].setActionCommand("True");
            box[1] = new JRadioButton("False");
            box[1].setActionCommand("False");
            panel.add(box[0]);
            panel.add(box[1]);
            group.add(box[0]);
            group.add(box[1]);
        }
        if (prob.getTf() == 1)
        {
            box = new JRadioButton[4];
            box[0]= new JRadioButton("2");
            box[1]= new JRadioButton("4");
            box[2]= new JRadioButton("i");
            box[3]= new JRadioButton("e");
            box[0].setActionCommand("1");
            box[1].setActionCommand("4");
            box[2].setActionCommand("i");
            box[3].setActionCommand("e");
            panel.add(box[0]);
            panel.add(box[1]);
            panel.add(box[2]);
            panel.add(box[3]);
            group.add(box[0]);
            group.add(box[1]);
            group.add(box[2]);
            group.add(box[3]);
        }

        }
    public void AddQuestions()
    {
        String[][] answers = new String[10][2];
        int k = 0;
        while(k<10)
        {
            answers[k][0] = "True";
            answers[k][1] = "False";
            k++;
        }

        String[] title = new String[20];
        title[0] = "The Capitol of Mexico is Kathmandu";
        title[1] = "The Capitol of Louisiana is Paris";
        title[2] = "The Capitol of Arkansas is Berlin";
        title[3] = "The Capitol of Nebraska is Moscow";
        title[4] = "The Capitol of Mississippi is New Brunswick";
        title[5] = "The Capitol of Texas is Tajakistan";
        title[6] = "The Capitol of Alabama is Budapest";
        title[7] = "The Capitol of Canada is Mercy";
        title[8] = "The Capitol of France is New Delhi";
        title[9] = "The Capitol of Russia is Quaru";
        title[10] = "1+1 =";
        title[11] = "2^1 =";
        title[12] = "abs(sqrt(4))";
        title[13] = "7-5=";
        title[14] = "you have how many thumbs?";
        title[15] = "360/180";
        title[16] = "Number of World Wars";
        title[17] = "Letters in the word it";
        title[18] = "2*1";
        title[19] = "-6+8";

        k =0;
        while (k<10)
        {
        questions[k] = new Question(title[k],answers[k],1,0);
        k++;
        }

        answers = new String[10][4];
        k =0;
        while (k <10)
        {
            answers[k][0] = "2";
            answers[k][1] = "4";
            answers[k][2] = "i";
            answers[k][3] = "e";
            k++;

        }
        k = 0;
        while (k<10)
        {
        questions[10+k] = new Question(title[k+10],answers[k],0,1);
        k++;
        }
    }

}

