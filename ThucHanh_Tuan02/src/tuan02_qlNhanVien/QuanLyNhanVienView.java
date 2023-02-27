package tuan02_qlNhanVien;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.basic.DefaultMenuLayout;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class QuanLyNhanVienView extends JFrame implements ActionListener{
	private ListEmployee listEmployeeModel;
	private JLabel jlbTitle, jlbMaNhanVien,jlbHo,jlbTen,jlbTuoi,jlbPhai,jlbTienLuong,jlbNhapMa;
	private JTextField jtxMaNhanVien,jtxHo,jtxTen,jtxTuoi,jtxTienLuong,jtxNhapMa;
	private JRadioButton jbtNu,jbtNam;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton jbtTim,jbtThem,jbtXoaTrang,jbtXoa,jbtLuu, jbtSua;
	private JPanel jpnNorth;
	private JPanel jpnCenter;

	public QuanLyNhanVienView() {
		this.setTitle("^-^");
		this.setSize(700, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		createGUI();
		this.setVisible(true);
	}

	private void createGUI() {
		listEmployeeModel = new ListEmployee();
		Font font = new Font("Arial", Font.BOLD, 12);

		// ------------------------ JPanel north ---------------------------
		jpnNorth = new JPanel();
		jlbTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
		Font fontTitle = new Font("Arial", Font.BOLD, 24);
		jlbTitle.setForeground(Color.BLUE);
		jlbTitle.setFont(fontTitle);
		jpnNorth.add(jlbTitle);

		// ---------------------- JPanel Center ---------------------------
		jpnCenter = new JPanel();
		jpnCenter.setLayout(new BoxLayout(jpnCenter, BoxLayout.Y_AXIS));
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		b.add(Box.createVerticalStrut(5));
		jpnCenter.add(b);
		jpnCenter.add(Box.createHorizontalStrut(15));
		
		jlbMaNhanVien = new JLabel("Mã nhân viên: ");
		jlbHo = new JLabel("Họ: ");
		jlbTen = new JLabel("Tên nhân viên: ");
		jlbTuoi = new JLabel("Tuổi: ");
		jlbPhai = new JLabel("Phái: ");
		jlbTienLuong = new JLabel("Tiền lương: ");
		
		jtxMaNhanVien = new JTextField();
		jtxHo = new JTextField();
		jtxTen = new JTextField();
		jtxTuoi = new JTextField();
		jtxTienLuong = new JTextField();
		

		// ---------- Mã nhân viên ------------
		b1.add(jlbMaNhanVien);
		b1.add(jtxMaNhanVien);

		// ---------- Họ tên ------------
		b2.add(jlbHo);
		b2.add(jtxHo);
		b2.add(jlbTen);
		b2.add(jtxTen);
		jlbHo.setPreferredSize(jlbMaNhanVien.getPreferredSize());

		// ------------ Tuổi và phái: Nam or Nữ ------------
		b3.add(jlbTuoi);
		b3.add(jtxTuoi);
		jbtNam = new JRadioButton("Nam");
		jbtNu = new JRadioButton("Nữ");
		ButtonGroup gr = new ButtonGroup();
		gr.add(jbtNam);
		gr.add(jbtNu);
		b3.add(jlbPhai);
		jlbTuoi.setPreferredSize(jlbMaNhanVien.getPreferredSize());
		b3.add(jbtNam);
		b3.add(jbtNu);
		jbtNam.setSelected(true);

		// ---------------- Tiền lương ------------------
		b4.add(jlbTienLuong);
		jlbTienLuong.setPreferredSize(jlbMaNhanVien.getPreferredSize());
		b4.add(jtxTienLuong);

		
		// Setup Model vào Table -> xử lí model thì table thay đổi
		taoBang();
		
		
		//------------------------ JPanel south ---------------------------
		JSplitPane split;
		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		split.setResizeWeight(0.5);
		
		JPanel jpnLeft = new JPanel();
		jpnLeft.setPreferredSize(new Dimension(350, 40));
		jpnLeft.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		jlbNhapMa = new JLabel("Nhập mã số cần tìm: ");
		jlbNhapMa.setPreferredSize(new Dimension(132, 30));
		jlbNhapMa.setFont(font);
		jtxNhapMa = new JTextField(10);
		jbtTim = new JButton("Tìm");
		jbtTim.setMargin(new Insets(0, 10, 0, 10));
		jpnLeft.add(jlbNhapMa);
		jpnLeft.add(jtxNhapMa);
		jpnLeft.add(jbtTim);
		split.add(jpnLeft);
		
		JPanel jpnRight = new JPanel();
		jpnRight.setPreferredSize(new Dimension(300, 40));
		jpnRight.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		jbtThem = new JButton("Thêm");
		jbtThem.setMargin(new Insets(0, 10, 0, 10));
		jbtXoaTrang = new JButton("Xóa trắng");
		jbtXoaTrang.setMargin(new Insets(0, 10, 0, 10));
		jbtXoa = new JButton("Xóa");
		jbtXoa.setMargin(new Insets(0, 10, 0, 10));
		jbtLuu = new JButton("Lưu");
		jbtLuu.setMargin(new Insets(0, 10, 0, 10));
		jbtSua = new JButton("Sửa");
		jbtSua.setMargin(new Insets(0, 10, 0, 10));
		jpnRight.add(jbtThem);
		jpnRight.add(jbtXoaTrang);
		jpnRight.add(jbtXoa);
		jpnRight.add(jbtSua);
		jpnRight.add(jbtLuu);
		split.add(jpnRight);

		// ---------------------- This ----------------------
		this.setLayout(new BorderLayout());
		this.add(jpnNorth, BorderLayout.NORTH);
		this.add(jpnCenter, BorderLayout.CENTER);
		this.add(split, BorderLayout.SOUTH);
		
		jbtThem.addActionListener(this);
		jbtXoaTrang.addActionListener(this);
		jbtTim.addActionListener(this);
	}
	
	public void taoBang() {
		JPanel jpnTable = new JPanel();
		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		tableModel.addColumn("Mã NV");
		tableModel.addColumn("Họ");
		tableModel.addColumn("Tên");
		tableModel.addColumn("Phái");
		tableModel.addColumn("Tuổi");
		tableModel.addColumn("Tiền lương");
		TableColumn phaiColumn = table.getColumnModel().getColumn(3);
		tableModel.setRowCount(0);
		JComboBox comboBox = new  JComboBox();
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");
		phaiColumn.setCellEditor(new DefaultCellEditor(comboBox));
		TableColumn column = new TableColumn();
		column.setPreferredWidth(100);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		table.getColumnModel().getColumn(0).setCellRenderer(center);
		table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		
		JScrollPane sp = new JScrollPane(table);
		sp.setPreferredSize(new Dimension(650, 300));
		jpnCenter.add(sp);
	}

	public void thucHienChucNangTim() {
		String id = jtxNhapMa.getText().trim();
		int vitri = listEmployeeModel.search(id);
		System.out.println(vitri);
		if(vitri < 0) {
			JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên có mã " + id + "!");
		}else {
			table.setRowSelectionInterval(vitri, vitri);
		}
	}
	
	public void thucHienChucNangThem() {
		try {
			String id = jtxMaNhanVien.getText().trim();
			if(id == "") {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên!");
				return;
			}
			String firstName = jtxHo.getText().trim();
			if(firstName == "") {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập họ nhân viên!");
				return;
			}
			String lastName = jtxTen.getText().trim();
			if(lastName == "") {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhân viên!");
				return;
			}
			if(jtxTuoi.getText().trim() == "") {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tuổi nhân viên!");
				return;
			}
			int age = Integer.parseInt(jtxTuoi.getText().trim());
			if(jtxTienLuong.getText().trim() == "") {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập lương nhân viên!");
				return;
			}
			double salary = Double.parseDouble(jtxTienLuong.getText().trim());
			
			String gender = "";
			if(jbtNam.isSelected()) {
				gender = "Nam";
			}else {
				gender = "Nữ";
			}
			
			Employee newEmployee = new Employee(id, firstName, lastName, gender, salary, age);
			if(listEmployeeModel.addEmployee(newEmployee)) {
				tableModel.addRow(new String[] {id, firstName, lastName, gender, salary + "", age + ""});
			}
				
			else
				JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại!");
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số!");
			System.out.println(e.getMessage());
		}
	}
	
	public void thucHienChucNangXoaTrang() {
		jtxMaNhanVien.setText("");
		jtxHo.setText("");
		jtxTen.setText("");
		jtxTuoi.setText("");
		jtxTienLuong.setText("");
		jbtNam.setSelected(true);
	}
	
	public void thucHienChucNangXoa() {
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(jbtThem)) {
			thucHienChucNangThem();
		}else if(o.equals(jbtXoaTrang)) {
			thucHienChucNangXoaTrang();
		}else if(o.equals(jbtTim)) {
			thucHienChucNangTim();
		}
		
	}
	
	public static void main(String[] args) {
		new QuanLyNhanVienView();
	}
}
