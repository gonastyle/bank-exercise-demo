package com.cx.bank.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.cx.bank.bll.UserManage;
import com.cx.bank.dal.UserService;
import com.cx.bank.model.User;

public class BankTest {

	public static void main(String[] args) {

		new LoginFrame();
	}

}
		/*        
			 * Model-1(表示层与控制层没有分离)
			 * 所有窗体都有一个共享一个UserMange对象
		 */

class LoginFrame extends JFrame implements ActionListener {

	JLabel nameLable = new JLabel("账   号：");
	JTextField nameText = new JTextField(20);

	JLabel pwdLabel = new JLabel("密    码：");
	JPasswordField pwdText = new JPasswordField(20);

	JButton login = new JButton("登陆");
	JButton register = new JButton("注册");

	JPanel centerPane = new JPanel();
	JPanel southPane = new JPanel();

	UserManage um = UserManage.getInstance();

	public LoginFrame() {

		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());

		c.add(centerPane, "Center");
		c.add(southPane, "South");

		centerPane.add(nameLable);
		centerPane.add(nameText);
		centerPane.add(pwdLabel);
		centerPane.add(pwdText);
		southPane.add(login);
		southPane.add(register);

		login.addActionListener(this);
		register.addActionListener(this);

		this.setTitle("银行管理系统Swing版本");
		this.setSize(320, 150);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {

		User user = new User();
		user.setId(this.nameText.getText());
		user.setPwd(this.pwdText.getText());

		System.out.println(user.getId() + user.getName() + user.getPwd()
				+ user.getMoney());

		if (e.getSource() == login) {

			if (um.login(user.getId(), user.getPwd())) {

				new UserInfoFrame();
				this.dispose();
			} else {

				JOptionPane.showMessageDialog(this, "密码错误或账号不存在", "错误",
						JOptionPane.ERROR_MESSAGE);
			}

		} else if (e.getSource() == register) {

			new RegisterFrame();
			this.dispose();
		}

	}

}

class RegisterFrame extends JFrame implements ActionListener {

	JLabel nameLable = new JLabel("请输入账号：");
	JTextField nameText = new JTextField(20);

	JLabel pwdLabel = new JLabel("请 输 入 密 码：");
	JPasswordField pwdText = new JPasswordField(20);

	JLabel confirmLabel = new JLabel("确  认  密   码 ：");
	JPasswordField confirmText = new JPasswordField(20);

	JButton post = new JButton("提交");

	JPanel centerPane = new JPanel();
	JPanel southPane = new JPanel();

	UserManage um = UserManage.getInstance();

	public RegisterFrame() {

		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());

		c.add(centerPane, "Center");
		c.add(southPane, "South");

		centerPane.add(nameLable);
		centerPane.add(nameText);
		centerPane.add(pwdLabel);
		centerPane.add(pwdText);
		centerPane.add(confirmLabel);
		centerPane.add(confirmText);

		southPane.add(post);

		post.addActionListener(this);

		this.setTitle("注册界面");
		this.setSize(360, 170);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {

		if (this.pwdText.getText().equals(this.confirmText.getText())) {

			boolean is = this.um.register(this.nameText.getText(),
					this.pwdText.getText());
			if (is) {
				JOptionPane.showMessageDialog(this, "注册成功", "提示",
						JOptionPane.OK_OPTION);
			} else {
				JOptionPane.showMessageDialog(this, "用户已存在或同名", "注册失败",
						JOptionPane.OK_OPTION);
			}

			this.dispose();
			new LoginFrame();

		} else {

			JOptionPane.showMessageDialog(this, "两次的密码输入不一致", "错误",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}

class UserInfoFrame extends JFrame implements ActionListener {

	JLabel nameLable = new JLabel("账号：");
	JLabel nameText = new JLabel("");

	JLabel moneyLabel = new JLabel("余额：");
	static JLabel moneyText = new JLabel();

	JButton transfer = new JButton("转账");
	JButton save = new JButton("存款");
	JButton take = new JButton("取款");
	JButton back = new JButton("返回");

	JPanel NorthPane = new JPanel();
	JPanel centerPane = new JPanel();
	JPanel southPane = new JPanel();

	UserManage um = UserManage.getInstance();

	public UserInfoFrame() {

		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());

		c.add(NorthPane, "North");
		c.add(centerPane, "Center");
		c.add(southPane, "South");

		NorthPane.add(nameLable);
		NorthPane.add(nameText);
		centerPane.add(moneyLabel);
		centerPane.add(moneyText);

		southPane.add(transfer);
		southPane.add(save);
		southPane.add(take);
		southPane.add(back);

		transfer.addActionListener(this);
		save.addActionListener(this);
		take.addActionListener(this);
		back.addActionListener(this);

		this.setTitle("用户信息界面");
		this.setSize(360, 170);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.moneyText.setText(um.getUser().getMoney());
		this.nameText.setText(um.getUser().getId());

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == transfer) {

			new TransferJFrame();

		} else if (e.getSource() == save) {

			new SaveFrame();
		} else if (e.getSource() == take) {

			new TakeFrame();
		}else if (e.getSource() == back) {

			this.dispose();
			new LoginFrame();
		}
	}

}
//转账
class TransferJFrame extends JFrame implements ActionListener {

	JLabel transferLable = new JLabel("转账账户号：");
	JTextField transferText = new JTextField(20);

	JLabel moneyLable = new JLabel("转 账 金 额：");
	JTextField moneyText = new JTextField(20);

	JButton confirm = new JButton("确认");

	JPanel centerPane = new JPanel();
	JPanel southPane = new JPanel();
	UserManage um = UserManage.getInstance();

	public TransferJFrame() {

		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());

		c.add(centerPane, "Center");
		c.add(southPane, "South");

		centerPane.add(transferLable);
		centerPane.add(transferText);
		centerPane.add(moneyLable);
		centerPane.add(moneyText);

		southPane.add(confirm);

		confirm.addActionListener(this);

		this.setTitle("转账界面");
		this.setSize(360, 170);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		boolean flag=true;
		if (this.moneyText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "金额为空", "提示",
					JOptionPane.OK_OPTION);
		} else {
			for(int i=0;i<this.moneyText.getText().length();i++){
				if(!(47<this.moneyText.getText().charAt(i)&&this.moneyText.getText().charAt(i)<58)){
					JOptionPane.showMessageDialog(this, "金额格式错误", "提示",JOptionPane.OK_OPTION);
					flag=false;
					break;
				}
			}
			if(flag&&!um.transferMoney(this.transferText.getText(),this.moneyText.getText())){
				//JOptionPane.showMessageDialog(this, "内部错误", "提示",JOptionPane.OK_OPTION);
			}else{
				if(flag)
				JOptionPane.showMessageDialog(this,"转账成功", "提示",JOptionPane.OK_OPTION);
				
				UserInfoFrame.moneyText.setText(um.getUserService().getUserById(um.getUser().getId()).getMoney());
			}
		}
		

		this.dispose();
	}

}

class SaveFrame extends JFrame implements ActionListener {

	JLabel moneyLable = new JLabel("请输入存款金额：");
	JTextField moneyText = new JTextField(20);

	JButton confirm = new JButton("确认");

	JPanel centerPane = new JPanel();
	JPanel southPane = new JPanel();
	UserManage um = UserManage.getInstance();
	public SaveFrame() {

		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());

		c.add(centerPane, "Center");
		c.add(southPane, "South");

		centerPane.add(moneyLable);
		centerPane.add(moneyText);

		southPane.add(confirm);

		confirm.addActionListener(this);

		this.setTitle("存款界面");
		this.setSize(360, 120);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
         boolean flag=true;
		if (this.moneyText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "金额为空", "提示",
					JOptionPane.OK_OPTION);
		} else {
			for(int i=0;i<this.moneyText.getText().length();i++){
				if(!(47<this.moneyText.getText().charAt(i)&&this.moneyText.getText().charAt(i)<58)){
					JOptionPane.showMessageDialog(this, "金额格式错误", "提示",JOptionPane.OK_OPTION);
					flag=false;
					break;
				}
			}
			
			if(flag&&!um.saveMoney(this.moneyText.getText())){
			//	JOptionPane.showMessageDialog(this, "内部错误", "提示",JOptionPane.OK_OPTION);
			}else{
				if(flag)
				JOptionPane.showMessageDialog(this,"存款成功", "提示",JOptionPane.OK_OPTION);
				
				UserInfoFrame.moneyText.setText(um.getUserService().getUserById(um.getUser().getId()).getMoney());
			}
		}

	    
		this.dispose();

	}
}

class TakeFrame extends JFrame implements ActionListener {

	JLabel moneyLable = new JLabel("请输入取款金额：");
	JTextField moneyText = new JTextField(20);

	JButton confirm = new JButton("确认");

	JPanel centerPane = new JPanel();
	JPanel southPane = new JPanel();
	UserManage um = UserManage.getInstance();
	public TakeFrame() {

		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());

		c.add(centerPane, "Center");
		c.add(southPane, "South");

		centerPane.add(moneyLable);
		centerPane.add(moneyText);

		southPane.add(confirm);

		confirm.addActionListener(this);

		this.setTitle("取款界面");
		this.setSize(360, 120);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {

		 boolean flag=true;
		if (this.moneyText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "金额为空", "提示",
					JOptionPane.OK_OPTION);
		} else {
			for(int i=0;i<this.moneyText.getText().length();i++){
				if(!(47<this.moneyText.getText().charAt(i)&&this.moneyText.getText().charAt(i)<58)){
					JOptionPane.showMessageDialog(this, "金额格式错误", "提示",JOptionPane.OK_OPTION);
					flag=false;
					break;
				}
			}
			if(flag&&!um.takeMoney(this.moneyText.getText())){
			//	JOptionPane.showMessageDialog(this, "内部错误", "提示",JOptionPane.OK_OPTION);
			}else{
				if(flag)
				JOptionPane.showMessageDialog(this,"取款成功", "提示",JOptionPane.OK_OPTION);
				
				UserInfoFrame.moneyText.setText(um.getUserService().getUserById(um.getUser().getId()).getMoney());
				
			}
		}

		this.dispose();
	}

}



