import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    static List<String> users = new ArrayList<String>();

    static boolean isRegister = false;
    public static void main(String[] args) {
        int op;
        users.add("Johnny");
        users.add("James");
        users.add("William");
        users.add("Tommy");
        users.add("Smith");
        users.add("Khaled");
        String name = "";
        String trainingPlan = "";
        double currentWeight;
        Scanner sc = new Scanner(System.in);
        InputHandler handler = new InputHandler(); // Method for Requests
        //Welcome Message
        boolean startProgram = true;
        //Start of the program with loop
        while (startProgram){
            clearConsole();
            while (true){
                System.out.println(" ------------------------------------------------------ " +
                        "\n| Welcome from the North Sussex Judo's Fees Calculator |\n --------" +
                        "---------------------------------------------- ");
                System.out.print(" 1. Register\n 2. Login\n 3. Quit\n");
                // asking register or login
                op = handler.requestOperation();
                //If Exit
                if(op == 3){
                    System.out.println("----- Successfully exit from the application ---------");
                    System.exit(0);
                // If Login
                }else if(op == 2){
                    name = handler.requestAthleteName();
                    boolean isFound = false;
                    for(String n : users){
                        if(n.equals(name)){
                            isFound = true;
                            break;
                        }
                    }
                    if(isFound){
                        System.out.println("\n----- Welcome " + name + " ----------");
                        break;
                    }else {
                        System.out.println("!!! Username not found, Try Again !!!");
                    }
                }else {
                    name = handler.requestAthleteName();
                    users.add(name);
                    break;
                }
            }

            // ask and validate athlete name
            printTrainingPLan(); // displaying available training plan
            // Asking training plan type
            trainingPlan = handler.requestTrainingPlan();

            // Asking current weight
            currentWeight = handler.requestCurrentWeight();

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
                //print result
                printResult(iAthlete.getAthleteName(), iAthlete.getCompetitionCost(), iAthlete.getCoachingCost(), iAthlete.getTrainingCost(), iAthlete.getTotalCost());
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
                eAthlete.calculateCompetitionFees();
                eAthlete.calculateTotalCosts();
                //print result
                printResult(eAthlete.getAthleteName(), eAthlete.getCompetitionCost(), eAthlete.getCoachingCost(),
                        eAthlete.getTrainingCost(), eAthlete.getTotalCost());

            }

            String runAgain = "";
            runAgain = handler.askRunAgain();
            if(runAgain.equalsIgnoreCase("no") || runAgain.equalsIgnoreCase("n")){
                System.out.println("----- Successfully exit from the application ---------");
                startProgram = false;
            }else {
                clearConsole();
            }



        }

    }

    static void printTrainingPLan(){
        int tableWidth = 52;
        // Print top border
        System.out.println("\nAvailable Training Plan at North Sussex Judo's");
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
        System.out.println("\nTotal Fees Result Data Of Athlete In a Month");
        System.out.println("-".repeat(39));
        System.out.printf(" %18s %-2s %-18s \n", "Athlete Name", "-", name);
        System.out.println("-".repeat(39));
        System.out.printf("| %-20s |   %-10s |\n", "Training Costs", decimalFormat.format(trainFee));
        System.out.printf("| %-20s |   %-10s |\n", "Competition Costs", decimalFormat.format(compFee));
        System.out.printf("| %-20s |   %-10s |\n", "Private Hours Costs", decimalFormat.format(coachFee));
        System.out.printf("| %-20s |   %-10s |\n", "Total Costs", decimalFormat.format(totalCosts));
        System.out.println("-".repeat(39));
    }

    private static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error while clearing the console: " + e.getMessage());
        }
    }

}
