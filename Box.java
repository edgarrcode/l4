public class Box {
  private double width;
  private double height;
  private double length;
  public Box next;
  
  //constructors
  public Box(double newWidth, double newHeight, double newLength) {
    width = newWidth;
    height = newHeight;
    length = newLength;
  }
  
  public Box() {
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
  public Box getNext() {
    return next;
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