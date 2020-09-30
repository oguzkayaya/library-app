package com.ok.libraryapp.repositories;

import com.ok.libraryapp.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
