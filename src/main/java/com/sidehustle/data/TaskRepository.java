package com.sidehustle.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sidehustle.beans.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

		
	}

