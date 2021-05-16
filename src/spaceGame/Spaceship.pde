class Spaceship {
  //member variables
  int x, y, health, lives, ammo;
  float r;

  //constructor
  Spaceship() {
    x = 0;
    y = 0;
    health = 100;
    lives = 3;
    ammo=1000;
    r=25;
  }

  //display method
  void display(int x, int y) {
      fill(0);
      this.x = x;
      this.y = y;
      //spaceship
      stroke(150);
      fill(150);
      quad(x+10, y, x+15, y, x+5, y+75, x+20, y+75);
      //wings
      stroke(255, 165, 0);
      fill(255, 165, 0);
      triangle(x+9, y+40, x+5, y+75, x-20, y+100);
      triangle(x+16, y+40, x+20, y+75, x+45, y+100);
      //cockpit
      triangle(x+10, y, x+15, y, x+12.5, y-25);
      fill(0);
      stroke(0);
      ellipse(x+12.5, y, 4, 10);
      //guns
      stroke(255, 165, 0);
      fill(255, 165, 0);
      line(x, y+60, x, y+45);
      line(x+25, y+60, x+25, y+45);
      stroke(0, 0, 150);
      fill(0, 0, 150);
      //exhaust
      triangle(x+5, y+75, x+20, y+75, x+12.5, y+100);
  }

  //detect collision rock and spaceship
  boolean asteroidIntersection(Asteroid asteroid) {
    float distance = dist(x, y, asteroid.x, asteroid.y);
    if (distance<r+asteroid.r) {
      return true;
    } else {
      return false;
    }
  }
}
