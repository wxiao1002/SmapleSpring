/**
 * @author wang xiao
 * @date 2022/5/7
 */
public class MyService {

    private String myId;

    private String name;

    private MyDao myDao;

    public MyService() {
    }

    public MyService(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getMyId() {
        return myId;
    }

    public void setMyId(String myId) {
        this.myId = myId;
    }


    public MyDao getMyDao() {
        return myDao;
    }

    public void setMyDao(MyDao myDao) {
        this.myDao = myDao;
    }

    @Override
    public String toString() {
        return "MyService{" +
                "myId='" + myId + '\'' +
                ", name='" + name + '\'' +
                ", myDao=" + myDao +
                '}';
    }
}
