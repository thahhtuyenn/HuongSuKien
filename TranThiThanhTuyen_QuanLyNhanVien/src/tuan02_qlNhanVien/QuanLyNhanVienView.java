package tuan02_qlNhanVien;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

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

public class QuanLyNhanVienView extends JFrame implements ActionListener, MouseListener{
	private ListEmployee listEmployeeModel;
	private JLabel jlbTitle, jlbMaNhanVien,jlbHo,jlbTen,jlbTuoi,jlbPhai,jlbTienLuong,jlbNhapMa;
	private JTextField jtxMaNhanVien,jtxHo,jtxTen,jtxTuoi,jtxTienLuong,jtxNhapMa;
	private JRadioButton jbtNu,jbtNam;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton jbtTim,jbtThem,jbtXoaTrang,jbtXoa,jbtLuu, jbtSua;
	private JPanel jpnNorth;
	private JPanel jpnCenter;
	private Database database;

	public QuanLyNhanVienView() {
		this.setTitle("^-^");
		this.setSize(700, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		createGUI();
		this.setVisible(true);
		loadData();
	}

	private void createGUI() {
		database = new Database();
		Font font = new Font("Arial", Font.BOLD, 12);

		// ------------------------ JPanel north ---------------------------
		jpnNorth = new JPanel();
		jlbTitle = new JLabel("TH??NG TIN NH??N VI??N");
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
		
		jlbMaNhanVien = new JLabel("M?? nh??n vi??n: ");
		jlbHo = new JLabel("H???: ");
		jlbTen = new JLabel("T??n nh??n vi??n: ");
		jlbTuoi = new JLabel("Tu???i: ");
		jlbPhai = new JLabel("Ph??i: ");
		jlbTienLuong = new JLabel("Ti???n l????ng: ");
		
		jtxMaNhanVien = new JTextField();
		jtxHo = new JTextField();
		jtxTen = new JTextField();
		jtxTuoi = new JTextField();
		jtxTienLuong = new JTextField();
		

		// ---------- M?? nh??n vi??n ------------
		b1.add(jlbMaNhanVien);
		b1.add(jtxMaNhanVien);

		// ---------- H??? t??n ------------
		b2.add(jlbHo);
		b2.add(jtxHo);
		b2.add(jlbTen);
		b2.add(jtxTen);
		jlbHo.setPreferredSize(jlbMaNhanVien.getPreferredSize());

		// ------------ Tu???i v?? ph??i: Nam or N??? ------------
		b3.add(jlbTuoi);
		b3.add(jtxTuoi);
		jbtNam = new JRadioButton("Nam");
		jbtNu = new JRadioButton("N???");
		ButtonGroup gr = new ButtonGroup();
		gr.add(jbtNam);
		gr.add(jbtNu);
		b3.add(jlbPhai);
		jlbTuoi.setPreferredSize(jlbMaNhanVien.getPreferredSize());
		b3.add(jbtNam);
		b3.add(jbtNu);
		jbtNam.setSelected(true);

		// ---------------- Ti???n l????ng ------------------
		b4.add(jlbTienLuong);
		jlbTienLuong.setPreferredSize(jlbMaNhanVien.getPreferredSize());
		b4.add(jtxTienLuong);

		
		// Setup Model v??o Table -> x??? l?? model th?? table thay ?????i
		taoBang();
		
		
		//------------------------ JPanel south ---------------------------
		JSplitPane split;
		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		split.setResizeWeight(0.5);
		
		JPanel jpnLeft = new JPanel();
		jpnLeft.setPreferredSize(new Dimension(350, 40));
		jpnLeft.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		jlbNhapMa = new JLabel("Nh???p m?? s??? c???n t??m: ");
		jlbNhapMa.setPreferredSize(new Dimension(132, 30));
		jlbNhapMa.setFont(font);
		jtxNhapMa = new JTextField(10);
		jbtTim = new JButton("T??m");
		jbtTim.setMargin(new Insets(0, 10, 0, 10));
		jpnLeft.add(jlbNhapMa);
		jpnLeft.add(jtxNhapMa);
		jpnLeft.add(jbtTim);
		split.add(jpnLeft);
		
		JPanel jpnRight = new JPanel();
		jpnRight.setPreferredSize(new Dimension(300, 40));
		jpnRight.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		jbtThem = new JButton("Th??m");
		jbtThem.setMargin(new Insets(0, 10, 0, 10));
		jbtXoaTrang = new JButton("X??a tr???ng");
		jbtXoaTrang.setMargin(new Insets(0, 10, 0, 10));
		jbtXoa = new JButton("X??a");
		jbtXoa.setMargin(new Insets(0, 10, 0, 10));
		jbtLuu = new JButton("L??u");
		jbtLuu.setMargin(new Insets(0, 10, 0, 10));
		jbtSua = new JButton("S???a");
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
		table.addMouseListener(this);
		jbtXoa.addActionListener(this);
		jbtSua.addActionListener(this);
	}
	
	public void taoBang() {
		JPanel jpnTable = new JPanel();
		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		tableModel.addColumn("M?? NV");
		tableModel.addColumn("H???");
		tableModel.addColumn("T??n");
		tableModel.addColumn("Ph??i");
		tableModel.addColumn("Tu???i");
		tableModel.addColumn("Ti???n l????ng");
		TableColumn phaiColumn = table.getColumnModel().getColumn(3);
		tableModel.setRowCount(0);
		JComboBox comboBox = new  JComboBox();
		comboBox.addItem("Nam");
		comboBox.addItem("N???");
		phaiColumn.setCellEditor(new DefaultCellEditor(comboBox));
		TableColumn column = new TableColumn();
		column.setPreferredWidth(100);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(center);
		table.getColumnModel().getColumn(3).setCellRenderer(center);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		
		JScrollPane sp = new JScrollPane(table);
		sp.setPreferredSize(new Dimension(650, 300));
		jpnCenter.add(sp);
	}
	
	private void nhanVien() {
		DecimalFormat df = new DecimalFormat("#,###");
		
		listEmployeeModel.addEmployee(new Employee("NV001", "L?? ????n", "Ch???ng", false, 12000000, 20));
		listEmployeeModel.addEmployee(new Employee("NV002", "Tr???n Th??? Thanh", "Tuy???n", true, 11000000, 20));
		listEmployeeModel.addEmployee(new Employee("NV003", "Tr???n Trung", "Hi???u", false, 9500000, 25));
		listEmployeeModel.addEmployee(new Employee("NV004", "V?? Th??nh", "Nh???", false, 900000, 22));
		listEmployeeModel.addEmployee(new Employee("NV005", "L?? Tr???n Tr??m", "Anh", true, 10000000, 18));
		
		for (Employee e : listEmployeeModel.getDs()) {
			String gender = "";
			if(e.isGender() == false)
				gender = "Nam";
			else
				gender = "N???";
			tableModel.addRow(new String[] {e.getId(), e.getFirstName(), e.getLastName(), gender, e.getAge() + "", df.format(e.getSalary())});
			try {
				database.saveFile("NhanVien.dat", listEmployeeModel);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	public void loadData(){
		listEmployeeModel = null;
		try {
			listEmployeeModel = (ListEmployee)database.readFile("NhanVien.dat");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(listEmployeeModel == null) {
			listEmployeeModel = new ListEmployee();
		}else {
			for (Employee epl : listEmployeeModel.getDs()) {
				String gt = "";
				if(epl.isGender() == false)
					gt = "Nam";
				else
					gt = "N???";
				DecimalFormat df = new DecimalFormat("#,###");
				tableModel.addRow(new String[] {epl.getId(), epl.getFirstName(), epl.getLastName(), gt, epl.getAge() + "", df.format(epl.getSalary())});
			}
		}
	}

	public void thucHienChucNangTim() {
		String id = jtxNhapMa.getText().trim();
		int vitri = listEmployeeModel.search(id);
		System.out.println(vitri);
		if(vitri < 0) {
			JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y nh??n vi??n c?? m?? " + id + "!");
		}else {
			table.setRowSelectionInterval(vitri, vitri);
			Employee e = listEmployeeModel.getEmployeeByIndex(vitri);
			jtxMaNhanVien.setText(e.getId());
			jtxHo.setText(e.getFirstName());
			jtxTen.setText(e.getLastName());
			jtxTuoi.setText(e.getAge() + "");
			if(e.isGender() == false)
				jbtNam.setSelected(true);
			else
				jbtNu.setSelected(true);
			DecimalFormat df = new DecimalFormat("###");
			jtxTienLuong.setText(df.format(e.getSalary()));
		}
	}
	
	public void thucHienChucNangThem() {
		DecimalFormat df = new DecimalFormat("#,###");
		try {
			String id = jtxMaNhanVien.getText().trim();
			if(id == "") {
				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p m?? nh??n vi??n!");
				return;
			}
			String firstName = jtxHo.getText().trim();
			if(firstName == "") {
				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p h??? nh??n vi??n!");
				return;
			}
			String lastName = jtxTen.getText().trim();
			if(lastName == "") {
				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p t??n nh??n vi??n!");
				return;
			}
			if(jtxTuoi.getText().trim() == "") {
				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p tu???i nh??n vi??n!");
				return;
			}
			int age = Integer.parseInt(jtxTuoi.getText().trim());
			if(jtxTienLuong.getText().trim() == "") {
				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p l????ng nh??n vi??n!");
				return;
			}
			double salary = Double.parseDouble(jtxTienLuong.getText().trim());
			
			String genderRow = "";
			boolean gender = false;
			if(jbtNam.isSelected()) {
				gender = false;
				genderRow = "Nam";
			}else {
				gender = true;
				genderRow = "N???";
			}
			
			
			
			Employee newEmployee = new Employee(id, firstName, lastName, gender, salary, age);
			if(listEmployeeModel.addEmployee(newEmployee)) {
				tableModel.addRow(new String[] {id, firstName, lastName, genderRow,  age + "",df.format(salary)});
				database.saveFile("NhanVien.dat", listEmployeeModel);
			}
				
			else
				JOptionPane.showMessageDialog(this, "M?? nh??n vi??n ???? t???n t???i!");
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Vui l??ng nh???p s???!");
			System.out.println(e.getMessage());
		}
	}
	
	public void thucHienChucNangSua() {
		String id = jtxMaNhanVien.getText().trim();
		String firstName = jtxHo.getText().trim();
		String lastName = jtxTen.getText().trim();
		String age = jtxTuoi.getText().trim();
		String salary = jtxTienLuong.getText().trim();
		int row = table.getSelectedRow();
		boolean gtinh = false;
		if(jbtNam.isSelected())
			gtinh = false;
		else if(jbtNu.isSelected())
			gtinh = true;
		
		if(row >= 0) {
			String idOld = (String) table.getValueAt(row, 0);
			if(idOld.equals(id)) {
				Employee e = new Employee(idOld, firstName, lastName, gtinh, Double.parseDouble(salary), Integer.parseInt(age));
				listEmployeeModel.update(idOld, firstName, lastName, gtinh, Double.parseDouble(salary), Integer.parseInt(age));
				String gender = "";
				if(gtinh == false) {
					gender = "Nam";
				}else if(gtinh == true)
					gender = "N???";
				tableModel.setValueAt(e.getFirstName(), row, 1);
				tableModel.setValueAt(e.getLastName(), row, 2);
				tableModel.setValueAt(e.getAge(), row, 4);
				tableModel.setValueAt(gender, row, 3);
				DecimalFormat df = new DecimalFormat("#,###");
				tableModel.setValueAt(df.format(e.getSalary()), row, 5);
				JOptionPane.showMessageDialog(this, "C???p nh???t th??ng tin th??nh c??ng!");
			}else {
				JOptionPane.showMessageDialog(this, "Kh??ng th??? c???p nh???t m?? nh??n vi??n!");
			}
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
		int row  = table.getSelectedRow();
		Employee epl = listEmployeeModel.getEmployeeByIndex(row);
		
		if(row >= 0) {
			int op = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n x??a nh??n vi??n c?? m?? " + epl.getId() + " kh??ng?", "Delete Employee", JOptionPane.YES_NO_OPTION);
			if(op == JOptionPane.YES_OPTION) {
				tableModel.removeRow(row);
				listEmployeeModel.removeEmployee(epl);
				thucHienChucNangXoaTrang();
				try {
					database.saveFile("NhanVien.dat", listEmployeeModel);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			JOptionPane.showMessageDialog(this, "B???n ch??a ch???n d??ng c???n x??a!");
		}
		
	}
	
	public void thucHienChucNangLuu() {
		try {
			database.saveFile("NhanVien.dat", listEmployeeModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		}else if(o.equals(jbtXoa)) {
			thucHienChucNangXoa();
		}else if(o.equals(jbtSua)) {
			thucHienChucNangSua();
		}else if(o.equals(jbtLuu)) {
			thucHienChucNangLuu();
		}
		
	}
	
	public static void main(String[] args) {
		new QuanLyNhanVienView();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		DecimalFormat df = new DecimalFormat("###");
		int row = table.getSelectedRow();
		
		Employee epl = listEmployeeModel.getEmployeeByIndex(row);
		
		if(epl == null)
			JOptionPane.showMessageDialog(this, "B???n ch??a ch???n nh??n vi??n n??o!");
		else {
			jtxMaNhanVien.setText(epl.getId());
			jtxHo.setText(epl.getFirstName());
			jtxTen.setText(epl.getLastName());
			jtxTuoi.setText(epl.getAge() + "");
			jtxTienLuong.setText(df.format(epl.getSalary()));
			if(epl.isGender() == false)
				jbtNam.setSelected(true);
			else
				jbtNu.setSelected(true);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
