package tuan01_phuongTrinhBachai;

public class PhuongTrinhBacHaiModel {
	private double a, b, c;

	public PhuongTrinhBacHaiModel(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public String giaiPhuongTrinhBacHai() {
		String ketQua = "";

		if (a == 0) {
			// Phuong trình bậc 1
			if(b == 0) {
				ketQua = "Phương trình vô nghiệm.";
			}else {
				ketQua = "x = " + (-c / b);
			}
		} else {
			// Phương trình bậc 2
			double denta = Math.pow(b, 2) - 4 * a * c;
			if (denta < 0) {
				ketQua = "Phương trình vô nghiệm.";
			} else if (denta == 0) {
				ketQua = "x1 = x2 = " + (-b / 2 * a);
			} else {
				double x1, x2;
				x1 = (-b + Math.sqrt(denta)) / 2 * a;
				x2 = (-b - Math.sqrt(denta)) / 2 * a;
				ketQua = "x1 = " + x1 + " x2 = " + x2;
			}
		}

		return ketQua;
	}
}
