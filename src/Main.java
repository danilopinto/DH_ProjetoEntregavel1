public class Main {
    public static void main(String[] args) {

        DigitalHouseManager manager = new DigitalHouseManager();

        //criando professores
        System.out.print("\r\n =================== CRIANDO PROFESSORES ===================  \r\n");
        manager.createPrimaryProfessor(1,"Yuri", "SobrenomeYuri", "Kotlin");
        manager.createPrimaryProfessor(2,"João", "SobrenomeJoão", "Java");

        manager.createAlternativeProfessor(3,"Ivan", "SobrenomeIvan", 10);
        manager.createAlternativeProfessor(4,"ProfNovo", "SobrenomeProfNovo", 20);

        System.out.print("\r\n");

        //criando cursos
        System.out.print("\r\n =================== CRIANDO CURSOS ===================  \r\n");
        manager.createCourse(20001, "Full Stack",3);
        manager.createCourse(20002, "Android",2);

        System.out.print("\r\n LISTAR  CURSOS \r\n");
        manager.showCourses();

        //alocando professores
        System.out.print("\r\n =================== ALOCANDO PROFESSORES ===================  \r\n");
        manager.defineProfessors(20001, 1, 3);//Yuri e Ivan
        manager.defineProfessors(20001, 2, 4);//João e ProfNovo

        System.out.print("\r\n LISTAR  CURSOS \r\n");
        manager.showCourses();

        System.out.print("\r\n");

        //cadastrando alunos
        System.out.print("\r\n =================== CADASTRAR ALUNOS ===================  \r\n");
        manager.createStudent(1, "Danilo", "Pinto");
        manager.createStudent(2, "Baby", "Baby");
        manager.createStudent(3, "Lucas", "Ribeiro");
        manager.createStudent(4, "Japa", "Script");
        manager.createStudent(5, "Thiago", "Santos");

        System.out.print("\r\n");

        //matriculando alunos em "full stack" (Lucas e Japa)
        System.out.print("\r\n =================== MATRICULANDO ALUNOS EM CURSOS (full stack) ===================  \r\n");
        manager.registryStudent(3,20001);
        manager.registryStudent(4,20001);

        System.out.print("\r\n");

        //matriculando alunos em "android" (Danilo, Baby e Thiago)
        System.out.print("\r\n =================== MATRICULANDO ALUNOS EM CURSOS (android) ===================  \r\n");
        manager.registryStudent(1,20002);
        manager.registryStudent(2,20002);
        manager.registryStudent(5,20002);

    }
}
