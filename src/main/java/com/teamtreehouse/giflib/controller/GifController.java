package com.teamtreehouse.giflib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GifController {
    @RequestMapping("/")
    public String listGifs() {
        // return index.html home page
        return "index";
    }

    @RequestMapping("/gif")
    public String getGif() {
        return "A single gif";
    }
}
