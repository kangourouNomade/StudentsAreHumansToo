package QueueTask;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Main {
   public static void main (String[] args){
      ArrayDeque <String> bbTheory = new ArrayDeque<>();
      String sheldon = "Sheldon";
      String volovic = "Volovic";
      String leonard = "Leonard";
      String kutrapally = "Kutrapally";
      String penny = "Penny";
      bbTheory.add(sheldon);
      bbTheory.add(leonard);
      bbTheory.add(volovic);
      bbTheory.add(kutrapally);
      bbTheory.add(penny);
      System.out.println(bbTheory);
      System.out.println();

      Main.doubleCola(bbTheory, 6);
   }

   public static void doubleCola(ArrayDeque <String> queue, int bottles){
      String next = "";
      for (int i = 0; i < bottles; i++){
         next = queue.pollFirst();
         queue.add(next);
         queue.add(next);
      }
      System.out.println(queue);
   }
}
