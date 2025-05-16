import java.awt.*;
import java.awt.event.*;

class CalcAwt extends WindowAdapter implements ActionListener {
    Frame f;
    Label l1;
    Button[] numberButtons = new Button[10];
    Button badd, bsub, bmult, bdiv, bcalc, bpts;
    double num1, num2, result;
    int operation; 
    CalcAwt() {
        f = new Frame("MY CALCULATOR");

        l1 = new Label();
        l1.setBackground(Color.LIGHT_GRAY);
        l1.setBounds(50, 50, 250, 50);

            for (int i = 0; i <= 9; i++) {
            numberButtons[i] = new Button(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        numberButtons[7].setBounds(50, 120, 50, 50);
        numberButtons[4].setBounds(50, 180, 50, 50);
        numberButtons[1].setBounds(50, 240, 50, 50);
        numberButtons[0].setBounds(50, 300, 50, 50);

        numberButtons[8].setBounds(120, 120, 50, 50);
        numberButtons[5].setBounds(120, 180, 50, 50);
        numberButtons[2].setBounds(120, 240, 50, 50);

        numberButtons[9].setBounds(190, 120, 50, 50);
        numberButtons[6].setBounds(190, 180, 50, 50);
        bcalc = new Button("=");     bcalc.setBounds(190, 300, 50, 50);
        bcalc.addActionListener(this);

        Button b3 = numberButtons[3];
        b3.setBounds(190, 240, 50, 50);

        bpts = new Button(".");
        bpts.setBounds(120, 300, 50, 50);
        bpts.addActionListener(this);

        badd = new Button("+");   badd.setBounds(260, 300, 50, 50);
        bsub = new Button("-");   bsub.setBounds(260, 240, 50, 50);
        bmult = new Button("*");  bmult.setBounds(260, 180, 50, 50);
        bdiv = new Button("/");   bdiv.setBounds(260, 120, 50, 50);

        badd.addActionListener(this);
        bsub.addActionListener(this);
        bmult.addActionListener(this);
        bdiv.addActionListener(this);

        f.addWindowListener(this);
        f.add(l1);

       
        for (Button b : numberButtons) f.add(b);
        f.add(bpts); f.add(badd); f.add(bsub); f.add(bmult); f.add(bdiv);
        f.add(bcalc); f.add(b3);

        f.setSize(360, 400);
        f.setLayout(null);
        f.setVisible(true);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        f.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentText = l1.getText();

        for (int i = 0; i <= 9; i++) {
            if (e.getSource() == numberButtons[i]) {
                l1.setText(currentText + i);
                return;
            }
        }

        if (e.getSource() == bpts) {
            if (!currentText.contains(".")) {
                l1.setText(currentText + ".");
            }
            return;
        }

        try {
            num1 = Double.parseDouble(currentText);
        } catch (NumberFormatException ex) {
            l1.setText("Invalid Format");
            return;
        }

        if (e.getSource() == badd) {
            operation = 1;
            l1.setText("");
        } else if (e.getSource() == bsub) {
            operation = 2;
            l1.setText("");
        } else if (e.getSource() == bmult) {
            operation = 3;
            l1.setText("");
        } else if (e.getSource() == bdiv) {
            operation = 4;
            l1.setText("");
        } else if (e.getSource() == bcalc) {
            try {
                num2 = Double.parseDouble(l1.getText());
            } catch (Exception ex) {
                l1.setText("ENTER NUMBER FIRST");
                return;
            }

            switch (operation) {
                case 1: result = num1 + num2; break;
                case 2: result = num1 - num2; break;
                case 3: result = num1 * num2; break;
                case 4:
                    if (num2 == 0) {
                        l1.setText("Cannot divide by 0");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    l1.setText("Error");
                    return;
            }

            l1.setText(String.valueOf(result));
        }
    }

    public static void main(String args[]) {
        new CalcAwt();
    }
}
