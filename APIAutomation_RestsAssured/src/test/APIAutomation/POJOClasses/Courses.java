package POJOClasses;

import java.util.List;

public class Courses {
	
	private List<WebAutomation> webAutomation;
	private List<API> api;
	private List<Mobile> mobile;
	
	/**
	 * @return the webAutomation
	 */
	public List<WebAutomation> getWebAutomation() {
		return webAutomation;
	}
	/**
	 * @param webAutomation the webAutomation to set
	 */
	public void setWebAutomation(List<WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	/**
	 * @return the api
	 */
	public List<API> getApi() {
		return api;
	}
	/**
	 * @param api the api to set
	 */
	public void setApi(List<API> api) {
		this.api = api;
	}
	/**
	 * @return the mobile
	 */
	public List<Mobile> getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}

}
