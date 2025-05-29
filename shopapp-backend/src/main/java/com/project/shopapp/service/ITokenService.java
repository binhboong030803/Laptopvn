package com.project.shopapp.service;

import com.project.shopapp.models.Token;
import com.project.shopapp.models.User;
import org.springframework.stereotype.Service;

@Service
public interface ITokenService {
    Token addToken(User user, String token, boolean isMobileDevice);

    //Token refreshToken(String refreshToken, User user) throws Exception;
}
