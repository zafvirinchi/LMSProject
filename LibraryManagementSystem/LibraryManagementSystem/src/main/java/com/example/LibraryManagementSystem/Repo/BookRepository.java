package com.example.LibraryManagementSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryManagementSystem.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
