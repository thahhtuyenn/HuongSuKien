package tuan01_congTruNhanChia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;

public class CalculatorView extends JFrame implements ActionListener {
	private CalculatorModel caModel; // chuaw new
	private JTextField jtField_nhapA;
	private JTextField jtField_nhapB;
	private JTextField jtField_ketQua;
	private JButton jButton_giai;
	private JButton jButton_xoa;
	private JButton jButton_thoat;
	private JLabel jLabel_title;
	private JRadioButton jrbCong;
	private JRadioButton jrbTru;
	private JRadioButton jrbNhan;
	private JRadioButton jrbChia;

	public CalculatorView() {
		this.setTitle("Cộng - Trừ - Nhân - Chia");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		createGUI();
		this.setVisible(true);
	}

	private void createGUI() {
		// ------------------------ Title C-T-N-C ------------------------
		Font font_title = new FontUIResource("Arial", Font.BOLD, 22);
		jLabel_title = new JLabel("Cộng Trừ Nhân Chia");
		jLabel_title.setForeground(Color.BLUE);
		jLabel_title.setFont(font_title);
		JPanel jPanel_title = new JPanel();
		jPanel_title.setPreferredSize(new Dimension(0, 45));
		jPanel_title.add(jLabel_title);

		Font font = new FontUIResource("Arial", Font.BOLD, 11);

		// -------------------------- Phần tác vụ --------------------------
		JPanel jPanel_tacVu = new JPanel();
		jPanel_tacVu.setBackground(Color.lightGray);
		jPanel_tacVu.setLayout(new BoxLayout(jPanel_tacVu, BoxLayout.Y_AXIS));
		jPanel_tacVu.setPreferredSize(new Dimension(100, 0));

		jButton_giai = new JButton("Giải");
		jButton_giai.setPreferredSize(new Dimension(80, 30));
		jButton_giai.setMargin(new Insets(0, 20, 0, 20));
		jButton_giai.setAlignmentX(CENTER_ALIGNMENT);
		jPanel_tacVu.add(jButton_giai);
		jPanel_tacVu.add(Box.createVerticalStrut(10));

		jButton_xoa = new JButton("Xóa");
		jButton_xoa.setPreferredSize(new Dimension(80, 30));
		jButton_xoa.setMargin(new Insets(0, 20, 0, 20));
		jButton_xoa.setAlignmentX(CENTER_ALIGNMENT);
		jPanel_tacVu.add(jButton_xoa);
		jPanel_tacVu.add(Box.createVerticalStrut(10));

		jButton_thoat = new JButton("Thoát");
		jButton_thoat.setPreferredSize(new Dimension(80, 30));
		jButton_thoat.setMargin(new Insets(0, 15, 0, 15));
		jButton_thoat.setAlignmentX(CENTER_ALIGNMENT);
		jPanel_tacVu.add(jButton_thoat);

		Border border = BorderFactory.createLineBorder(Color.gray);
		TitledBorder tb = new TitledBorder(border, "Chọn tác vụ");
		tb.setTitleFont(font);
		jPanel_tacVu.setBorder(tb);

		// --------------------------- Phần tính toán ---------------------
		JPanel jPanel_center = new JPanel();

		JPanel pnNhapA = new JPanel();
		JLabel jlNhapA = new JLabel("Nhập a: ");
		jtField_nhapA = new JTextField(25);
		jtField_nhapA.setMargin(new Insets(3, 0, 3, 0));
		pnNhapA.add(jlNhapA);
		pnNhapA.add(jtField_nhapA);
		jPanel_center.add(pnNhapA);

		JPanel pnNhapB = new JPanel();
		JLabel jlNhapB = new JLabel("Nhập b: ");
		jtField_nhapB = new JTextField(25);
		jtField_nhapB.setMargin(new Insets(3, 0, 3, 0));
		pnNhapB.add(jlNhapB);
		pnNhapB.add(jtField_nhapB);
		jPanel_center.add(pnNhapB);

		JPanel jpnPhepToan = new JPanel();
		jpnPhepToan.setLayout(new GridLayout(2, 2));
		jpnPhepToan.setPreferredSize(new Dimension(250, 100));
		jpnPhepToan.setFont(font);
		Border borderPhepToan = BorderFactory.createLineBorder(Color.gray);
		TitledBorder tbPhepToan = new TitledBorder("Phép toán");
		tbPhepToan.setBorder(borderPhepToan);
		jpnPhepToan.setBorder(tbPhepToan);
		jPanel_center.add(jpnPhepToan);

		jrbCong = new JRadioButton("Cộng");
		jrbTru = new JRadioButton("Trừ");
		jrbNhan = new JRadioButton("Nhân");
		jrbChia = new JRadioButton("Chia");
		jpnPhepToan.add(jrbCong);
		jpnPhepToan.add(jrbTru);
		jpnPhepToan.add(jrbNhan);
		jpnPhepToan.add(jrbChia);
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrbCong);
		bg.add(jrbTru);
		bg.add(jrbNhan);
		bg.add(jrbChia);

		JPanel jpnKetQua = new JPanel();
		JLabel jlKetQua = new JLabel("Kết quả: ");
		jtField_ketQua = new JTextField(25);
		jtField_ketQua.setEditable(false);
		jtField_ketQua.setMargin(new Insets(3, 0, 3, 0));
		jpnKetQua.add(jlKetQua);
		jpnKetQua.add(jtField_ketQua);
		jPanel_center.add(jpnKetQua);

		Border borderCenter = BorderFactory.createLineBorder(Color.gray);
		TitledBorder tbCenter = new TitledBorder(borderCenter, "Tính toán");
		tbCenter.setTitleFont(font);
		jPanel_center.setBorder(tbCenter);

		// ---------------------- Phần south -----------------------
		JPanel jPanel_south = new JPanel();
		jPanel_south.setBackground(Color.pink);
		jPanel_south.setPreferredSize(new Dimension(0, 45));
		;
		jPanel_south.setLayout(new FlowLayout());

		JButton jbBlue = new JButton();
		jbBlue.setBackground(Color.BLUE);
		jbBlue.setMargin(new Insets(10, 10, 10, 10));
		JButton jbRed = new JButton();
		jbRed.setBackground(Color.red);
		jbRed.setMargin(new Insets(10, 10, 10, 10));
		JButton jbYellow = new JButton();
		jbYellow.setBackground(Color.YELLOW);
		jbYellow.setMargin(new Insets(10, 10, 10, 10));

		jPanel_south.add(jbBlue, CENTER_ALIGNMENT);
		jPanel_south.add(jbRed, CENTER_ALIGNMENT);
		jPanel_south.add(jbYellow, CENTER_ALIGNMENT);

		this.setLayout(new BorderLayout());
		this.add(jPanel_title, BorderLayout.NORTH);
		this.add(jPanel_tacVu, BorderLayout.WEST);
		this.add(jPanel_center, BorderLayout.CENTER);
		this.add(jPanel_south, BorderLayout.SOUTH);
		jButton_giai.addActionListener(this);
		jButton_xoa.addActionListener(this);
		jButton_thoat.addActionListener(this);
	}

	private void thucHienChucNangXoa() {
		jtField_nhapA.setText("");
		jtField_nhapB.setText("");
		jtField_ketQua.setText("");
		jtField_nhapA.requestFocus();
	}

	private void thucHienChucNangThoat() {
		System.exit(0);
	}

	private void thucHienChucNangGiai() {
		String strA = jtField_nhapA.getText().trim();
		if (strA.equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập a!");
			return;
		}

		String strB = jtField_nhapB.getText().trim();
		if (strB.equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập b!");
			return;
		}
		
		double a = 0, b = 0;
		try {

			a = Double.parseDouble(strA);

			b = Double.parseDouble(strB);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số!");
		}
		
		
		if (jrbCong.isSelected()) {
			caModel = new CalculatorModel(a, b, SystemConstains.CONG);
		} else if (jrbTru.isSelected()) {
			caModel = new CalculatorModel(a, b, SystemConstains.TRU);
		} else if (jrbNhan.isSelected()) {
			caModel = new CalculatorModel(a, b, SystemConstains.NHAN);
		} else if (jrbChia.isSelected()) {
			caModel = new CalculatorModel(a, b, SystemConstains.CHIA);
		}
		double ketQua = caModel.tinhToan();
		jtField_ketQua.setText("" + ketQua);
	}

	public static void main(String[] args) {
		new CalculatorView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(jButton_giai))
			thucHienChucNangGiai();
		else if (o.equals(jButton_xoa))
			thucHienChucNangXoa();
		else if (o.equals(jButton_thoat))
			thucHienChucNangThoat();

	}
}
