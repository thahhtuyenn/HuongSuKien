package tuan01_phuongTrinhBachai;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;

public class PhuongTrinhBacHaiView extends JFrame implements ActionListener{
	private PhuongTrinhBacHaiModel ptModel;
	private JTextField jTextField_nhapA;
	private JTextField jTextField_nhapB;
	private JTextField jTextField_nhapC;
	private JTextField jTextField_ketQua;
	private JButton jButton_giai;
	private JButton jButton_xoaRong;
	private JButton jButton_thoat;
	
	public PhuongTrinhBacHaiView() {
		this.setTitle("^-^");
		this.setSize(450,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		createGUI();
		this.setVisible(true);
	}
	
	private void createGUI() {
		Font font_Title = new FontUIResource("Arial", Font.BOLD, 20);
		JLabel jLabel_title = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
		jLabel_title.setFont(font_Title);
		JPanel jPanel_title = new JPanel();
		jPanel_title.add(jLabel_title, jPanel_title.CENTER_ALIGNMENT);
		jPanel_title.setBackground(Color.cyan);
		
		Font font_center = new FontUIResource("Arial", Font.BOLD, 13);
		
		JLabel jLabel_nhapA = new JLabel("Nhập a: ");
		jLabel_nhapA.setBounds(40, 70, 100, 25);
		jLabel_nhapA.setFont(font_center);
		jTextField_nhapA = new JTextField();
		jTextField_nhapA.setBounds(150, 70, 250, 25);
		jTextField_nhapA.setEditable(true);
		
		
		JLabel jLabel_nhapB = new JLabel("Nhập b: ");
		jLabel_nhapB.setBounds(40, 110, 100, 25);
		jLabel_nhapB.setFont(font_center);
		jTextField_nhapB = new JTextField();
		jTextField_nhapB.setBounds(150, 110, 250, 25);
		jTextField_nhapB.setEditable(true);
		
		JLabel jLabel_nhapC = new JLabel("Nhập c: ");
		jLabel_nhapC.setBounds(40, 150, 100, 25);
		jLabel_nhapC.setFont(font_center);
		jTextField_nhapC = new JTextField();
		jTextField_nhapC.setBounds(150, 150, 250, 25);
		jTextField_nhapC.setEditable(true);
		
		JLabel jLabel_ketqua = new JLabel("Kết quả: ");
		jLabel_ketqua.setBounds(40, 190, 100, 25);
		jLabel_ketqua.setFont(font_center);
		jTextField_ketQua = new JTextField();
		jTextField_ketQua.setBounds(150, 190, 250, 25);
		jTextField_ketQua.setFont(font_center);
		jTextField_ketQua.setEditable(false);
		
		JPanel jPanel_center = new JPanel();
		jPanel_center.setLayout(null);
		jPanel_center.add(jLabel_nhapA);
		jPanel_center.add(jTextField_nhapA);
		jPanel_center.add(jLabel_nhapB);
		jPanel_center.add(jTextField_nhapB);
		jPanel_center.add(jLabel_nhapC);
		jPanel_center.add(jTextField_nhapC);
		jPanel_center.add(jLabel_ketqua);
		jPanel_center.add(jTextField_ketQua);
		
		jButton_giai = new JButton("Giải");
		jButton_giai.addActionListener(this);
		jButton_xoaRong = new JButton("Xóa rỗng");
		jButton_xoaRong.addActionListener(this);
		jButton_thoat = new JButton("Thoát");
		jButton_thoat.addActionListener(this);
		
		JPanel jPanel_south = new JPanel();
		jPanel_south.add(jButton_giai, CENTER_ALIGNMENT);
		jPanel_south.add(jButton_xoaRong, CENTER_ALIGNMENT);
		jPanel_south.add(jButton_thoat, CENTER_ALIGNMENT);
		TitledBorder tb = BorderFactory.createTitledBorder("Chọn tác vụ: ");
		tb.setTitleJustification(TitledBorder.LEFT);
		jPanel_south.setBorder(tb);
		
		this.setLayout(new BorderLayout());
		this.add(jPanel_title, BorderLayout.NORTH);
		this.add(jPanel_center, BorderLayout.CENTER);
		this.add(jPanel_south, BorderLayout.SOUTH);
	}
	
	private void thucHienChucNangXoaRong() {
		jTextField_nhapA.setText("");
		jTextField_nhapB.setText("");
		jTextField_nhapC.setText("");
		jTextField_ketQua.setText("");
		jTextField_nhapA.requestFocus();
	}
	
	private void thucHienChucNangThoat() {
		System.exit(0);
	}
	
	private void thucHienChucNangGiai() {
		double a = 0, b = 0, c = 0;
		try {
			String stringA = jTextField_nhapA.getText().trim();
			if(stringA.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập a!");
				return;
			}
			a = Double.parseDouble(stringA);
			
			String stringB = jTextField_nhapB.getText().trim();
			if(stringB.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập b!");
				return;
			}
			b = Double.parseDouble(stringB);
			
			String stringC = jTextField_nhapC.getText().trim();
			if(stringC.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập c!");
				return;
			}
			c = Double.parseDouble(stringC);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số!");
			return;
		}
		ptModel = new PhuongTrinhBacHaiModel(a, b, c);
		jTextField_ketQua.setText(ptModel.giaiPhuongTrinhBacHai());
	}
	
	public static void main(String[] args) {
		PhuongTrinhBacHaiView pt = new PhuongTrinhBacHaiView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(jButton_giai)) {
			thucHienChucNangGiai();
		}else if(o.equals(jButton_xoaRong)){
			thucHienChucNangXoaRong();
		}else if(o.equals(jButton_thoat)) {
			thucHienChucNangThoat();
		}
		
	}
}
