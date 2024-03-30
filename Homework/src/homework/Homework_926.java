package homework;

public class Homework_926 {
	static final double PI = 3.1415926;
	public static void main(String[] args) {
		Planet [] solarSystem = Planet.values();
		
		System.out.println("== 태양계 행성의 면적 ==");
		for(Planet p : solarSystem) {
			double area = (double)p.getRadius()*p.getRadius()*PI*4;
			System.out.println(p.name() + "의 면적 : " + area + " km^2");
		}
	}
	public enum Planet{
		수성(2439), 금성(6052), 지구(6371), 화성(3390), 목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);
		
		private int radius;

		public int getRadius() {
			return radius;
		}

		private Planet(int radius) {
			this.radius = radius;
		}
	};
}
