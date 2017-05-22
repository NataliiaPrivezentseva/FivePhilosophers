public class DinnerForFive {

    private static Fork[] createFiveForks() {
        return new Fork[]{new Fork(), new Fork(), new Fork(),
                new Fork(), new Fork()};
    }

    public static void main(String[] args) {
        Fork[] fiveForks = createFiveForks();
        final Philosopher descartes = new Philosopher("Descartes", fiveForks[1], fiveForks[0],
                ": I am eating therefor I exist.",
                1000);
        final Philosopher kant = new Philosopher("Kant", fiveForks[2], fiveForks[1],
                ": Two things awe me most, the starry sky above me and a big steak within me.",
                2000);
        final Philosopher democritus = new Philosopher("Democritus", fiveForks[3], fiveForks[2],
                ": It is greed to do all the eating but not to want to wait at all.",
                1500);
        final Philosopher sartre = new Philosopher("Sartre", fiveForks[4], fiveForks[3],
                ": Hell is other eaters.",
                2500);
        final Philosopher plato = new Philosopher("Plato", fiveForks[0], fiveForks[4],
                ": We are twice armed if we fight with full stomach.",
                3000);

        new Thread(new EatLoop(descartes)).start();
        new Thread(new EatLoop(kant)).start();
        new Thread(new EatLoop(democritus)).start();
        new Thread(new EatLoop(sartre)).start();
        new Thread(new EatLoop(plato)).start();

    }

}
