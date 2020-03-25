import java.util.List;

public class Course {

    private Integer id;
    private String name;
    private Integer maxStudentsClass;
    private Professor primaryProfessor, alternativeProfessor;
    private List<Student> studentList;

    public Course(Integer id) {
        this.id = id;
    }

    public Course(Integer id, String name, Integer maxStudentsClass) {
        this.id = id;
        this.name = name;
        this.maxStudentsClass = maxStudentsClass;
        System.out.println("=> CRIANDO CURSO - NOME ["+name+"]");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxStudentsClass() {
        return maxStudentsClass;
    }

    public void setMaxStudentsClass(Integer maxStudentsClass) {
        this.maxStudentsClass = maxStudentsClass;
    }

    public Professor getPrimaryProfessor() {
        return primaryProfessor;
    }

    public void setPrimaryProfessor(Professor primaryProfessor) {
        this.primaryProfessor = primaryProfessor;
    }

    public Professor getAlternativeProfessor() {
        return alternativeProfessor;
    }

    public void setAlternativeProfessor(Professor alternativeProfessor) {
        this.alternativeProfessor = alternativeProfessor;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
