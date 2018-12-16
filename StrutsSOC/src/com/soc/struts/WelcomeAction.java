
/**
 * @author Eduardo Lucio
 *
 */
package com.soc.struts;
import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport {
	
	@Override
	public String execute() throws Exception{
		return SUCCESS;
	}
}