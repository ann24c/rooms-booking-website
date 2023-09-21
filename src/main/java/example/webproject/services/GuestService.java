package example.webproject.services;

import example.webproject.Entities.Guest;
import example.webproject.repositories.GuestRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;

}
