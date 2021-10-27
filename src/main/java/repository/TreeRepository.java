package repository;

import model.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> {
}
