import java.util.ArrayList;
import java.util.List;

public class Frame {

	int nummer;
	List<Integer> throwList = new ArrayList<Integer>();// statt throw1 und throw1 ich habe eine Liste für throws
														// erstellt

	public Frame(int num) {
		nummer = num;
	}

	@Override
	public String toString() {
		if (nummer < 9) {
			return "Frame " + nummer + " [first Throw =" + throwList.get(0) + ", second Throw =" + throwList.get(1)
					+ ", score=" + getScore() + "]";

		} else {
			return "Frame " + nummer + " [first Throw =" + throwList.get(0) + ", second Throw =" + throwList.get(1)
					+ ", third Throw =" + throwList.get(2) + ", fourth Throw =" + throwList.get(3) + ", score="
					+ getScore() + "]";
		}
	}

	public int getScore() {
		return throwList.stream().mapToInt(i -> i).sum();
	}

	boolean isStrike() {
		return (throwList.get(0) == 10);
	}

	boolean isSpare() {
		if (!isStrike()) {
			return ((throwList.get(0) + throwList.get(1)) == 10);
		} else {
			return false;
		}
	}
}