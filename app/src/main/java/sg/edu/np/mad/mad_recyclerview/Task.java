package sg.edu.np.mad.mad_recyclerview;

public class Task {
    private String name;
    private Boolean check;

    public Task(){}
    public Task(String name, Boolean check) {
        this.name = name;
        this.check = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }
}
