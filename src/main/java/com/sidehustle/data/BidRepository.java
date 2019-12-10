package com.sidehustle.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sidehustle.beans.Bid;


@Repository
public interface BidRepository extends JpaRepository<Bid, Integer>{



}
