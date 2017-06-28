import java.util.Locale;
import java.util.ResourceBundle;

public class DinnerForFive {

    private static Fork[] createFiveForks() {
        return new Fork[]{new Fork(), new Fork(), new Fork(),
                new Fork(), new Fork()};
    }

    public static void main(String[] args) {
        Fork[] fiveForks = createFiveForks();

//      Locale.setDefault(Locale.ENGLISH);

        Locale currentLocale = Locale.getDefault();
        ResourceBundle philosophersNames = ResourceBundle.getBundle("PhilosophersNamesBundle", currentLocale);
        ResourceBundle speeches = ResourceBundle.getBundle("SpeechesBundle", currentLocale);

        PhilosopherBuilder firstPhilosopher = new PhilosopherBuilder();
        firstPhilosopher.setName(philosophersNames.getString("nameDescartes")).setLeftFork(fiveForks[1])
                .setRightFork(fiveForks[0]).setSpeech(speeches.getString("speechDescartes"))
                .setMaxTimeWithoutFood(1000);
        final Philosopher descartes = firstPhilosopher.build();

        PhilosopherBuilder secondPhilosopher = new PhilosopherBuilder();
        secondPhilosopher.setName(philosophersNames.getString("nameKant")).setLeftFork(fiveForks[2])
                .setRightFork(fiveForks[1]).setSpeech(speeches.getString("speechKant"))
                .setMaxTimeWithoutFood(2000);
        final Philosopher kant = secondPhilosopher.build();

        PhilosopherBuilder thirdPhilosopher = new PhilosopherBuilder();
        thirdPhilosopher.setName(philosophersNames.getString("nameDemocritus")).setLeftFork(fiveForks[3])
                .setRightFork(fiveForks[2]).setSpeech(speeches.getString("speechDemocritus"))
                .setMaxTimeWithoutFood(1500);
        final Philosopher democritus = thirdPhilosopher.build();

        PhilosopherBuilder forthPhilosopher = new PhilosopherBuilder();
        forthPhilosopher.setName(philosophersNames.getString("nameSartre")).setLeftFork(fiveForks[4])
                .setRightFork(fiveForks[3]).setSpeech(speeches.getString("speechSartre"))
                .setMaxTimeWithoutFood(2500);
        final Philosopher sartre = forthPhilosopher.build();

        PhilosopherBuilder fifthPhilosopher = new PhilosopherBuilder();
        fifthPhilosopher.setName(philosophersNames.getString("namePlato")).setLeftFork(fiveForks[0])
                .setRightFork(fiveForks[4]).setSpeech(speeches.getString("speechPlato"))
                .setMaxTimeWithoutFood(3000);
        final Philosopher plato = fifthPhilosopher.build();

        new Thread(new EatLoop(descartes)).start();
        new Thread(new EatLoop(kant)).start();
        new Thread(new EatLoop(democritus)).start();
        new Thread(new EatLoop(sartre)).start();
        new Thread(new EatLoop(plato)).start();

    }

}
