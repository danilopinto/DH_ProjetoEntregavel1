import java.util.Date;

public class StudentRegistry {

    private Integer id;
    private Student student;
    private Course course;
    private Date date = new Date();

    public StudentRegistry(Integer id, Student student, Course course) {
        this.id = id;
        this.student = student;
        this.course = course;
        System.out.println("=> CRIANDO MATRICULA(StudentRegistry)");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getDate() {
        return date;
    }

}
