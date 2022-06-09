package br.com.training.school.domain.student;

//VALUE OBJECT
public class Phone {
    private String ddd;
    private String number;

    public Phone(String ddd, String number) {
        if (!isValid(ddd, number)) {
            throw new IllegalArgumentException("Phone is not valid!");
        }
        this.ddd = ddd;
        this.number = number;
    }

    private boolean isValid(String ddd, String number) {
        if (ddd == null || number == null) {
            return false;
        }
        return (ddd.matches("\\d{2}") && number.matches("\\d{8}|\\d{9}"));
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object object) {
        Phone phone = (Phone) object;
        return this.number.equals(phone.number) && this.ddd.equals(phone.ddd);
    }

    @Override
    public int hashCode() {
        return this.ddd.hashCode();
    }
}
