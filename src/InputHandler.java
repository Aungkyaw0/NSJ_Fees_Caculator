import java.util.Scanner;

public class InputHandler{
    public String requestAthleteName() { /* Validation for Athlete Name*/
        Scanner sc = new Scanner(System.in);
        String name = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print("Enter Athlete Name :: ");
            String inp = sc.nextLine().trim();
            if (inp.isEmpty()) {
                System.out.println("!!! Empty Value, Pls Enter Again !!!");
            } else {
                try {
                    name = inp;
                    isValid = true;
                } catch (Exception e) {
                    System.out.println("!!! Invalid Input, Pls Enter Again !!!");
                }
            }
        }
        return name;
    }

    public int requestOperation(){
        Scanner sc = new Scanner(System.in);
        while(true){
            int op;
            System.out.print("Enter the operation number (1 or 2) :: ");
            op = sc.nextInt();
            if( op == 1 || op == 2){
                if(op == 1){
                    Main.isRegister = true;
                }
                return op;
            }else{
                System.out.println("!!!Pls enter 1 or 2 only!!!");
            }
        }
    }
    public String requestTrainingPlan(){
        Scanner sc = new Scanner(System.in);
        while (true){
            String tp="";
            System.out.print("Choose the training plan :: ");
            tp = sc.nextLine();
            if(!(tp.isEmpty()) || !(tp.isBlank()) ){
                if(tp.equalsIgnoreCase("Beginner") || tp.equalsIgnoreCase("Intermediate") || tp.equalsIgnoreCase("Elite")){
                    return tp;
                }
                System.out.println("!!! \"" + tp +"\" is not a valid string - Pleas enter (Beginner, Intermediate, Elite) only!!!");
            }
        }
    }

    public double requestCurrentWeight(){
        Scanner sc = new Scanner(System.in);
        double weight = 0.0;
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print("Enter your current weight :: ");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Invalid Input: Try Again");
            } else {
                try {
                    weight = Double.parseDouble(input);
                    isValidInput = true;
                } catch (NumberFormatException e) {
                    System.out.println( e.toString() +" : Try Again");
                }
            }
        }

        return weight;
    }

    public int requestCompetitionEntered(){
        Scanner sc = new Scanner(System.in);
        int numOfCom = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print("Enter the number of competition entered :: ");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Invalid Input: Try Again");
            } else {
                try {
                    numOfCom = Integer.parseInt(input);
                    isValidInput = true;
                } catch (NumberFormatException e) {
                    System.out.println( e.toString() +" : Try Again");
                }
            }
        }

        return numOfCom;
    }

    public String hasCoachingHour(){
        Scanner sc = new Scanner(System.in);
        String ans = "";
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.println("Have you taken private coaching hour? (y/n)");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Invalid Input, Pls enter (y,n) only, Try Again");
            } else if( !(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes") ||
                    input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) ){
                System.out.println("Invalid Input, Pls enter (y,n) only, Try Again");
            } else {
                try {
                    ans = input;
                    isValidInput = true;
                } catch (Exception e) {
                    System.out.println( e.toString() +" : Try Again");
                }
            }
        }

        return ans;
    }
}


