import java.util.ArrayList;
import java.util.List;
public class Game {

//	Player player;//Klasse Player wird erstmal nicht gebraucht
	List<Frame> frames = new ArrayList<Frame>(10);
	int iteration;

	public static void main(String[] args) {
		System.out.println("Game 1 :");
		Game game1 = new Game();
		test1(game1);// Beispiel nummer 1 (von Freitag)
		
		System.out.println("Game 2 :");
		Game game2 = new Game();
		test2(game2);//Beispiel nummer 2 (von Freitag) -> bei variante 2, ich habe 133 statt 151 bekommen auch wenn ich  selbe rechne, vielleicht rechne ich falsch oder haben wir Freitag was  übersehen!
		
		System.out.println("Game 3 :");
		Game game3 = new Game();
		test3(game3);//Beispiel3(andre Beispiel)

	}

	public int spielStand(int iteration) {
		int sum = 0;
		int bonus = 0;
		if (iteration == 0) {
			sum = frames.get(0).getScore();
		} else {
			sum = spielStand(iteration - 1) + frames.get(iteration).getScore();
			if (frames.get(iteration - 1).isSpare()) {
				bonus = bonus + frames.get(iteration).throwList.get(0);
			} else if ((frames.get(iteration - 1).isStrike())) {
				bonus = bonus + frames.get(iteration).throwList.get(0) + frames.get(iteration).throwList.get(1);
				if ((iteration > 2) && (frames.get(iteration - 2).isStrike())) {
					bonus = bonus + frames.get(iteration).throwList.get(0);
				}
			}
		}
		if ((iteration == 9)) {
			if (frames.get(iteration).isStrike()) {
				bonus = bonus + frames.get(iteration).throwList.get(2) + frames.get(iteration).throwList.get(3);
			} else if (frames.get(iteration).isSpare()) {
				bonus = bonus + frames.get(iteration).throwList.get(2);
			}
			if (frames.get(8).isStrike()) {

				if (frames.get(9).isStrike()) {
					bonus = bonus + frames.get(9).throwList.get(2);
				}
			}
		}

		sum = sum + bonus;
		return sum;
	}

	private void printframes() {
		frames.forEach(System.out::println);
	}

	public void wurfelnAccept(int zahl) {
		if (frames.size() <= iteration) {
			Frame frame = new Frame(iteration);
			frame.throwList.add(zahl);
			frames.add(frame);
		} else {
			frames.get(iteration).throwList.add(zahl);
		}
	}

	public static void test1(Game game) {
		game.iteration = 0;
		game.wurfelnAccept(5);
		game.wurfelnAccept(3);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 1;
		game.wurfelnAccept(0);
		game.wurfelnAccept(1);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 2;
		game.wurfelnAccept(5);
		game.wurfelnAccept(5);

		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 3;
		game.wurfelnAccept(1);
		game.wurfelnAccept(4);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 4;
		game.wurfelnAccept(10);
		game.wurfelnAccept(0);

		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 5;
		game.wurfelnAccept(1);
		game.wurfelnAccept(1);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 6;
		game.wurfelnAccept(10);
		game.wurfelnAccept(0);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 7;
		game.wurfelnAccept(10);
		game.wurfelnAccept(0);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 8;
		game.wurfelnAccept(10);
		game.wurfelnAccept(0);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 9;
		game.wurfelnAccept(10);
		game.wurfelnAccept(0);
		game.wurfelnAccept(10);
		game.wurfelnAccept(10);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.printframes();

	}

	public static void test2(Game game) {
		game.iteration = 0;
		game.wurfelnAccept(5);
		game.wurfelnAccept(3);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 1;
		game.wurfelnAccept(0);
		game.wurfelnAccept(1);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 2;
		game.wurfelnAccept(5);
		game.wurfelnAccept(5);

		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 3;
		game.wurfelnAccept(1);
		game.wurfelnAccept(4);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 4;
		game.wurfelnAccept(10);
		game.wurfelnAccept(0);

		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 5;
		game.wurfelnAccept(1);
		game.wurfelnAccept(1);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 6;
		game.wurfelnAccept(10);
		game.wurfelnAccept(0);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 7;
		game.wurfelnAccept(10);
		game.wurfelnAccept(0);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 8;
		game.wurfelnAccept(10);
		game.wurfelnAccept(0);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 9;
		game.wurfelnAccept(2);
		game.wurfelnAccept(8);
		game.wurfelnAccept(6);
		game.wurfelnAccept(0);// es wird nicht 0 gewuerfelt, 0 sorgt hier nur fuer weniger Komlexitaet

		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.printframes();

	}

	public static void test3(Game game) {
		game.iteration = 0;
		game.wurfelnAccept(1);
		game.wurfelnAccept(1);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 1;
		game.wurfelnAccept(2);
		game.wurfelnAccept(3);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 2;
		game.wurfelnAccept(5);
		game.wurfelnAccept(4);

		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 3;
		game.wurfelnAccept(6);
		game.wurfelnAccept(1);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 4;
		game.wurfelnAccept(1);
		game.wurfelnAccept(6);

		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 5;
		game.wurfelnAccept(7);
		game.wurfelnAccept(2);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 6;
		game.wurfelnAccept(0);
		game.wurfelnAccept(5);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 7;
		game.wurfelnAccept(3);
		game.wurfelnAccept(3);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 8;
		game.wurfelnAccept(10);
		game.wurfelnAccept(0);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.iteration = 9;
		game.wurfelnAccept(5);
		game.wurfelnAccept(5);
		game.wurfelnAccept(6);
		game.wurfelnAccept(0);
		System.out.println("Spielstand Turn " + game.iteration + " :" + game.spielStand(game.iteration));

		game.printframes();

	}

}
