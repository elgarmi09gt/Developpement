//package sn.ucad.master2.service;
//
//@Service
//@Slf4j
//public class UtilisateurService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Objects.requireNonNull(email);
//        return userRepository.findUserWithName(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }
//
//}