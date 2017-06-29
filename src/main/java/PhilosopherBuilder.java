class PhilosopherBuilder {
    private String name;
    private Fork leftFork;
    private Fork rightFork;
    private long maxTimeWithoutFood;

    private String speech;

   PhilosopherBuilder withName(String name){
        this.name = name;
        return this;
    }

    PhilosopherBuilder withLeftFork(Fork leftFork){
        this.leftFork = leftFork;
        return this;
    }

    PhilosopherBuilder withRightFork(Fork rightFork){
        this.rightFork = rightFork;
        return this;
    }

    PhilosopherBuilder withSpeech(String speech){
        this.speech = speech;
        return this;
    }

    PhilosopherBuilder withMaxTimeWithoutFood(long maxTimeWithoutFood){
        this.maxTimeWithoutFood = maxTimeWithoutFood;
        return this;
    }

    Philosopher build(){
        return new Philosopher(this.name, this.leftFork, this.rightFork, this.speech, this.maxTimeWithoutFood);
    }
}
