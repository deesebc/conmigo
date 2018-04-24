package com.conmigo.app.bbdd.dao;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.conmigo.app.bbdd.jpa.Event;
import com.conmigo.app.bbdd.jpa.Province;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventDaoTest {

    @Autowired
    private EventDao eDao;

    @Test
    public void metodo() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        LocalDateTime date = LocalDateTime.now();
        Province province = new Province();
        province.setId(3L);
        Page<Event> result = eDao.findByDateAfterAndProvinceOrderByDateAsc(pageRequest, date, province);
        for (Event event : result.getContent()) {
            System.out.println(event.getName());
        }
        System.out.println("Fin");
    }
}
