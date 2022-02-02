public class AudioCollage {
    public static double[] amplify(double[] a, double alpha) {
        double[] amplifieda = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            amplifieda[i] = a[i] * alpha;
        }
        return amplifieda;
    }

    public static double[] reverse(double[] a) {
        double[] reverseda = new double[a.length]; 
        for (int i = 0; i < a.length; i++) {
            reverseda[a.length - i - 1] = a[i];
        }
        return reverseda;
    }

    public static double[] merge(double[] a, double[] b) {
        double[] merged = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            merged[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            merged[i + a.length] = b[i];
        }
        return merged;
    }

    public static double[] mix(double[] a, double[] b) {
        int largest = Math.max(a.length, b.length);
        double[] uniforma = new double[largest];
        double[] uniformb = new double[largest];
        double[] mixed = new double[largest];
        for (int i = 0; i < largest; i++) {
            if ((i + 1) < a.length) {
                uniforma[i] = a[i];
            } else {
                uniforma[i] = 0;
            }
            
            if ((i + 1) < b.length) {
                uniformb[i] = b[i];
            } else {
                uniformb[i] = 0;
            }
        } 
        for (int i = 0; i < uniforma.length; i++) {
            mixed[i] = uniforma[i] + uniformb[i];
        }
        return mixed;
    }

    public static double[] changeSpeed(double[] a, double alpha) {
        double[] newa = new double[(int) (a.length / alpha)];
        for (int i = 0; i < newa.length - 1; i += 2) {
            newa[i] = a[(int) alpha * i];
        }
        return newa;
    }

    public static void main(String[] args) {
        double[] silence = StdAudio.read("silence.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] dialup = StdAudio.read("dialup.wav");
        double[] piano = StdAudio.read("piano.wav");
        double[] exposure = StdAudio.read("exposure.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        double[] singer = StdAudio.read("singer.wav");

        StdAudio.play(amplify(piano, 0.1));
        StdAudio.play(reverse(singer));
        StdAudio.play(merge(exposure, dialup));
        StdAudio.play(mix(harp, chimes));
        StdAudio.play(changeSpeed(silence, 1));
    }
}
