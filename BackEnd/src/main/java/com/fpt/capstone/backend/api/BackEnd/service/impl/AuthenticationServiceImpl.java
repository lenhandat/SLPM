package com.fpt.capstone.backend.api.BackEnd.service.impl;


import com.fpt.capstone.backend.api.BackEnd.dto.UserLoginDto;
import com.fpt.capstone.backend.api.BackEnd.dto.UserRegisterDTO;
import com.fpt.capstone.backend.api.BackEnd.entity.ApiResponse;
import com.fpt.capstone.backend.api.BackEnd.entity.Users;
import com.fpt.capstone.backend.api.BackEnd.entity.sercurity.security.TokenResponseInfo;
import com.fpt.capstone.backend.api.BackEnd.repository.UserRepository;
import com.fpt.capstone.backend.api.BackEnd.service.AuthenticationService;
import com.fpt.capstone.backend.api.BackEnd.utils.security.JwtUtils;
import lombok.AllArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private final JwtUtils jwtUtils;

   // private final CommonProperties commonProperties;

    //private final MailServiceImpl mailService;

    private  AuthenticationManager authenticationManager;

    //private final CommonUtils utils;

    @Override
    public ResponseEntity<?> authenticate(UserLoginDto userLoginDto) throws AuthenticationException {
        if ((userLoginDto.getEmail().trim().isEmpty())
                || (userLoginDto.getPassword().trim()).isEmpty()) {
            logger.error("Parameter invalid!");
            return ResponseEntity.status(401).body(
                    ApiResponse.builder()
                            .success(false)
                            .message("Parameter invalid!").build()
            );
        }
        Users user = userRepository.findByEmail(userLoginDto.getEmail()).get();

        if (user.getStatus().equals("inactive")) {
            logger.error("Account INACTIVE!");
            return ResponseEntity.status(401).body(
                    ApiResponse.builder()
                            .success(false)
                            .message("Account INACTIVE!").build()
            );
        }

        TokenResponseInfo tokenResponseInfo = jwtUtils.generateTokenResponseInfo(userLoginDto.getEmail(), userLoginDto.getPassword(), authenticationManager);

        logger.info("authenticate Ok!");
        return ResponseEntity.ok().body(
                ApiResponse.builder()
                        .success(true)
                        .message("Login success")
                        .data(tokenResponseInfo).build()
        );

    }
    @Autowired
    private JavaMailSender mailSender;

@Autowired
private ModelMapper modelMapper;
    public void register(UserRegisterDTO user, String siteURL)
        throws UnsupportedEncodingException, MessagingException {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            String randomCode = RandomString.make(64);
            user.setVerificationCode(randomCode);
            user.setEnabled(false);
            userRepository.save(modelMapper.map(user,Users.class));
            sendVerificationEmail(user, siteURL);

    }

    private void sendVerificationEmail(UserRegisterDTO user, String siteURL)
       throws MessagingException, UnsupportedEncodingException {
            String toAddress = user.getEmail();
            String fromAddress = "Your email address";
            String senderName = "Your company name";
            String subject = "Please verify your registration";
            String content = "Dear [[name]],<br>"
                    + "Please click the link below to verify your registration:<br>"
                    + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                    + "Thank you,<br>"
                    + "Your company name.";

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom(fromAddress, senderName);
            helper.setTo(toAddress);
            helper.setSubject(subject);

            content = content.replace("[[name]]", user.getFullName());
            String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();

            content = content.replace("[[URL]]", verifyURL);

            helper.setText(content, true);

            mailSender.send(message);
    }


        @Override
    public ResponseEntity<?> getVerifyCode(String email) throws Exception {
//        if (StringUtils.isEmpty(email.trim())) {
//            logger.error("Parameter invalid!");
//            return ResponseEntity.badRequest().body(
//                    ApiResponse.builder()
//                            .code(commonProperties.getCODE_UPDATE_FAILED())
//                            .message(commonProperties.getMESSAGE_PARAM_VALUE_EMPTY()).build()
//            );
//        }
//        User user = userRepository.findByEmail(email).orElse(null);
//
//        if (user == null) {
//            logger.error("Email is not correct");
//            return ResponseEntity.badRequest().body(
//                    ApiResponse.builder()
//                            .code(commonProperties.getCODE_UPDATE_FAILED())
//                            .message("Email này không tồn tại trong hệ thống!").build()
//            );
//        }
//
//
//        String verifyCode = utils.generateRandomCode(commonProperties.getCodeSize());
//
//        try {
//            mailService.createMailVerifyCode(email, verifyCode);
//        } catch (Exception ignored) {
//            return ResponseEntity.ok().body(
//                    ApiResponse.builder()
//                            .code(commonProperties.getCODE_UPDATE_FAILED())
//                            .message("Không thể gửi mail!").build()
//            );
//        }
//
//        String newPassword = passwordEncoder.encode(verifyCode);
//        user.setPassword(newPassword);
//        userRepository.save(user);
//
//        return ResponseEntity.ok().body(
//                ApiResponse.builder()
//                        .code(commonProperties.getCODE_UPDATE_SUCCESS())
//                        .message(commonProperties.getMESSAGE_SUCCESS()).build()
//        );
        return null;
    }

}
