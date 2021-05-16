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

void setup() {
  size(600, 600);
  s1 = new Spaceship();
  blasters = new ArrayList();
  asteroids = new ArrayList();
  stars = new ArrayList();
  asteroidtimer = new Timer(int(random(1000, 2500)));
  asteroidtimer.start();
  score = 0;
  pass = 0;
  explode = loadImage("explode.png");
  play = false;
}

void draw() {
  background(0); 
  if (!play) {
    startScreen();
  } else {
    stars.add(new Stars(int(random(width)), int(random(height))));

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
      asteroids.add(new Asteroid(int(random(50, 550)), -50, int(random(2, 5))));
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


void keyReleased() {
  if (s1.ammo >0) {
    blasters.add(new Blasters(s1.x-2, s1.y+40, color(100, 0, 0), 3));
    blasters.add(new Blasters(s1.x+27, s1.y+40, color(100, 0, 0), 3));
    s1.ammo = s1.ammo-2;
  }
}

void infoPanel() {
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

void startScreen() {
  textSize(48);
  textAlign(CENTER);
  text("START", width/2, height/2);
  if (mousePressed || keyPressed) {
    //play=true;
  }
}

void gameOver() {
  background(0);
  image(explode, s1.x, s1.y);
  fill(255, 128);
  textSize(48);
  textAlign(CENTER);
  text("GAME OVER", width/2, height/2);
  textSize(20);
  text("Score:" + score, width/2, height/2+48);
}
