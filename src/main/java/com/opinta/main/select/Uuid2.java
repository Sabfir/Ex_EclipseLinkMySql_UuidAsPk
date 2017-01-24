package com.opinta.main.select;

import com.opinta.dao.PersonDAOImpl_UUID_generated_uuid2;
import com.opinta.model.Person_UUID_generated_uuid2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
public class Uuid2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        PersonDAOImpl_UUID_generated_uuid2 dao = context.getBean(PersonDAOImpl_UUID_generated_uuid2.class);

        List<Person_UUID_generated_uuid2> all = dao.list();
        AtomicInteger rowNumber = new AtomicInteger(1);
        List<String> ids = all.stream()
                .filter(p -> rowNumber.getAndIncrement() % 5 == 0)
                .map(Person_UUID_generated_uuid2::getId)
                .collect(Collectors.toList());

        // measure time
        long startTime = System.currentTimeMillis();
        ids.forEach(dao::getOne);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        log.info("Duration for fetching {} records PK: VARCHAR(64) {}", ids.size(), totalTime);

        context.close();
    }
}
