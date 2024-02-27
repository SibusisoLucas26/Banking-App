package com.demo.bankDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.bankDemo.Model.User;
import com.demo.bankDemo.Repo.UserRepository;
import com.demo.bankDemo.Requests.UserLoginRequest;

import jakarta.transaction.Transactional;

@Controller
// @RequestMapping("/api/banking")
public class BankingController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "loginPage";
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("user", new User());

        return"registerForm";
    }

    @Transactional
    @PostMapping("/register")
    public String UserRegister(@ModelAttribute User user, Model model) {
        long defaultBalance = 5000000;
        User newUser = new User(user.getUsername(),user.getPassword(),user.getAccountNumber(),defaultBalance);
           
        userRepository.save(newUser);
               
        model.addAttribute("balance",defaultBalance);
        model.addAttribute("user",newUser);
        
        return"index";
    }
   
    @PostMapping("/submit")
    public String login(@ModelAttribute User loginUser, Model model, RedirectAttributes redirectAttributes) {
    User user = userRepository.findByUsernameAndPassword(loginUser.getUsername(), 
    loginUser.getPassword());
        
    if (user.getUsername().equals(loginUser.getUsername()) && user.getPassword().equals(loginUser.getPassword())) {
        // Add user to model for welcome page
        model.addAttribute("user", user);
        return "welcome";
    } else {
        // Redirect to index page with an error message
        redirectAttributes.addFlashAttribute("error", "Invalid /username or password");
        return "index";
    }
}

/*
    @PostMapping("/deposit")
    public String deposit(@RequestBody TransactionRequest transactionRequest) {
        Account account = accountRepository.findById(transactionRequest.getUsername()).orElse(null);

        if (account != null) {
            account.setBalance((long) (account.getBalance() + transactionRequest.getAmount()));
            accountRepository.save(account);
            return "Deposit successful" + account.getBalance();
        } else {
            return "Account not found";
        }
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestBody TransactionRequest transactionRequest) {
        Account account = accountRepository.findById(transactionRequest.getUsername()).orElse(null);

        if (account != null) {
            if (account.getBalance() >= transactionRequest.getAmount()) {
                account.setBalance((long) (account.getBalance() - transactionRequest.getAmount()));
                accountRepository.save(account);
                return "Withdrawal successful. New balance: $" + account.getBalance();
            } else {
                return "Insufficient funds. Withdrawal failed.";
            }
        } else {
            return "Account not found.";
        }
    

    

    @GetMapping("/balance/{username}")
    public double getBalance(@PathVariable String username) {
        Account account = accountRepository.findById(username).orElse(null);

        if (account != null) {
            return account.getBalance();
        } else {
            return -1;
        }
    }

    }*/

}
