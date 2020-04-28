import java.time.LocalDate;

    public class User {

        private String lastName, firstName, gender, userDate, color;
        private String name;
        private LocalDate dob;

        public User(String lastName, String firstName, String gender, String userDate, String color) {
            //super();
            this.lastName = lastName;
            this.firstName = firstName;
            this.gender = gender;
            this.userDate = userDate;
            this.color = color;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getUserDate() {
            return userDate;
        }

        public void setUserDate(String userDate) {
            this.userDate = userDate;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDate getDob() {
            return dob;
        }

        public void setDob(LocalDate dob) {
            this.dob = dob;
        }

        //Getters and Setters


        @Override
        public String toString() {
            return "User " + lastName + " " + firstName + " " + gender + " " + userDate + " " + color + "]";
        }
    }

