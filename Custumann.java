package Datetime;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface Cricketplayer{
	int age=22;
	
}
@Cricketplayer
class Virat{
     @Cricketplayer
	int inning;
	int runs;
public int getinning() {
	return inning;
}
public void setinning(int inning) {
	this.inning=inning;
}
public int getruns() {
	return runs;
}
public void setruns(int runs) {
	this.runs=runs;
	
}
}

public class Custumann {
	public static void main(String[]args) {
		Virat v=new Virat();
		v.setinning(300);
		v.setruns(100000);
		System.out.println(v.getinning());
		System.out.println(v.getruns());
		
		Class c=v.getClass();
		Annotation a=c.getAnnotation(Cricketplayer.class);
		Cricketplayer cp=(Cricketplayer)a;
		int age=cp.age;
		System.out.println(age);
		
	}
		
	}


