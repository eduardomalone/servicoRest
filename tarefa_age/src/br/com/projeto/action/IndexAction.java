package br.com.projeto.action;

import com.opensymphony.xwork2.Action;

public class IndexAction implements Action{

	@Override
	public String execute() throws Exception {
		System.out.println("Executou Index");
		return "success";
	}

	public String menu() {
		return "menu";
	}
	
}
