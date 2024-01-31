package geometry;

public interface Movable {
	
	//Svi atributi su const sa podrazumevanim public static final kljucnim recima
	//  /*public static final*/ int BROJ = 55;
	
	
	//Sve metode u interfesju su apstraktne i uveksu public pa se 2 kljucne reci ne pisu
	void moveTo(int x, int y);
	void moveBy(int byX, int byY);
}
