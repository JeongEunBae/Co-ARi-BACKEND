package com.cse.coari.web.controller.users;

import com.cse.coari.service.users.UsersService;
import com.cse.coari.web.dto.users.UsersResponseDto;
import com.cse.coari.web.dto.users.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/users")
public class UsersApiController {
    private final UsersService usersService;

    @PostMapping
    public Long save(@RequestBody UsersSaveRequestDto requestDto) {
        return usersService.save(requestDto);
    }

    @GetMapping(value = "/{user_id}")
    public UsersResponseDto findById(@PathVariable Long user_id) {
        return usersService.findById(user_id);
    }

    @DeleteMapping(value = "/{user_id}")
    public Long delete(@PathVariable Long user_id) {
        usersService.delete(user_id);
        return user_id;
    }
}
