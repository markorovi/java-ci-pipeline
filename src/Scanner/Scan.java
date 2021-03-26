package Scanner;
import java.util.Scanner;

public class Scan {
    Scanner scan = new Scanner(System.in);
    private int first;
    private int second;
    private int count = 0;

    public void Read() {
        System.out.println("Type a digit");
        String input = scan.nextLine();
        try {
            int i = Integer.parseInt(input.trim());
            if (this.count == 0) {
                this.first = i;
                this.count++;
                this.Read();
            } else {
                this.second = i;
                this.count = 0;
                this.Operate();
                this.Read();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
            System.out.println("Type a digit");
            this.count = 0;
            this.Read();
        }
    }

    private void Operate(){
        System.out.println("1 for addition, 2 for substraction, 3 for multiplication, 4 for division.");
        String input = scan.nextLine();
        try {
            int i = Integer.parseInt(input.trim());
            if(i == 1){
                Calculator.Addition(this.first, this.second);
            }else if(i == 2){
                Calculator.Substraction(this.first, this.second);
            }else if(i == 3){
                Calculator.Multiplication(this.first, this.second);
            }else if(i == 4){
                Calculator.Division(this.first, this.second);
            }else{
                System.out.println("Type a valid digit");
                this.Operate();
            }


        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
            System.out.println("Type a digit");
            this.Operate();
        }
    }
}
