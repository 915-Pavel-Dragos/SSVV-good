package service;

import domain.Nota;
import domain.Student;
import domain.Tema;
import junit.framework.TestCase;
import repository.*;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

import java.time.LocalDate;

public class TestClass extends TestCase {

    StudentXMLRepo stud_XML_rep = new StudentXMLRepo("fisiere/Studenti.xml");
    NotaXMLRepo nota_XML_rep = new NotaXMLRepo("fisiere/Note.xml");
    TemaXMLRepo teme_XML_rep = new TemaXMLRepo("fisiere/Teme.xml");
    StudentValidator studentValidator = new StudentValidator();
    TemaValidator temaValidator = new TemaValidator();
    NotaValidator notaValidator = new NotaValidator(stud_XML_rep, teme_XML_rep);
    Service service = new Service(stud_XML_rep, studentValidator, teme_XML_rep, temaValidator, nota_XML_rep, notaValidator);

    public void testAddStudent() {
        Student student = new Student("234", "Andrei", 934, "andrei@gmail.com");
        Student result = service.addStudent(student);
        assertEquals(student, result);
    }

    public void testAddAssignment() {
        Tema tema = new Tema("55", "descriere", 8, 5);
        Tema result1 = service.addTema(tema);
        assertEquals(tema, result1);
    }

    public void testAddGrade() {

        Tema tema = new Tema("55", "descriere", 8, 5);
        Tema result1 = service.addTema(tema);

        Nota nota = new Nota("234", "1", "55", 5, LocalDate.parse("2018-12-01"));
        double result = service.addNota(nota, "Foarte bine");
        assertEquals(2.5, result);
    }

    public void BigBangTesting(){
        testAddStudent();
        testAddAssignment();
        testAddGrade();
    }
}