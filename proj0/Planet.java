public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }
    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p) {
        double diffX = p.xxPos - this.xxPos;
        double diffY = p.yyPos - this.yyPos;
        double r = Math.sqrt(diffY * diffY + diffX * diffX);
        return r;
    }
    public double calcForceExertedBy(Planet p) {
        double r = calcDistance(p);
        return G * p.mass * this.mass / r / r;
    }
    public double calcForceExertedByX(Planet p) {
        double F = calcForceExertedBy(p);
        double dx = p.xxPos - this.xxPos;
        double r = calcDistance(p);
        return F * dx / r;
    }
    public double calcForceExertedByY(Planet p) {
        double F = calcForceExertedBy(p);
        double dy = p.yyPos - this.yyPos;
        double r = calcDistance(p);
        return F * dy / r;
    }
    public double calcNetForceExertedByX(Planet[] planets) {
        double val = 0;
        for (Planet p: planets) {
            if (!p.equals(this)) {
                val += calcForceExertedByX(p);
            }
        }
        return val;
    }
    public double calcNetForceExertedByY(Planet[] planets) {
        double val = 0;
        for (Planet p: planets) {
            if (!p.equals(this)) {
                val += calcForceExertedByY(p);
            }
        }
        return val;
    }
    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel = this.xxVel + dt * aX;
        this.yyVel = this.yyVel + dt * aY;
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }
    public  void draw() {
        StdDraw.picture(xxPos,yyPos, "./images/" +imgFileName);
    }
}