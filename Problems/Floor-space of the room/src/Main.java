import shapes.Shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        var shapeName = scanner.nextLine();
        var shapeClass =
                (Class<Shape>) Class.forName("shapes." + shapeName.substring(0, 1).toUpperCase() + shapeName.substring(1));

        var params = new ArrayList<Double>(4);
        while (scanner.hasNext()) {
            params.add(Double.valueOf(scanner.nextLine()));
        }

        var doubles = new Class[params.size()];
        Arrays.fill(doubles, Double.class);

        var constructor = shapeClass.getConstructor(doubles);
        var shape = constructor.newInstance(params.toArray());
        System.out.println(shape.area());
    }
}
