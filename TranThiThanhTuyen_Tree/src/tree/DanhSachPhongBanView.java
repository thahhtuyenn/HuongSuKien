package tree;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class DanhSachPhongBanView extends JFrame implements TreeSelectionListener{
	private DefaultMutableTreeNode root;
	private JTree tree;
	private DanhSachPhongBan ds;
	
	public DanhSachPhongBanView() {
		loadData();
		this.setTitle("Danh sách phòng ban");
		this.setSize(700, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		root = new DefaultMutableTreeNode("Danh sách phòng ban");
		for (PhongBan item : ds.getListPhongBan()) {
			DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(item);
			root.add(node1);
		}
		
		tree = new JTree(root);
		tree.addTreeSelectionListener(this);
		
		JScrollPane cr  = new JScrollPane(tree);
		this.add(cr, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new DanhSachPhongBanView();
	}
 


	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode selectNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		PhongBan pb = (PhongBan) selectNode.getUserObject();
		new PhongBanView(pb.getTenPhong(), pb);
		
	}
	
	private void loadData() {
		PhongBan p1 = new PhongBan("PTC", "Phòng Tài Chính");
		p1.addEmployee(new Employee("NV01", "Trần Thị Thanh", "Tuyền", true, 3000, 20));
		p1.addEmployee(new Employee("NV02", "Trần Thị Thanh", "Tuyền", true, 3000, 20));
		p1.addEmployee(new Employee("NV03", "Trần Thị Thanh", "Tuyền", true, 3000, 20));
		
		PhongBan p2 = new PhongBan("PTC", "Phòng Nhân Sự");
		p2.addEmployee(new Employee("NV06", "Trần Thị Thanh", "Tuyền", true, 3000, 20));
		p2.addEmployee(new Employee("NV04", "Trần Thị Thanh", "Tuyền", true, 3000, 20));
		p2.addEmployee(new Employee("NV05", "Trần Thị Thanh", "Tuyền", true, 3000, 20));
		
		ds = new DanhSachPhongBan();
		ds.addPhongBan(p1);
		ds.addPhongBan(p2);
	}
}
