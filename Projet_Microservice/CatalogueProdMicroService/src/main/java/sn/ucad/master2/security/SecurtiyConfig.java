//package sn.ucad.master2.security;
//
//@Configuration
//@EnableWebSecurity
//public class SecurtiyConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    UserService userDetailsService;
//
//    @Autowired
//    private AccessDeniedHandler accessDeniedHandler;
//
//    //@Autowired
//    //private RememberMeServices rememberMeServices;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf()
//                .disable()
//                .exceptionHandling()
//                .authenticationEntryPoint(new Http401AuthenticationEntryPoint("App header"))
//                .and()
//                .authenticationProvider(getProvider())
//                .formLogin()
//                .loginProcessingUrl("/login")
//                .successHandler(new AuthentificationLoginSuccessHandler())
//                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessHandler(new AuthentificationLogoutSuccessHandler())
//                .invalidateHttpSession(true)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/logout").permitAll()
//                .antMatchers("/user").authenticated()
//                .anyRequest().permitAll();
//    }
//
//    private class AuthentificationLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//
//        @Override
//        public void onAuthenticationSuccess(HttpServletRequest request,
//                                            HttpServletResponse response, Authentication authentication)
//                throws IOException, ServletException {
//            response.setStatus(HttpServletResponse.SC_OK);
//        }
//        private class AuthentificationLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//
//            @Override
//            public void onAuthenticationSuccess(HttpServletRequest request,
//                                                HttpServletResponse response, Authentication authentication)
//                    throws IOException, ServletException {
//                response.setStatus(HttpServletResponse.SC_OK);
//            }
//        }
//
//        private class AuthentificationLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
//
//            @Override
//            public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
//                                        Authentication authentication) throws IOException, ServletException {
//                response.setStatus(HttpServletResponse.SC_OK);
//            }
//        }
//
//        @Bean
//        public AuthenticationProvider getProvider() {
//
//            AppAuthProvider provider = new AppAuthProvider();
//            provider.setUserDetailsService(userDetailsService);
//            return provider;
//
//        }
//    }
//    }
//    