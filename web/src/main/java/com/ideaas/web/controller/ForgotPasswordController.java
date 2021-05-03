package com.ideaas.web.controller;

import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.service.ColaboradorNotFoundException;
import com.ideaas.services.service.interfaces.ColaboradorService;
import com.ideaas.web.configuration.Utility;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class ForgotPasswordController {

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/forgotPassword")
    public String forgotPassword() {
        return "forgotPassword";
    }

    @PostMapping("/forgotPassword")
    public String processForgotPasswordForm(HttpServletRequest request, Model model){
        String email = request.getParameter("email");
        String token = RandomString.make(45);

        try {
            colaboradorService.updateResetPassword(token, email);
            String resetPasswordLink = Utility.getSiteUrl(request) + "/resetPassword?token=" + token;
            sendEmail(email, resetPasswordLink);
        } catch (ColaboradorNotFoundException | UnsupportedEncodingException | MessagingException e) {
            model.addAttribute("error", e.getMessage());
        }

        System.out.println("Email: " + email);
        System.out.println("Token: " + token);

        return "forgotPassword";
    }

    private void sendEmail(String email, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("contacto@gestal.com", "Soporte Gestal");
        helper.setTo(email);
        String subject = "Aquí está el enlace para restablecer su contraseña";
        String content = "<p>Hola, </p>"
                + "<p>Ha solicitado restablecer su contraseña</p>"
                + "<p>Haga clic en el enlace de abajo para cambiar su contraseña</p>"
                + "<p><b><a href=\"" + resetPasswordLink + "\">Cambiar contraseña</a><b></p>"
                + "<p>Ignore este correo electrónico si recuerda su contraseña o no ha realizado la solicitud.</p>";
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }

    @GetMapping("/resetPassword")
    public String showResetPasswordForm(@Param(value = "token") String token, Model model){
        Colaborador colaborador = colaboradorService.get(token);
        if (colaborador == null){
            model.addAttribute("title", "Restablecer su contraseña");
            model.addAttribute("message", "Token invalido");
            return "message";
        }
        model.addAttribute("token", token);
        return "resetPassword";
    }

    @PostMapping("/resetPassword")
    public String processResetPassword(HttpServletRequest request, Model model){
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        Colaborador colaborador = colaboradorService.get(token);
        if (colaborador == null){
            model.addAttribute("title", "Restablecer su contraseña");
            model.addAttribute("message", "Token invalido");
            return "message";
        }else {
            colaboradorService.updatePassword(colaborador, password);
            model.addAttribute("message", "Has cambiado satisfactoriamente tu contraseña");
        }
        return "login";
    }
}
