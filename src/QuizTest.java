import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizTest extends JFrame implements ActionListener {


    JLabel label;
    JRadioButton radioButtons[] = new JRadioButton[5];
    JButton btnNext, btnResult;
    ButtonGroup  bg;
    int count  =0, current  = 1, x = 1, y = 1 , now = 0;
    int m[] = new int [10];




    // constructor
    QuizTest(String s){
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        
        for (int i =0 ; i < 5; i++){
            radioButtons[i] = new JRadioButton();
            add(radioButtons[i]);
            bg.add(radioButtons[i]);
        }
        
         btnNext = new JButton("next");
         btnResult  = new JButton("Result"); 
         btnResult.setVisible(true);
         btnResult.addActionListener(this);
         btnNext.addActionListener(this);
         add(btnNext);
         add(btnResult);
         
         setData();
         label.setBounds(30,40,450,20);
         radioButtons[0].setBounds(50,80,450,20);
         radioButtons[1].setBounds(50,110,200,20);
         radioButtons[2].setBounds(50,140,200,20);
         radioButtons[3].setBounds(50,170,200,20);
         btnNext.setBounds(100,240,100,30);
         btnResult.setBounds(270,240,100,30);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(null);
         setVisible(true);
         setSize(600,350);





    }

       void setData() {
        radioButtons[4].setSelected(true);
        if (current == 0){
            label.setText("Question 1: Which is the official language for Android Development");
            radioButtons[0].setText("Java");
            radioButtons[1].setText("Kotlin");
            radioButtons[2].setText("C++");
            radioButtons[3].setText("Javascript");
        }
        if (current == 1){
            label.setText("Question 2: What is the default value of long variable?");
            radioButtons[0].setText("0");
            radioButtons[1].setText("0.0");
            radioButtons[2].setText("0L is ans");
            radioButtons[3].setText("not known");
        }
        if (current == 2){
            label.setText("Question 3: What kind of variables a class can consist of");
            radioButtons[0].setText("class variables, instance variables");
            radioButtons[1].setText("class variables, local variables, instance variable is ans");
            radioButtons[2].setText("class variables");
            radioButtons[3].setText("class variables, local variables");
        }
        if (current == 3){
            label.setText("Question 4: What is function overloading?");
            radioButtons[0].setText("Methods with same name but different parameter, is ans");
            radioButtons[1].setText("Methods with same but different return types");
            radioButtons[2].setText("Methods with same name, same parameter types but different parameter names");
            radioButtons[3].setText("None of the above");
        }
        if (current == 4){
            label.setText("Question 5: What is Serialization?");
            radioButtons[0].setText("Serialization is the process of writing the state of an object to another object.");
            radioButtons[1].setText("Serialization is teh process of writing the state of an object to a byte stream. is ans");
            radioButtons[2].setText("Both of the above");
            radioButtons[3].setText("None of the above");
        }
        if (current == 5){
            label.setText("Question 6: Which of the following is a thread safe");
            radioButtons[0].setText("String builder");
            radioButtons[1].setText("StringBuffer is ans");
            radioButtons[2].setText("Both of the above");
            radioButtons[3].setText("None of the above");
        }
        if (current == 6){
            label.setText("Question 7: What is the size of boolean variable?");
            radioButtons[0].setText("8 bits");
            radioButtons[1].setText("16 bits is ans");
            radioButtons[2].setText("32 bits");
            radioButtons[3].setText("not known");
        }
        if (current == 7){
            label.setText("Question 8: What is the default value of Boolean variable?");
            radioButtons[0].setText("true");
            radioButtons[1].setText("false in ans");
            radioButtons[2].setText("null");
            radioButtons[3].setText("not defined");
        }
        if (current == 8){
            label.setText("Question 9: Type of data primitive is correct ,except");
            radioButtons[0].setText("byte");
            radioButtons[1].setText("short");
            radioButtons[2].setText("int");
            radioButtons[3].setText("Boolean");
        }
        if (current == 9){
            label.setText("Question 10: Accessible modifier in Java is true, except ");
            radioButtons[0].setText("Public");
            radioButtons[1].setText("Private");
            radioButtons[2].setText("Protected");
            radioButtons[3].setText("null");
        }

        label.setBounds(30,40,450,200);
        for (int i =0 , j =0 ;  i<=90; i+=30, j++){
            radioButtons[j].setBounds(50,80+i,200,20);
        }

    }

    boolean checkAns(){
        if (current ==0){
            return (radioButtons[0].isSelected());
        }
        if (current ==1){
            return (radioButtons[2].isSelected());
        }
        if (current ==2){
            return (radioButtons[1].isSelected());
        }
        if (current ==3){
            return (radioButtons[0].isSelected());
        }
        if (current ==4){
            return (radioButtons[1].isSelected());
        }
        if (current ==5){
            return (radioButtons[1].isSelected());
        }
        if (current ==6){
            return (radioButtons[1].isSelected());
        }
        if (current ==7){
            return (radioButtons[1].isSelected());
        }
        if (current ==8){
            return (radioButtons[3].isSelected());
        }
        if (current ==9){
            return (radioButtons[3].isSelected());
        }


        return false;
    }

    public static void main(String[] args) {

        new QuizTest("Simple Quiz App");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnNext){
            if(checkAns())
                count = count +1;
            current++;
            setData();
            if(current ==9){
                btnNext.setEnabled(false);
                btnResult.setVisible(true);
                btnResult.setText("Result");
            }
        }
        if(e.getActionCommand().equals("Result")){
            if(checkAns())
                count = count +1;
            current++;
            JOptionPane.showMessageDialog(this,"Correct answer are" + count);
            System.exit(0);
        }
    }
}