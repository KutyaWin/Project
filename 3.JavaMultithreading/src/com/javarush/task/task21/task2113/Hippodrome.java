package com.javarush.task.task21.task2113;


import java.util.ArrayList;
import java.util.List;


public class Hippodrome {
 static  Hippodrome game;
 private final List<Horse>  horses;

 public List<Horse> getHorses() {
  return horses;
 }

 public Hippodrome(List<Horse> horses){
  this.horses = horses;
 }

 public static void main(String[] args) throws InterruptedException {
  List<Horse> horses = new ArrayList<>();
  horses.add(new Horse("Katrina", 3,0));
  horses.add(new Horse("Kafka", 3,0));
  horses.add(new Horse("Katya", 3,0));
game = new Hippodrome(horses);
game.run();
game.printWinner();
 }

 void run() throws InterruptedException {                                 //для управления move и print
  for (int i = 0; i < 100; i++) {
   move();
   print();
   Thread.sleep(200);
  }
 }
 void move(){                              //для управления лошадьми
for (Horse horse: horses){
      horse.move();
}
 }
 void print(){                                        //для отрисовки лощадей
  for (Horse horse: horses){
   horse.print();
  }

  for (int i = 0; i <10; i++) {
   System.out.println();
  }

 }
 public Horse getWinner(){
  Horse hor =horses.get(0);
  for(Horse horse: horses) {
   if(horse.getDistance()>hor.getDistance())
    hor = horse;
  }
  return hor;
 }
 public void printWinner(){
  System.out.println("Winner is "+ getWinner().getName()+"!");
 }
}
