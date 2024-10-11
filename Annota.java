package Datetime;
// Functional interface
@FunctionalInterface
interface Demo{
	void Disp();
	//void Disp2();
}
//parent class
@Deprecated
class Plane{
	public void Planeflyatgoodheight() {
		System.out.println("plane is flying");
	}
}
//child class
class Cargoplane extends Plane{
	//overriden method from parent class
	@Override
	public void Planeflyatgoodheight() {
		System.out.println("cargoplane flies low");
	}
	
	
}
public class Annota {
	public static void main(String[]args) {
		Plane p =new Cargoplane();
		p.Planeflyatgoodheight();
			
		}
		
	}


