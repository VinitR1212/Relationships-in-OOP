class CEO extends Manager {
    private String companyOwned;

    public CEO(int id, String name, double salary, String companyOwned) {
        super(id, name, salary, "Executive");
        this.companyOwned = companyOwned;
    }

    public String getCompanyOwned() {
        return companyOwned;
    }

    @Override
    public void displayAdditionalInfo() {
        System.out.println("Company Owned: " + companyOwned);
    }
}
