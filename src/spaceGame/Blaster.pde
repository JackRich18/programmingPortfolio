class Blasters {
  //member variables
  int x, y, speed;
  color c;
  float r;

  //constructor
  Blasters(int x, int y, color c, int speed) {
    this.x = x;
    this.y = y;
    this.c = c;
    this.speed = speed;
    r=25;
  }

  //display method
  void display() {
    rectMode(CENTER);
    fill(c);
    noStroke();
    ellipse(x, y, 8, 8);
    triangle(x+4, y, x-4, y, x, y-8);
  }

  void move() {
    y-=speed;
  }

  boolean reachedTop() {
    if (y<-10) {
      return true;
    } else {
      return false;
    }
  }
}
