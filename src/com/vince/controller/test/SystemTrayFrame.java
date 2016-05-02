/**
 * 
 */
package com.vince.controller.test;

/**
 * @author 流浪大法师
 * @time 2015-4-28 下午4:00:19
 * @email liuliangsir@gmail.com
 * @descript
 * @warning 注意将字符集设置成UTF-8
 */
import java.awt.FlowLayout; 
import java.awt.Image;
import java.awt.MenuItem; 
import java.awt.PopupMenu; 
import java.awt.SystemTray; 
import java.awt.Toolkit;
import java.awt.TrayIcon; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
import java.net.URL; 
   
import javax.swing.ImageIcon; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.SwingUtilities; 
import javax.swing.UIManager; 
/**
 * Java托盘菜单
 * @author 小叶
 * @since 2011-08-29 23:36
 *
 */ 
public class SystemTrayFrame extends JFrame { 
    /**系统托盘*/ 
    private SystemTray systemTray; 
       
    /**托盘图标*/ 
    private TrayIcon trayIcon; 
   
    public SystemTrayFrame() throws Exception { 
        setTitle("托盘菜单"); 
        setLayout(new FlowLayout(FlowLayout.CENTER)); 
        add(new JButton("托盘菜单")); 
        setSize(180, 100); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        addWindowListener(new WindowAdapter() { 
            @Override 
            public void windowClosing(WindowEvent e) { 
                setVisible(false); 
            } 
        }); 
   
        if (SystemTray.isSupported()) { //当前平台是否支持系统托盘 
            //创建一个右键弹出菜单 
            PopupMenu popupMenu = new PopupMenu(); 
            String openMainPanel =new String("显示主程序");
            MenuItem mi = new MenuItem(openMainPanel); 
            MenuItem exit = new MenuItem("退出"); 
            popupMenu.add(mi); 
            popupMenu.add(exit); 
            mi.addActionListener(new ActionListener() { 
                @Override 
                public void actionPerformed(ActionEvent e) { 
                    setVisible(true); 
                } 
   
            }); 
            exit.addActionListener(new ActionListener() { 
                @Override 
                public void actionPerformed(ActionEvent e) { 
                    System.exit(0); 
                } 
            }); 
            ClassLoader cl = this.getClass().getClassLoader(); 
            URL url = cl.getResource("./images/QQ_3D-16-WHITE.png"); 
            //ImageIcon icon = Toolkit.getDefaultToolkit().getImage(url);//new ImageIcon(url); 
            //创建托盘图标 
            trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().getImage(url).getScaledInstance(16, 16, Image.SCALE_SMOOTH), "Java托盘菜单", popupMenu);
            //trayIcon.setImageAutoSize(true);
            //获取托盘菜单 
            systemTray = SystemTray.getSystemTray(); 
            //添加托盘图标 
            systemTray.add(trayIcon); 
        } 
    } 
    public static void main(String[] args) throws Exception {
		new SystemTrayFrame();
	}
}