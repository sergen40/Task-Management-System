package mainapplication.util;

abstract public class DatabaseInformation {

    private String url;
    private String userName;
    private String userPassword;
    private String forNameData;

    public DatabaseInformation() {

        this.url = "jdbc:sqlserver://localhost:1433; databaseName=deneme_proje2; integratedSecurity=true;";
        this.userName = "root";
        this.userPassword = "root";
        this.forNameData = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    }

    public DatabaseInformation(String url, String userName, String userPassword, String forNameData) {
        this.url = url;
        this.userName = userName;
        this.userPassword = userPassword;
        this.forNameData = forNameData;
    }

    @Override
    public String toString() {
        return "DatabaseInformation{"
                + "url='" + url + '\''
                + ", userName='" + userName + '\''
                + ", userPassword='" + userPassword + '\''
                + ", forNameData='" + forNameData + '\''
                + '}';
    }

    public String getUrl() {
        return url;
    }

    public DatabaseInformation setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public DatabaseInformation setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public DatabaseInformation setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public String getForNameData() {
        return forNameData;
    }

    public DatabaseInformation setForNameData(String forNameData) {
        this.forNameData = forNameData;
        return this;
    }

}
