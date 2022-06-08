package school;

import java.time.LocalDate;

public class Indication {
    private Student indicatorStudent;
    private Student indicadedStudent;
    private LocalDate date;

    public Indication(Student indicatorStudent, Student indicadedStudent, LocalDate date) {
        this.indicatorStudent = indicatorStudent;
        this.indicadedStudent = indicadedStudent;
        this.date = LocalDate.now();
    }

    public Student getIndicatorStudent() {
        return indicatorStudent;
    }

    public Student getIndicadedStudent() {
        return indicadedStudent;
    }

    public LocalDate getDate() {
        return date;
    }
}
