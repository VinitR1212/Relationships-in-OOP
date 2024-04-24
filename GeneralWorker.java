class Worker extends Employee {
    private int hoursWorked;

    public Worker(int id, String name, double salary, int hoursWorked) {
        super(id, name, salary);
        this.hoursWorked = hoursWorked;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public void displayAdditionalInfo() {
        System.out.println("Hours Worked: " + hoursWorked);
    }
}
