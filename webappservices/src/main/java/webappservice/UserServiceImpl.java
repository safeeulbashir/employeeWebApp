package webappservice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;

import webappmodels.UserInfo;

public class UserServiceImpl implements UserService {

	public boolean validateUser(UserInfo user, ServletConfig servletConfig) {
		// Enumeration<String> initParams =
		// servletConfig.getInitParameterNames();
		// boolean validUser = false;
		//
		// while (initParams.hasMoreElements()) {
		// String initParamName = initParams.nextElement();
		// String initParamValue =
		// servletConfig.getInitParameter(initParamName);
		//
		// if (user != null && user.getUserId().equals(initParamName)
		// && user.getPassword().equals(initParamValue)) {
		// validUser = true;
		// }
		// }
		/* List<UserInfo> users=new ArrayList(); */
		UserInfo user1 = new UserInfo();
		user1.setUserId("safee");
		user1.setPassword("12345");
		if (user.getUserId().equals(user1.getUserId()) && user.getPassword().equals(user1.getPassword()))
			return true;

		return false;
	}

}
