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

        final Philosopher descartes = new PhilosopherBuilder()
                .withName(philosophersNames.getString("nameDescartes"))
                .withLeftFork(fiveForks[1])
                .withRightFork(fiveForks[0])
                .withSpeech(speeches.getString("speechDescartes"))
                .withMaxTimeWithoutFood(1000)
                .build();

        final Philosopher kant = new PhilosopherBuilder()
                .withName(philosophersNames.getString("nameKant"))
                .withLeftFork(fiveForks[2])
                .withRightFork(fiveForks[1])
                .withSpeech(speeches.getString("speechKant"))
                .withMaxTimeWithoutFood(2000)
                .build();

        final Philosopher democritus = new PhilosopherBuilder()
                .withName(philosophersNames.getString("nameDemocritus"))
                .withLeftFork(fiveForks[3])
                .withRightFork(fiveForks[2])
                .withSpeech(speeches.getString("speechDemocritus"))
                .withMaxTimeWithoutFood(1500)
                .build();

        final Philosopher sartre = new PhilosopherBuilder()
                .withName(philosophersNames.getString("nameSartre"))
                .withLeftFork(fiveForks[4])
                .withRightFork(fiveForks[3])
                .withSpeech(speeches.getString("speechSartre"))
                .withMaxTimeWithoutFood(2500)
                .build();

        final Philosopher plato = new PhilosopherBuilder()
                .withName(philosophersNames.getString("namePlato"))
                .withLeftFork(fiveForks[0])
                .withRightFork(fiveForks[4])
                .withSpeech(speeches.getString("speechPlato"))
                .withMaxTimeWithoutFood(3000)
                .build();

        new Thread(new EatLoop(descartes)).start();
        new Thread(new EatLoop(kant)).start();
        new Thread(new EatLoop(democritus)).start();
        new Thread(new EatLoop(sartre)).start();
        new Thread(new EatLoop(plato)).start();

    }

}
