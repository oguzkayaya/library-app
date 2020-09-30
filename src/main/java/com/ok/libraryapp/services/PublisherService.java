package com.ok.libraryapp.services;

import com.ok.libraryapp.models.Publisher;
import com.ok.libraryapp.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> getPublishers() {
        return publisherRepository.findAll();
    }

    public void savePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void deletePublisher(int id) {
        publisherRepository.deleteById(id);
    }

    public void updatePublisher(Publisher publisher, int id) {
        Publisher p = publisherRepository.findById(id).get();
        p.setName(publisher.getName());
        p.setDescription(publisher.getDescription());
        publisherRepository.save(p);
    }

    public Publisher getPublisher(int id) {
        return publisherRepository.findById(id).get();
    }

}
