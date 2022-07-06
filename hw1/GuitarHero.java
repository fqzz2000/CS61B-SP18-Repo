import synthesizer.GuitarString;

public class GuitarHero {
    private static final double CONCRERE_BASE = 440.0;
    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static void main(String [] args) {
        synthesizer.GuitarString stringList = new GuitarString(CONCRERE_BASE);
        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int idx =  keyboard.indexOf(key);
                double freq = CONCRERE_BASE * Math.pow(2  ,((idx - 24)/12));
                stringList = new GuitarString(freq);

                stringList.pluck();

            }

            double sample = stringList.sample();


            StdAudio.play(sample);
            stringList.tic();

    }
}
}
