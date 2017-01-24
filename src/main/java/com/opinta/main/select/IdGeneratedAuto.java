package com.opinta.main.select;

import com.opinta.dao.PersonDAOImpl_id_generated_auto;
import com.opinta.model.Person_Id_generated_auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
public class IdGeneratedAuto {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        PersonDAOImpl_id_generated_auto dao = context.getBean(PersonDAOImpl_id_generated_auto.class);

        List<Person_Id_generated_auto> all = dao.list();
        AtomicInteger rowNumber = new AtomicInteger(1);
        List<Integer> ids = all.stream()
                .filter(p -> rowNumber.getAndIncrement()%5 == 0)
                .map(Person_Id_generated_auto::getId)
                .collect(Collectors.toList());

        // measure time
        long startTime = System.currentTimeMillis();
        ids.forEach(dao::getOne);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        log.info("Duration for fetching {} records PK: INT(11) {}", ids.size(), totalTime);

        context.close();
    }
}
