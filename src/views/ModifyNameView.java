/*
 * ModifyNameView.java
 *
 * Created on __DATE__, __TIME__
 */

package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Point;
import java.net.URI;

import javax.swing.ToolTipManager;

import controls.ModifyNameBySimilarity;

/**
 *
 * @author  __USER__
 */
public class ModifyNameView extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Point msx = new Point();

	/** Creates new form ModifyNameView */
	public ModifyNameView() {
		initComponents();
		jLabel4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		jLabel1 = new javax.swing.JLabel();
		path = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		videoFormat = new javax.swing.JComboBox<String>();
		jLabel3 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();
		dorename = new javax.swing.JButton();
		selectall = new javax.swing.JButton();
		unselectall = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		jButton4 = new javax.swing.JButton();
		process = new javax.swing.JProgressBar();
		status = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		maindir = new javax.swing.JCheckBox();
		chnset = new javax.swing.JRadioButton();
		engsrt = new javax.swing.JRadioButton();
		close = new javax.swing.JLabel();
		max = new javax.swing.JLabel();
		min = new javax.swing.JLabel();
		help = new javax.swing.JLabel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void setToolTipText(String text) {
				String oldText = getToolTipText();
				putClientProperty(TOOL_TIP_TEXT_KEY, text);
				ToolTipManager toolTipManager = ToolTipManager.sharedInstance();
				toolTipManager.setInitialDelay(10);
				toolTipManager.setDismissDelay(50000);
				if (text != null) {
					if (oldText == null) {
						toolTipManager.registerComponent(this);
					}
				} else {
					toolTipManager.unregisterComponent(this);
				}

			}
		};
		reversecheck = new javax.swing.JCheckBox();
		reversematch = new javax.swing.JCheckBox();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(102, 102, 102));
		setMinimumSize(new java.awt.Dimension(765, 500));
		setUndecorated(true);
		addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				formMousePressed(evt);
			}
		});
		addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent evt) {
				formMouseDragged(evt);
			}
		});

		jLabel1.setText("\u8981\u89e3\u6790\u7684\u8def\u5f84\uff1a");

		path.setText("Y:\\FilenameMatchTest");
		path.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				pathMouseClicked(evt);
			}
		});

		jLabel2.setText("\u89c6\u9891\u6587\u4ef6\u683c\u5f0f\uff1a");

		videoFormat.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] {
				"*.mov", "*.mp4", "*.flv", "*.f4v", "*.avi", "*.wmv" }));

		jLabel3.setFont(new java.awt.Font("微软雅黑", 1, 12));
		jLabel3.setForeground(new java.awt.Color(0, 0, 51));
		jLabel3.setText("\u76ee\u6807\u5b57\u5e55\u7c7b\u578b\uff1a");

		table.setBackground(new java.awt.Color(204, 255, 204));
		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null } },
				new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		table.setRequestFocusEnabled(false);
		table.setRowHeight(20);
		table.setSelectionBackground(new java.awt.Color(51, 51, 51));
		table.setSelectionForeground(new java.awt.Color(255, 153, 0));
		jScrollPane1.setViewportView(table);

		dorename.setText("\u6279\u91cf\u6267\u884c\u4fee\u6539");
		dorename.setToolTipText("\u5fc5\u987b\u5148\u6267\u884c\u5168\u90e8\u626b\u63cf\u540e\u624d\u80fd\u6279\u91cf\u4fee\u6539");
		dorename.setEnabled(false);
		dorename.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				dorenameMouseClicked(evt);
			}
		});

		selectall.setText("\u5168\u9009");
		selectall.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				selectallMouseClicked(evt);
			}
		});

		unselectall.setText("\u53d6\u6d88\u5168\u9009");
		unselectall.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				unselectallMouseClicked(evt);
			}
		});

		jLabel4.setFont(new java.awt.Font("微软雅黑", 1, 14));
		jLabel4.setForeground(new java.awt.Color(204, 0, 51));
		jLabel4.setText("ACELY.CN");
		jLabel4.setToolTipText("\u8bbf\u95ee\u72ec\u5bb6\u53d1\u5e03\u7ad9\uff1aACELY.CN");
		jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel4MouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabel4MouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				jLabel4MouseExited(evt);
			}
		});

		jButton4.setText("\u5168\u90e8\u626b\u63cf");
		jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton4MouseClicked(evt);
			}
		});

		status.setText("\u6b22\u8fce\u4f7f\u7528");

		jButton1.setText("\u4e0b\u4e00\u4e2a\u6587\u4ef6\u5939");
		jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton1MouseClicked(evt);
			}
		});

		maindir.setText("\u4e3b\u76ee\u5f55");

		buttonGroup1.add(chnset);
		chnset.setText("\u4e2d\u6587[CHN]SRT");
		chnset.setToolTipText("\u4ee5[CHN]\u7ed3\u5c3e\u7684\u4e2d\u6587\u5b57\u5e55\uff0c\u540c\u6b65\u540e\u4f1a\u5728\u89c6\u9891\u540d\u79f0\u540e\u6dfb\u52a0[CHN]\u4ee5\u4fbf\u533a\u5206");

		buttonGroup1.add(engsrt);
		engsrt.setSelected(true);
		engsrt.setText("\u82f1\u6587SRT");
		engsrt.setToolTipText("\u540c\u6b65\u6807\u51c6\u82f1\u6587SRT\uff0c\u4f1a\u5c06\u89c6\u9891\u540d\u79f0\u4e2d\u7684[CHN]\u5220\u9664");

		close.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/views/x.png"))); // NOI18N
		close.setToolTipText("\u9000\u51fa\u7a0b\u5e8f");
		close.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				closeMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				threebtMouseEnter(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				threebtMouseExit(evt);
			}
		});

		max.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/views/max.png"))); // NOI18N
		max.setToolTipText("\u6700\u5927\u5316\uff08\u6df7\u52a8\u9f20\u6807\u8f6e\u6a2a\u5411\u7f29\u653e\u7a97\u53e3\uff09");
		max.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
			public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
				maxMouseWheelMoved(evt);
			}
		});
		max.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				maxMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				threebtMouseEnter(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				threebtMouseExit(evt);
			}
		});

		min.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/views/min.png"))); // NOI18N
		min.setToolTipText("\u6700\u5c0f\u5316\uff08\u6eda\u52a8\u9f20\u6807\u8f6e\u7eb5\u5411\u7f29\u653e\u7a97\u53e3\uff09");
		min.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
			public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
				minMouseWheelMoved(evt);
			}
		});
		min.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				minMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				threebtMouseEnter(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				threebtMouseExit(evt);
			}
		});

		help.setFont(new java.awt.Font("微软雅黑", 1, 12));
		help.setForeground(new java.awt.Color(153, 153, 153));
		help.setText(" HELP\uff1f");
		help.setToolTipText("");
		help.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				helpMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				helpMouseExited(evt);
			}
		});

		reversecheck.setText("\u53cd\u5411\u68c0\u6d4b");

		reversematch.setText("\u53cd\u5411\u540c\u6b65");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addComponent(help)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										771, Short.MAX_VALUE)
								.addComponent(min)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(max)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(close))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel4,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		114,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		status,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		384,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		116,
																		Short.MAX_VALUE)
																.addComponent(
																		reversematch))
												.addComponent(
														process,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														705, Short.MAX_VALUE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(
														dorename,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		selectall)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		unselectall)))
								.addContainerGap())
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										857, Short.MAX_VALUE).addContainerGap())
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														javax.swing.GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup()
																.addComponent(
																		jLabel1)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		path,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		569,
																		Short.MAX_VALUE))
												.addGroup(
														javax.swing.GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup()
																.addComponent(
																		jLabel2)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		videoFormat,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		102,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		jLabel3)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		engsrt)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		chnset)))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(maindir)
												.addComponent(reversecheck))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												false)
												.addComponent(
														jButton1,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jButton4,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														115, Short.MAX_VALUE))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
																.addComponent(
																		max,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		close,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
												.addComponent(help)
												.addComponent(min))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(jButton1)
												.addComponent(maindir)
												.addComponent(
														path,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(
														videoFormat,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jButton4,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(reversecheck)
												.addComponent(chnset)
												.addComponent(engsrt)
												.addComponent(jLabel3))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										402, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																				.addComponent(
																						unselectall,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						selectall,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(21, 21,
																		21)
																.addComponent(
																		process,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		10,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(
																		dorename)
																.addComponent(
																		reversematch))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabel4)
																				.addComponent(
																						status))
																.addGap(4, 4, 4)))
								.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void minMouseClicked(java.awt.event.MouseEvent evt) {
		setExtendedState(ICONIFIED);
	}

	private void maxMouseClicked(java.awt.event.MouseEvent evt) {
		setExtendedState(MAXIMIZED_BOTH);
	}

	private void minMouseWheelMoved(java.awt.event.MouseWheelEvent e) {
		int to = e.getWheelRotation();
		Dimension De = getSize();
		if (to == 1) {//down
			setSize(De.width, De.height - 10);
		}
		if (to == -1) {//up
			setSize(De.width, De.height + 10);
		}
	}

	private void maxMouseWheelMoved(java.awt.event.MouseWheelEvent e) {
		int to = e.getWheelRotation();
		Dimension De = getSize();
		Point jframep = getLocation();
		if (to == 1) {//down
			setSize(De.width - 5, De.height);
			setLocation(jframep.x + 5, jframep.y);
		}
		if (to == -1) {//up
			setSize(De.width + 5, De.height);
			setLocation(jframep.x - 5, jframep.y);
		}
	}

	private void formMouseDragged(java.awt.event.MouseEvent e2) {
		Point jframep = getLocation();
		setLocation(jframep.x + e2.getX() - msx.x, jframep.y + e2.getY()
				- msx.y);
	}

	private void formMousePressed(java.awt.event.MouseEvent e) {
		msx.x = e.getX();
		msx.y = e.getY();
	}

	private void closeMouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}

	private void threebtMouseEnter(java.awt.event.MouseEvent evt) {
		close.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/views/x-active.png"))); // NOI18N
		max.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/views/max-active.png"))); // NOI18N
		min.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/views/min-active.png"))); // NOI18N
	}

	private void threebtMouseExit(java.awt.event.MouseEvent evt) {
		close.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/views/x.png"))); // NOI18N
		max.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/views/max.png"))); // NOI18N
		min.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/views/min.png"))); // NOI18N
	}

	private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {
		if (!Desktop.isDesktopSupported()) {
			return;
		}
		//用来打开系统默认浏览器浏览指定的URL
		Desktop desktop = Desktop.getDesktop();
		try {
			//创建URI统一资源标识符
			URI uri = new URI("http://acely.cn");
			//使用默认浏览器打开超链接
			desktop.browse(uri);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {
		jLabel4.setForeground(new java.awt.Color(204, 0, 51));
	}

	private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {
		jLabel4.setForeground(new java.awt.Color(204, 99, 51));
	}

	private void helpMouseExited(java.awt.event.MouseEvent evt) {
		help.setForeground(Color.GRAY);
	}

	private void helpMouseEntered(java.awt.event.MouseEvent evt) {
		help.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		help.setForeground(Color.red);
	}

	private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
		ModifyNameBySimilarity.getIns().nextDir();
	}

	//GEN-END:initComponents

	private void dorenameMouseClicked(java.awt.event.MouseEvent evt) {
		ModifyNameBySimilarity.getIns().renameAll();
	}

	private void pathMouseClicked(java.awt.event.MouseEvent evt) {
		path.setSelectionStart(0);
		path.setSelectionEnd(path.getText().length());
	}

	private void unselectallMouseClicked(java.awt.event.MouseEvent evt) {
		ModifyNameBySimilarity.getIns().setAllCheckboxValueTo(false);
	}

	private void selectallMouseClicked(java.awt.event.MouseEvent evt) {
		ModifyNameBySimilarity.getIns().setAllCheckboxValueTo(true);
	}

	private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {
		ModifyNameBySimilarity.getIns().scanAll();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ModifyNameView().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.ButtonGroup buttonGroup1;
	public javax.swing.JRadioButton chnset;
	private javax.swing.JLabel close;
	public javax.swing.JButton dorename;
	public javax.swing.JRadioButton engsrt;
	public javax.swing.JLabel help;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JScrollPane jScrollPane1;
	public javax.swing.JCheckBox maindir;
	private javax.swing.JLabel max;
	private javax.swing.JLabel min;
	public javax.swing.JTextField path;
	public javax.swing.JProgressBar process;
	public javax.swing.JCheckBox reversecheck;
	public javax.swing.JCheckBox reversematch;
	private javax.swing.JButton selectall;
	public javax.swing.JLabel status;
	public javax.swing.JTable table;
	private javax.swing.JButton unselectall;
	public javax.swing.JComboBox<String> videoFormat;
	// End of variables declaration//GEN-END:variables

}