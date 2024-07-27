public class NBody {
    public static double readRadius(String filePath) {
        In in = new In(filePath);
        in.readInt();
        double r = in.readDouble();
        return r;
    }
    public static Planet[] readPlanets(String filePath) {
        In in = new In(filePath);
        int N = in.readInt();
        in.readDouble();
        Planet[] planets = new Planet[N];
        for (int i = 0; i < N; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double r = readRadius(filename);
        StdDraw.setXscale(-r, r);
        StdDraw.setYscale(-r, r);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();


        double t = 0;
        while (t < T) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(t, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "./images/starfield.jpg", 2*r, 2*r);
            for (int i = 0; i < planets.length; i++) {
                planets[i].draw();

            }
            StdDraw.show();
            StdDraw.pause(10);
            t = dt + t;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }



    }

}
