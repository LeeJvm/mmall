import javax.lang.model.element.VariableElement;
import java.util.Vector;

this is from mmall-k  change

public class main {

    private static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) {
      /*  String ss = "dfadsfdnuifgdufadyfuiduifgauifuidsfguisdhfuid";
        char[] chars = ss.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
            if (i=='c') {
                System.out.println("这是c字符啊");

        }*/
        while (true) {


            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }


        Thread removeThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }

            }
        });

        Thread printThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < vector.size(); i++) {
                    System.out.println(vector.get(i));
                }
            }
        });

        removeThread.start();
        printThread.start();

        while (Thread.activeCount()>1);

    }

    }
}
