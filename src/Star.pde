class Stars {
  //member variables
  color c;
  int x, y, speed, dia;

  //constructor
  Stars(int x, int y) {
    this.c = color(255);
    this.x = x;
    this.y = y;
    speed = int(random(1, 2));
    dia = int(random(1, 4));
  }

  //display method
  void display() {
    fill(c);
    ellipse(x, y, dia, dia);
  }
  void move() {
    y+=speed;
 }
  boolean reachedBottom() {
    if (y>height+10) {
      return true;
    } else {
      return false;
    }
  }
}
