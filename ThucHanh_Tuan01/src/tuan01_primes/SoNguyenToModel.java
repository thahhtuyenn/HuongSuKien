package tuan01_primes;

public class SoNguyenToModel {
	private int n;

	public SoNguyenToModel(int n) {
		this.n = n;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	private boolean ktSoNguyenTo(int x) {
		if (x < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if ((x % i) == 0)
				return false;
		}
		return true;
	}

	public String daySoNguyenTo() {
		String s = "";
		int count = 0;
		int i = 1;
		while (count < n) {
			if (ktSoNguyenTo(i)) {
				count++;
				s += i + "\n";
				i++;
			} else
				i++;
		}
		return s;
	}

}
