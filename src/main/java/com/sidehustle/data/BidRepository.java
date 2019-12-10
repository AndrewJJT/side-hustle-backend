package com.sidehustle.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sidehustle.beans.Bid;
import com.sidehustle.beans.Task;

@Repository
public interface BidRepository extends JpaRepository<Bid, Integer>{



}
