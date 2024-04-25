import java.util.Scanner;

public class Main {
    static boolean isRegister = false;
    public static void main(String[] args) {
        int op;
        String name = "";
        String trainingPlan = "";
        double currentWeight;
        Scanner sc = new Scanner(System.in);
        InputHandler handler = new InputHandler(); // Method for Requests
        //Welcome Message

        System.out.println(" ------------------------------------------------------ " +
                "\n| Welcome from the North Sussex Judo's Fees Calculator |\n --------" +
                "---------------------------------------------- ");
        System.out.print(" 1. Register\n 2. Login\n");

        // asking register or login
        op = handler.requestOperation();
        System.out.println("isREgister :: " + isRegister);

        // ask and validate athlete name
        name = handler.requestAthleteName();
        System.out.println("Name :: " + name);

        printTrainingPLan(); // displaying available training plan
        // Asking training plan type
        trainingPlan = handler.requestTrainingPlan();
        System.out.println("Selected Training Plan :: " + trainingPlan);

        // Asking current weight
        currentWeight = handler.requestCurrentWeight();
        System.out.println("Current Weight :: " + currentWeight);

        //Beginner
        if(trainingPlan.equalsIgnoreCase("Beginner")){
            BeginnerAthelte bAthlete = new BeginnerAthelte();
            bAthlete.setAthleteName(name);
            bAthlete.setTrainingPlan(trainingPlan);
            bAthlete.setCurrentWeight(currentWeight);
            String hasCoachingHour = handler.hasCoachingHour();
            // If user have private coaching hour
            if(hasCoachingHour.equalsIgnoreCase("y") || hasCoachingHour.equalsIgnoreCase("yes")){
                System.out.println("Enter the number of coaching hour :: ");
                bAthlete.setNumOfCoachingHour(sc.nextInt());
            }
            bAthlete.calculateTotalCosts();
            bAthlete.calculateTrainingFees();
        //Intermediate
        }else if(trainingPlan.equalsIgnoreCase("Intermediate")){
            IntermediateAthlete iAthlete = new IntermediateAthlete();
            iAthlete.setAthleteName(name);
            iAthlete.setTrainingPlan(trainingPlan);
            iAthlete.setCurrentWeight(currentWeight);
            if(!isRegister){
                System.out.println("Enter the number of competition entered :: ");
                iAthlete.setNumOfCompetition(sc.nextInt());
            }
            String hasCoachingHour = "";
            System.out.println("Have you taken private coaching hour? (y/n)");
            hasCoachingHour = sc.nextLine();
            if(hasCoachingHour.equalsIgnoreCase("y") || hasCoachingHour.equalsIgnoreCase("yes")){
                System.out.println("Enter the number of coaching hour :: ");
                iAthlete.setNumOfCoachingHour(sc.nextInt());
            }
            iAthlete.calculateTotalCosts();
            iAthlete.calculateTrainingFees();
        //Elite
        } else if(trainingPlan.equalsIgnoreCase("Elite")){
            EliteAthlete eAthlete = new EliteAthlete();
            eAthlete.setAthleteName(name);
            eAthlete.setTrainingPlan(trainingPlan);
            eAthlete.setCurrentWeight(currentWeight);
            if(!isRegister){
                System.out.println("Enter the number of competition entered :: ");
                eAthlete.setNumOfCompetition(sc.nextInt());
            }
            String hasCoachingHour = "";
            System.out.println("Have you taken private coaching hour? (y/n)");
            hasCoachingHour = sc.nextLine();
            if(hasCoachingHour.equalsIgnoreCase("y") || hasCoachingHour.equalsIgnoreCase("yes")){
                System.out.println("Enter the number of coaching hour :: ");
                eAthlete.setNumOfCoachingHour(sc.nextInt());
            }
            eAthlete.calculateTotalCosts();
            eAthlete.calculateTrainingFees();
        }
    }

    static void printTrainingPLan(){
        int tableWidth = 52;
        // Print top border
        System.out.println("+" + "-".repeat(tableWidth) + "+");
        // Print table header with formatted output
        System.out.printf("| %-10s | %10s | %10s |\n", "Training Plan", "SessionPerWeek", "Weekly Fee (£GBP)");
        // Print separator line
        System.out.println("+" + "-".repeat(tableWidth) + "+");
        // Print data rows with formatted output
        System.out.printf("| %-13s | %14s | %17.2f |\n", "Beginner", "2 session",  25.00);
        System.out.printf("| %-13s | %14s | %17.2f |\n", "Intermediate", "3 session", 30.00);
        System.out.printf("| %-13s | %14s | %17.2f |\n", "Elite", "5 session", 35.00);
        // Print bottom border
        System.out.println("+" + "-".repeat(tableWidth) + "+");
    }
}
