import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Space_Game extends PApplet {

//Space Game
// by Jack Rich| Dec. 2020
//user controlled space ship
Spaceship s1;
ArrayList<Stars> stars = new ArrayList<Stars>();
ArrayList<Blasters> blasters = new ArrayList<Blasters>();
ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
Timer asteroidtimer;
int score, pass;
PImage explode;
boolean play;

public void setup() {
  
  s1 = new Spaceship();
  blasters = new ArrayList();
  asteroids = new ArrayList();
  stars = new ArrayList();
  asteroidtimer = new Timer(PApplet.parseInt(random(1000, 2500)));
  asteroidtimer.start();
  score = 0;
  pass = 0;
  explode = loadImage("explode.png");
  play = false;
}

public void draw() {
  background(0); 
  if (!play) {
    startScreen();
  } else {
    stars.add(new Stars(PApplet.parseInt(random(width)), PApplet.parseInt(random(height))));

    //Stars
    for (int i = 0; i < stars.size(); i++) {
      Stars star = stars.get(i);
      star.display();
      star.move();
      if (star.reachedBottom()==true) {
        stars.remove(star);
      }
    }

    //Blasters
    for (int i = 0; i < blasters.size(); i++) {
      Blasters blaster = blasters.get(i);
      blaster.display();
      blaster.move();
      //laser vs. asteroid collision
      for (int j = 0; j < asteroids.size(); j++) {
        Asteroid asteroid = asteroids.get(j);
        if (asteroid.blasterIntersection(blaster)) {
          blasters.remove(blaster);
          asteroid.health-=25;
        }
        if (asteroid.health<0) {
          asteroids.remove(asteroid);
          score+=25;
        }
      }
      if (blaster.reachedTop()==true) {
        blasters.remove(blaster);
      }
    }

    //Asteroids
    for (int i = 0; i < asteroids.size(); i++) {
      Asteroid asteroid = asteroids.get(i);
      asteroid.display();
      asteroid.move();
      if (s1.asteroidIntersection(asteroid)==true) {
        asteroids.remove(asteroid);
        s1.health-=50;
        score+=25;
      }
      if (asteroid.reachedBottom()==true) {
        asteroids.remove(asteroid);
        pass++;
      }
    }
    if (asteroidtimer.isFinished()) {
      //distribute Asteroid
      asteroids.add(new Asteroid(PApplet.parseInt(random(50, 550)), -50, PApplet.parseInt(random(2, 5))));
      asteroidtimer.start();
    }

    //infoPanel
    infoPanel();

    //spaceship
    s1.display(mouseX, mouseY);
    if (s1.health<1) {
      s1.lives--;
      if (s1.lives>0) {
        s1.health=100;
      }
    }

    //GameOver
    if (s1.health<1 && s1.lives<1 || pass>5) { 
      gameOver();
    }
  }
}


public void keyReleased() {
  if (s1.ammo >0) {
    blasters.add(new Blasters(s1.x-2, s1.y+40, color(100, 0, 0), 3));
    blasters.add(new Blasters(s1.x+27, s1.y+40, color(100, 0, 0), 3));
    s1.ammo = s1.ammo-2;
  }
}

public void infoPanel() {
  fill(128, 128);
  textSize(12);
  rectMode(CORNER);
  rect(0, height-50, width, 100);
  fill(255, 128);
  text("Health:" + s1.health, 40, height-20);
  text("Ammo:" + s1.ammo, 40, height-5);
  text("Lives:" + s1.lives, 40, height-35);
  text("Score:" + score, width-100, height-20);
}

public void startScreen() {
  textSize(48);
  textAlign(CENTER);
  text("START", width/2, height/2);
  if (mousePressed || keyPressed) {
    //play=true;
  }
}

public void gameOver() {
  background(0);
  image(explode, s1.x, s1.y);
  fill(255, 128);
  textSize(48);
  textAlign(CENTER);
  text("GAME OVER", width/2, height/2);
  textSize(20);
  text("Score:" + score, width/2, height/2+48);
}
class Asteroid {
  //member variables
  int x, y, speed, health;
  int c;
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
  public void display() {
    rectMode(CENTER);
    fill(100, 82, 77);
    noStroke();
    image(asteroid,x,y);
  } 
  public void move() {
    y+=speed;
  }

  //Laser Vs. Asteroid
  public boolean blasterIntersection(Blasters blaster) {
    float distance = dist(x, y, blaster.x, blaster.y);
    if (distance<r+blaster.r) {
      return true;
    } else {
      return false;
    }
  }


  public boolean reachedBottom() {
    if (y>height+50) {
      return true;
    } else {
      return false;
    }
  }
}
class Blasters {
  //member variables
  int x, y, speed;
  int c;
  float r;

  //constructor
  Blasters(int x, int y, int c, int speed) {
    this.x = x;
    this.y = y;
    this.c = c;
    this.speed = speed;
    r=25;
  }

  //display method
  public void display() {
    rectMode(CENTER);
    fill(c);
    noStroke();
    ellipse(x, y, 8, 8);
    triangle(x+4, y, x-4, y, x, y-8);
  }

  public void move() {
    y-=speed;
  }

  public boolean reachedTop() {
    if (y<-10) {
      return true;
    } else {
      return false;
    }
  }
}
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
  public void display(int x, int y) {
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
      triangle(x+10, y, x+15, y, x+12.5f, y-25);
      fill(0);
      stroke(0);
      ellipse(x+12.5f, y, 4, 10);
      //guns
      stroke(255, 165, 0);
      fill(255, 165, 0);
      line(x, y+60, x, y+45);
      line(x+25, y+60, x+25, y+45);
      stroke(0, 0, 150);
      fill(0, 0, 150);
      //exhaust
      triangle(x+5, y+75, x+20, y+75, x+12.5f, y+100);
  }

  //detect collision rock and spaceship
  public boolean asteroidIntersection(Asteroid asteroid) {
    float distance = dist(x, y, asteroid.x, asteroid.y);
    if (distance<r+asteroid.r) {
      return true;
    } else {
      return false;
    }
  }
}
class Stars {
  //member variables
  int c;
  int x, y, speed, dia;

  //constructor
  Stars(int x, int y) {
    this.c = color(255);
    this.x = x;
    this.y = y;
    speed = PApplet.parseInt(random(1, 2));
    dia = PApplet.parseInt(random(1, 4));
  }

  //display method
  public void display() {
    fill(c);
    ellipse(x, y, dia, dia);
  }
  public void move() {
    y+=speed;
 }
  public boolean reachedBottom() {
    if (y>height+10) {
      return true;
    } else {
      return false;
    }
  }
}
//Danie Shiffman || http://learningprocessing.com/examples/chp10/example-10-10-rain-catcher-game

class Timer {

  int savedTime; // When Timer started
  int totalTime; // How long Timer should last

  Timer(int tempTotalTime) {
    totalTime = tempTotalTime;
  }

  // Starting the timer
  public void start() {
    // When the timer starts it stores the current time in milliseconds.
    savedTime = millis();
  }

  // The function isFinished() returns true if 5,000 ms have passed. 
  // The work of the timer is farmed out to this method.
  public boolean isFinished() { 
    // Check how much time has passed
    int passedTime = millis()- savedTime;
    if (passedTime > totalTime) {
      return true;
    } else {
      return false;
    }
  }
}
  public void settings() {  size(600, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Space_Game" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
