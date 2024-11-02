/*
2. Описать класс Vector, который хранит координаты начала и конца вектора на плоскости. Методы: сумма двух векторов,
скалярное произведение двух векторов, умножение вектора на скаляр, длина вектора.
*/

public class Vector {
    private final double x1, y1;
    private final double x2, y2;

    public Vector(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Vector sum(Vector secondVector) {
        return new Vector(this.x2, this.y2, secondVector.x2, secondVector.y2);
    }

    public double scalarMultiply(Vector secondVector) {
        double firstAbscissasDifference = this.x2 - this.x1;
        double firstOrdinatesDifference = this.y2 - this.y1;
        double secondAbscissasDifference = secondVector.x2 - secondVector.x1;
        double secondOrdinatesDifference = secondVector.y2 - secondVector.y1;

        return (firstAbscissasDifference * secondAbscissasDifference + firstOrdinatesDifference * secondOrdinatesDifference);
    }

    public Vector multiplyByScalar(double scalarValue) {
        return new Vector(
                this.x1,
                this.y1,
                this.x1 + (this.x2 - this.x1) * scalarValue,
                this.y1 + (this.y2 - this.y1) * scalarValue);
    }

    public double length() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    @Override
    public String toString() {
        return "(" + x1 + ", " + y1 + ") и (" + x2 + ", " + y2 + ")";
    }

    public static void main(String[] args) {
        Vector firstVector = new Vector(1, 2, 4, 6);
        Vector secondVector = new Vector(2, 3, 5, 7);

        System.out.println("AB: " + firstVector);
        System.out.println("CD: " + secondVector);

        System.out.println("AB + CD = " + firstVector.sum(secondVector));

        System.out.println("Скалярное произведение векторов AB * CD = " + firstVector.scalarMultiply(secondVector));

        System.out.println("Умножение вектора AB на скаляр 2 = " + firstVector.multiplyByScalar(2));
        System.out.println("Умножение вектора CD на скаляр 2 = " + secondVector.multiplyByScalar(2));

        System.out.println("Длина вектора AB = " + firstVector.length());
        System.out.println("Длина вектора CD = " + secondVector.length());
    }
}

