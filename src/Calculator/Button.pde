class Button{
  //Member Variables
  int x,y,w,h,c;
  String val;
  boolean hover, isNumber;
  color c1,c2,c3;
  
  //Constructor
  Button(int tempX, int tempY, int tempW, int tempH, int tempC, String tempVal, boolean isNumber)  {    
    x  = tempX;   
    y  = tempY;   
    w  = tempW;   
    h  = tempH; 
    c  = tempC;
    val = tempVal;
    hover = false;
    c1 = 25;
    c2 = 200;
    c3 = 100;
    this.isNumber = isNumber;
  }
  //Display the button
  void display() {
    if(hover){ 
      fill(c2);
    }else if(isNumber == true){
      fill(c1);      
    } else {
      fill (c3); 
   }
    rect(x,y,w,h,c);
    fill(255);
    textAlign(CENTER,CENTER);
    text(val, x+w/2,y+h/2);
  }
  
  //Edge detection
  void hover(){
    hover = mouseX > x && mouseX < x+w && mouseY > y && mouseY < y+h; 
  }
}
