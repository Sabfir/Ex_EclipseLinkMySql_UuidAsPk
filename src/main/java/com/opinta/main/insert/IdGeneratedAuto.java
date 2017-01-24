package com.opinta.main.insert;

import com.opinta.dao.PersonDAOImpl_id_generated_auto;
import com.opinta.model.Person_Id_generated_auto;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IdGeneratedAuto {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        PersonDAOImpl_id_generated_auto PersonDAOImpl_PersonDAOImpl_id_generated_auto = context.getBean(PersonDAOImpl_id_generated_auto.class);

        int count = 100;

        // Person_Id_generated_auto
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            Person_Id_generated_auto person = new Person_Id_generated_auto();
            person.setName("Pankaj" + i);
            person.setCountry("India" + i);
            PersonDAOImpl_PersonDAOImpl_id_generated_auto.save(person);
        }
        long endTime = System.currentTimeMillis();
        long totalTimePerson_Person_Id_generated_auto = endTime - startTime;

        System.out.println("Duration for totalTimePerson_Person_Id_generated_auto: " + totalTimePerson_Person_Id_generated_auto);

        context.close();
    }
}
