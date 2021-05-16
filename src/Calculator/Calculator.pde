/*
2020 Calculator for Programming I
 Jack Rich|Nov 2020
 */

//globals
Button[] buttons = new Button[10];
Button[] opButtons = new Button[13];
String dVal, op;
boolean left;
float l, r, result;
int currentNum;

void setup() {
  dVal= "0";
  op = "";
  left = true;
  l = 0.0;
  r = 0.0;
  result = 0.0;
  size(360, 630);
  background(0);
  //column 1
  rect(0, 0, 360, 90);
  textAlign(CENTER, RIGHT);
  opButtons[0] = new Button(0, 90, 90, 90, 10, "C", false);
  opButtons[1] = new Button(0, 180, 90, 90, 10, "sin", false);
  buttons[0] = new Button(0, 270, 90, 90, 10, "7", true);
  buttons[1] = new Button(0, 360, 90, 90, 10, "4", true);
  buttons[2] = new Button(0, 450, 90, 90, 10, "1", true);
  buttons[3] = new Button(0, 540, 180, 90, 10, "0", true);
  //column 2
  opButtons[2] = new Button(90, 90, 90, 90, 10, "√x", false);
  opButtons[3] = new Button(90, 180, 90, 90, 10, "cos", false);
  buttons[4] = new Button(90, 270, 90, 90, 10, "8", true);
  buttons[5] = new Button(90, 360, 90, 90, 10, "5", true);
  buttons[6] = new Button(90, 450, 90, 90, 10, "2", true);
  //column 3
  opButtons[4] = new Button(180, 90, 90, 90, 10, "x²", false);
  opButtons[5] = new Button(180, 180, 90, 90, 10, "tan", false);
  buttons[7] = new Button(180, 270, 90, 90, 10, "9", true);
  buttons[8] = new Button(180, 360, 90, 90, 10, "6", true);
  buttons[9] = new Button(180, 450, 90, 90, 10, "3", true);
  opButtons[12] = new Button(180, 540, 90, 90, 10, ".", false);
  //column 4
  opButtons[6] = new Button(270, 90, 90, 90, 10, "±", false);
  opButtons[7] = new Button(270, 180, 90, 90, 10, "÷", false);
  opButtons[8] = new Button(270, 270, 90, 90, 10, "x", false);
  opButtons[9] = new Button(270, 360, 90, 90, 10, "-", false);
  opButtons[10] = new Button(270, 450, 90, 90, 10, "+", false);
  opButtons[11] = new Button(270, 540, 90, 90, 10, "=", false);
}

void draw() {
  updateDisplay();
  for (int i=0; i<buttons.length; i++) {
    textSize(39);
    buttons[i].display();
    buttons[i].hover();
  }
  for (int i=0; i<opButtons.length; i++) {
    textSize(39);   
    opButtons[i].display();
    opButtons[i].hover();
  }    
  if (dVal == str(result)) {
    if (key == '0' ||key == '1' ||key == '2' ||key == '3' ||key == '4' ||key == '5' ||key == '6' ||key == '7' ||key == '8'||key == '9') {
    dVal = "0";
    result = 0;
    left = true;
    r = 0.0;
    l = 0.0;
    op = "";
    }
  }
}

void mousePressed() {
  for (int i=0; i<buttons.length; i++) {
    if (buttons[i].hover && dVal.length()<14) {
      handEvent(buttons[i].val, true);
    }
  }
  for (int i=0; i<opButtons.length; i++) {
    if (opButtons[i].hover) {
      handEvent(opButtons[i].val, false);
    }
  }
  println("L=" + l, "R=" + r, "Op=" + op);
  println("Result=" + result, "Left=" + left);
}

void keyPressed() {
  println("KEY:" + key + " keyCode: " + keyCode);

  if (key == '0' && dVal.length()<14) {
    handEvent("0", true);
  } else if (key == '1'&& dVal.length()<14) {
    handEvent("1", true);
  } else if (key == '2'&& dVal.length()<14) {
    handEvent("2", true);
  } else if (key == '3'&& dVal.length()<14) {
    handEvent("3", true);
  } else if (key == '4'&& dVal.length()<14) {
    handEvent("4", true);
  } else if (key == '5'&& dVal.length()<14) {
    handEvent("5", true);
  } else if (key == '6'&& dVal.length()<14) {
    handEvent("6", true);
  } else if (key == '7'&& dVal.length()<14) {
    handEvent("7", true);
  } else if (key == '8'&& dVal.length()<14) {
    handEvent("8", true);
  } else if (key == '9'&& dVal.length()<14) {
    handEvent("9", true);
  } else if (key == '.'&& dVal.length()<14) {
    handEvent(".", false);
  } else if (key == 'c') {
    handEvent("C", false);
  } else if (key == 's') {
    handEvent("sin", false);
  } else if (key == 'r') {
    handEvent("√x", false);
  } else if (key == 'v') {
    handEvent("cos", false);
  } else if (key == '-') {
    handEvent("-", false);
  } else if (key == 'x') {
    handEvent("x²", false);
  } else if (key == 't') {
    handEvent("tan", false);
  } else if (key == 'n') {
    handEvent("±", false);
  } else if (key == '/') {
    handEvent("÷", false);
  } else if (key == '*') {
    handEvent("x", false);
  } else if (key == '+') {
    handEvent("+", false);
  } else if (key == 10) {
    if (keyCode == ENTER || keyCode == RETURN) {
      handEvent("=", false);
    }
  }
}


String handEvent(String val, boolean num) {
  if (left && num) {
    if (dVal.equals("0") || result == l) {
      dVal = val;
      l = float(dVal);
    } else {
      dVal += val;
      l = float(dVal);
    }
  } else if (!left && num) {
    if (dVal.equals("o") ||result == l) {
      dVal = val;
      r = float(dVal);
    } else {
      dVal += val;
      r = float(dVal);
    }
  } else if (val.equals("C")) {
    dVal = "0";
    result = 0;
    left = true;
    r = 0.0;
    l = 0.0;
    op = "";
  } else if (val.equals("√x")) {
    if (left) {
      l = sqrt(l);
      dVal = str(l);
    } else {
      r = sqrt(r);
      dVal = str(r);
    }
  } else if (val.equals("x²")) {
    if (left) {
      l = l*l;
      dVal = str(l);
    } else {
      r = r*r;
      dVal = str(r);
    }
  } else if (val.equals("±")) {
    if (left) {
      l *= -1;
      dVal = str(l);
    } else {
      r *= -1;
      dVal = str(r);
    }
  } else if (val.equals("sin")) {
    if (left) {
      l = sin(radians(l));
      dVal = str(l);
    } else {
      r = sin(radians(r));
      dVal = str(r);
    }
  } else if (val.equals("cos")) {
    if (left) {
      l = cos(radians(l));
      dVal = str(l);
    } else {
      r = cos(radians(r));
      dVal = str(r);
    }
  } else if (val.equals("tan")) {
    if (left) {
      l = tan(radians(l));
      dVal = str(l);
    } else {
      r = tan(radians(r));
      dVal = str(r);
    }
  } else if (val.equals("÷")) {
    if (!left) {
      performCalc();
    } else {
      op = "÷";
      left = false;
      dVal = "";
    }
  } else if (val.equals("x")) {
    if (!left) {
      performCalc();
    } else {
      op = "x";
      left = false;
      dVal = "";
    }
  } else if (val.equals("-")) {
    if (!left) {
      performCalc();
    } else {
      op = "-";
      left = false;
      dVal = "";
    }
  } else if (val.equals("+")) {
    if (!left) {
      performCalc();
    } else {
      op = "+";
      left = false;
      dVal = "";
    }
  } else if (val.equals("=")) {
    performCalc();
    dVal = str(result);
  } else if (val.equals(".") && !dVal.contains(".")) {
    if (left) {
      dVal+= val;
      l = float(dVal);
    } else {
      dVal += val;
      r = float(dVal);
    }
  }
  return val;
}



void updateDisplay() {
  fill(255);
  rect(0, 0, width, 90);
  fill(0);
  //render scale
  if (dVal.length()<11) {
    textSize(45);
  } else if (dVal.length()<12) {
    textSize(43);
  } else if (dVal.length()<13) {
    textSize(41);
  } else if (dVal.length()<14) {
    textSize(39);
  }
  textAlign(RIGHT, DOWN);
  text(dVal, width, 85);
}

void performCalc() {
  if (op.equals("+")) {
    result = l + r;
  } else if (op.equals("-")) {
    result = l - r;
  } else if (op.equals("x")) {
    result = l * r;
  } else if (op.equals("÷")) {
    result = l / r;
    l = result;
    dVal = str(result);
    left = true;
  }
}
