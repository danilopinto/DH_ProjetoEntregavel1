public class PrimaryProfessor extends Professor {
    private String speciality;

    public PrimaryProfessor(Integer id, String name, String surname, Float houseTime, String speciality) {
        super(id, name, surname, houseTime);
        this.speciality = speciality;
        System.out.println("=> CRIANDO PROFESSOR PRIMÁRIO - NOME ["+name+"]");
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
