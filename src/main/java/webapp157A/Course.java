package webapp157A;

public class Course {

    private String courseId;
    private String name;
    private int units;
    private String description;
    private String departmentId;

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public int getUnits() {
        return units;
    }

    public String getDescription() {
        return description;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
 }
