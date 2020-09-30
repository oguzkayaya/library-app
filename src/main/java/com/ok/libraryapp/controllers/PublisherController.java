package com.ok.libraryapp.controllers;

import com.ok.libraryapp.models.Publisher;
import com.ok.libraryapp.services.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PublisherController {

    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @RequestMapping(value = "/publishers", method = RequestMethod.GET)
    public String getPublishers(Model model) {
        List<Publisher> publishers = publisherService.getPublishers();
        model.addAttribute("publishers", publishers);
        return "/publisher/publisherList";
    }

    @RequestMapping(value = "/publishers/new", method = RequestMethod.GET)
    public String showPublisherForm() {
        return "/publisher/publisherForm";
    }

    @RequestMapping(value = "/publishers", method = RequestMethod.POST)
    public String addPublisher(Publisher publisher, Model model) {
        publisherService.savePublisher(publisher);
        return "redirect:/publishers";
    }

    @RequestMapping(value = "/publishers/delete/{id}", method = RequestMethod.GET)
    public String deletePublisher(@PathVariable int id){
        publisherService.deletePublisher(id);
        return "redirect:/publishers";
    }

    @RequestMapping(value = "/publishers/update/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable int id, Model model){
        Publisher publisher = publisherService.getPublisher(id);
        model.addAttribute("updatePublisher", publisher);
        return "/publisher/publisherUpdateForm";
    }

    @RequestMapping(value = "/publishers/update/{id}", method = RequestMethod.POST)
    public String updatePublisher(@PathVariable int id, Publisher newPublisher){
        publisherService.updatePublisher(newPublisher, id);
        return "redirect:/publishers";
    }
}
