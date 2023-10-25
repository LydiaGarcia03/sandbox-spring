package com.br.findYourPet.userAccount;

import com.br.findYourPet.userAccount.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}
