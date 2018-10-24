//package sn.ucad.master2.security;
//
//public class AuthenticationProvider extends DaoAuthenticationProvider {
//
//    @Autowired
//    UserService userDetailsService;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
//
//        String name = auth.getName();
//        String password = auth.getCredentials()
//                .toString();
//
//        UserDetails user = userDetailsService.loadUserByUsername(name);
//
//        if (user == null) {
//            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
//        }
//
//        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return true;
//
//    }
//}