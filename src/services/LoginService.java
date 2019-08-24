package services;

import dao.UserDao;
import entity.UserEntity;

public interface LoginService {

    public String userExist(UserEntity user);


}
