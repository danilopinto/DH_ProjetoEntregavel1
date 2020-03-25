import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DigitalHouseManager {

    private Integer id;
    private List<Student> studentList = new ArrayList<>();
    private List<Professor> professorList = new ArrayList<>();
    private List<Course> courseList = new ArrayList<>();
    private List<StudentRegistry> listStudentRegistry = new ArrayList<>();
             //<codigoCurso, qtdeAlunos
    private Map<Integer,Integer> listCounterStudentsForCourse = new HashMap<Integer,Integer>();

    public DigitalHouseManager() {

    }

    public void showCourses(){
        for (Course course : courseList) {

            System.out.println("= Curso - id["+course.getId()+"] ["+course.getName()+"] " +
                    "professorPrimario["+course.getPrimaryProfessor()+"] " +
                    "professorAlternativo["+course.getAlternativeProfessor()+"]");

        }
    }

    public void createCourse(Integer idCourse, String courseName, Integer maxStudentsCourse){

        System.out.println("==> CONSTRUINDO CURSO <==");
        Course course = new Course(idCourse, courseName, maxStudentsCourse);

        System.out.println("= adicionando curso da lista id["+idCourse+"]");
        courseList.add(course);

    }

    public void removeCourse(Integer idCourse){

        boolean find = false;

        for (Course course : courseList) {
            if (course.getId().equals(idCourse)){
                System.out.println("= removendo curso da lista - id["+idCourse+"]");
                courseList.remove(idCourse);
                find = true;
            }
        }

        if (!find){
            System.out.println("= curso não encontrado - id["+idCourse+"]");
        }

    }

    public void createAlternativeProfessor(Integer idProfessor, String professorName,
                                            String professorSurname, Integer hourAmount){
        System.out.println("==> CONSTRUINDO PROFESSOR ALTERNATIVO <==");
        Professor professorAlternative = new AlteranativeProfessor(idProfessor, professorName, professorSurname,
                                                        0.0f, hourAmount);
        System.out.println("= adicionando professor alternativo a lista - nome["+professorName+"]");
        professorList.add(professorAlternative);
    }


    public void createPrimaryProfessor(Integer idProfessor, String professorName, String professorSurname,
                                       String speciality){

        System.out.println("==> CONSTRUINDO PROFESSOR PRIMARIO <==");
        PrimaryProfessor primaryProfessor = new PrimaryProfessor(idProfessor, professorName, professorSurname,
                                    0.0f, speciality);

        System.out.println("= adicionando professor primario a lista - nome["+professorName+"]");
        professorList.add(primaryProfessor);

    }

    public void createStudent(Integer idStudent, String studentName, String studentSurname){

        System.out.println("==> CONSTRUINDO ALUNO <==");
        Student student = new Student(idStudent, studentName, studentSurname);

        System.out.println("= adicionando estudante a lista - nome["+studentName+"]");
        studentList.add(student);

    }

    //método complementar para auxiliar na logica
    public Course findCourse(Integer idCourse){

        System.out.println("\n\r= buscando curso (findCourse)");
        for (Course course : courseList) {

            if (course.getId().equals(idCourse)){
                System.out.println("= curso encontrado - nome["+course.getName()+"]");
                return course;
            }
        }

        System.out.println("= curso não encontrado - id["+idCourse+"]");
        return null;
    }

    //método complementar para auxiliar na logica
    public Student findStudent(Integer idStudent){

        System.out.println("= buscando aluno (findStudent)");
        for (Student student : studentList) {
            if (student.getId().equals(idStudent)){
                System.out.println("= aluno encontrado - nome["+student.getName()+"]");
                return student;
            }
        }

        System.out.println("= aluno não encontrado - id["+idStudent+"]");
        return null;
    }

    /*
         método complementar para auxiliar na logica
         retorna Map com a quantidade de alunos matriculados por curso
     */
    public void countStudentsForCourse(){

        listCounterStudentsForCourse = null;

        //percorre lista de matriculas
        for (StudentRegistry listStudentRegistry : listStudentRegistry) {

            //busca o id do curso (dentro do curso na lista)
            Integer idCourse = listStudentRegistry.getCourse().getId();

            //busca id do estudante na lista quantidade de alunos por curso
            //verifica se existe o curso na lista de qtdeAlunosPorCurso
            if (listCounterStudentsForCourse.containsKey(idCourse)){
                //<codigoCurso, qtdeAlunos>
                //adiciona +1 a qtdeAlunos para o curso encontrado
                listCounterStudentsForCourse.put(idCourse, listCounterStudentsForCourse.get(idCourse)+1);
            }else{
                //inclui o curso (que foi não encontrado) a lista com a qtdeAlunos = 1
                listCounterStudentsForCourse.put(idCourse, 1);
            }

        }
    }

    //matricula estudante em um curso
    public void registryStudent(Integer idStudent, Integer idCourse){

        System.out.println("= matricula aluno (registryStudent) ");

        Student student =  findStudent(idStudent);
        if (student==null){
            System.out.println("= aluno não encontrado - id["+idStudent+"]");
            return;
        }

        Course course = findCourse(idCourse);
        if (course==null){
            System.out.println("= curso não encontrado - id["+idCourse+"]");
            return;
        }

        // verifica se existe curso na lista
        // retorna qtde de alunos matriculados no curso
        // retorna null se não existir curso na lista
        Integer valueStudentsCourse = listCounterStudentsForCourse.get(course.getId());

        //verifica se existe curso na lista
        if (valueStudentsCourse!=null){
            //verifica se existem vagas disponiveis para curso
            if (valueStudentsCourse < course.getMaxStudentsClass()){
                //adicionar aluno ao contador de alunos do curso
                listCounterStudentsForCourse.put(course.getId(), valueStudentsCourse+1);

                //criar matricula
                System.out.println("==> CRIAR MATRUCULA ALUNO (registryStudent) ");
                //gera código da matricula
                Integer registryStudentSizeList = listStudentRegistry.size();

                StudentRegistry studentRegistry = new StudentRegistry(registryStudentSizeList + 1, student, course);

            }else{
                System.out.println("= curso id["+course.getId()+"] tem a quantidade máxima de ["
                                                +course.getMaxStudentsClass()+"] - quantidade excedida!");
            }
        }
    }

    //método complementar para auxiliar na logica
    public Professor findProfessor(Integer idProfessor){

        System.out.println("==> buscando professor");
        for (Professor professor : professorList) {
            if (professor.getId().equals(idProfessor)){
                System.out.println("= professor encontrado - nome["+professor.getName()+"]");
                return professor;
            }
        }
        System.out.println("= professor não encontrado - id["+idProfessor+"]");
        return null;
    }

    //Aloca professor em um curso
    public void defineProfessors(Integer idCourse, Integer idPrimaryProfessor, Integer idAlternativeProfessor) {

        System.out.println("= aloca professores (defineProfessors) ");

        Course course = findCourse(idCourse);
        if (course==null){
            return;
        }

        Professor professorPrimary = findProfessor(idPrimaryProfessor);
        if (professorPrimary==null){
            return;
        }

        Professor professorAlternative = findProfessor(idAlternativeProfessor);
        if (professorAlternative==null){
            return;
        }

        System.out.println("==> ALOCANDO PROFESSOR AO CURSO ");

        course.setAlternativeProfessor(professorAlternative);
        course.setPrimaryProfessor(professorPrimary);

    }

    // ============================= GETTERS E SETTERS =============================
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<StudentRegistry> getListStudentRegistry() {
        return listStudentRegistry;
    }

    public void setListStudentRegistry(List<StudentRegistry> listStudentRegistry) {
        this.listStudentRegistry = listStudentRegistry;
    }
}
