public interface Training {
    public abstract double calculateTrainingFees();
    public abstract double calculateTotalCosts();
}

class BeginnerAthelte extends Athlete implements Training{

    @Override
    public double calculateTrainingFees() {
        return 0;
    }

    @Override
    public double calculateTotalCosts() {
        return 0;
    }
}

class IntermediateAthlete extends Athlete implements Training{

    @Override
    public double calculateTrainingFees() {
        return 0;
    }
    @Override
    public double calculateTotalCosts() {
        return 0;
    }
}

class EliteAthlete extends Athlete implements Training{

    @Override
    public double calculateTrainingFees() {
        return 0;
    }
    @Override
    public double calculateTotalCosts() {
        return 0;
    }
}
