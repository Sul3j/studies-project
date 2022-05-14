package Car;

public class Car {
    private String mark;
    private String model;
    private int productionDate;
    private String color;
    private int course;
    private int doorQuantity;

    // getters and setters
    public String getMark() {
        return this.mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionDate() {
        return this.productionDate;
    }

    public void setProductionDate(int productionDate) {
        this.productionDate = productionDate;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCourse() {
        return this.course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getDoorQuantity() {
        return this.doorQuantity;
    }

    public void setDoorQuantity(int doorQuantity) {
        this.doorQuantity = doorQuantity;
    }

    // constructors
    public Car() {
        this.mark = "";
        this.model = "";
        this.productionDate = 0;
        this.color = "";
        this.course = 0;
        this.doorQuantity = 0;
    }

    public Car(String mark, String model, int productionDate, String color, int course, int doorQuantity) {
        this.mark = mark;
        this.model = model;
        this.productionDate = productionDate;
        this.color = color;
        this.course = course;
        this.doorQuantity = doorQuantity;
    }

    // methods

}
