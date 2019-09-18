package Application;

public class Catalog extends Person {
    private String phone_number;
    private String phone_number_2;

    private String Organization;
    private String Note;

    //статический класс для шаблона Builder спользуемый для создание объекта класса с большим кол-вом параметров (не объязательных)
    static public class Builder{
        //Объязательный параметр
        private  String phone_number;

        private String phone_number_2 = "";

        private String Organization = "";
        private String Note = "";

        public Builder(String phone_number) {
            this.phone_number = phone_number;
        }

        public Builder setPhone_number_2(String phone_number_2) {
            this.phone_number_2 = phone_number_2;
            return this;
        }

        public Builder Organization(String Organization) {
            this.Organization = Organization;
            return this;
        }

        public Builder Note(String Note){
            this.Note = Note;
            return this;
        }

        public Catalog build(String name, String surname){
            return new Catalog(name, surname, this);
        }
    }


    private Catalog(String name, String surname,Builder builder){
        super(name, surname);
        this.phone_number = builder.phone_number;
        this.phone_number_2 = builder.phone_number_2;
        this.Organization = builder.Organization;
        this.Note = builder.Note;
    }

    private String getPhone_number() {
        return phone_number;
    }

    private String getPhone_number_2() {
        return phone_number_2;
    }

    private String getOrganization() {
        return Organization;
    }

    private String getNote() {
        return Note;
    }

    public void getInfo(){
        System.out.println("Name: " + getName());
        System.out.println("Surname: " + getSurname());
        System.out.println("--------------------------------");
        System.out.println("Phone: " + getPhone_number());
        System.out.println("(2) Phone: " + getPhone_number_2());
        System.out.println("--------------------------------");
        System.out.println("Organization: " + getOrganization());
        System.out.println("Note: " + getNote());
        System.out.println("--------------------------------");
        System.out.println("--------------------------------\n");
    }

}
