class Asteroid {
  //member variables
  int x, y, speed, health;
  color c;
  float r;
  PImage asteroid;
  //constructor
  Asteroid(int x, int y, int speed) {
    this.x = x;
    this.y = y;
    this.speed = speed;
    r=25;
    health=100;
    asteroid = loadImage("asteroid.png");
  }

  //display method
  void display() {
    rectMode(CENTER);
    fill(100, 82, 77);
    noStroke();
    image(asteroid,x,y);
  } 
  void move() {
    y+=speed;
  }

  //Laser Vs. Asteroid
  boolean blasterIntersection(Blasters blaster) {
    float distance = dist(x, y, blaster.x, blaster.y);
    if (distance<r+blaster.r) {
      return true;
    } else {
      return false;
    }
  }


  boolean reachedBottom() {
    if (y>height+50) {
      return true;
    } else {
      return false;
    }
  }
}
