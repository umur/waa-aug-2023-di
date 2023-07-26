package app;

import reflection.example.di.annotations.Component;
import reflection.example.di.annotations.InjectField;

@Component
public class UserService {

    @InjectField
    private UserRepository userRepository;
}
