package com.teamtreehouse.giflib.controller;

import com.teamtreehouse.giflib.data.GifRepository;
import com.teamtreehouse.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class GifController {
    @Autowired //-> tells spring to construct and assign a gif repo instance when it's needed
    private GifRepository gifRepository;

//    @Autowired
//    public GifController(GifRepository gifRepository) {
//        this.gifRepository = gifRepository;
//    }

    @RequestMapping("/")
    public String listGifs(ModelMap modelMap) {
        // return index.html home page
        List<Gif> gifList = gifRepository.getAllGifs();
        // add gif list to the model map
        modelMap.put("gifList", gifList);
        return "home";
    }

    @RequestMapping(path = "/gif/{gifName}", method = RequestMethod.GET)
    public String gifDetails(@PathVariable("gifName") String gifName, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(gifName);
        // add gif object to the model map
        modelMap.put("gif", gif);
        // return gif-details.html
        return "gif-details";
    }
}
