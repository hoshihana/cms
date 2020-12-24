package team.cms.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.cms.entity.Account;
import team.cms.entity.Hotel;
import team.cms.entity.enums.Role;
import team.cms.result.AdminHotelResult;
import team.cms.result.CountResult;
import team.cms.result.Result;
import team.cms.service.AccountService;
import team.cms.service.HotelService;
import team.cms.util.CipherUtil;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/admin/hotel")
public class AdminHotelController {

    @Resource
    private HotelService hotelService;

    @Resource
    private AccountService accountService;

    @PostMapping("/count")
    public CountResult getHotelNumber() {
        return new CountResult(hotelService.getAll().size());
    }

    @PostMapping("/getAll")
    public List<AdminHotelResult> getAllHotel() {
        List<AdminHotelResult> resultList = new LinkedList<>();
        List<Hotel> tempList = hotelService.getAll();

        for (Hotel hotel : tempList) {
            String username = accountService.getAccountById(hotel.getAccountId()).getUsername();
            resultList.add(new AdminHotelResult(hotel.getAccountId(), username, hotel.getId(), hotel.getName()));
        }

        return resultList;
    }

    @PostMapping("/profile/get")
    public Hotel getHotelById(Integer hotelId) {
        return hotelService.getHotelById(hotelId);
    }

    @PostMapping("/profile/modify")
    public Result modifyHotelProfile(Integer hotelId, String name, String address, String detail, String telephone) {

        Hotel hotel = new Hotel();
        hotel.setId(hotelId);
        hotel.setName(name);
        hotel.setDetail(detail);
        hotel.setAddress(address);
        hotel.setTelephone(telephone);
        hotelService.modifyHotel(hotel);
        return new Result(true, null);
    }

    @PostMapping("/password/modify")
    public Result modifyHotelPassword(Integer hotelId, String password) {

        Integer accountId = hotelService.getHotelById(hotelId).getAccountId();

        Account account = new Account();
        account.setId(accountId);
        account.setPassword(CipherUtil.encipherText(password));

        accountService.modifyPassword(account);

        return new Result(true, null);
    }

    @PostMapping("/add")
    public Result addHotelAccount(String username, String password,String name,String address,String detail,String telephone) {
        hotelService.addHotel(username, CipherUtil.encipherText(password),name,address,detail,telephone);
        return new Result(true, null);
    }
}
