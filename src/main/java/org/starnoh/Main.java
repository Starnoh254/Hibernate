package org.starnoh;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        StudentDao studentDao = new StudentDao();
        Student s1 = new Student();
        Student s3 = new Student();
        s1.setSid(9L);
        s1.setSname("Mark");
        s1.setMarks(367L);

        s3.setSid(9L);
        s3.setSname("Agwambo");
        s3.setMarks(432L);

        studentDao.saveStudent(s1);
        Student s2 = studentDao.getStudent(9L);
        System.out.println(s2);
//        studentDao.updateStudent(s3);
        studentDao.deleteStudent(9L);

    }
}