package com.ontariotechu.sofe3980U;
import org.joda.time.LocalTime;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      boolean cont = true;
      LocalTime currentTime = new LocalTime();
      System.out.println("The current local time is " + currentTime);
      while (cont=true) {
      Scanner scan=new Scanner(System.in);
      System.out.println("Select an operation: 1.Addition, 2.Or, 3.And, 4.multiplication, 5.exit ");
      String reply=scan.next();
      reply = reply.toLowerCase();
      if (reply.equals("5") || reply.equals("exit")){
         cont=false;
         break;
      }
      System.out.println("Enter the first number:");
      Binary binary1=new Binary(scan.next());
      System.out.println("Enter the second number");
      Binary binary2=new Binary(scan.next());
      if (reply.equals("1") || reply.equals("addition")){
         Binary sum= Binary.add(binary1,binary2);
            System.out.println( "Their summation is "+sum.getValue());
      }
      if (reply.equals("2") || reply.equals("or")){
	    Binary or= Binary.or(binary1,binary2);
            System.out.println( "Their or is "+or.getValue());

      }
      if (reply.equals("3") || reply.equals("and")){
      Binary and=Binary.and(binary1,binary2);
       System.out.println("Their and is " +and.getValue());
       } 
       
      if (reply.equals("4") || reply.equals("muliplication")){
	Binary multiply = Binary.multiply(binary1,binary2);
	System.out.println("Their multiplcation is: " + multiply.getValue());
      }
      

       }
       System.out.println("Goodbye");
    }
}
