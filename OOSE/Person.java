class Person{



    private String firstName;
    private String lastName;
    private String idCard;
    private String gender;

    public void setAccount(String firstName, String lastName, String idCard, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCard = idCard;
        this.gender = gender;
    }
    
    public String getAccountFirstName() {
        return firstName;
    }

    public String getAccountLastName() {
        return lastName;
    }

    public String getAccountIdCard(){
        return idCard;
    }

    public String getAccountGender(){
        return gender;
    }
}
