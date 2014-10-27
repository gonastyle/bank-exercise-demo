package com.cx.bank.view;

import java.util.Scanner;

import com.cx.bank.bll.UserManage;
import com.cx.bank.model.User;

public class BankTest {

	public static void main(String[] args) {
		
		LoginView l=new LoginView();

	}

}

class LoginView{
	
	UserManage um = UserManage.getInstance();
	User u=new User();
	Scanner s=new Scanner(System.in);
	public LoginView(){
		
	   choose();
	   
		
	}

	public void choose() {
		
		showLogin();
		int c=s.nextInt();
		while(true){
			switch(c){
			case 1: 
				verifyLogin();
			break;
			
			case 2: 
				register();
			break;
			
			case 3: System.exit(0);break;
			default: System.out.println("请重新输入");break;
			}
			break;
		}
		choose();
	}
	
	public void register(){
		System.out.println("欢迎注册账号");
		System.out.println("请输入你的账号：");
		String id=s.next();
		System.out.println("请输入你的密码：");
		String pwd=s.next();
		if(um.register(id, pwd)){
			System.out.println("注册成功！");
		}else{
			System.out.println("注册失败：用户名重复！");
		}
		
		
	}

	//登陆界面
	public void showLogin() {
		
		System.out.println(" 银行管理系统Dos版 ");
		System.out.println("   1.登陆");
		System.out.println("   2.注册");
		System.out.println("   3.退出");
		System.out.println("请输入选项：1-3");
		
	}
	//操作界面
	public void showMain(){
		
		System.out.println(" 用户操作界面        ");
		System.out.println("   1.查询");
		System.out.println("   2.存款");
		System.out.println("   3.取款");
		System.out.println("   4.转账");
		System.out.println("   5。退出");
		System.out.println("请输入选项：1-5");
		
	}
	
	public void verifyLogin(){
		String id;
		String pwd;
		System.out.println("请输入用户名：");
		id=s.next();
		System.out.println("请输入密码：：");
		pwd=s.next();
		
		u.setId(id);
		u.setPwd(pwd);
		
		if(um.login(id, pwd)){
			System.out.println(id+"登陆成功");
			//保存当前用户的信息	
			dealMoney();
			
		}else{
			System.out.println("登陆失败//用户名或密码错误://请重新登陆");
			choose();
			
		}
		
			
	}
	
	public void dealMoney(){
		showMain();
		int c=s.nextInt();
		while(true){
			
			switch(c){
			case 1: 
				selectMoney();
			break;
			
			case 2: 
				saveMoney();
			break;
			case 3: 
				takeMoney();
				break;
			case 4: 
				transferMoney();
				break;
			case 5: 
			System.out.println("系统正在退出！");
			System.exit(0); 
			break;
			default: System.out.println("请重新输入");break;
			}
			
			break;
		}
		dealMoney();
	}
	
	public void selectMoney(){
		 System.out.println("你的余额为:"+um.getUser().getMoney());
		
	}
	
   public void takeMoney(){
	   System.out.println("请输入取款金额：");
	   String money=s.next();
	   if(um.takeMoney(money)){
		   System.out.println("取款成功！");
	   }else{
		   System.out.println("取款失败！");
	   }
	   
		
	}
   public void saveMoney(){
	   System.out.println("请输入存款金额：");
	   String money=s.next();
	   if(um.saveMoney(money)){
		   System.out.println("存款成功！");
	   }else{
		   System.out.println("存款失败！");
	   }
   }
   public void transferMoney(){
	
	   System.out.println("请输入转账号:");
	   String id=s.next();
	   System.out.println("请输入转账金额：");
	   String money=s.next();
	   if(um.transferMoney(id,money)){
		   System.out.println("转账成功！");
	   }else{
		   System.out.println("转账失败！");
	   }
   }
	
}





