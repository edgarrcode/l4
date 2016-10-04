public class Box {
  private double width;
  private double height;
  private double length;
  
  //constructors
  public Box() {}
  
  public Box(double newWidth, double newHeight, double newLength) {
    width = newWidth;
    height = newHeight;
    length = newLength;
  }
  
  //accessors
  public double getWidth() {
    return width;
  }
  public double getHeight(){
    return height;
  }
  public double getLength() {
    return length;
  }
  
  public double getVolume() {
    return (width * height * length);
  }
  
  public boolean isCube() {
    if((width == height) && (height == length)) {
      return true;
    }
    return false;
  }
}