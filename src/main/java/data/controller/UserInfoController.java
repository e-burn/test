package data.controller;

import data.UserInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserInfoController
{
    public static void saveUserInfoToFile(UserInfo userInfoToSave, File destinationFile)
    {
        //serialize userinfo
    }
    public static UserInfo getUserInfoFromFile(File sourceFile)
    {
        //deserialize userInfo
        UserInfo result = new UserInfo("userName");
        return result;
    }
}
