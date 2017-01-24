package com.opinta.main;

import com.opinta.dao.PersonDAOImpl_UUID_generated_uuid2;
import com.opinta.dao.PersonDAOImpl_id_generated_auto;
import com.opinta.model.Person_Id_generated_auto;
import com.opinta.model.Person_UUID_generated_uuid2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		PersonDAOImpl_id_generated_auto personDAOImpl_PersonDAOImpl_id_generated_auto = context.getBean(PersonDAOImpl_id_generated_auto.class);
		PersonDAOImpl_UUID_generated_uuid2 personDAOImpl_UUID_generated_uuid2 = context.getBean(PersonDAOImpl_UUID_generated_uuid2.class);

		int count = 10;

		// INSERT Person_Id_generated_auto
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			System.out.println("int auto: " + i);
			Person_Id_generated_auto person = new Person_Id_generated_auto();
			person.setName("Pankaj" + i);
			person.setCountry("India" + i);
			personDAOImpl_PersonDAOImpl_id_generated_auto.save(person);
		}
		long endTime   = System.currentTimeMillis();
		long totalTimePerson_Person_Id_generated_auto = endTime - startTime;

		// INSERT Person_UUID_generated_uuid2
		startTime = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			System.out.println("uuid: " + i);
			Person_UUID_generated_uuid2 person = new Person_UUID_generated_uuid2();
			person.setName("Pankaj" + i);
			person.setCountry("India" + i);
			personDAOImpl_UUID_generated_uuid2.save(person);
		}
		endTime   = System.currentTimeMillis();
		long totalTimePerson_UUID_generated_uuid2 = endTime - startTime;

		// FETCH Person_Id_generated_auto
		List<Person_Id_generated_auto> all_auto = personDAOImpl_PersonDAOImpl_id_generated_auto.list();
		AtomicInteger rowNumber_auto = new AtomicInteger(1);
		List<Integer> ids_auto = all_auto.stream()
				.filter(p -> rowNumber_auto.getAndIncrement()%5 == 0)
				.map(Person_Id_generated_auto::getId)
				.collect(Collectors.toList());

		// measure time
		startTime = System.currentTimeMillis();
		ids_auto.forEach(personDAOImpl_PersonDAOImpl_id_generated_auto::getOne);
		endTime = System.currentTimeMillis();
		long totalTime_fetchAuto = endTime - startTime;

		// FETCH Person_UUID_generated_uuid2
		List<Person_UUID_generated_uuid2> all_uuid2 = personDAOImpl_UUID_generated_uuid2.list();
		AtomicInteger rowNumber_uuid2 = new AtomicInteger(1);
		List<String> ids = all_uuid2.stream()
				.filter(p -> rowNumber_uuid2.getAndIncrement() % 5 == 0)
				.map(Person_UUID_generated_uuid2::getId)
				.collect(Collectors.toList());

		// measure time
		startTime = System.currentTimeMillis();
		ids.forEach(personDAOImpl_UUID_generated_uuid2::getOne);
		endTime = System.currentTimeMillis();
		long totalTime_fetchUuid2 = endTime - startTime;

		log.info("Duration for inserting {} records PK: INT(11) {}",  count, totalTimePerson_Person_Id_generated_auto);
		log.info("Duration for inserting {} records PK: VARCHAR(64) {}", count, totalTimePerson_UUID_generated_uuid2);
		log.info("Duration for fetching {} records PK: INT(11) {}", ids_auto.size(), totalTime_fetchAuto);
		log.info("Duration for fetching {} records PK: VARCHAR(64) {}", ids.size(), totalTime_fetchUuid2);

		context.close();
	}

}
