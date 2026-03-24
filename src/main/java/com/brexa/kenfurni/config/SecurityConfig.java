package com.brexa.kenfurni.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.brexa.kenfurni.service.MemberDetailsService;
import com.brexa.kenfurni.service.StaffDetailsService;

/**
 * Spring Security設定クラス
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final MemberDetailsService memberDetailsService;
    private final StaffDetailsService staffDetailsService;

    public SecurityConfig(MemberDetailsService memberDetailsService,
            StaffDetailsService staffDetailsService) {
        this.memberDetailsService = memberDetailsService;
        this.staffDetailsService = staffDetailsService;
    }

    /**
     * 管理側セキュリティ設定（Order(1)で優先）
     *
     * @param http HttpSecurityオブジェクト
     * @return SecurityFilterChain
     * @throws Exception 設定例外
     */
    @Bean
    @Order(1)
    public SecurityFilterChain adminFilterChain(HttpSecurity http) throws Exception {
        http
            .securityMatcher("/admin/**")
            .userDetailsService(staffDetailsService)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/admin/login").permitAll()
                .requestMatchers("/admin/send/**", "/admin/stock/**").hasAnyRole(
                        "STAFF_FULL", "STAFF_CONTRACT", "STAFF_OUTSOURCE", "STAFF_PART", "STAFF_OTHER")
                .requestMatchers("/admin/earnings/**", "/admin/members/**").hasAnyRole(
                        "STAFF_FULL", "STAFF_OUTSOURCE")
                .requestMatchers("/admin/products/**", "/admin/categories/**").hasAnyRole(
                        "STAFF_FULL", "STAFF_CONTRACT")
                .requestMatchers("/admin/staff/**").hasRole("STAFF_FULL")
                .anyRequest().hasAnyRole(
                        "STAFF_FULL", "STAFF_CONTRACT", "STAFF_OUTSOURCE", "STAFF_PART", "STAFF_OTHER")
            )
            .formLogin(form -> form
                .loginPage("/admin/login")
                .loginProcessingUrl("/admin/login")
                .usernameParameter("staffName")
                .passwordParameter("password")
                .defaultSuccessUrl("/admin/menu", true)
                .failureUrl("/admin/login?error")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/admin/login?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            );

        return http.build();
    }

    /**
     * ユーザー側セキュリティ設定
     *
     * @param http HttpSecurityオブジェクト
     * @return SecurityFilterChain
     * @throws Exception 設定例外
     */
    @Bean
    @Order(2)
    public SecurityFilterChain userFilterChain(HttpSecurity http) throws Exception {
        http
            .securityMatcher("/", "/top", "/products/**", "/member/**", "/cart/**",
                             "/purchase/**", "/login", "/logout", "/error")
            .userDetailsService(memberDetailsService)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/login", "/member/register", "/member/register/**",
                                 "/member/password-reset").permitAll()
                .requestMatchers("/cart/**", "/purchase/**", "/member/mypage/**",
                                 "/member/history").authenticated()
                .anyRequest().permitAll()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/top", true)
                .failureUrl("/login?error")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            );

        return http.build();
    }

    /**
     * パスワードエンコーダー
     *
     * @return NoOpPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}