import javax.swing.*;
import java.util.Stack;

public class Funciones {
    private Stack<Integer> Torre1 = new Stack<>();
    private Stack<Integer> Torre2 = new Stack<>();
    private Stack<Integer> Torre3 = new Stack<>();


    public double NumMinMov(int objetivo) {
        return Math.pow(2, objetivo) - 1;
    }

    public void Limpiar(int ContNumMov, int NumMinMov, Stack<String> s1, Stack<String> s2, Stack<String> s3, JTextArea t1, JTextArea t2,
                        JTextArea t3, JTextField t4, JTextField t5) {
        s1.clear();
        s2.clear();
        s3.clear();
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        ContNumMov = 0;
        NumMinMov = 0;
    }

    public int CantMov(int ContNumMov) {
        return ContNumMov++;
    }


    public String CrearTorre(int n) {

        if (n == 1) {
            return "o";
        } else if (n <= 0) {
            return "";
        } else {

            return CrearTorre(n - 1) + "o";
        }

    }

    public Stack<String> LlenarStack(int n, Stack<String> m, int objetivo) {
        for (int i = 0; i < n; i++) {
            m.push(CrearTorre(objetivo - i));
        }
        return m;
    }

    public void CambiarLado(JTextArea textArea1, JTextArea textArea2, Stack<String> StackTorreA, Stack<String> StackTorreB) {
        textArea1.setText("");
        textArea2.setText("");

        if (!StackTorreA.isEmpty()) {
            if (StackTorreB.isEmpty() || StackTorreA.peek().compareTo(StackTorreB.peek()) <= -1) {
                StackTorreB.push(StackTorreA.pop());


                for (int i = StackTorreA.size() - 1; i >= 0; i--) {
                    textArea1.setText(textArea1.getText() + "\n" + StackTorreA.get(i));
                }
                for (int i = StackTorreB.size() - 1; i >= 0; i--) {
                    textArea2.setText(textArea2.getText() + "\n" + StackTorreB.get(i));
                }
            }
        }
    }

    /*  public void Resolver(int n, Stack<String> A, Stack<String> B, Stack<String> C,JTextArea textArea1, JTextArea textArea2,JTextArea textArea3) {


          if (n == 1) {

              JOptionPane.showMessageDialog(null,"Paso 1");
              CambiarLado(textArea1, textArea3, A, C);
              JOptionPane.showMessageDialog(null,"Paso 2");
              CambiarLado(textArea1, textArea2, A, B);


          } else {

              Resolver(n - 2, A, C, B, textArea1,textArea2,textArea3);
              JOptionPane.showMessageDialog(null,"Paso "+(n));
              CambiarLado(textArea3, textArea2, C, B);
              JOptionPane.showMessageDialog(null,"Paso "+(n+1));
              CambiarLado(textArea1, textArea3, A, C);
              JOptionPane.showMessageDialog(null,"Paso "+(n+2));
              CambiarLado(textArea2, textArea1, B, A);
              JOptionPane.showMessageDialog(null,"Paso "+(n+3));
              CambiarLado(textArea2, textArea3, B, C);
              JOptionPane.showMessageDialog(null,"Paso "+(n+4));
              CambiarLado(textArea1, textArea3, A, C);

          }
      }*/
    public void resolverHanoi(int numDiscos, Stack<String> origen, Stack<String> auxiliar, Stack<String> destino,JTextArea textArea1,JTextArea textArea2, JTextArea textArea3) {
        if (numDiscos == 1) {

            CambiarLado(textArea1, textArea3, origen, destino);
            System.out.println("Mover disco de " + origen + " a " + destino);
        } else {

            resolverHanoi(numDiscos - 1, origen, destino, auxiliar, textArea1,textArea2, textArea3);


            CambiarLado(textArea1, textArea3, origen, destino);
            System.out.println("Mover disco de " + origen + " a " + destino);

            resolverHanoi(numDiscos - 1, auxiliar, origen, destino,textArea2,textArea1, textArea3);
        }
    }
}
