package tree;

import java.awt.BorderLayout;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class PhongBanView extends JFrame {
	private PhongBan model;
	private DefaultTableModel tableModel;
	private JTable table;

	public PhongBanView(String title, PhongBan pb) {
		this.model = pb;
		this.setTitle(title);
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		createViewTable();

		this.setVisible(true);
	}

	public void createViewTable() {
		this.setLayout(new BorderLayout());
		tableModel = new DefaultTableModel();

		tableModel.addColumn("Mã NV");
		tableModel.addColumn("Họ");
		tableModel.addColumn("Tên");
		tableModel.addColumn("Phái");
		tableModel.addColumn("Tuổi");
		tableModel.addColumn("Tiền lương");
		table = new JTable(tableModel);
		loadDSNhanVien();

		DefaultTableCellRenderer right = new DefaultTableCellRenderer();
		right.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(center);
		table.getColumnModel().getColumn(3).setCellRenderer(center);
		table.getColumnModel().getColumn(4).setCellRenderer(right);
		table.getColumnModel().getColumn(5).setCellRenderer(right);

		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane, BorderLayout.CENTER);
	}

	private void loadDSNhanVien() {
		DecimalFormat df = new DecimalFormat("#,###");
		for (Employee e : model.getListEployee()) {
			tableModel.addRow(new String[] { e.getId(), e.getFirstName(), e.getLastName(), e.isGender() ? "Nam" : "Nữ",
					e.getAge() + "", df.format(e.getSalary()) });
		}
	}

}
