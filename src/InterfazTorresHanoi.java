import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class InterfazTorresHanoi extends JFrame {
    private JPanel panel1;
    private JButton bButton;
    private JButton cButton;
    private JButton aButton;
    private JButton cButton1;
    private JButton aButton1;
    private JButton bButton1;
    private JComboBox comboBox1;
    private JTextField textField22;
    private JTextField textField23;
    private JButton iniciarButton;
    private JButton reiniciarButton;
    private JButton resolverButton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private int ContNumMov=0;
    private Funciones f= new Funciones();
    private Stack<String> StackTorreA=new Stack<>();
    private Stack<String> StackTorreB=new Stack<>();
    private Stack<String> StackTorreC=new Stack<>();
    int NumMinMov=0;
    public InterfazTorresHanoi() {
        super ("Torres de Hanoi");
        setContentPane(panel1);

        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                textArea2.setText("");
                textArea3.setText("");

                StackTorreA=new Stack<>();
                StackTorreB=new Stack<>();
                StackTorreC=new Stack<>();
                int objetivo=Integer.parseInt(comboBox1.getSelectedItem().toString());
                textArea1.setText("");
                textField22.setText(String.valueOf(String.format("%.0f",f.NumMinMov(Integer.parseInt(comboBox1.getSelectedItem().toString())))));
                textField23.setText(String.valueOf(ContNumMov));

                f.LlenarStack(Integer.parseInt(comboBox1.getSelectedItem().toString()),StackTorreA,objetivo);

                for (int i=Integer.parseInt(comboBox1.getSelectedItem().toString())-1;i>=0;i--) {
                    textArea1.setText(textArea1.getText()+"\n"+StackTorreA.get(i));
                }

            }
        });
        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (!StackTorreA.isEmpty()) {
                    if (StackTorreB.isEmpty()||StackTorreA.peek().compareTo(StackTorreB.peek()) <= -1){
                        ContNumMov=ContNumMov+1;
                        textField23.setText(String.valueOf(ContNumMov));
                        f.CambiarLado(textArea1,textArea2,StackTorreA, StackTorreB);
                }else{
                        JOptionPane.showMessageDialog(null, "Movimiento no valido");
                    }
            }
            }

        });
        aButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!StackTorreB.isEmpty()) {
                    ContNumMov=ContNumMov+1;
                    textField23.setText(String.valueOf(ContNumMov));
                    if (StackTorreA.isEmpty()||StackTorreB.peek().compareTo(StackTorreA.peek()) <= -1){

                        f.CambiarLado(textArea2,textArea1,StackTorreB, StackTorreA);
                    }else{
                        JOptionPane.showMessageDialog(null, "Movimiento no valido");
                    }
                }
            }
        });
        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!StackTorreA.isEmpty()) {
                    if (StackTorreC.isEmpty()||StackTorreA.peek().compareTo(StackTorreC.peek()) <= -1){
                        ContNumMov=ContNumMov+1;
                        textField23.setText(String.valueOf(ContNumMov));
                        f.CambiarLado(textArea1,textArea3,StackTorreA, StackTorreC);
                    }else{
                        JOptionPane.showMessageDialog(null, "Movimiento no valido");
                    }
                }
            }
        });
        cButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!StackTorreB.isEmpty()) {
                    if (StackTorreC.isEmpty()||StackTorreB.peek().compareTo(StackTorreC.peek()) <= -1){
                        ContNumMov=ContNumMov+1;
                        textField23.setText(String.valueOf(ContNumMov));
                        f.CambiarLado(textArea2,textArea3,StackTorreB, StackTorreC);
                    }else{
                        JOptionPane.showMessageDialog(null, "Movimiento no valido");
                    }
                }
            }
        });
        aButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!StackTorreC.isEmpty()) {
                    if (StackTorreA.isEmpty()||StackTorreC.peek().compareTo(StackTorreA.peek()) <= -1){
                        ContNumMov=ContNumMov+1;
                        textField23.setText(String.valueOf(ContNumMov));
                        f.CambiarLado(textArea3,textArea1,StackTorreC, StackTorreA);
                    }else{
                        JOptionPane.showMessageDialog(null, "Movimiento no valido");
                    }
                }
            }
        });
        bButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!StackTorreC.isEmpty()) {
                    if (StackTorreB.isEmpty()||StackTorreC.peek().compareTo(StackTorreB.peek()) <= -1){
                        ContNumMov=ContNumMov+1;
                        textField23.setText(String.valueOf(ContNumMov));
                        f.CambiarLado(textArea3,textArea2,StackTorreC, StackTorreB);
                    }else{
                        JOptionPane.showMessageDialog(null, "Movimiento no valido");
                    }
                }
            }
        });
        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.Limpiar(ContNumMov, NumMinMov, StackTorreA,StackTorreB,StackTorreC,textArea1,textArea2,
                        textArea3,textField22,textField23);
                ContNumMov=0;
            }
        });
        resolverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.resolverHanoi(Integer.parseInt(comboBox1.getSelectedItem().toString()),StackTorreA,StackTorreB,StackTorreC,textArea1,textArea2,textArea3);
            textField23.setText(String.valueOf(String.format("%.0f",f.NumMinMov(Integer.parseInt(comboBox1.getSelectedItem().toString())))));
            }
        });
    }


}
