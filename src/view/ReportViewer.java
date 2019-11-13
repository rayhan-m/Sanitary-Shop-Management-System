package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

public class ReportViewer extends JFrame {

	public ReportViewer(String fileName) {
		this(fileName, null);
	}

	public ReportViewer(String fileName, HashMap parameter) {
		super("Report Viewer");
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/zihad_enterprise", "root", "");

			JasperPrint print = JasperFillManager.fillReport(fileName,
					parameter, con);

			JRViewer viewer = new JRViewer(print);

			Container c = getContentPane();
			c.setLayout(new BorderLayout());
			c.add(viewer);
                        con.close();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (JRException jre) {
			jre.printStackTrace();
		}

		setBounds(80, 10, 1200, 1000);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
