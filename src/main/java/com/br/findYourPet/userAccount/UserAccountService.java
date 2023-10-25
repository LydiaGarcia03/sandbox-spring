package com.br.findYourPet.userAccount;

import com.br.findYourPet.userAccount.dto.UserAccountDto;
import com.br.findYourPet.userAccount.model.UserAccount;
import com.br.findYourPet.utils.Mapper;
import com.br.findYourPet.utils.RequestResponse;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    private final UserAccountRepository repository;

    private final Mapper<UserAccountDto, UserAccount> mapper;

    public UserAccountService(UserAccountRepository repository, Mapper<UserAccountDto, UserAccount> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public RequestResponse<UserAccountDto> getUserAccount(final Long userAccountId) {
        final UserAccount entity = this.repository.getReferenceById(userAccountId);
        return RequestResponse.ok(this.mapper.mapEntityToDto(entity, UserAccountDto.class));
    }

    public RequestResponse<UserAccountDto> createUserAccount(final UserAccountDto dto) {
        this.repository.save(this.mapper.mapDtoToEntity(dto, UserAccount.class));
        return RequestResponse.ok(dto);
    }

    public RequestResponse<UserAccountDto> updateUserAccount(final UserAccountDto dto, final Long userAccountId) {
        final UserAccount entity = this.repository.getReferenceById(userAccountId);
        this.mapper.mapDtoToEntity(dto, UserAccount.class);
        this.repository.save(entity);
        return RequestResponse.ok(dto);
    }

    public RequestResponse<UserAccountDto> deleteUserAccount(final Long userAccountId) {
        final UserAccount entity = this.repository.getReferenceById(userAccountId);
        this.repository.deleteById(userAccountId);
        return  RequestResponse.ok(this.mapper.mapEntityToDto(entity, UserAccountDto.class));
    }
}
