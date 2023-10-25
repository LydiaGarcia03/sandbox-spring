package com.br.findYourPet.userAccount;

import com.br.findYourPet.userAccount.dto.UserAccountDto;
import com.br.findYourPet.utils.RequestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userAccount")
public class UserAccountController {

    private final UserAccountService service;


    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @GetMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getUserAccount(final @RequestParam Long userAccountId) {
        final RequestResponse<UserAccountDto> foundUser = this.service.getUserAccount(userAccountId);
        return ResponseEntity.status(HttpStatus.OK).body(foundUser);
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createUserAccount(final @RequestBody UserAccountDto dto) {
        final RequestResponse<UserAccountDto> createdUser = this.service.createUserAccount(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PatchMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateUserAccount(final @RequestBody UserAccountDto dto, final @RequestParam Long userAccountId) {
        final RequestResponse<UserAccountDto> updatedUser = this.service.updateUserAccount(dto, userAccountId);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @DeleteMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> deleteUserAccount(final @RequestParam Long userAccountId) {
        final RequestResponse<UserAccountDto> deletedUser = this.service.deleteUserAccount(userAccountId);
        return ResponseEntity.status(HttpStatus.OK).body(deletedUser);
    }


}
