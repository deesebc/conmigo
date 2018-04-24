package com.conmigo.app.bbdd.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
        LocalDateTime date = LocalDateTime.now();
        Province province = new Province();
        province.setId(3L);
        List<Event> result = eDao.findTop5ByDateAfterAndProvinceOrderByDateAsc(date, province);
        for (Event event : result) {
            System.out.println(event.getName());
        }
        System.out.println("Fin");
    }
}
