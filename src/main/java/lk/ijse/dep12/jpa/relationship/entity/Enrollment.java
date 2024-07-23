package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enrollment")
public class Enrollment implements Serializable {
    @EmbeddedId
    private EnrollmentPK enrollmentPK;
    private Date date;
    @Column(name = "registered_by")
    private String registeredBy;

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("courseCode")
    private Course course;

    public Enrollment(Student student, Course course, Date date, String registeredBy) {
        this.enrollmentPK = new EnrollmentPK(student.getId(), course.getCode());
        this.student = student;
        this.course = course;
        this.date = date;
        this.registeredBy = registeredBy;
    }
}
