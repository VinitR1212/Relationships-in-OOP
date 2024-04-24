class Supervisor extends Employee {
    private int teamSize;

    public Supervisor(int id, String name, double salary, int teamSize) {
        super(id, name, salary);
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    @Override
    public void displayAdditionalInfo() {
        System.out.println("Team Size: " + teamSize);
    }
}
