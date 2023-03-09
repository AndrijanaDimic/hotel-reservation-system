package com.raf.bookuserservice.runner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.raf.bookreservationservice.domain.RoomType;
import com.raf.bookreservationservice.domain.RoomTypeValue;
import com.raf.bookreservationservice.repository.RoomTypeValueRepository;



@Profile({"default"})
@Component
public class TestDataRunner implements CommandLineRunner {

    private RoomTypeValueRepository roomTypeValueRepository;
 

    public TestDataRunner(RoomTypeValueRepository roomTypeValueRepository) {
        this.roomTypeValueRepository = roomTypeValueRepository;
      
    }

    @Override
    public void run(String... args) throws Exception {
        //Insert roles
    	Long i = (long) 1;
    	double b = 20;
        roomTypeValueRepository.save(new RoomTypeValue(i, b,  RoomType.A));
        roomTypeValueRepository.save(new RoomTypeValue(i + 1, b, RoomType.B));
        roomTypeValueRepository.save(new RoomTypeValue(i + 2, b, RoomType.C));
    
    
    }
}
