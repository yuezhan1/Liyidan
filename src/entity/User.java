package entity;

public class User {
    String username;
    String password;
    String schoolName;
    String zhuanye;
    String[] jishu;

    public User() {
    }

    public User(String username, String schoolName, String zhuanye, String[] jishu) {
        this.username = username;
        this.schoolName = schoolName;
        this.zhuanye = zhuanye;
        this.jishu = jishu;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getZhuanye() {
        return zhuanye;
    }

    public void setZhuanye(String zhuanye) {
        this.zhuanye = zhuanye;
    }

    public String[] getJishu() {
        return jishu;
    }

    public void setJishu(String[] jishu) {
        this.jishu = jishu;
    }
}
