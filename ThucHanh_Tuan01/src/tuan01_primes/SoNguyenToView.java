package tuan01_primes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SoNguyenToView extends JFrame implements ActionListener{
	private SoNguyenToModel sntModel;
	private JTextField jTextField_soNguyen;
	private JTextArea jTextArea_ketQua;
	private JButton jButton_generate;
	
	public SoNguyenToView() {
		this.setTitle("Primes");
		this.setSize(360,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		createGUI();
		this.setVisible(true);
	}

	private void createGUI() {
		this.setLayout(null);
		
		jTextField_soNguyen = new JTextField();
		jTextField_soNguyen.setBounds(20, 5, 200, 30);
		jTextField_soNguyen.setToolTipText("Nhập số nguyên vào ô");
		
		jButton_generate = new JButton("Generate");
		jButton_generate.setBounds(225, 5, 100, 30);
		
		jTextArea_ketQua = new JTextArea();
		jTextArea_ketQua.setToolTipText("Danh sách các số nguyên tố");
		jTextArea_ketQua.setEditable(false);
		JScrollPane jScollPane_ketQua = new JScrollPane(jTextArea_ketQua);
		jScollPane_ketQua.setBounds(20, 40, 305, 200);
		this.add(jTextField_soNguyen);
		this.add(jButton_generate);
		this.add(jScollPane_ketQua);
		jButton_generate.addActionListener(this);
	}
	
	private void thucHienChucNangGenerate() {
		int n;
		try {
			String stringN = jTextField_soNguyen.getText().trim();
			if(stringN.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập dữ liệu vào!");
				return;
			}
			n = Integer.parseInt(stringN);
			if(n <= 0) {
				JOptionPane.showMessageDialog(this, "Vui long nhap n lon hon 0!");
				return;
			}
			sntModel = new SoNguyenToModel(n);
			jTextArea_ketQua.setText(sntModel.daySoNguyenTo());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên!");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(jButton_generate))
			thucHienChucNangGenerate();
		
	}
	
	public static void main(String[] args) {
		new SoNguyenToView();
	}
}
