package ru.trofimov.bookshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.trofimov.bookshare.domain.swap.Swap;

import java.util.Collection;

@Repository
public interface SwapRepository extends CrudRepository<Swap, Long> {

    Collection<Swap> findByReqId(Long reqId);
}
