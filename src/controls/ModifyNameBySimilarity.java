package controls;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;

import views.CheckBoxRenderer;
import views.CheckButtonEditor;
import views.Logo;
import views.ModifyNameView;

/**
 * Run this class as java application
 * @author ACELY
 *
 */
public class ModifyNameBySimilarity {
	
	/*class mylookandfeel extends NimbusLookAndFeel{
		private static final long serialVersionUID = 1L;
		@Override
		protected void initSystemColorDefaults(UIDefaults table) {
			super.initSystemColorDefaults(table);
			table.put("info", new ColorUIResource(255, 255, 225));
		}
		@Override
		protected void initComponentDefaults(UIDefaults table) {
			super.initComponentDefaults(table);
			Border border = BorderFactory.createLineBorder(new Color(255,0,0));
		    table.put("ToolTip.background", new Color(255,0,0));
		}		
	}*/
	private static ModifyNameBySimilarity ins = new ModifyNameBySimilarity();
	public static ModifyNameBySimilarity getIns() {return ins;}
	private ModifyNameBySimilarity() {
		Logo logo = new Logo();
		logo.setAlwaysOnTop(true);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		logo.setLocation((screen.width-logo.getWidth())/2,(screen.height-logo.getHeight())/2);
		logo.setVisible(true);
		JFrame.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		}
		catch ( UnsupportedLookAndFeelException e ) {
			System.out.println ("Look & Feel not supported on this platform.");
		}
		mdfnv = new ModifyNameView();
		mdfnv.setTitle("视频&字幕 文件名智能同步利器V2.2   ---   ACELY.CN,2013");
		mdfnv.help.setToolTipText("<html><center><font size=5 color=#B3004E><b>Syncer v2.2</b></font></center><br>" +
				"1、在上方输入要操作的路径，若为总目录需勾选上“主目录”复选框<br>" +
				"2、选择视频格式<br>" +
				"3、选择同步英文SRT还是中文[CHN]SRT<br>" +
				"4、若为主目录的话直接单击“下一个文件夹”按钮，可按顺序依次解析各个子文件夹中的内容...<br>" +
				"......若不是主目录的话直接单击下方的“全部扫描”按钮<br>" +
				"5、在执行完解析后可以再表格中看到匹配的状态，自动勾选的为程序认定匹配的...<br>" +
				"......确定性很低的程序将不予勾选，需要你自己核实是否匹配，若匹配请手动勾选上<br>" +
				"......注：若因视频文件名较特殊导致匹配不成功，请勾选“反向探测”再试<br>" +
				"6、点击“批量执行修改”按钮，即可将选中的SRT文件名改为与对应的视频同名<br><br>" +
				"<center><img src=\"" +
				getClass().getResource("/views/logo.png") + "\"></center>" +
				"<br><center><b>本工具由ACELY.CN独家制作发布,更多精彩资源请访问www.acely.cn</b></center>" +
				"<br><center><b>Powered by ACELY,2013</b></center>" +
				"<center>All rights reserved.</center>" +
				"<center>联系方式: acely@126.com</center></html>");
		mdfnv.reversecheck.setToolTipText("<html><center>默认不勾选，即为正向检测，正向检测在大多数情况下可用" +
				"<br>勾选即为反向检测，在正向检测无效时，即视频名称较不规则的情况下使用</center></html>");
		mdfnv.reversematch.setToolTipText("<html><center>默认将srt字幕文件名称更改为与视频文件对应名称" +
				"<br>如果视频的文件名较乱，可勾选此项" +
				"<br>勾选后，将视频名文件称更改为对应字幕文件名，整洁规范，推荐使用</center></html>");
		//-----------------------------
		String[] headers = {"视频文件名", "SRT文件名", "匹配"};
		Object[][] content = {{ "此处显示视频文件名", "此处显示SRT文件名",new JCheckBox()}};
		tableModel = new DefaultTableModel(content,headers);
		mdfnv.table.setModel(tableModel);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {}
		mdfnv.setLocation((screen.width-mdfnv.getWidth())/2,(screen.height-mdfnv.getHeight())/2);
		mdfnv.setVisible(true);	
		//-----------------------------
		mdfnv.table.getColumn("视频文件名").setPreferredWidth(345);
		mdfnv.table.getColumn("SRT文件名").setPreferredWidth(345);
		mdfnv.table.getColumn("匹配").setPreferredWidth(50);
		mdfnv.table.getColumn("匹配").setCellEditor(new CheckButtonEditor(new JCheckBox()));
		mdfnv.table.getColumn("匹配").setCellRenderer(new CheckBoxRenderer()); 
		//----------
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		logo.setAlwaysOnTop(false);
		logo.setVisible(false);
	}

	//--------------------------------------------
	static ModifyNameView mdfnv;
	static DefaultTableModel tableModel;
	int lastmatch = 0;
	int match = 0;
	static String matchFactor = "0/0";
	static File videos[][];
	File subdirs[];
	int curr_subdir = 0;
	//--------------------------------------------
	public static void main(String[] args) {
		
	}
	
	
	public void scanAll() {
		//==================================================
		lastmatch = 0;
		match = 0;
		//列出所有指定格式的视频
		videos = listAllSelectedVideoFormat();
		if (videos != null) {
			if (videos.length == 0) {
				mdfnv.status.setText("未找到指定格式的文件");
				return;
			}else {
				//只有在当前文件夹中包含了指定格式的视频时才能执行到这里
				removeAllItemsInTable();
				for (int i = 0; i < videos.length; i++) {
					tableModel.addRow(new Object[]{videos[i][0].getName(), "未匹配到SRT文件", new JCheckBox()});
					mdfnv.table.repaint();
				}
				File srts[] = listAllSRTFiles();
				mdfnv.process.setMaximum(videos.length);
				for (int i = 0; i < videos.length; i++) {
					JCheckBox cb = (JCheckBox) tableModel.getValueAt(i,2);
					boolean matched = false;
					//第一轮检测，容差为1，符合条件的自动勾选
					for (int j = 0; j < srts.length; j++) {
						String vn = videos[i][0].getName();
						String srtn = srts[j].getName();
						if (vn.substring(0, vn.length()-4).equals(srtn.substring(0, srtn.length()-4))) {
							tableModel.setValueAt(srts[j].getName(), i, 1);
							cb.setEnabled(false);
							cb.setText("相同");
							cb.setForeground(new Color(0,200, 40));
							mdfnv.table.repaint();
							matched = true;
							break;
						}
						if (judgeMatch(vn,srtn,1)) {
							System.out.println("!=");
							if (match > lastmatch) {
								tableModel.setValueAt(srts[j].getName(), i, 1);
								videos[i][1] = srts[j];//将srt的文件信息与视频的放在一起
								cb.setSelected(true);
								cb.setText(matchFactor+"匹配");
								cb.setForeground(new Color(0, 123, 180));
								mdfnv.table.repaint();
								matched = true;
							}							
							//break;
						}
					}
					//第二轮检测。容差变为2，符合条件的也不勾选
					if (matched == false) {
						for (int j = 0; j < srts.length; j++) {		
							if (judgeMatch(videos[i][0].getName(),srts[j].getName(),2)) {
								if (match > lastmatch) {
									tableModel.setValueAt(srts[j].getName(), i, 1);
									videos[i][1] = srts[j];//将srt的文件信息与视频的放在一起
									cb.setText(matchFactor+"匹配");
									cb.setForeground(new Color(238, 130, 0));
									mdfnv.table.repaint();
									matched = true;
								}							
								//break;
							}
						}
					}
					//第3轮检测。容差变为4，符合条件的也不勾选
					if (matched == false) {
						for (int j = 0; j < srts.length; j++) {		
							if (judgeMatch(videos[i][0].getName(),srts[j].getName(),4)) {
								if (match > lastmatch) {
									tableModel.setValueAt(srts[j].getName(), i, 1);
									videos[i][1] = srts[j];//将srt的文件信息与视频的放在一起
									cb.setText(matchFactor+"匹配");
									cb.setForeground(Color.red);
									mdfnv.table.repaint();
									matched = true;
								}
								//break;
							}
						}
					}
					//如果还没有匹配的，就视为无对应SRT文件
					if (matched == false) {
						cb.setEnabled(false);
					}
					mdfnv.process.setValue(i+1);
					mdfnv.process.repaint();
				}
			}
		}else {return;}
		//==================================================
		mdfnv.status.setText("就绪");
		mdfnv.dorename.setEnabled(true);
		System.out.println("done!");
	}
	
	public void renameAll() {
		if (mdfnv.dorename.isEnabled() == false) {
			return;
		}
		if (videos == null) {
			mdfnv.status.setText("尚未就绪");
			return;
		}
		int selectedCount = 0;
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			JCheckBox cb = (JCheckBox) tableModel.getValueAt(i,2);
			if (cb.isSelected()) {
				selectedCount ++;
			}
		}
		if (selectedCount == 0) {
			mdfnv.status.setText("未选中任何项");
			return;
		}else {
			mdfnv.process.setValue(0);
			mdfnv.process.setMaximum(selectedCount);
			String format = mdfnv.videoFormat.getSelectedItem().toString().replace("*", "");
			int succeedCounter = 0;
			for (int i = 0; i < tableModel.getRowCount(); i++) {
				JCheckBox cb = (JCheckBox) tableModel.getValueAt(i,2);
				if (cb.isSelected()) {
					if (mdfnv.reversematch.isSelected() == false) {
						//>>>>>>>>>>>>>>>>>>正向匹配>>>>>>>>>>>>>>>>>>>>
						String videoname = videos[i][0].getAbsolutePath().replace(format, "");
						if (mdfnv.engsrt.isSelected()) {//如果在同步英文字幕的时候，将字母的名称改为视频的名称即可
							File renamedSRT = new File(videoname.replace(" [CHN]", "")+".srt");
							File remanevideo = new File(videoname.replace(" [CHN]", "")+format);
							if (videos[i][1].renameTo(renamedSRT) && videos[i][0].renameTo(remanevideo)) {
								succeedCounter++;
							}
						}else if (mdfnv.chnset.isSelected()) {
							//如果在同步中文字幕的时候，将视频最后也添加上[CHN]标记
							File renamedSRT = new File(videoname+" [CHN].srt");
							File remanevideo = new File(videoname+" [CHN]"+format);
							if (videos[i][1].renameTo(renamedSRT) && videos[i][0].renameTo(remanevideo)) {
								succeedCounter++;
							}
						}
					}else{
						//<<<<<<<<<<<<<<<<<<<反向匹配<<<<<<<<<<<<<<<<<<<<<<
						String srtname = videos[i][1].getAbsolutePath().replace(".srt", "");
						if (mdfnv.engsrt.isSelected()) {//如果在同步英文字幕的时候，将字母的名称改为视频的名称即可
							File renamedSRT = new File(srtname.replace(" [CHN]", "")+".srt");
							File remanevideo = new File(srtname.replace(" [CHN]", "")+format);
							if (videos[i][1].renameTo(renamedSRT) && videos[i][0].renameTo(remanevideo)) {
								succeedCounter++;
							}
						}else if (mdfnv.chnset.isSelected()) {
							//如果在同步中文字幕的时候，将视频最后也添加上[CHN]标记
							File renamedSRT = new File(srtname + ".srt");
							File remanevideo = new File(srtname + format);
							if (videos[i][1].renameTo(renamedSRT) && videos[i][0].renameTo(remanevideo)) {
								succeedCounter++;
							}
						}
					}
					//System.out.println(videos[i][1].getAbsolutePath());
					//System.out.println(videoname);
					mdfnv.process.setValue(mdfnv.process.getValue()+1);
					mdfnv.process.repaint();
				}
			}
			mdfnv.dorename.setEnabled(false);
			mdfnv.status.setText("完成！成功"+succeedCounter+" / 失败"+(selectedCount-succeedCounter));
			scanAll();
			mdfnv.dorename.setEnabled(false);
		}
	}
	
	private File[][] listAllSelectedVideoFormat() {
		if (mdfnv.path.getText().replace(" ", "").equals("")) {
			mdfnv.status.setText("请输入视频路径");
			return null;
		}
		File dirpath = new File(mdfnv.path.getText());
		if (dirpath.exists() && dirpath.isDirectory()) {
			
			File videos[] = dirpath.listFiles(new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					String format = mdfnv.videoFormat.getSelectedItem().toString();
					if (pathname.getName().toLowerCase().endsWith(format.replace("*", ""))) {
						return true;}return false;}});
			File videosPlus[][] = new File[videos.length][2];
			for (int i = 0; i < videos.length; i++) {
				videosPlus[i][0] = videos[i];
				System.out.println(videos[i].getName());
			}
			return videosPlus;
		}else {
			mdfnv.status.setText("错误：路径不存在");
		}
		return null;
	}
	
	private File[] listAllSRTFiles() {
		File dirpath = new File(mdfnv.path.getText());
		if (dirpath.exists() && dirpath.isDirectory()) {
			File srts[] = dirpath.listFiles(new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					if (mdfnv.engsrt.isSelected()) {
						if (pathname.getName().toLowerCase().endsWith(".srt") && pathname.getName().contains("[CHN]")==false) {
							return true;}
					}else if (mdfnv.chnset.isSelected()) {
						if (pathname.getName().endsWith("[CHN].srt")) {
							return true;}
					}
					return false;
				}});
			for (int i = 0; i < srts.length; i++) {
				System.out.println("[SRT]"+srts[i].getName());
			}
			return srts;
		}else {
			mdfnv.status.setText("错误：路径不存在");
		}
		return null;
	}

	public boolean judgeMatch(String a,String b,int rc) {
		if (mdfnv.reversecheck.isSelected()) {
			b = a.toLowerCase();
			a = b.toLowerCase();
		}else {
			a = a.toLowerCase();
			b = b.toLowerCase();
		}
		
		a = a.substring(0,a.length()-4);//去除后缀名
		b = b.substring(0,b.length()-4);
		String[] as = a.replace("-", " ").replace("'", " ")
				.replace("_", " ").replace(".", " ").replace(",", "")
				.replace("  ", " ").replace("   ", " ").split(" ");
		int ttkws = as.length;
		int mckws = 0;
		for (int i = ttkws-1; i >=0; i--) {
			if (b.contains(as[i])) {
				mckws ++;
				//System.out.println(as[i]);
			}
		}
		matchFactor = mckws+"/"+ttkws;
		lastmatch = match;
		match = mckws;
		if (mckws >= (ttkws-rc)) {
			return true;
		}
		return false;
	}

	public void setAllCheckboxValueTo(boolean to) {
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			JCheckBox cb = (JCheckBox) tableModel.getValueAt(i,2);
			if (cb.isEnabled()) {
				cb.setSelected(to);
			}		
		}
		mdfnv.table.repaint();
	}

	private void removeAllItemsInTable() {
		int c = tableModel.getRowCount();
		for (int i = 0; i < c; i++) {
			tableModel.removeRow(0);
		}
	}
	
	public void nextDir() {
		if (mdfnv.maindir.isSelected()) {
			mdfnv.maindir.setSelected(false);
			File fatherdir = new File(mdfnv.path.getText());
			if (fatherdir.exists() && fatherdir.isDirectory()) {
				if (fatherdir.listFiles(new FileFilter() {			
					@Override
					public boolean accept(File pathname) {
						if (pathname.isDirectory()) {
							return true;}return false;}}).length == 0) {
					mdfnv.status.setText("此目录下没有文件夹");
					return;
				}
				subdirs = fatherdir.listFiles(new FileFilter() {			
					@Override
					public boolean accept(File pathname) {
						if (pathname.isDirectory()) {
							return true;}return false;}});
				curr_subdir = 0;
			}else {
				mdfnv.status.setText("这不是一个有效地路径");
			}
		}
		if (subdirs != null) {
			mdfnv.path.setText(subdirs[curr_subdir].getAbsolutePath());
			scanAll();
			mdfnv.process.setMaximum(subdirs.length);
			mdfnv.process.setValue(curr_subdir+1);
			curr_subdir++;
			if (curr_subdir >= subdirs.length) {
				curr_subdir = 0;
			}
		}
	}

}
