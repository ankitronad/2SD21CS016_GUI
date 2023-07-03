package Home1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 class WrongMarks extends Exception {
  public WrongMarks(String de) {
    super(de);
   }
  public String toString(){
    return "Input Error";
   }
}
 class Pr1 extends JFrame implements ActionListener {
    JFrame f ;
    JButton b;
    Container contpane;
    JPanel p,p1,p2,p3,p4,p5,p6;
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5;
     Pr1(String title) {
        super(title);

        b = new JButton("Compute");
        b.addActionListener(this);
        b.setBackground(Color.WHITE);
        
        l1 = new JLabel("    Enter the IA 1 marks:" );
        t1 = new JTextField(5);

        l2 = new JLabel("    Enter the IA 2 marks:");
        t2 = new JTextField(5);

        l3 = new JLabel("    Enter the IA 3 marks:");
        t3 = new JTextField(5);

        l4 = new JLabel("    Enter the CTA marks:");
        t4 = new JTextField(5);

        l5 = new JLabel("    Enter the SEE marks:");
        t5 = new JTextField(5);
        l6 = new JLabel("Grade calculator");
        l7 = new JLabel("  Total Marks:");
        l8 = new JLabel("   Grade:");
        l = new JLabel();
        p =new JPanel();
        p1 = new JPanel();
        p3 = new JPanel();
        p2 = new JPanel();
        p4 =new JPanel();
        p5 =new JPanel();
        p6 =new JPanel();
       
        p.add(l1);
        p1.add(t1);
        p.add(l2);
        p1.add(t2);
        p.add(l3);
        p1.add(t3);
        p.add(l4);
        p1.add(t4);
        p.add(l5);
        p1.add(t5);
        p.add(l7) ;
        p.add(l);
        p1.add(l8);
        p4.add(b);
        p5.add(l6);
        p.setLayout(new GridLayout(7, 1, 50 , 30));
        p1.setLayout(new GridLayout(7, 1, 40, 30));
        contpane = this.getContentPane();
        contpane.add(p,BorderLayout.WEST);
        contpane.add(p5,BorderLayout.NORTH);
        contpane.add(p1,BorderLayout.CENTER);
        contpane.add(p3,BorderLayout.EAST);
        contpane.add(p4,BorderLayout.SOUTH);
       
        p5.setBackground(Color.WHITE);
     }

     @Override
      public void actionPerformed(ActionEvent e) {
        double sum,cie;
        
        double ia1 = Double.parseDouble(t1.getText());
        double ia2 = Double.parseDouble(t2.getText());
        double ia3 = Double.parseDouble(t3.getText());
        double cta = Double.parseDouble(t4.getText());
        double see = Double.parseDouble(t5.getText());

       try {
          if ( ia1<0 || ia1>20)
              throw new WrongMarks("wrong") ;
        }
          catch (WrongMarks wm){
            JOptionPane.showMessageDialog(null, "IA1 marks not in range(0-20)", "Marks out of range", JOptionPane.OK_CANCEL_OPTION); 
          }
       try {
          if ( ia2<0 || ia2>20)
              throw new WrongMarks("wrong") ;
        }
          catch (WrongMarks wm){
            JOptionPane.showMessageDialog(null, "IA2 marks not in range(0-20)", "Marks out of range", JOptionPane.OK_CANCEL_OPTION); 
          }
       try {
          if ( ia3<0 || ia3>20)
              throw new WrongMarks("wrong") ;
        }
          catch (WrongMarks wm){
            JOptionPane.showMessageDialog(null, "IA3 marks not in range(0-20)", "Marks out of range", JOptionPane.OK_CANCEL_OPTION); 
          }
       try {
          if ( cta<0 || cta>10)
              throw new WrongMarks("wrong") ;
        }
          catch (WrongMarks wm){
            JOptionPane.showMessageDialog(null, "CTA marks not in range(0-10)", "Marks out of range", JOptionPane.OK_CANCEL_OPTION); 
          }
       try {
          if ( see<0 || see>100)
              throw new WrongMarks("wrong") ;
        }
          catch (WrongMarks wm){
            JOptionPane.showMessageDialog(null, "SEE marks not in range(0-100)", "Marks out of range", JOptionPane.OK_CANCEL_OPTION); 
          }

         if(ia1>ia3 && ia2>ia3)
           cie = ia1 + ia2 + cta;
        else if(ia1>ia2 && ia3>ia2)
           cie = ia1 + ia3 + cta;
        else 
           cie = ia2 + ia3 + cta;
           try {
          if ( cie<20)
              throw new WrongMarks("wrong") ;
        }
          catch (WrongMarks wm){
            JOptionPane.showMessageDialog(null, "Student is detained from taking SEE ", "Detained", JOptionPane.ERROR_MESSAGE); 
          }
           if (see<38) {
        	   l7.setText("  Student Failed");
               l8.setText("   Grade  : F"); 
           return;
           }
           if(see==38 || see==39) {
        	   see=40;
           }
           if(see%2 == 0)
        	   sum = cie + see/2;
           else
        	   sum = cie +(see +1)/2;
              if(sum<=100)
            l7.setText("  Total marks:"+sum);
              else
            	  l7.setText("  Total marks:");
        	  
        if(cie<20)
          l8.setText("  Grade is : "); 
        else if(see<=38 && sum<=40)
          l8.setText("  Grade is : F");
        else if (sum>=90 && sum<=100)
          l8.setText("  Grade is : S");
        else if(sum>=80 && sum <=89)
          l8.setText("  Grade is : A");
        else if(sum>=70 && sum <=79)
          l8.setText("  Grade is : B");
        else if(sum>=60 && sum <=69)
          l8.setText("  Grade is : C");
        else if(sum>=50 && sum<= 59)
          l8.setText("  Grade is : D");
        else if(sum>=40 && sum <=49)
          l8.setText("  Grade is : E");
        else 
          System.out.println("");
      }
 }

 public class Pro{
    public static void main(String[] args) {
     JFrame f = new Pr1("Student Grade Calculator");
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.setBounds(600, 140, 450, 450);
      f.setVisible(true);
   }
 }