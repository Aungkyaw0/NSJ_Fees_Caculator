public interface Training {
    public abstract double calculateTrainingFees();
    public abstract double calculateCoachingHoursFees();
    public abstract double calculateTotalCosts();
}

class BeginnerAthlete extends Athlete implements Training{
    private double trainingCost = 0;
    private double coachingCost = 0;
    private double totalCost = 0;

    public double getTrainingCost() {
        return trainingCost;
    }

    public void setTrainingCost(double trainingCost) {
        this.trainingCost = trainingCost;
    }

    public double getCoachingCost() {
        return coachingCost;
    }

    public void setCoachingCost(double coachingCost) {
        this.coachingCost = coachingCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public double calculateTrainingFees() {
        // 2 seesion per week cost 25.00
        double weeklyFee = 25.00;
        trainingCost = weeklyFee * 4;
        // 4 week in a month
        return trainingCost;
    }
    @Override
    public double calculateCoachingHoursFees(){
        // 9.50 fees per hour
        double feePerHour = 9.50;
        // total of coaching hour * fees per hour
        coachingCost = feePerHour * this.getNumOfCoachingHour();
        return coachingCost;
    }

    @Override
    public double calculateTotalCosts() {
        totalCost = this.calculateTrainingFees() + this.calculateCoachingHoursFees();
        return totalCost;
    }

    @Override
    public String toString() {
        return "BeginnerAthlete{" +
                "trainingCost=" + trainingCost +
                ", coachingCost=" + coachingCost +
                ", totalCost=" + totalCost +
                '}';
    }
}

class IntermediateAthlete extends Athlete implements Training{
    private double trainingCost = 0.0;
    private double coachingCost = 0.0;
    private double totalCost = 0.0;
    private double competitionCost = 0.0;

    public double getTrainingCost() {
        return trainingCost;
    }

    public void setTrainingCost(double trainingCost) {
        this.trainingCost = trainingCost;
    }

    public double getCoachingCost() {
        return coachingCost;
    }

    public void setCoachingCost(double coachingCost) {
        this.coachingCost = coachingCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getCompetitionCost() {
        return competitionCost;
    }

    public void setCompetitionCost(double competitionCost) {
        this.competitionCost = competitionCost;
    }

    @Override
    public double calculateTrainingFees() {
        // 3 session per week cost 30.00
        double weeklyFee = 30.00;
        // 4 week in a month
        trainingCost = weeklyFee * 4;
        return trainingCost;
    }
    @Override
    public double calculateCoachingHoursFees(){
        // 9.50 fees per hour
        double feePerHour = 9.50;
        // total of coaching hour * fees per hour
        coachingCost = feePerHour * this.getNumOfCoachingHour();
        return coachingCost;
    }
    public double calculateCompetitionFees(){
        // entry fees per competition is 22.00
        double entryFeePerCompetition = 22.00;
        // entry fees per competition * total num of competition
        competitionCost = entryFeePerCompetition * this.getNumOfCompetition();
        return competitionCost;
    }
    @Override
    public double calculateTotalCosts() {
        // total fees calculation
        totalCost = this.calculateTrainingFees() + this.calculateCoachingHoursFees() + this.calculateCompetitionFees();
        return totalCost;
    }

    @Override
    public String toString() {
        return "IntermediateAthlete{" +
                "trainingCost=" + trainingCost +
                ", coachingCost=" + coachingCost +
                ", totalCost=" + totalCost +
                ", competitionCost=" + competitionCost +
                '}';
    }
}

class EliteAthlete extends Athlete implements Training{

    private double trainingCost = 0.0;
    private double coachingCost = 0.0;
    private double totalCost = 0.0;
    private double competitionCost = 0.0;

    public double getTrainingCost() {
        return trainingCost;
    }

    public void setTrainingCost(double trainingCost) {
        this.trainingCost = trainingCost;
    }

    public double getCoachingCost() {
        return coachingCost;
    }

    public void setCoachingCost(double coachingCost) {
        this.coachingCost = coachingCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getCompetitionCost() {
        return competitionCost;
    }

    public void setCompetitionCost(double competitionCost) {
        this.competitionCost = competitionCost;
    }
    @Override
    public double calculateTrainingFees() {
        // 5 seesion per week cost 35.00
        double weeklyFee = 35.00;
        // 4 week in a month
        trainingCost = weeklyFee * 4;
        return trainingCost;
    }
    @Override
    public double calculateCoachingHoursFees(){
        // 9.50 fees per hour
        double feePerHour = 9.50;

        // total of coaching hour * fees per hour
        coachingCost = feePerHour * this.getNumOfCoachingHour();
        return  coachingCost;
    }
    public double calculateCompetitionFees(){
        // entry fees per competition is 22.00
        double entryFeePerCompetition = 22.00;
        // entry fees per competition * total num of competition
        competitionCost = entryFeePerCompetition * this.getNumOfCompetition();
        return competitionCost;
    }
    @Override
    public double calculateTotalCosts() {
        // total fees calculation
        totalCost = this.calculateTrainingFees() + this.calculateCoachingHoursFees() + this.calculateCompetitionFees();
        return totalCost;
    }
}
