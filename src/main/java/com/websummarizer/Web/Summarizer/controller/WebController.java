package com.websummarizer.Web.Summarizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Controller
public class WebController {

    @PostMapping("/api/summary")
    String getSummary(Model model) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd h:mm:ss a");
        Date date = new Date();

        model.addAttribute("date", dateFormat.format(date));
        model.addAttribute("input", "input text");
        model.addAttribute("output", "<< Example Data from WebController >> The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog<br /><br />The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog << END >>");
        return "api/summary";
    }

}
