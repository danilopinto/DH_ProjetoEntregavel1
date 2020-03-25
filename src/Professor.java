public abstract class Professor {
    private Integer id;
    private String name;
    private String surname;
    private Float houseTime;


    public Professor(Integer id, String name, String surname, Float houseTime) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.houseTime = houseTime;
        System.out.println("=> CRIANDO PROFESSOR - NOME ["+name+"]");
    }

    public boolean compareProfessor(Integer id){
        System.out.println("= compare professor =");
        if (id == this.id){
            return true;
        }
        return false;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Float getHouseTime() {
        return houseTime;
    }

    public void setHouseTime(Float houseTime) {
        this.houseTime = houseTime;
    }
}
