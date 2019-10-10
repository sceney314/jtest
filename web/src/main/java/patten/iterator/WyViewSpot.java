package patten.iterator;

/**
 * 婺源景点类
 */
public class WyViewSpot {
    private String Name;
    private String Introduce;

    WyViewSpot(String Name, String Introduce) {
        this.Name = Name;
        this.Introduce = Introduce;
    }

    public String getName() {
        return Name;
    }

    public String getIntroduce() {
        return Introduce;
    }

    @Override
    public String toString() {
        return "WyViewSpot{" +
                "Name='" + Name + '\'' +
                ", Introduce='" + Introduce + '\'' +
                '}';
    }
}
