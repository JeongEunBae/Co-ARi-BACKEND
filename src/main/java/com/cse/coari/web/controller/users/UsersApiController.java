package com.cse.coari.web.controller.users;

import com.cse.coari.service.users.UsersService;
import com.cse.coari.web.dto.users.UsersListResponseDto;
import com.cse.coari.web.dto.users.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/users")
public class UsersApiController {
    private final UsersService usersService;

    @PostMapping
    public Long save(@RequestBody UsersSaveRequestDto requestDto) {
        return usersService.save(requestDto);
    }

    @GetMapping(value = "/{userID}")
    public List<UsersListResponseDto> findByUserID(@PathVariable String userID) {
        System.out.println(userID);
        return usersService.findByUserID(userID);
    }
}
