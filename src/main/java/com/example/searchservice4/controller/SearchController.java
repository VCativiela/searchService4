package com.example.searchservice4.controller;

import com.example.searchservice4.model.Message;
import com.example.searchservice4.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/all")
    public List<Message> searchAllMessages() {
        return searchService.getMessages();
    }

    @GetMapping("/hashtag/{hashtag}")
    public List<Message> searchByHashtag(@PathVariable("hashtag") String hashtagToSearch) {
        return searchService.searchByHashtag(hashtagToSearch);
    }

    @GetMapping("/text/{text}")
    public List<Message> searchByText(@PathVariable("text") String textToSearch) {
        return searchService.searchByText(textToSearch);
    }

}
