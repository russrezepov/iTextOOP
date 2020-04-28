import java.time.LocalDate;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Date;

public class User implements Comparable<User >{

        private String lastName, firstName, gender, color, userDate;
        private String name;
        Date realDate;
        private LocalDate dob;

        public User(String lastName, String firstName, String gender, String userDate, String color, Date realDate) {
            //super();
            this.lastName = lastName;
            this.firstName = firstName;
            this.gender = gender;
            this.userDate = userDate;
            this.color = color;
            this.realDate = realDate;
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

        public String getUserDate(){
            return userDate;
        }

        public Date realDate() {
            return realDate;
        }

        public void setUserDate(Date realDate) {
            this.realDate = realDate;
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

//        public void sort(Comparator<? super E> c)
//        {
//            final int expectedModCount = modCount;
//
//            Arrays.sort((E[]) elementData, 0, size, c);
//
//            if (modCount != expectedModCount) {
//                throw new ConcurrentModificationException();
//            }
//            modCount++;
//        }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    public Date getRealDate() {
        return realDate;
    }

    public void setRealDate(Date realDate) {
        this.realDate = realDate;
    }

    @Override
        public String toString() {
            return lastName + " " + firstName + " " + gender + " " + userDate + " " + color;
        }

    @Override
    public int compareTo(User user) {
        return 0;
    }
}

