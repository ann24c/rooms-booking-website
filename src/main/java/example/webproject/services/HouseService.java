package example.webproject.services;

import example.webproject.Entities.House;
import example.webproject.repositories.HouseRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService {
    @Autowired
    private HouseRepository houseRepository;
    public List<House> getAllHouses(){
        return houseRepository.findAll();
    }
}
