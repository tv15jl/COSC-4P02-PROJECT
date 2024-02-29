package com.websummarizer.Web.Summarizer.controller;

import com.websummarizer.Web.Summarizer.controller.history.HistoryResAto;
import com.websummarizer.Web.Summarizer.services.history.HistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@Slf4j
public class ShortLinkController {
    @Autowired
    private HistoryService historyService;

    // Get a short link for a summarize
    @GetMapping("/{shortlink}")
    public ResponseEntity<HistoryResAto> getShortLink(@PathVariable String shortlink) {
        log.info("Get history request received : " + shortlink);
        var historyResAto = historyService.getShortLink(shortlink);
        log.info("Get history request processed : " + historyResAto);
        return ResponseEntity.ok(historyResAto);
    }
}