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


        final Philosopher descartes = new Philosopher(philosophersNames.getString("nameDescartes"),
                fiveForks[1], fiveForks[0], speeches.getString("speechDescartes"),
                1000);
        final Philosopher kant = new Philosopher(philosophersNames.getString("nameKant"),
                fiveForks[2], fiveForks[1], speeches.getString("speechKant"),
                2000);
        final Philosopher democritus = new Philosopher(philosophersNames.getString("nameDemocritus"),
                fiveForks[3], fiveForks[2], speeches.getString("speechDemocritus"),
                1500);
        final Philosopher sartre = new Philosopher(philosophersNames.getString("nameSartre"),
                fiveForks[4], fiveForks[3], speeches.getString("speechSartre"),
                2500);
        final Philosopher plato = new Philosopher(philosophersNames.getString("namePlato"),
                fiveForks[0], fiveForks[4], speeches.getString("speechPlato"),
                3000);

        new Thread(new EatLoop(descartes)).start();
        new Thread(new EatLoop(kant)).start();
        new Thread(new EatLoop(democritus)).start();
        new Thread(new EatLoop(sartre)).start();
        new Thread(new EatLoop(plato)).start();

    }

}
