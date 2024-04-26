package org.launchcode.skillstracker.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillsController {

    @GetMapping
    public String skillsTrackerHomePage(){
        return "<html>" +
                "<body>" +
                "<h1>Skills Tracker</h1>" +
                "<div></div>" +
                "<h2>We have a few skills we would like to learn. Here is the  list!" +
                "<div></div>" +
                "<ol>" +
                "<li>Java</li>" +
                "<li>JavaScript</li>" +
                "<li>Python</li>" +
                "</ol>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("form")
    public String skillsForm(){
        String selectMenu =
                "<option value='Select'>"+"Select"+"</option>"+
                "<option value='Java'>"+"Java"+"</option>" +
                "<option value='JavaScript'>"+"JavaScript"+"</option>" +
                "<option value='Python'>"+"Python"+"</option>" +
                "</select>";

        return "<html>" +
                "<body>" +
                "<form action='/form' method='post'>" +
                "<div>Name:</div>" +
                "<input type='text' name='name'>" +
                "<div></div>" +
                "<div>My favorite language:</div>" +
                "<select name='language1'>" +
                selectMenu +
                "<div>My second favorite language:</div>" +
                "<select name='language2'>" +
                selectMenu +
                "<div>My third favorite language:</div>" +
                "<select name='language3'>" +
                selectMenu +
                "<div></div>" +
                "<input type='submit' value='Submit'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @PostMapping("form")
    public String formPost(@RequestParam String name, @RequestParam String language1, @RequestParam String language2, @RequestParam String language3){
        if(name.equals("")){
            name="Anonymous User";
        }
        return submitForm(name, language1, language2, language3);
    }

    public static String submitForm(String n, String l1, String l2, String l3){
        return "<h1>" + n + "</h1>" +
                "<div></div>" +
                "<ol>" +
                "<li>" +
                l1 +
                "<li>" +
                l2 +
                "<li>" +
                l3 +
                "</ol>";
    }
}
