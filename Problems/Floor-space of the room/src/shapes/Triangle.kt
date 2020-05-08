package shapes

import kotlin.math.sqrt

class Triangle(val a: Double, val b: Double, val c: Double) : Shape {
    private val semiPerimeter = (a + b + c) / 2

    override fun area() =
            sqrt((semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c))
}