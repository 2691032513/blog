package actions;

import entity.UserEntity;
import services.LoginService;

public class UserAction {

    UserEntity user;
    LoginService loginService;

    public String executeLogin() {
        return loginService.userExist(user);
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
