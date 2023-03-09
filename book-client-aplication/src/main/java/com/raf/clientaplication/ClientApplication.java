package com.raf.clientaplication;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import com.raf.clientaplication.view.HotelsView;
import com.raf.clientaplication.view.LoginView;

public class ClientApplication extends JFrame{
	
	private String token;
	private LoginView loginView;
	private HotelsView hotelsView;
	
	public ClientApplication() throws IllegalAccessException, NoSuchMethodException {
		
		this.setTitle("Client Application");
		this.setSize(1200, 1200);
		this.setLayout(new BorderLayout());
		
		loginView = new LoginView();
		this.add(loginView, BorderLayout.NORTH);
		
		hotelsView = new HotelsView();
		this.add(hotelsView, BorderLayout.CENTER);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static class InstanceHolder {
		private static ClientApplication instance;

		static {
			try {
				instance = new ClientApplication();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LoginView getLoginView() {
		return loginView;
	}

	public void setLoginView(LoginView loginView) {
		this.loginView = loginView;
	}
	
	public HotelsView getHotelsView() {
		return hotelsView;
	}

	public void setHotelsView(HotelsView hotelsView) {
		this.hotelsView = hotelsView;
	}

	public static ClientApplication getInstance() {
		return InstanceHolder.instance;
	}
	
	
	

}
