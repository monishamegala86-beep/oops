import java.util.Scanner;

abstract class Shape {
    int a, b;
    abstract void printArea();
}

class Rectangle extends Shape {
    Rectangle(int l, int br) {
        a = l;
        b = br;
    }

    void printArea() {
        System.out.println("Area of Rectangle = " + (a * b));
    }
}

class Triangle extends Shape {
    Triangle(int base, int height) {
        a = base;
        b = height;
    }

    void printArea() {
        System.out.println("Area of Triangle = " + (0.5 * a * b));
    }
}

class Circle extends Shape {
    Circle(int r) {
        a = r;
    }

    void printArea() {
        System.out.println("Area of Circle = " + (3.14 * a * a));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Shape (Rectangle/Triangle/Circle):");
        String shape = sc.next();

        if (shape.equalsIgnoreCase("Rectangle")) {
            System.out.print("Length: ");
            int l = sc.nextInt();
            System.out.print("Breadth: ");
            int b = sc.nextInt();
            Shape s = new Rectangle(l, b);
            s.printArea();
        } 
        else if (shape.equalsIgnoreCase("Triangle")) {
            System.out.print("Base: ");
            int base = sc.nextInt();
            System.out.print("Height: ");
            int h = sc.nextInt();
            Shape s = new Triangle(base, h);
            s.printArea();
        } 
        else if (shape.equalsIgnoreCase("Circle")) {
            System.out.print("Radius: ");
            int r = sc.nextInt();
            Shape s = new Circle(r);
            s.printArea();
        } 
        else {
            System.out.println("Invalid Shape");
        }

        sc.close();
    }
}

Get Outlook for Android
