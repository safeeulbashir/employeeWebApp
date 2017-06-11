package webappservice;

import javax.servlet.ServletConfig;

import webappmodels.UserInfo;

public interface UserService {

	boolean validateUser(UserInfo user, ServletConfig servletConfig);

}
