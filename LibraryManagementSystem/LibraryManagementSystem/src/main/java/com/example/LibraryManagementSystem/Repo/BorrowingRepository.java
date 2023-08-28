package com.example.LibraryManagementSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryManagementSystem.Entity.BorrowingRecord;



public interface BorrowingRepository extends JpaRepository<BorrowingRecord, Long>{
	BorrowingRecord findByUser(String name);
}
