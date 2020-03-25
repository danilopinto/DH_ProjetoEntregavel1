public class AlteranativeProfessor extends Professor{
    private Integer hourMonitoring;

    public AlteranativeProfessor(Integer id, String name, String surname, Float houseTime, Integer hourMonitoring) {
        super(id, name, surname, houseTime);
        this.hourMonitoring = hourMonitoring;
        System.out.println("=> CRIANDO PROFESSOR ALTERNATIVO - NOME ["+name+"]");
    }

    public Integer getHourMonitoring() {
        return hourMonitoring;
    }

    public void setHourMonitoring(Integer hourMonitoring) {
        this.hourMonitoring = hourMonitoring;
    }
}
