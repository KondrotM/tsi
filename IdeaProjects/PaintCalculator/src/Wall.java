public class Wall {
    float width;
    float height;

    public Wall(float inputWidth, float inputHeight) {
        width = inputWidth;
        height = inputHeight;
    }

    public float calculateArea() {
        return width * height;
    }


}
