import java.util.Locale;
import java.util.ResourceBundle;

class PhilosopherBuilder {
    private String name;
    private Fork leftFork;
    private Fork rightFork;
    private long maxTimeWithoutFood;

    private String speech;

   PhilosopherBuilder setName(String name){
        this.name = name;
        return this;
    }

    PhilosopherBuilder setLeftFork(Fork leftFork){
        this.leftFork = leftFork;
        return this;
    }

    PhilosopherBuilder setRightFork(Fork rightFork){
        this.rightFork = rightFork;
        return this;
    }

    PhilosopherBuilder setSpeech(String speech){
        this.speech = speech;
        return this;
    }

    PhilosopherBuilder setMaxTimeWithoutFood(long maxTimeWithoutFood){
        this.maxTimeWithoutFood = maxTimeWithoutFood;
        return this;
    }

    Philosopher build(){
        return new Philosopher(this.name, this.leftFork, this.rightFork, this.speech, this.maxTimeWithoutFood);
    }
}
