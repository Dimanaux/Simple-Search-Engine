package shapes

class Rectangle(
        private val width: Double,
        private val height: Double
) : Shape {
    override fun area() = width * height
}
