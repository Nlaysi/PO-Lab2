import java.util.Scanner;

import java.util.ArrayList;

import java.nio.file.Paths;


public class main {

    public static class Timer {
        private final long start;

        Timer(){
            start = System.currentTimeMillis();
        }

        public long Get(){
            return System.currentTimeMillis() - start;
        }
    }

    public static class Reader {
        ArrayList<String> container = new ArrayList<String>();

        Reader(String path){
            this.read(path);
        }

        public void read(String path){
            container.clear();

            Scanner scanner;

            try {
                scanner = new Scanner(Paths.get(path));
                while(scanner.hasNext())
                    container.add(scanner.next());
                scanner.close();
            } 
            catch (Exception e) {
                System.out.println(e);
            }
        }

        public ArrayList<String> Get(){
            return container;
        }
    }

    public static class Calculator {
        private float total_value;
        private float value;

        Calculator(){
            total_value = 0;
            value = 0;
        }
        

        /**
         * <p>Clear all fiedls<p>
         */
        private void clear(){
            total_value = 0;
            value = 0;
        }

        public void calculate(String command){
            switch (command) {
                case ("+"):
                    this.summation();
                    break;
                case ("-"):
                    this.subtraction();
                    break;
                case ("*"):
                    this.multiplication();
                    break;
                case ("/"):
                    this.division();
                    break;
                case ("c"):
                    this.clear();
                    break;
                default:
                    float v;
                    try {
                        v = Float.parseFloat(command);
                        this.set_value(v);
                    } 
                    catch (NumberFormatException e) {
                        System.out.println("Command unknown!");
                    }
                    break;
            }
            
        }

        private void set_value(float value) {
            this.value = value; 
        }

        private void summation(){
            total_value += value;
        }
        private void subtraction(){
            total_value -= value;
        }
        private void multiplication(){
            total_value *= value;
        }
        private void division(){
            total_value /= value;
        }

        public float GetTotalValue(){
            return total_value;
        }

    }

    public static void main(String[] args) {
        //Timer t = new Timer();
        Calculator c = new Calculator();
        Reader file = new Reader("C:\\Users\\Vanya\\Documents\\JavaProject\\Calculator\\calculator.in");

        ArrayList<String> list = file.Get();
        
        for (String string : list) {
            c.calculate(string);
            System.out.println(c.GetTotalValue());
        }
    }
}