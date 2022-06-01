import java.sql.NClob;

public class NBody {
    public static double readRadius(String path){
        In in = new In(path);
        int num = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String path){
        In in = new In(path);
        int num = in.readInt();
        double radius = in.readDouble();
        Planet[] Planets = new Planet[num];
        for (int i = 0; i < num; i = i + 1){
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();
            Planet p = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
            Planets[i] = p;
        }
        return Planets;
    }
    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] Planets = readPlanets(filename);
        double radius = readRadius(filename);
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "./images/starfield.jpg");
    }
}
