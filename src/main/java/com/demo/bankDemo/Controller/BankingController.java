package com.demo.bankDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.bankDemo.Model.User;
import com.demo.bankDemo.Service.Service;
import jakarta.transaction.Transactional;

@Controller
// @RequestMapping("/api/banking")
public class BankingController {
    
  // @Autowired
  // private final PasswordCoder passwordCoder;
   

   @Autowired
   private Service service;


   // public BankingController(PasswordCoder passwordCoder){
   //    this.passwordCoder = passwordCoder;}


    @GetMapping({"/" , "/home"})
    public String indexPage() {
        return "index";
    }

    @GetMapping("/transfer")
    public String transfer(){
        return "transfer";
    }
 
    @GetMapping("/lotto")
    public String play(){
            return "play-lotto";
        }
    
    @GetMapping("/pay")
    public String pay(){
            return "pay-bill";
        }

    @GetMapping("/airtime")
    public String airtime(){
        return "airtime";
    }    
        
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "loginPage";
    }

    @GetMapping("/logout")
    public String logout() {
        // Add code to invalidate session or clear authentication
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String form(Model model){
        model.addAttribute("user", new User());

        return"registerForm";
    }


@Transactional
@PostMapping("/register")
public String UserRegister(@ModelAttribute User user, Model model, RedirectAttributes redirectAttributes) {

    // Set default balance (optional)
    user.getBalance(); // Assuming a constant DEFAULT_BALANCE defined elsewhere

    // Hash password before saving (security best practice)
   //user.setPassword(passwordCoder.encode(user.getPassword()));

    try {
        service.saveUser(user);
        redirectAttributes.addFlashAttribute("success", "User registration successful!"); // Set success message for redirect
        return "redirect:/login";  // Redirect to login page after successful registration
    } catch (DataIntegrityViolationException e) {
        // Handle potential duplicate username exception
        redirectAttributes.addFlashAttribute("error", "Username already exists!");
        return "redirect:/register"; // Redirect back to registration page with error message
    } catch (Exception e) {
        // Handle other unexpected exceptions
        redirectAttributes.addFlashAttribute("error", "Registration failed!");
        return "redirect:/register"; // Redirect back to registration page with generic error message
    }
}

    
    ////////////////// SECURITY LOGIN/////////////////////////

    @Transactional
    @PostMapping("/login")
    public String log(@ModelAttribute User loginUser, Model model, RedirectAttributes redirectAttributes) {
    // Find user by username
    User user = service.findByUsername(loginUser.getUsername());

    // Check if user exists and credentials match
    if (user != null && user.getUsername().equals(loginUser.getUsername())) {
        // Add user to model for welcome page
        model.addAttribute("user", user);
        return "welcome";
    } else {
        // Add error message for redirect
        redirectAttributes.addFlashAttribute("error", "Invalid username");
        return "redirect:/login";
    }
}

    
   /* 

    @PostMapping("/login")
    public String login(@ModelAttribute User loginUser, Model model, RedirectAttributes redirectAttributes) {
    // Find user by username
    User user = service.findByUsername(loginUser.getUsername());

    // Check if user exists
    if (user == null) {
        // Add error message for redirect (invalid username)
        redirectAttributes.addFlashAttribute("error", "Invalid username");
        return "redirect:/login";
    }

    // Check if password is correct
    if (!passwordCoder.matches(loginUser.getPassword(), user.getPassword())) {
        // Add error message for redirect (invalid password)
        redirectAttributes.addFlashAttribute("error", "Invalid password");
        return "redirect:/login";
    }

    // Add user to model for welcome page
    model.addAttribute("user", user);
    return "welcome";
}
*/



}


