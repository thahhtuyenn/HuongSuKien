package tuan01_congTruNhanChia;

public class CalculatorModel {
	private double a;
	private double b;
	private String phepToan;

	public CalculatorModel(double a, double b, String phepToan) {
		this.a = a;
		this.b = b;
		this.phepToan = phepToan;
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

	public double tinhToan() {
		double ketQua = 0;
		if (SystemConstains.CONG.equals(phepToan)) {
			ketQua = a + b;
		} else if (SystemConstains.TRU.equals(phepToan)) {
			ketQua = a - b;
		} else if (SystemConstains.NHAN.equals(phepToan)) {
			ketQua = a * b;
		} else if (SystemConstains.CHIA.equals(phepToan)) {
			// Xuwr lis chia cho 0
			ketQua = a / b;
		}
		return ketQua;
	}
}
