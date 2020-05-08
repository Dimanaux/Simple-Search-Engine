package shapes

import kotlin.math.PI

class Circle(private val radius: Double) : Shape {
    override fun area() = PI * radius * radius
}
