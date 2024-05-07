    import java.text.DecimalFormat;
    import java.util.ArrayList;
    import java.util.List;

    public class Main {
        static List<String> users = new ArrayList<>(); // To Store Username

        public static void main(String[] args) {
            int op;
            //Existing users in Jud
            users.add("Johnny");
            users.add("James");
            users.add("William");
            users.add("Tommy");
            users.add("Smith");
            users.add("Khaled");
            String name = "";
            String trainingPlan;
            double currentWeight;
            InputHandler handler = new InputHandler(); // Method for Requests
            //Welcome Message
            boolean startProgram = true;
            //Start of the program with loop
            while (startProgram) {
                boolean isRegister = false; // To check whether register user or login user
                clearConsole();
                boolean isLoginCorrect = false;
                while (!isLoginCorrect) {
                    System.out.println(" ------------------------------------------------------ " +
                            "\n| Welcome from the North Sussex Judo's Fees Calculator |\n --------" +
                            "---------------------------------------------- ");
                    System.out.print(" 1. Register\n 2. Login\n 3. Quit\n");
                    // asking register or login
                    op = handler.requestOperation();
                    //If Exit
                    switch (op){
                        //Register
                        case 1:
                            name = handler.requestAthleteName();
                            users.add(name);
                            clearConsole();
                            System.out.println(" \n-- Username " + name + " is successfully registered in the system --\n-- Login to your registered account again --");
                            break;
                        //Login
                        case 2:
                            name = handler.requestAthleteName();
                            int counter = 0;
                            boolean isFound = false;
                            for (String n : users) {
                                if (n.equals(name)) {
                                    isFound = true;
                                    break;
                                }
                                counter++;
                            }
                            if (isFound) {
                                clearConsole();
                                System.out.println("\n-- Hello " + name + " , Welcome From Judo Fees Calculator --");
                                // Filter for new user :: for not to ask competition entered
                                if(counter > 5){
                                    isRegister = true;
                                }
                                isLoginCorrect = true;
                            } else {
                                System.out.println("!!! Username not found, Try Again !!!");
                            }
                            break;
                        //Exit
                        case 3:
                            System.out.println("----- Successfully exit from the application ---------");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("!!! Invalid Opeartion Number !!!");
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
                if (trainingPlan.equalsIgnoreCase("Beginner")) {
                    BeginnerAthlete bAthlete = new BeginnerAthlete();
                    bAthlete.setAthleteName(name);
                    bAthlete.setTrainingPlan(trainingPlan);
                    bAthlete.setCurrentWeight(currentWeight);
                    String hasCoachingHour = handler.hasCoachingHour();
                    // If user have private coaching hour
                    if (hasCoachingHour.equalsIgnoreCase("y") || hasCoachingHour.equalsIgnoreCase("yes")) {
                        bAthlete.setNumOfCoachingHour(handler.requestCoachingHour());
                    }

                    // Calculation
                    bAthlete.calculateCoachingHoursFees();
                    bAthlete.calculateTrainingFees();
                    bAthlete.calculateTotalCosts();

                    //Output Displaying for Beginner
                    printResult(bAthlete.getAthleteName(), 0.0, bAthlete.getCoachingCost(), bAthlete.getTrainingCost(), bAthlete.getTotalCost());
                    printWeightComparison(bAthlete.getAthleteName(), bAthlete.getTrainingPlan(), bAthlete.getNumOfCompetition(), bAthlete.getNumOfCoachingHour(), bAthlete.getCurrentWeight());

                //INTERMEDIATE ATHLETE
                } else if (trainingPlan.equalsIgnoreCase("Intermediate")) {
                    IntermediateAthlete iAthlete = new IntermediateAthlete();
                    iAthlete.setAthleteName(name);
                    iAthlete.setTrainingPlan(trainingPlan);
                    iAthlete.setCurrentWeight(currentWeight);
                    //IF Login User, Ask number of competition entered
                    if (!isRegister) {
                        iAthlete.setNumOfCompetition(handler.requestCompetitionEntered());
                    }
                    // Asking user have coaching hour or not
                    String hasCoachingHour = handler.hasCoachingHour();
                    // If user have private coaching hour
                    if (hasCoachingHour.equalsIgnoreCase("y") || hasCoachingHour.equalsIgnoreCase("yes")) {
                        iAthlete.setNumOfCoachingHour(handler.requestCoachingHour());
                    }
                    // Intermediate Calculation
                    iAthlete.calculateCoachingHoursFees();
                    iAthlete.calculateTrainingFees();
                    iAthlete.calculateCompetitionFees();
                    iAthlete.calculateTotalCosts();
                    //Output Displaying for Intermediate
                    printResult(iAthlete.getAthleteName(), iAthlete.getCompetitionCost(), iAthlete.getCoachingCost(), iAthlete.getTrainingCost(), iAthlete.getTotalCost());
                    printWeightComparison(iAthlete.getAthleteName(), iAthlete.getTrainingPlan(), iAthlete.getNumOfCompetition(), iAthlete.getNumOfCoachingHour(), iAthlete.getCurrentWeight());

                //ELITE ATHLETE
                } else if (trainingPlan.equalsIgnoreCase("Elite")) {
                    EliteAthlete eAthlete = new EliteAthlete();
                    eAthlete.setAthleteName(name);
                    eAthlete.setTrainingPlan(trainingPlan);
                    eAthlete.setCurrentWeight(currentWeight);
                    //IF Login User, Ask number of competition entered
                    if (!isRegister) {
                        eAthlete.setNumOfCompetition(handler.requestCompetitionEntered());
                    }
                    // Asking user have coaching hour or not
                    String hasCoachingHour = handler.hasCoachingHour();
                    // If user have private coaching hour
                    if (hasCoachingHour.equalsIgnoreCase("y") || hasCoachingHour.equalsIgnoreCase("yes")) {
                        eAthlete.setNumOfCoachingHour(handler.requestCoachingHour());
                    }

                    //Calculate costs
                    eAthlete.calculateCoachingHoursFees();
                    eAthlete.calculateTrainingFees();
                    eAthlete.calculateCompetitionFees();
                    eAthlete.calculateTotalCosts();

                    //Output displaying for Elite
                    printResult(eAthlete.getAthleteName(), eAthlete.getCompetitionCost(), eAthlete.getCoachingCost(),
                            eAthlete.getTrainingCost(), eAthlete.getTotalCost());
                    printWeightComparison(eAthlete.getAthleteName(), eAthlete.getTrainingPlan(), eAthlete.getNumOfCompetition(), eAthlete.getNumOfCoachingHour(), eAthlete.getCurrentWeight());
                }
                //Loop to rung program again
                String runAgain;
                runAgain = handler.askRunAgain();
                if (runAgain.equalsIgnoreCase("no") || runAgain.equalsIgnoreCase("n")) {
                    System.out.println("----- Successfully exit from the application ---------");
                    startProgram = false;
                } else {
                    clearConsole();
                }
            }
        }

        static void printTrainingPLan() {
            int tableWidth = 52;
            // Print top border
            System.out.println("\nAvailable Training Plan at North Sussex Judo's");
            System.out.println("+" + "-".repeat(tableWidth) + "+");
            // Print table header with formatted output
            System.out.printf("| %-10s | %10s | %10s |\n", "Training Plan", "SessionPerWeek", "Weekly Fee (£GBP)");
            // Print separator line
            System.out.println("+" + "-".repeat(tableWidth) + "+");
            // Print data rows with formatted output
            System.out.printf("| %-13s | %14s |     £ %-11.2f |\n", "Beginner", "2 session", 25.00);
            System.out.printf("| %-13s | %14s |     £ %-11.2f |\n", "Intermediate", "3 session", 30.00);
            System.out.printf("| %-13s | %14s |     £ %-11.2f |\n", "Elite", "5 session", 35.00);
            // Print bottom border
            System.out.println("+" + "-".repeat(tableWidth) + "+");
            // Competition Fees
            System.out.printf("| %-30s |     £ %-11.2f |\n", "Coaching Fees Per Hour ", 9.50);
            System.out.println("+" + "-".repeat(tableWidth) + "+");
            // Competition Fees
            System.out.printf("| %-30s |     £ %-11.2f |\n", " Fees Per Competition ", 22.00);
            System.out.println("+" + "-".repeat(tableWidth) + "+");
        }

        static void printWeightComparison(String name, String trainPlan, int numOfCompt, int numOfCoach, double currentWeight) {
            String weightCategory = "";
            if (currentWeight <= 66.00) {
                weightCategory = "Fly Weight";
            } else if (currentWeight > 66 && currentWeight <= 73) {
                weightCategory = "Light Weight";
            } else if (currentWeight > 73 && currentWeight <= 81) {
                weightCategory = "Light-Middle Weight";
            } else if (currentWeight > 81 && currentWeight <= 90) {
                weightCategory = "Middle Weight";
            } else if (currentWeight > 90 && currentWeight <= 100) {
                weightCategory = "Light-Heavy Weight";
            } else if (currentWeight > 100) {
                weightCategory = "Heavy Weight";
            }
            //Printing
            int tableWidth = 117;
            // Print top border
            System.out.println("\n Athlete Data : Weight Comparison");
            System.out.println("+" + "-".repeat(tableWidth) + "+");
            // Print table header with formatted output
            System.out.printf("| %-15s | %-10s | %-10s | %10s | %10s | %10s |\n", "Athlete Name", "Current Weight", "Competition Weight Category ", "Training Plan", "No of Competition", "Private Hours");
            // Print separator line
            System.out.println("+" + "-".repeat(tableWidth) + "+");
            // Print data rows with formatted output
            System.out.printf("| %-15s |     %4s kg    |      %-23s | %13s |        %-10s |       %-7s |\n", name, currentWeight, weightCategory, trainPlan, numOfCompt, numOfCoach);
            // Print bottom border
            System.out.println("+" + "-".repeat(tableWidth) + "+");
        }

        static void printResult(String name, double compFee, double coachFee, double trainFee, double totalCosts) { // Method to print Result
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            System.out.println("\nTotal Fees Result Data Of Athlete In a Month");
            System.out.println("-".repeat(39));
            System.out.printf(" %18s %-2s %-18s \n", "Athlete Name", "-", name);
            System.out.println("-".repeat(39));
            System.out.printf("| %-20s |   £ %-8s |\n", "Training Costs", decimalFormat.format(trainFee));
            System.out.printf("| %-20s |   £ %-8s |\n", "Competition Costs", decimalFormat.format(compFee));
            System.out.printf("| %-20s |   £ %-8s |\n", "Private Hours Costs", decimalFormat.format(coachFee));
            System.out.println("-".repeat(39));
            System.out.printf("| %-20s |   £ %-8s |\n", "Total Costs", decimalFormat.format(totalCosts));
            System.out.println("-".repeat(39));
        }

        private static void clearConsole() { // Method to clear console after user run again
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
