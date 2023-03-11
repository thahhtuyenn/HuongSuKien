package quanLySach;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

import javax.lang.model.element.Element;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class QuanLySachView extends JFrame implements ActionListener, MouseListener {
	private JLabel jlbMaSach, jlbTuaSach, jlbTacGia, jlbNamXB, jlbNhaSX, jlbSoTrang, jlbDonGia, jlbISBN, jlbTimSach;
	private JTextField jtxMaSach, jtxTuaSach, jtxTacGia, jtxNamXB, jtxNhaSX, jtxSoTrang, jtxDonGia, jtxISBN;
	private JButton jbtThem, jbtXoaRong, jbtSua, jbtXoa;
	private DefaultTableModel tableModel;
	private JTable table;
	private JComboBox<String> jcbBox;
	private DefaultComboBoxModel<String> jcbBoxModel;
	private QuanLySachModel listModel;
	private Database database;

	public QuanLySachView() {
		this.setTitle("Quản lý sách");
		this.setSize(900, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		createGUI();
		this.setVisible(true);
		loadData();
	}

	public void createGUI() {
		this.setLayout(new BorderLayout());
		database = new Database();

		// Recorts Editor
		JPanel jpnBox = new JPanel();
		jpnBox.setLayout(new BoxLayout(jpnBox, BoxLayout.Y_AXIS));
		jpnBox.setBorder(BorderFactory.createTitledBorder("Records Editor"));

		Box boxID = Box.createHorizontalBox();
		jlbMaSach = new JLabel("Mã sách: ");
		jtxMaSach = new JTextField();
		boxID.add(jlbMaSach);
		boxID.add(jtxMaSach);
		boxID.add(Box.createHorizontalStrut(530));

		Box boxTitleAndAuthor = Box.createHorizontalBox();
		Box boxTitle = Box.createHorizontalBox();
		jlbTuaSach = new JLabel("Tựa sách: ");
		jtxTuaSach = new JTextField();
		boxTitle.add(jlbTuaSach);
		boxTitle.add(jtxTuaSach);
		Box boxAuthor = Box.createHorizontalBox();
		jlbTacGia = new JLabel("Tác giả: ");
		jtxTacGia = new JTextField();
		boxAuthor.add(jlbTacGia);
		boxAuthor.add(jtxTacGia);
		boxTitleAndAuthor.add(boxTitle);
		boxTitleAndAuthor.add(Box.createHorizontalStrut(40));
		boxTitleAndAuthor.add(boxAuthor);

		Box boxNamXBAndNhaXB = Box.createHorizontalBox();
		Box boxNamXB = Box.createHorizontalBox();
		jlbNamXB = new JLabel("Năm xuất bản: ");
		jtxNamXB = new JTextField();
		boxNamXB.add(jlbNamXB);
		boxNamXB.add(jtxNamXB);
		Box boxNhaXB = Box.createHorizontalBox();
		jlbNhaSX = new JLabel("Nhà xuất bản: ");
		jtxNhaSX = new JTextField();
		boxNhaXB.add(jlbNhaSX);
		boxNhaXB.add(jtxNhaSX);
		boxNamXBAndNhaXB.add(boxNamXB);
		boxNamXBAndNhaXB.add(Box.createHorizontalStrut(40));
		boxNamXBAndNhaXB.add(boxNhaXB);

		Box boxPageAndPrice = Box.createHorizontalBox();
		Box boxPage = Box.createHorizontalBox();
		jlbSoTrang = new JLabel("Số trang: ");
		jtxSoTrang = new JTextField();
		boxPage.add(jlbSoTrang);
		boxPage.add(jtxSoTrang);
		Box boxPrice = Box.createHorizontalBox();
		jlbDonGia = new JLabel("Đơn giá: ");
		jtxDonGia = new JTextField();
		boxPrice.add(jlbDonGia);
		boxPrice.add(jtxDonGia);
		boxPageAndPrice.add(boxPage);
		boxPageAndPrice.add(Box.createHorizontalStrut(40));
		boxPageAndPrice.add(boxPrice);

		Box boxISBN = Box.createHorizontalBox();
		jlbISBN = new JLabel("International Standard Book Number (ISBN): ");
		jtxISBN = new JTextField();
		boxISBN.add(jlbISBN);
		boxISBN.add(jtxISBN);
		boxISBN.add(Box.createHorizontalStrut(460));

		jpnBox.add(Box.createVerticalStrut(15));
		jpnBox.add(boxID);
		jpnBox.add(Box.createVerticalStrut(5));
		jpnBox.add(boxTitleAndAuthor);
		jpnBox.add(Box.createVerticalStrut(5));
		jpnBox.add(boxNamXBAndNhaXB);
		jpnBox.add(Box.createVerticalStrut(5));
		jpnBox.add(boxPageAndPrice);
		jpnBox.add(Box.createVerticalStrut(5));
		jpnBox.add(boxISBN);
		jpnBox.add(Box.createVerticalStrut(15));

		// Set khach cạchlb
		jlbMaSach.setPreferredSize(jlbNamXB.getPreferredSize());
		jlbTuaSach.setPreferredSize(jlbNamXB.getPreferredSize());
		jlbSoTrang.setPreferredSize(jlbNamXB.getPreferredSize());

		jlbTacGia.setPreferredSize(jlbNhaSX.getPreferredSize());
		jlbDonGia.setPreferredSize(jlbNhaSX.getPreferredSize());

		// Button
		JPanel jpnButtonAndComboBox = new JPanel();

		JPanel jpnButton = new JPanel();
		jpnButton.setLayout(new BoxLayout(jpnButton, BoxLayout.X_AXIS));

		jbtThem = new JButton("Thêm");
		jbtXoaRong = new JButton("Xóa rỗng");
		jbtSua = new JButton("Sửa");
		jbtXoa = new JButton("Xóa");
		jpnButton.add(jbtThem);
		jpnButton.add(Box.createHorizontalStrut(5));
		jpnButton.add(jbtXoaRong);
		jpnButton.add(Box.createHorizontalStrut(5));
		jpnButton.add(jbtSua);
		jpnButton.add(Box.createHorizontalStrut(5));
		jpnButton.add(jbtXoa);

		JPanel jpnComboBox = new JPanel();
		jcbBoxModel = new DefaultComboBoxModel<String>();
//		jcbBoxModel.addElement("A001");
//		jcbBoxModel.addElement("J002");
//		jcbBoxModel.addElement("H003");
		jcbBox = new JComboBox<String>(jcbBoxModel);
		jlbTimSach = new JLabel("Tìm theo mã sách: ");
		jpnComboBox.add(jlbTimSach);
		jpnComboBox.add(jcbBox);

		jpnButtonAndComboBox.add(Box.createVerticalStrut(5));
		jpnButtonAndComboBox.add(jpnButton);
		jpnButtonAndComboBox.add(Box.createHorizontalStrut(40));
		jpnButtonAndComboBox.add(jpnComboBox);
		jpnButtonAndComboBox.add(Box.createVerticalStrut(5));

		// Table
		JPanel jpnTable = new JPanel();
		jpnTable.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã sách");
		tableModel.addColumn("Tựa sách");
		tableModel.addColumn("Tác giả");
		tableModel.addColumn("Năm xuất bản");
		tableModel.addColumn("Nhà sản xuất");
		tableModel.addColumn("Số trang");
		tableModel.addColumn("Đơn giá");
		tableModel.addColumn("ISBN");

		table = new JTable(tableModel);
		DefaultTableCellRenderer right = new DefaultTableCellRenderer();
		right.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);

		table.getColumnModel().getColumn(3).setCellRenderer(right);
		table.getColumnModel().getColumn(5).setCellRenderer(right);
		table.getColumnModel().getColumn(6).setCellRenderer(right);

		JScrollPane sp = new JScrollPane(table);
		sp.setPreferredSize(new Dimension(880, 220));
		jpnTable.add(sp);

		this.add(jpnBox, BorderLayout.NORTH);
		this.add(jpnButtonAndComboBox, BorderLayout.CENTER);
		this.add(jpnTable, BorderLayout.SOUTH);
		
		table.addMouseListener(this);
		jbtThem.addActionListener(this);
		jbtXoaRong.addActionListener(this);
		jbtSua.addActionListener(this);
		jbtXoa.addActionListener(this);
	}
	
	
	
	public void loadData() {
		listModel = null;
		try {
			listModel = (QuanLySachModel) database.readFile("Sach.dat");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(listModel == null) {
			listModel = new QuanLySachModel();
		}else {
			for (Sach s : listModel.getListBook()) {
				DecimalFormat df = new DecimalFormat("#,###");
				tableModel.addRow(new String[] {s.getId(), s.getTitle(), s.getAuthor(), s.getYear() + "", s.getPublishing(), s.getPage()+"", df.format(s.getPrice()), s.getIsbn()});
			}
			addElement();
		}
	}

	public void thucHienChucNangThem() {
		try {
			String id = jtxMaSach.getText().trim();
			if (id == "") {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sách!");
				return;
			}

			String title = jtxTuaSach.getText().trim();
			if (title == "") {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tựa sách!");
				return;
			}

			String author = jtxTacGia.getText().trim();
			if (author == "") {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tác giả!");
				return;
			}

			int year = Integer.parseInt(jtxNamXB.getText().trim());

			String publishing = jtxNhaSX.getText().trim();
			if (publishing == "") {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập nhà sản xuất!");
				return;
			}

			int page = Integer.parseInt(jtxSoTrang.getText().trim());

			double price = Double.parseDouble(jtxDonGia.getText().trim());

			String isbn = jtxISBN.getText().trim();
			if (isbn == "") {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập International Standard Book Number!");
				return;
			}
			
			Sach s = new Sach(id, title, author, year, publishing, page, price, isbn);
			if(listModel.addBook(s)) {
				DecimalFormat df = new DecimalFormat("#,###");
				tableModel.addRow(new String [] {id, title, author, year + "", publishing, page + "", df.format(price), isbn});
				addElement();
				database.saveFile("Sach.dat", listModel);
			}else
				JOptionPane.showMessageDialog(this, "Mã sách đã tồn tại!");
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số!");
		}
	}
	
	private void addElement() {
		jcbBoxModel.removeAllElements();
		
		for (Sach s : listModel.getListBook()) {
			jcbBoxModel.addElement(s.getId());
		}
	}
	
	public void thucHienChucNangXoaRong() {
		jtxMaSach.setText("");
		jtxTuaSach.setText("");
		jtxTacGia.setText("");
		jtxNamXB.setText("");
		jtxNhaSX.setText("");
		jtxSoTrang.setText("");
		jtxDonGia.setText("");
		jtxISBN.setText("");
	}
	
	public void thucHienChucNangSua() {
		int row = table.getSelectedRow();
		String id = jtxMaSach.getText().trim(), title = jtxTuaSach.getText().trim(), author = jtxTacGia.getText().trim(), publishing = jtxNhaSX.getText().trim(), isbn = jtxISBN.getText().trim();
		int year = Integer.parseInt(jtxNamXB.getText().trim()), page = Integer.parseInt(jtxSoTrang.getText().trim());
		double price = Double.parseDouble(jtxDonGia.getText().trim());
		
		if(row >= 0) {
			String idOld = (String) table.getValueAt(row, 0);
			if(id.equalsIgnoreCase(idOld)) {
				Sach s = new Sach(idOld, title, author, year, publishing, page, price, isbn);
				listModel.updateBook(idOld, title, author, year, publishing, page, price, isbn);
				DecimalFormat df = new DecimalFormat("#,###");
				tableModel.setValueAt(s.getTitle(), row, 1);
				tableModel.setValueAt(s.getAuthor(), row, 2);
				tableModel.setValueAt(s.getYear(), row, 3);
				tableModel.setValueAt(s.getPublishing(), row, 4);
				tableModel.setValueAt(s.getPage(), row, 5);
				tableModel.setValueAt(df.format(s.getPrice()), row, 6);
				tableModel.setValueAt(s.getIsbn(), row, 7);
				JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công!");
				try {
					database.saveFile("Sach.dat", listModel);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(this, "Không thể cập nhật mã sách!");
			}
		}
	}
	
	public void thucHienChucNangXoa() {
		int row = table.getSelectedRow();
		Sach s = listModel.searchBookByIndex(row);
		if(row >= 0) {
			int jop = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa sách có mã "+ s.getId() + " khong?", "Remove book", JOptionPane.YES_NO_OPTION);
			if(jop == JOptionPane.YES_OPTION) {
				listModel.removeBook(s);
				tableModel.removeRow(row);
				try {
					database.saveFile("Sach.dat", listModel);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng cần xóa!");
		
		
	}

	public static void main(String[] args) {
		new QuanLySachView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(jbtThem))
			thucHienChucNangThem();
		else if(o.equals(jbtXoaRong))
			thucHienChucNangXoaRong();
		else if(o.equals(jbtSua))
			thucHienChucNangSua();
		else if(o.equals(jbtXoa))
			thucHienChucNangXoa();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		Sach s = listModel.searchBookByIndex(row);
		if(row < 0)
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn sách nào!");
		else {
			jtxMaSach.setText(s.getId());
			jtxTuaSach.setText(s.getTitle());
			jtxTacGia.setText(s.getAuthor());
			jtxNamXB.setText(s.getYear()+ "");
			jtxNhaSX.setText(s.getPublishing());
			jtxSoTrang.setText(s.getPage()+"");
			jtxDonGia.setText(s.getPrice() +"");
			jtxISBN.setText(s.getIsbn());
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
