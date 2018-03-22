package com.teamtreehouse.giflib.data;

import com.teamtreehouse.giflib.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

// act as our storage device for the gif objects
@Component
//@Repository //--> lets spring know this is a valid spring component
public class GifRepository {
    // storage device acting db
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", LocalDate.of(2015,2,13), "Chris Ramacciotti", false),
            new Gif("ben-and-mike", LocalDate.of(2015,10,30), "Ben Jakuben", true),
            new Gif("book-dominos", LocalDate.of(2015,9,15), "Craig Dennis", false),
            new Gif("compiler-bot", LocalDate.of(2015,2,13), "Ada Lovelace", true),
            new Gif("cowboy-coder", LocalDate.of(2015,2,13), "Grace Hopper", false),
            new Gif("infinite-andrew", LocalDate.of(2015,8,23), "Marissa Mayer", true)
    );

    // return a gif object from name
    public Gif findByName(String name) {
        // loop through list with enhanced for loop
        for(Gif gif : ALL_GIFS) {
            if(gif.getName().equals(name)) {
                return gif;
            }
        }
        // if no matching
        return null;
    }

    // return all the Gif objects
    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }
}
