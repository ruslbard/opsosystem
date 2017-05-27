package com.tsystems.jschool20.controllers;

import com.tsystems.jschool20.srvengine.api.AccountService;
import com.tsystems.jschool20.srvengine.api.ContractService;
import com.tsystems.jschool20.srvengine.dtos.DTOAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ruslbard on 24.04.2017.
 */
@Controller
public class CommonController {

    @Autowired
    AccountService accountService;
    ContractService contractService;

    @RequestMapping(value = "/common")
    public String showCommonLoginForm(Model model) {

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        DTOAccount dto = accountService.getAccountByLogin(principal.getUsername());
        model.addAttribute("account", dto);
        return "userMainForm";
    }

    @RequestMapping(value = "/startPage")
    public String showStartPage(Model model){

        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
            User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            String redirectUrl = null;

            for (GrantedAuthority grantedAuthority : principal.getAuthorities()) {
                if (grantedAuthority.getAuthority().compareTo("ROLE_CLIENT") == 0) {
                    redirectUrl = "redirect:/common";
                } else if (grantedAuthority.getAuthority().compareTo("ROLE_OPERATOR") == 0) {
                    redirectUrl = "redirect:/operator";
                } else if (grantedAuthority.getAuthority().compareTo("ROLE_ADMIN") == 0) {
                    redirectUrl = "redirect:/admin";
                }
            }

            return redirectUrl;
        }

        return "redirect:/admin";
    }

    @RequestMapping(value = "/")
    public String redirectToStartPage(){
        return "redirect:/startPage";
    }

    @RequestMapping(value = "/common/showChangeContractRate")
    public String showChangeContractRate(Model model){

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        DTOAccount dto = accountService.getAccountByLogin(principal.getUsername());
        model.addAttribute("account", dto);
        return "changeContractRate";
    }

    @RequestMapping(value = "/common/showChangeContractOptionsSet")
    public String showChangeContractOptionsSet(Model model){

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        DTOAccount dto = accountService.getAccountByLogin(principal.getUsername());
        model.addAttribute("account", dto);
        return "changeContractOptionsSet";
    }

    private UserDetails getPrincipal() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return (UserDetails) principal;
        } else {
            return null;
        }
    }
}