import java.text.DecimalFormat;
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
            BeginnerAthlete bAthlete = new BeginnerAthlete();
            bAthlete.setAthleteName(name);
            bAthlete.setTrainingPlan(trainingPlan);
            bAthlete.setCurrentWeight(currentWeight);
            String hasCoachingHour = handler.hasCoachingHour();
            // If user have private coaching hour
            if(hasCoachingHour.equalsIgnoreCase("y") || hasCoachingHour.equalsIgnoreCase("yes")){
                bAthlete.setNumOfCoachingHour(handler.requestCoachingHour());
            }
            System.out.println(bAthlete.toString());
            // Calculation
            bAthlete.calculateTotalCosts();
            bAthlete.calculateTrainingFees();
            bAthlete.calculateTotalCosts();
            //Output Displaying
            printResult(bAthlete.getAthleteName(), 0.0, bAthlete.getCoachingCost(), bAthlete.getTrainingCost(), bAthlete.getTotalCost());
        //Intermediate
        }else if(trainingPlan.equalsIgnoreCase("Intermediate")){
            IntermediateAthlete iAthlete = new IntermediateAthlete();
            iAthlete.setAthleteName(name);
            iAthlete.setTrainingPlan(trainingPlan);
            iAthlete.setCurrentWeight(currentWeight);

            //IF Login User, Ask number of competition entered
            if(!isRegister){
                iAthlete.setNumOfCompetition(handler.requestCompetitionEntered());
            }

            // Asking user have coaching hour or not
            String hasCoachingHour = handler.hasCoachingHour();
            // If user have private coaching hour
            if(hasCoachingHour.equalsIgnoreCase("y") || hasCoachingHour.equalsIgnoreCase("yes")){
                iAthlete.setNumOfCoachingHour(handler.requestCoachingHour());
            }
            // Intermediate Calculation
            iAthlete.calculateTotalCosts();
            iAthlete.calculateTrainingFees();
            iAthlete.calculateCompetitionFees();
            iAthlete.calculateTotalCosts();
            System.out.println(iAthlete.toString());


        //Elite
        } else if(trainingPlan.equalsIgnoreCase("Elite")){
            EliteAthlete eAthlete = new EliteAthlete();
            eAthlete.setAthleteName(name);
            eAthlete.setTrainingPlan(trainingPlan);
            eAthlete.setCurrentWeight(currentWeight);

            //IF Login User, Ask number of competition entered
            if(!isRegister){
                eAthlete.setNumOfCompetition(handler.requestCompetitionEntered());
            }

            // Asking user have coaching hour or not
            String hasCoachingHour = handler.hasCoachingHour();
            // If user have private coaching hour
            if(hasCoachingHour.equalsIgnoreCase("y") || hasCoachingHour.equalsIgnoreCase("yes")){
                eAthlete.setNumOfCoachingHour(handler.requestCoachingHour());
            }
            System.out.println(eAthlete.toString());

            //Calculate costs
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
//

    static void printResult(String name, double compFee, double coachFee, double trainFee,double totalCosts){
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        System.out.println();
        System.out.println("-".repeat(39));
        System.out.printf(" %18s %-2s %-18s \n", "Athlete Name", "-", name);
        System.out.println("-".repeat(39));
        System.out.printf("| %-20s |   %-10s |\n", "Training Costs", decimalFormat.format(trainFee));
        System.out.printf("| %-20s |   %-10s |\n", "Competition Costs", decimalFormat.format(compFee));
        System.out.printf("| %-20s |   %-10s |\n", "Private Hours Costs", decimalFormat.format(coachFee));
        System.out.printf("| %-20s |   %-10s |\n", "Total Costs", decimalFormat.format(totalCosts));
        System.out.println("-".repeat(39));
    }
}
