package services.implement;

import dao.UserDao;
import entity.UserEntity;
import services.LoginService;

public class LoginServiceImpl implements LoginService {

    private UserDao userDao;

    @Override
    public String userExist(UserEntity user) {
        if (userDao.SearchUser(user) != null) {
            return "success";
        } else {
            return "fail";
        }
    }

    public UserDao getUserDao() {
        return userDao;

    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
