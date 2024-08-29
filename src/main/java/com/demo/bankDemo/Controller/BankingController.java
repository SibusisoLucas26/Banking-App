package com.demo.bankDemo.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.bankDemo.Model.AirtimeRequest;
import com.demo.bankDemo.Model.BillPaymentRequest;
import com.demo.bankDemo.Model.TransferRequest;
import com.demo.bankDemo.Model.User;
import com.demo.bankDemo.Repo.UserRepository;
import com.demo.bankDemo.Service.Service;

@Controller
// @RequestMapping("/api/banking")
public class BankingController {

    @Autowired
    private PasswordCoder passwordCoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Service service;

    // public BankingController(PasswordCoder passwordCoder){
    // this.passwordCoder = passwordCoder;}

    @GetMapping({ "/home" })
    public String indexPage() {
        return "index";
    }

    //////////////// React API ///////////////////////////////
    // PostMapping //

    //////////////////////////
    @PostMapping("/pay-bills")
    public ResponseEntity<String> paybills(@RequestBody BillPaymentRequest billPaymentRequest) {
        return ResponseEntity.ok("bill payment was successful");
    }

    @PostMapping("/buy-airtime")
    public ResponseEntity<String> buyAirtime(@RequestBody AirtimeRequest airtimeRequest) {
        return ResponseEntity.ok("airtime purchase successful");
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(@RequestBody TransferRequest transferRequest) {
        return ResponseEntity.ok("transfer was successful");
    }

    ////////////////////////////////////////////////////////

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "loginPage";
    }

    @GetMapping("/logout")
    public String logout() {
        // Add code to invalidate session or clear authentication
        return "redirect:/home";
    }

    @GetMapping("/register")
    public String form(Model model) {
        model.addAttribute("user", new User());

        return "forward:/index.html";
    }

    // @Transactional
    // @PostMapping("/register")
    public String UserRegister(@ModelAttribute User user, Model model, RedirectAttributes redirectAttributes) {

        // Set default balance (optional)
        user.getBalance(); // Assuming a constant DEFAULT_BALANCE defined elsewhere

        // Hash password before saving (security best practice)
        user.setPassword(passwordCoder.encode(user.getPassword()));

        try {
            service.saveUser(user);
            redirectAttributes.addFlashAttribute("success", "User registration successful!"); // Set success message for
                                                                                              // redirect
            return "redirect:/login"; // Redirect to login page after successful registration
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

    @GetMapping("/welcome")
    public String welcome(Model model, Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        model.addAttribute("user", user);
        return "welcome";
    }

}
