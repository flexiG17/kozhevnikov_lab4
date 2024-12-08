class CentripetalAcceleration {
    private final double speed;
    private final double radius;

    public CentripetalAcceleration(double speed, double radius) {
        this.speed = speed;
        this.radius = radius;
    }

    public double calculate() {
        return Math.pow(speed, 2) / radius;
    }
}