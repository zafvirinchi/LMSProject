package com.example.LibraryManagementSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryManagementSystem.Entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
