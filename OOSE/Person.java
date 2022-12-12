class Person{



    private String name;
    private String address;
    private String phone;
    private String email;

    public void setAccount(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone(){
        return phone;
    }

    public String getemail(){
        return email;
    }
}
