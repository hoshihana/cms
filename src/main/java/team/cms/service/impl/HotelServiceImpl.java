package team.cms.service.impl;

import org.springframework.stereotype.Service;
import team.cms.entity.Account;
import team.cms.entity.Hotel;
import team.cms.entity.enums.Role;
import team.cms.repository.AccountRepository;
import team.cms.repository.HotelRepository;
import team.cms.service.HotelService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Resource
    private AccountRepository accountRepository;

    @Resource
    private HotelRepository hotelRepository;

    @Override
    public Hotel getHotelByAccountId(Integer accountId) {
        return hotelRepository.getHotelByAccountId(accountId);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.getAll();
    }

    @Override
    public Hotel getHotelById(Integer id) {
        return hotelRepository.getHotelById(id);
    }

    @Override
    public void addHotel(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setRole(Role.HOTEL);
        accountRepository.addAccount(account);
        hotelRepository.addHotel(account.getId());
    }

    @Override
    public void modifyHotel(Hotel hotel) {
        hotelRepository.modifyHotel(hotel);
    }
}
