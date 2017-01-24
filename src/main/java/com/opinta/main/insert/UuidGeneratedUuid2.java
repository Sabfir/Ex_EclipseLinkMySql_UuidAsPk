package com.opinta.main.insert;

import com.opinta.dao.PersonDAOImpl_UUID_generated_uuid2;
import com.opinta.model.Person_UUID_generated_uuid2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UuidGeneratedUuid2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        PersonDAOImpl_UUID_generated_uuid2 PersonDAOImpl_UUID_generated_uuid2 = context.getBean(PersonDAOImpl_UUID_generated_uuid2.class);

        int count = 10;

        // Person_UUID_generated_uuid2
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            Person_UUID_generated_uuid2 person = new Person_UUID_generated_uuid2();
            person.setName("Pankaj" + i);
            person.setCountry("India" + i);
            PersonDAOImpl_UUID_generated_uuid2.save(person);
        }
        long endTime   = System.currentTimeMillis();
        long totalTimePerson_UUID_generated_uuid2 = endTime - startTime;

        System.out.println("Duration for Person_UUID_generated_uuid2: " + totalTimePerson_UUID_generated_uuid2);

        context.close();
    }
}
