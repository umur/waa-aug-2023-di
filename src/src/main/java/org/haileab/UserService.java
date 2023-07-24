package org.haileab;

import org.haileab.UserRepository;
import org.haileab.framework.DI_HaileabWay;

public class UserService {
    @DI_HaileabWay
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
