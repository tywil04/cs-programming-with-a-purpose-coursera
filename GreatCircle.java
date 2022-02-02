public class GreatCircle {
    public static void main(String[] args) {
        double x1d = Double.parseDouble(args[0]);
        double y1d = Double.parseDouble(args[1]);
        double x2d = Double.parseDouble(args[2]);
        double y2d = Double.parseDouble(args[3]);
        double x1r = Math.toRadians(x1d);
        double y1r = Math.toRadians(y1d);
        double x2r = Math.toRadians(x2d);
        double y2r = Math.toRadians(y2d);
        double r = 6371.0;

        double answer = (r * 2) * Math.asin(Math.sqrt(Math.pow(Math.sin((x2r - x1r) / 2), 2) + Math.cos(x1r) * Math.cos(x2r) * Math.pow(Math.sin((y2r - y1r) / 2), 2)));
        System.out.println(answer + " kilometers");
    }
}
