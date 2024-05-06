    public class Athlete{
        private String athleteName;
        private String trainingPlan;
        private double currentWeight;
        private int numOfCompetition;
        private int numOfCoachingHour;
        Athlete(){
            this.athleteName = "";
            this.trainingPlan = "";
            this.currentWeight = 0.00;
            this.numOfCoachingHour = 0;
            this.numOfCompetition = 0;
        }
        public void setAthleteName(String athleteName) {
            this.athleteName = athleteName;
        }

        public String getAthleteName() {
            return athleteName;
        }
        public String getTrainingPlan() {
            return trainingPlan;
        }
        public void setTrainingPlan(String trainingPlan) {
            this.trainingPlan = trainingPlan;
        }
        public double getCurrentWeight() {
            return currentWeight;
        }
        public void setCurrentWeight(double currentWeight) {
            this.currentWeight = currentWeight;
        }
        public int getNumOfCompetition() {
            return numOfCompetition;
        }
        public void setNumOfCompetition(int numOfCompetition) {
            this.numOfCompetition = numOfCompetition;
        }
        public int getNumOfCoachingHour() {
            return numOfCoachingHour;
        }
        public void setNumOfCoachingHour(int numOfCoachingHour) {
            this.numOfCoachingHour = numOfCoachingHour;
        }
        @Override
        public String toString() {
            return "Athlete{" +
                    "athleteName='" + athleteName + '\'' +
                    ", trainingPlan='" + trainingPlan + '\'' +
                    ", currentWeight=" + currentWeight +
                    ", numOfCompetition=" + numOfCompetition +
                    ", numOfCoachingHour=" + numOfCoachingHour +
                    '}';
        }}
