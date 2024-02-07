package mx.com.pruebarsg.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import mx.com.pruebarsg.service.UsuarioDetalles;


@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
 
   
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
 
        UsuarioDetalles userDetails = (UsuarioDetalles) authentication.getPrincipal();
         
        String redirectURL = request.getContextPath();
         
        System.out.println("Entre a loginSuccess");
        if (userDetails.hasRole("ADMIN")) {
            redirectURL = "pagina_principal";
        } else if (userDetails.hasRole("VD")) {
            redirectURL = "home";
        } else if (userDetails.hasRole("ADMIN")) {
            redirectURL = "home";
        }else if (userDetails.hasRole("VL")){
            redirectURL = "inicio_vocalia_local";
        }
         
        response.sendRedirect(redirectURL);
         
    }
   
}
