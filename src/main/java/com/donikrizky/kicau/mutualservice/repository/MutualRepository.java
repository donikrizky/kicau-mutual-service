package com.donikrizky.kicau.mutualservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.donikrizky.kicau.mutualservice.entity.Mutual;

@Repository
public interface MutualRepository extends JpaRepository<Mutual, Integer> {
	@Query("SELECT m.userId FROM Mutual m WHERE m.followerId = :followerId")
	Optional<List<Integer>> findUserByFollowerId(@Param("followerId") Integer followerId);
}
