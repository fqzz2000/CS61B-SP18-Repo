public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public static double G = 6.67e-11;
    public String imgFileName;
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;

    }
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public double calcDistance(Planet p){
        double distSqr = (xxPos - p.xxPos)*(xxPos - p.xxPos) + (yyPos - p.yyPos)*(yyPos - p.yyPos);
        return Math.sqrt(distSqr);

    }

    public double calcForceExertedBy(Planet p){
        double r = calcDistance(p);
        double force = G * mass * p.mass / (r * r);
        return force;
    }
    public double calcForceExertedByX(Planet p){
        double force = calcForceExertedBy(p);
        double forceX = force * (p.xxPos - xxPos) / calcDistance(p);
        return forceX;
    }
    public double calcForceExertedByY(Planet p){
        double force = calcForceExertedBy(p);
        double forceY = force * (p.yyPos - yyPos) / calcDistance(p);
        return forceY;
    }
}
